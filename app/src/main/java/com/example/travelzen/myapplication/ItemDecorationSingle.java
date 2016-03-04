package com.example.travelzen.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hui.xiong on 2016/3/4.
 */
public class ItemDecorationSingle extends RecyclerView.ItemDecoration{

    private static final int[] ATTRS =new int[]{android.R.attr.listDivider};
    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    private int mOrientation;

    public ItemDecorationSingle(Context context,int orientation){
        TypedArray a=context.obtainStyledAttributes(ATTRS);
        mDivider=a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation){
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation =orientation;
    }

    public void drawHorizontal(Canvas canvas,RecyclerView parent){

        final int top =parent.getPaddingTop();
        final int bottom =parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }
    public void drawVertical(Canvas canvas,RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right= parent.getWidth() - parent.getPaddingRight();
        final int childCount =parent.getChildCount();
        for (int i=0;i<childCount;i++){
            final View child =parent.getChildAt(i);
            RecyclerView recycler=new RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top =child.getBottom() +params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(canvas);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL){
            drawVertical(c,parent);
        }else{
            drawHorizontal(c,parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mOrientation == VERTICAL){
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}

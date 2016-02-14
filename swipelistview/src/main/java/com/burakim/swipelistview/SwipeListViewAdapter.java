package com.burakim.swipelistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.burakim.slidinglistview.R;


/**
 * Created by Burak on 13/02/16.
 */
public class SwipeListViewAdapter extends RecyclerView.Adapter<SwipeListViewHolder> {
    private int itemSize;
    private Context mContext;
    private SwipeListViewActions swipeListViewActions;
    private int rowHeight=100;
    public SwipeListViewAdapter(Context mContext, int itemSize, int rowHeight, SwipeListViewActions swipeListViewActions)
    {
        this.rowHeight = rowHeight;
        this.setSwipeListViewActions(swipeListViewActions);
        this.mContext = mContext;
        try{
            this.itemSize = itemSize;
            if(itemSize<0)
            {
                throw new Exception("Item size cannot be negative value.");
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void onBindViewHolder(SwipeListViewHolder holder, int position) {
        SecondViewAdapter secondViewAdapter = new SecondViewAdapter(mContext, position, getSwipeListViewActions());
        holder.setViewPagerAdapter(secondViewAdapter);
    }

    @Override
    public int getItemCount() {
        return itemSize;
    }

    @Override
    public SwipeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_floatingview_row,parent,false);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,rowHeight));
        return new SwipeListViewHolder(view);
    }

    public SwipeListViewActions getSwipeListViewActions() {
        return swipeListViewActions;
    }

    public void setSwipeListViewActions(SwipeListViewActions swipeListViewActions) {
        this.swipeListViewActions = swipeListViewActions;
    }
}

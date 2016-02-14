package com.burakim.swipelistview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burakim.slidinglistview.R;

/**
 * Created by Burak on 13/02/16.
 */
public class SwipeListViewHolder extends RecyclerView.ViewHolder {

    private ViewPager viewPager;
    public SwipeListViewHolder(View itemView) {
        super(itemView);

        viewPager = (ViewPager)itemView.findViewById(R.id.floating_listview_rowpager);
    }

    public void setViewPagerAdapter(SecondViewAdapter secondViewAdapter)
    {
        viewPager.setAdapter(secondViewAdapter);
        viewPager.setCurrentItem(0);
    }

}

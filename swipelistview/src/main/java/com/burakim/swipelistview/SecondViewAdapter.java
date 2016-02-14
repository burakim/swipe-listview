package com.burakim.swipelistview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.burakim.slidinglistview.R;

/**
 * Created by Burak on 13/02/16.
 */
public class SecondViewAdapter extends PagerAdapter  {
    private Context mcontext;
    private int itemPosition;
    private SwipeListViewActions swipeListViewActions;
    public SecondViewAdapter(Context context, int position, SwipeListViewActions swipeListViewActions)
    {
        this.swipeListViewActions = swipeListViewActions;
        this.mcontext = context;
        this.itemPosition = position;
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        if(swipeListViewActions != null)
        {
            view = swipeListViewActions.setView(container,itemPosition,position);
        }


//               view = LayoutInflater.from(mcontext).inflate(R.layout.view_secondview,container,false);




        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    public SwipeListViewActions getSwipeListViewActions() {
        return swipeListViewActions;
    }

    public void setSwipeListViewActions(SwipeListViewActions swipeListViewActions) {
        this.swipeListViewActions = swipeListViewActions;
    }
}

package com.burakim.floatinglistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.burakim.swipelistview.SwipeListView;
import com.burakim.swipelistview.SwipeListViewActions;

/**
 * Created by Burak on 13/02/16.
 */
public class MainScreen extends Activity implements SwipeListViewActions {

    private SwipeListView swipeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        swipeListView = (SwipeListView) findViewById(R.id.floatinglistview);
        swipeListView.setActionInterface(this);
        swipeListView.setItemSize(2);
        swipeListView.setHasFixedSize(true);


    }

    @Override
    public View setView(ViewGroup container,int position, int side) {
        View view = null;
        switch (side)
        {
            case 0:
            {
             view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_firstview,container,false);
                view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));

                break;
            }
            case 1:
            {
                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_secondview,container,false);
                view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));


                break;
            }
        }
        return view;
    }
}

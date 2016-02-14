package com.burakim.swipelistview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Burak on 13/02/16.
 */
public class SwipeListView extends RecyclerView {
    private int itemSize;
    private int rowHeight;
    private SwipeListViewActions swipeListViewActions;
    private Context context;
    public static String XmlNamespace = "http://schemas.android.com/apk/res-auto";

    public SwipeListView(Context context, int itemSize, int rowHeight, boolean isFixedRowDimensions) {
        super(context);
        this.context = context;
        this.rowHeight = rowHeight;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        SwipeListViewAdapter floatingViewAdapter = new SwipeListViewAdapter(context,itemSize,rowHeight,swipeListViewActions);
        setHasFixedSize(isFixedRowDimensions);
        this.itemSize = itemSize;
        setAdapter(floatingViewAdapter);
        setLayoutManager(linearLayoutManager);
    }

    public void setItemSize(int itemSize)
    {
        this.itemSize = itemSize;
        if(getAdapter() != null)
        getAdapter().notifyDataSetChanged();
        {
            SwipeListViewAdapter floatingViewAdapter = new SwipeListViewAdapter(context,itemSize,rowHeight,swipeListViewActions);
            setAdapter(floatingViewAdapter);


        }
    }
    public void setActionInterface(SwipeListViewActions swipeListViewActions) {

        this.swipeListViewActions = swipeListViewActions;
    }
    public SwipeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rowHeight = attrs.getAttributeIntValue(XmlNamespace,"rowheight",0);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(linearLayoutManager);
    }

    public SwipeListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        rowHeight = attrs.getAttributeIntValue(XmlNamespace,"rowheight",0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(linearLayoutManager);
    }
}

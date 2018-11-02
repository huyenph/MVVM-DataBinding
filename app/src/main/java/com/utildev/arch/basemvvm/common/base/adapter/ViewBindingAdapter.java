package com.utildev.arch.basemvvm.common.base.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class ViewBindingAdapter {
    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, RecyclerView.LayoutManager manager) {
        recyclerView.setLayoutManager(manager);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}

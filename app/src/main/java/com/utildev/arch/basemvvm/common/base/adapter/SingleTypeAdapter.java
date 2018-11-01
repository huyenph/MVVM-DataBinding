package com.utildev.arch.basemvvm.common.base.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SingleTypeAdapter<T> extends BaseAdapter<T> {
    protected int layoutRes;

    private int getLayoutRes() {
        return layoutRes;
    }

    protected SingleTypeAdapter(Context context, int layoutRes) {
        super(context);
        this.layoutRes = layoutRes;
        itemList = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, getLayoutRes(), viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public void add(T viewModel) {
        itemList.add(viewModel);
        notifyDataSetChanged();
    }

    public void add(int position, T viewModel) {
        itemList.add(position, viewModel);
        notifyDataSetChanged();
    }

    public void set(List<T> viewModels) {
        itemList.clear();
        addAll(viewModels);
    }

    public void addAll(List<T> viewModels) {
        itemList.addAll(viewModels);
        notifyDataSetChanged();
    }
}

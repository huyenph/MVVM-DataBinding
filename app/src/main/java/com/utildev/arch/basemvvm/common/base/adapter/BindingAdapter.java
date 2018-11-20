package com.utildev.arch.basemvvm.common.base.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class BindingAdapter<T> extends BaseAdapter<T> {
    private int layoutRes;

    public BindingAdapter(RecyclerView recyclerView, LinearLayoutManager layoutManager, int layoutRes) {
        super(recyclerView, layoutManager, layoutRes);
    }

    //    public BindingAdapter(RecyclerView recyclerView, LinearLayoutManager layoutManager, int layoutRes) {
//        super(recyclerView.getContext(), layoutManager, layoutRes);
//        this.layoutRes = layoutRes;
//        itemList = new ArrayList<>();
//    }

//    private int getLayoutRes() {
//        return layoutRes;
//    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, layoutRes, viewGroup, false));
    }

//    public void add(T viewModel) {
//        itemList.add(viewModel);
//        notifyDataSetChanged();
//    }
//
//    public void add(int position, T viewModel) {
//        itemList.add(position, viewModel);
//        notifyDataSetChanged();
//    }
//
//    public void set(List<T> viewModels) {
//        itemList.clear();
//        addAll(viewModels);
//    }
//
//    public void addAll(List<T> viewModels) {
//        itemList.addAll(viewModels);
//        notifyDataSetChanged();
//    }
}

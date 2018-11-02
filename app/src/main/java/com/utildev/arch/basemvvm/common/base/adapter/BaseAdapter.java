package com.utildev.arch.basemvvm.common.base.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.utildev.arch.basemvvm.BR;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    final LayoutInflater layoutInflater;
    List<T> itemList;
    private AdapterListener adapterListener;

    BaseAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Object item = itemList.get(position);
        holder.getBinding().setVariable(BR.viewModel, item);
        holder.getBinding().setVariable(BR.listener, getAdapterListener());
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public void removeItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }

    public void clearItemList() {
        itemList.clear();
        notifyDataSetChanged();
    }

    class ViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
        final T binding;

        ViewHolder(T binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        T getBinding() {
            return binding;
        }
    }

    public interface AdapterListener {
        void onItemClick(String value);
    }

    public void setAdapterListener(AdapterListener adapterListener) {
        this.adapterListener = adapterListener;
    }

    public AdapterListener getAdapterListener() {
        return adapterListener;
    }
}

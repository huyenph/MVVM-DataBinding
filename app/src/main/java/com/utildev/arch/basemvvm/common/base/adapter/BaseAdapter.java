package com.utildev.arch.basemvvm.common.base.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.utildev.arch.basemvvm.BR;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    final LayoutInflater layoutInflater;
    List<T> itemList;
    private AdapterListener adapterListener;

    private int layoutRes;
    private boolean isLoading = true;
    private int visibleItemCount, totalItemCount, firstVisibleItem;

    public BaseAdapter(RecyclerView recyclerView, LinearLayoutManager layoutManager, int layoutRes) {
        layoutInflater = (LayoutInflater) recyclerView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutRes = layoutRes;
        itemList = new ArrayList<>();

        if (layoutManager != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy > 0) {
                        visibleItemCount = layoutManager.getChildCount();
                        totalItemCount = layoutManager.getItemCount();
                        firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                        if (isLoading) {
                            if (visibleItemCount + firstVisibleItem >= totalItemCount) {
                                getAdapterListener().onLoadMore();
                                isLoading = false;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Object item = itemList.get(position);
        holder.getBinding().setVariable(BR.viewModel, item);
        holder.getBinding().setVariable(BR.listener, getAdapterListener());
        holder.getBinding().executePendingBindings();
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

    int getLayoutRes() {
        return layoutRes;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
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

    public void removeItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }

    public void clearList() {
        itemList.clear();
        notifyDataSetChanged();
    }

    class ViewHolder<t extends ViewDataBinding> extends RecyclerView.ViewHolder {
        final t binding;

        ViewHolder(t binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        t getBinding() {
            return binding;
        }
    }

    public interface AdapterListener {
        void onItemClick(String value);

        boolean onItemLongClick(Object object);

        void onLoadMore();
    }

    public void setAdapterListener(AdapterListener adapterListener) {
        this.adapterListener = adapterListener;
    }

    AdapterListener getAdapterListener() {
        return adapterListener;
    }
}

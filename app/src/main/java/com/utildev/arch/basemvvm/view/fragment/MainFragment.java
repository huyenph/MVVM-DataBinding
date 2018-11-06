package com.utildev.arch.basemvvm.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.BaseFragment;
import com.utildev.arch.basemvvm.common.base.adapter.BaseAdapter;
import com.utildev.arch.basemvvm.common.base.adapter.BindingAdapter;
import com.utildev.arch.basemvvm.databinding.FragmentMainBinding;
import com.utildev.arch.basemvvm.model.rest.RestItemSE;
import com.utildev.arch.basemvvm.model.rest.RestUserSE;
import com.utildev.arch.basemvvm.viewmodel.fragment.MainFragmentVM;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment implements BaseAdapter.AdapterListener {
    private FragmentMainBinding binding;
    private MainFragmentVM viewModel;

    private List<RestItemSE> userList;
    private BindingAdapter<RestItemSE> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(MainFragmentVM.class);
        binding.setViewModel(viewModel);
        init(view);
        registerLiveData();
        return view;
    }

    private void init(View view) {
        userList = new ArrayList<>();
        adapter = new BindingAdapter<>(getContext(), R.layout.item_user);
        adapter.setAdapterListener(this);
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        binding.setLayoutManager(layoutManager);
        binding.setAdapter(adapter);

        viewModel.getApiClient().getAllUser("desc", "reputation", "stackoverflow", 1);
        viewModel.showLoading(view);
    }

    private void registerLiveData() {
        viewModel.getUserSELiveData().observe(this, this::liveDataListener);
    }

    private void liveDataListener(RestUserSE restUserSE) {
        viewModel.dismissLoading(null);
        userList.addAll(restUserSE.getItems());
        adapter.addAll(userList);
    }

    @Override
    public void onItemClick(String value) {

    }

    @Override
    public boolean onItemLongClick(Object object) {
        return false;
    }
}

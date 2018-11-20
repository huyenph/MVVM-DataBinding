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
import android.widget.Toast;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.BaseFragment;
import com.utildev.arch.basemvvm.common.base.adapter.BaseAdapter;
import com.utildev.arch.basemvvm.databinding.FragmentMainBinding;
import com.utildev.arch.basemvvm.model.rest.RestItemSE;
import com.utildev.arch.basemvvm.model.rest.RestUserSE;
import com.utildev.arch.basemvvm.viewmodel.fragment.FmMainVM;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment implements BaseAdapter.AdapterListener {
    private FragmentMainBinding binding;
    private FmMainVM viewModel;

    private List<RestItemSE> userList;
    private BaseAdapter<RestItemSE> adapter;

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(FmMainVM.class);
        binding.setViewModel(viewModel);
        init();
        registerLiveData();
        return view;
    }

    private void init() {
        userList = new ArrayList<>();
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        adapter = new BaseAdapter<>(binding.fragMainIncludeList.viewListRvContent, layoutManager, R.layout.item_user);
        adapter.setAdapterListener(this);
        binding.setLayoutManager(layoutManager);
        binding.setAdapter(adapter);

        binding.fragMainIncludeList.viewListSrLayout.setOnRefreshListener(() -> {
            userList.clear();
            page = 1;
            adapter.set(userList);
            viewModel.getAllUser("desc", "reputation", "stackoverflow", page, true);
            binding.fragMainIncludeList.viewListSrLayout.setRefreshing(false);
        });

        viewModel.getAllUser("desc", "reputation", "stackoverflow", page, true);
    }

    private void registerLiveData() {
        viewModel.getUserSELiveData().observe(this, this::liveDataListener);
    }

    private void liveDataListener(RestUserSE restUserSE) {
        if (restUserSE != null) {
            adapter.setLoading(true);
            userList.addAll(restUserSE.getItems());
            adapter.set(userList);
        } else {
            Toast.makeText(getContext(), "Connection error!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(String value) {
    }

    @Override
    public boolean onItemLongClick(Object object) {
        return false;
    }

    @Override
    public void onLoadMore() {
        viewModel.getAllUser("desc", "reputation", "stackoverflow", ++page, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.resetSubscribeObservable();
    }
}

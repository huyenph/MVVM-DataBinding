package com.utildev.arch.basemvvm.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.BaseFragment;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.databinding.FragmentMainBinding;
import com.utildev.arch.basemvvm.model.rest.RestUserSE;
import com.utildev.arch.basemvvm.viewmodel.fragment.MainFragmentVM;

public class MainFragment extends BaseFragment {
    private FragmentMainBinding fmMainBinding;
    private MainFragmentVM viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fmMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = fmMainBinding.getRoot();
        viewModel = ViewModelProviders.of(this).get(MainFragmentVM.class);
        fmMainBinding.setViewModel(viewModel);
        init(view);
        registerLiveData();
        return view;
    }

    private void init(View view) {
        viewModel.getApiClient().getAllUser("desc", "reputation", "stackoverflow", 1);
//        viewModel.showLoading(view);
    }

    private void registerLiveData() {
        viewModel.getUserSELiveData().observe(this, this::liveDataListener);
    }

    private void liveDataListener(RestUserSE restUserSE) {
        Log.d("aaa", "liveDataListener: " + restUserSE);
    }
}

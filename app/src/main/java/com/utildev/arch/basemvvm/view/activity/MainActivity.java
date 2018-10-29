package com.utildev.arch.basemvvm.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.BaseActivity;
import com.utildev.arch.basemvvm.databinding.ActivityMainBinding;
import com.utildev.arch.basemvvm.viewmodel.activity.MainActivityVM;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityVM mainViewModel;

    public MainActivityVM getMainViewModel() {
        return mainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainActivityVM.class);
        activityMainBinding.setViewModel(mainViewModel);
    }
}

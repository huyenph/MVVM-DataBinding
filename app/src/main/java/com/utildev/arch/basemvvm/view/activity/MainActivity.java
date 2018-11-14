package com.utildev.arch.basemvvm.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.BaseActivity;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.databinding.ActivityMainBinding;
import com.utildev.arch.basemvvm.view.fragment.MainFragment;
import com.utildev.arch.basemvvm.viewmodel.activity.MainActivityVM;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding actMainBinding;
    private MainActivityVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityVM.class);
        actMainBinding.setViewModel(viewModel);
        registerVMListener();
    }

    private void registerVMListener() {
        viewModel.getMutableLiveData().observe(this, this::liveDataListener);
    }

    private void liveDataListener(BaseModel model) {
        Toast.makeText(this, "" + model, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.resetSubscribeObservable();
    }
}

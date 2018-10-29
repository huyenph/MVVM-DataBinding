package com.utildev.arch.basemvvm.viewmodel.activity;

import android.databinding.ObservableInt;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {

    @Override
    public ObservableInt getLoadingView() {
        return super.getLoadingView();
    }

    @Override
    public void showLoading(View view) {
        super.showLoading(view);
    }

    @Override
    public void dismissLoading(View view) {
        super.dismissLoading(view);
    }
}

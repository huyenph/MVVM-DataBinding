package com.utildev.arch.basemvvm.common.base;

import android.databinding.ObservableInt;
import android.view.View;

import java.util.Observable;

public class BaseViewModel extends Observable {
    private ObservableInt loadingView = new ObservableInt(View.GONE);

    public ObservableInt getLoadingView() {
        return loadingView;
    }

    public void showLoading(View view) {
        loadingView.set(View.VISIBLE);
    }

    public void dismissLoading(View view) {
        loadingView.set(View.GONE);
    }
}

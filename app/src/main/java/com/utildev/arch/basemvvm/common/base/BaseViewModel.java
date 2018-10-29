package com.utildev.arch.basemvvm.common.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.view.View;

public class BaseViewModel extends ViewModel {
    private ObservableInt loadingView = new ObservableInt(View.GONE);

    public ObservableInt getLoadingView() {
        return loadingView;
    }

    public void showLoading(View view) {
        if (loadingView.get() != View.VISIBLE) {
            loadingView.set(View.VISIBLE);
        }
    }

    public void dismissLoading(View view) {
        if (loadingView.get() != View.GONE) {
            loadingView.set(View.GONE);
        }
    }
}

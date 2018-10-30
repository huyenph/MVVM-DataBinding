package com.utildev.arch.basemvvm.common.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.view.View;

import com.utildev.arch.basemvvm.common.network.ApiResponseListener;
import com.utildev.arch.basemvvm.common.network.builder.ApiClient;
import com.utildev.arch.basemvvm.common.network.handler.ApiResponseHandler;
import com.utildev.arch.basemvvm.model.rest.RestError;

public class BaseViewModel extends ViewModel implements ApiResponseListener {
    private ApiClient apiClient;
    private ObservableInt loadingView = new ObservableInt(View.GONE);

    protected BaseViewModel() {
        ApiResponseHandler responseHandler = new ApiResponseHandler(null, this);
        apiClient = new ApiClient(responseHandler.requestListener);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

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

    @Override
    public void onDataResponse(int code, BaseModel model) {

    }

    @Override
    public void onDataError(int code, RestError error) {

    }
}

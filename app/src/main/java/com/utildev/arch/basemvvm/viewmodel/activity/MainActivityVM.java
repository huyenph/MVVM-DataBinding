package com.utildev.arch.basemvvm.viewmodel.activity;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.common.network.builder.ApiClient;
import com.utildev.arch.basemvvm.model.rest.RestError;

public class MainActivityVM extends BaseViewModel {
    private MutableLiveData<Integer> requestIntent;
    private MutableLiveData<BaseModel> mutableLiveData;
    private ApiClient apiClient;

    public MainActivityVM() {
        super();
        requestIntent = new MutableLiveData<>();
        mutableLiveData = new MutableLiveData<>();
        apiClient = new ApiClient(getResponseHandler().requestListener);
    }

    public MutableLiveData<Integer> getRequestIntent() {
        return requestIntent;
    }

    public MutableLiveData<BaseModel> getMutableLiveData() {
        return mutableLiveData;
    }

    public void onClickRv(View view) {
        getRequestIntent().setValue(1);
    }

    public void onClickRetrofit(View view) {
        apiClient.getAllUserRx("desc", "reputation", "stackoverflow");
        showLoading(view);
    }

    @Override
    public void onDataResponse(int code, BaseModel model) {
        dismissLoading(null);
        mutableLiveData.setValue(model);
    }

    @Override
    public void onDataError(int code, RestError error) {
        dismissLoading(null);
        mutableLiveData.setValue(null);
    }
}

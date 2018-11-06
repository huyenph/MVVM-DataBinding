package com.utildev.arch.basemvvm.viewmodel.activity;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.common.network.builder.ApiClient;
import com.utildev.arch.basemvvm.model.rest.RestError;

public class MainActivityVM extends BaseViewModel {
    private MutableLiveData<Integer> requestIntent;
    private ApiClient apiClient;

    public MainActivityVM() {
        super();
        requestIntent = new MutableLiveData<>();
        apiClient = new ApiClient(getResponseHandler().requestListener);
    }

    public MutableLiveData<Integer> getRequestIntent() {
        return requestIntent;
    }

    public void getAllUser() {
        apiClient.getAllUserRx("desc", "reputation", "stackoverflow");
    }

    public void onClickRv(View view) {
        getRequestIntent().setValue(1);
    }

    @Override
    public void onDataResponse(int code, BaseModel model) {
        super.onDataResponse(code, model);
    }

    @Override
    public void onDataError(int code, RestError error) {
        super.onDataError(code, error);
    }
}

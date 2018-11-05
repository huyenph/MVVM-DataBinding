package com.utildev.arch.basemvvm.viewmodel.activity;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.common.network.client.StackExchangeClient;
import com.utildev.arch.basemvvm.model.rest.RestError;

public class MainActivityVM extends BaseViewModel {
    private MutableLiveData<Integer> requestIntent;
    private StackExchangeClient stackExchangeClient;

    public MainActivityVM() {
        super();
        requestIntent = new MutableLiveData<>();
        stackExchangeClient = new StackExchangeClient(getResponseHandler().requestListener);
    }

    public MutableLiveData<Integer> getRequestIntent() {
        return requestIntent;
    }

    public void getAllUser() {
        stackExchangeClient.getAllUserRx("desc", "reputation", "stackoverflow");
    }

    public void onClickRecyclerView(View view) {
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

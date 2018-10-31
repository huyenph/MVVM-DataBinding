package com.utildev.arch.basemvvm.viewmodel.activity;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.common.network.client.StackExchangeClient;
import com.utildev.arch.basemvvm.model.rest.RestError;

public class MainActivityVM extends BaseViewModel {
    private StackExchangeClient stackExchangeClient;

    public MainActivityVM() {
        super();
        stackExchangeClient = new StackExchangeClient(getResponseHandler().requestListener);
    }

    public void getAllUser() {
        stackExchangeClient.getAllUserRx("desc", "reputation", "stackoverflow");
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

package com.utildev.arch.basemvvm.viewmodel.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.common.network.client.StackExchangeClient;
import com.utildev.arch.basemvvm.model.rest.RestError;
import com.utildev.arch.basemvvm.view.activity.RecyclerViewActivity;

public class MainActivityVM extends BaseViewModel {
    private Activity activity;
    private StackExchangeClient stackExchangeClient;

    public MainActivityVM(Activity activity) {
        super();
        this.activity = activity;
        stackExchangeClient = new StackExchangeClient(getResponseHandler().requestListener);
    }

    public void getAllUser() {
        stackExchangeClient.getAllUserRx("desc", "reputation", "stackoverflow");
    }

    public void onClickRecyclerView(View view) {
        activity.startActivity(new Intent(activity, RecyclerViewActivity.class));
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

package com.utildev.arch.basemvvm.viewmodel.activity;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseActivity;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.common.network.builder.ApiClient;
import com.utildev.arch.basemvvm.model.rest.RestError;
import com.utildev.arch.basemvvm.view.activity.ListActivity;
import com.utildev.arch.basemvvm.view.fragment.MainFragment;

public class MainActivityVM extends BaseViewModel {
    private MutableLiveData<BaseModel> mutableLiveData;
    private ApiClient apiClient;

    public MainActivityVM() {
        super();
        mutableLiveData = new MutableLiveData<>();
        apiClient = new ApiClient(getResponseHandler().requestListener);
    }

    public MutableLiveData<BaseModel> getMutableLiveData() {
        return mutableLiveData;
    }

    public void onClickRv(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), ListActivity.class));
    }

    public void onClickRetrofit(View view) {
        if (view.getContext() instanceof BaseActivity) {
            ((BaseActivity) view.getContext()).addFragment(new MainFragment(), true, true);
        }
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

package com.utildev.arch.basemvvm.viewmodel.fragment;

import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.model.rest.RestError;
import com.utildev.arch.basemvvm.model.rest.RestUserSE;

public class FmMainVM extends BaseViewModel {
    private MutableLiveData<RestUserSE> userSELiveData = new MutableLiveData<>();

    public MutableLiveData<RestUserSE> getUserSELiveData() {
        return userSELiveData;
    }

    public void getAllUser(String v1, String v2, String v3, int page, boolean showLoading) {
        getApiClient().getAllUser(v1, v2, v3, page);
        if (showLoading) {
            showLoading(null);
        }
    }

    @Override
    public void onDataResponse(int code, BaseModel model) {
        super.onDataResponse(code, model);
        userSELiveData.setValue((RestUserSE) model);
    }

    @Override
    public void onDataError(int code, RestError error) {
        super.onDataError(code, error);
        userSELiveData.setValue(null);
    }
}

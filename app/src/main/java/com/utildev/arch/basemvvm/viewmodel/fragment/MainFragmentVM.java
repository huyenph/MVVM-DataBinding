package com.utildev.arch.basemvvm.viewmodel.fragment;

import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.model.rest.RestError;
import com.utildev.arch.basemvvm.model.rest.RestUserSE;

public class MainFragmentVM extends BaseViewModel {
    private MutableLiveData<RestUserSE> userSELiveData;

    public MainFragmentVM() {
        super();
        userSELiveData = new MutableLiveData<>();
    }

    public MutableLiveData<RestUserSE> getUserSELiveData() {
        return userSELiveData;
    }

    @Override
    public void onDataResponse(int code, BaseModel model) {
        userSELiveData.setValue((RestUserSE) model);
    }

    @Override
    public void onDataError(int code, RestError error) {
        userSELiveData.setValue(null);
    }
}

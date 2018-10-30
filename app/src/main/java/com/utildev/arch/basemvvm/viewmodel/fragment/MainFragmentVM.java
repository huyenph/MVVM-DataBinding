package com.utildev.arch.basemvvm.viewmodel.fragment;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.model.rest.RestError;

public class MainFragmentVM extends BaseViewModel {
    public MainFragmentVM() {
        super();
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

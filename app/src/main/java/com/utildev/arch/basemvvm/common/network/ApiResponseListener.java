package com.utildev.arch.basemvvm.common.network;

import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.model.rest.RestError;

public interface ApiResponseListener {
    void onDataResponse(int code, BaseModel model);

    void onDataError(int code, RestError error);
}

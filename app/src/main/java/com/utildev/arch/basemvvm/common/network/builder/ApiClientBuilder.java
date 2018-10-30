package com.utildev.arch.basemvvm.common.network.builder;

import com.google.gson.JsonObject;
import com.utildev.arch.basemvvm.common.network.ApiKeyParams;
import com.utildev.arch.basemvvm.common.network.ApiRequestListener;

import java.lang.reflect.Type;

import retrofit2.Call;

public class ApiClientBuilder {
    private ApiRequestListener requestListener;

    ApiClientBuilder(ApiRequestListener requestListener) {
        this.requestListener = requestListener;
    }

    void requestApi(Type type, Call<JsonObject> call) {
        if (requestListener != null) {
            requestListener.onRequestApi(ApiKeyParams.CODE_DEFAULT, type, call);
        }
    }

    public void requestApi(int code, Type type, Call<JsonObject> call) {
        if (requestListener != null) {
            requestListener.onRequestApi(code, type, call);
        }
    }
}
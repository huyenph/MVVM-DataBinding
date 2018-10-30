package com.utildev.arch.basemvvm.common.network.handler;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.network.ApiKeyParams;
import com.utildev.arch.basemvvm.common.network.ApiRequestListener;
import com.utildev.arch.basemvvm.common.network.ApiResponseListener;
import com.utildev.arch.basemvvm.model.rest.RestError;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiResponseHandler {
    private ApiResponseListener responseListener;

    public ApiResponseHandler(ApiResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    public ApiRequestListener requestListener = new ApiRequestListener() {
        @Override
        public void onRequestApi(int code, Type type, Call<JsonObject> call) {
            if (call != null) {
                if (call.isExecuted()) {
                    call.cancel();
                }
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                        BaseModel data = null;
                        if (response.body() != null) {
                            Gson gson = new Gson();
                            data = gson.fromJson(response.body(), type);
                        }
                        if (responseListener != null) {
                            responseListener.onDataResponse(code, data);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                        if (responseListener != null) {
                            responseListener.onDataError(code, RestError.parseData(t.getMessage()));
                        }
                    }
                });
            } else {
                if (responseListener != null) {
                    responseListener.onDataError(ApiKeyParams.CODE_ERROR, null);
                }
            }
        }
    };
}

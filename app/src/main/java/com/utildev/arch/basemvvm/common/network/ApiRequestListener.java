package com.utildev.arch.basemvvm.common.network;

import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import retrofit2.Call;

public interface ApiRequestListener {
    void onRequestApi(int code, Type type, Call<JsonObject> call);
}

package com.utildev.arch.basemvvm.common.network;

import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import retrofit2.Call;

public interface ApiRequestListener {
    void onRequestApi(int code, Type type, Call<JsonObject> call);

    void onRequestApiRx(int code, Type type, Observable<JsonObject> observable);
}

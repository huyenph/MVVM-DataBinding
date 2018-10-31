package com.utildev.arch.basemvvm.common.network.service;

import com.google.gson.JsonObject;
import com.utildev.arch.basemvvm.common.base.BaseModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //retrofit
    @FormUrlEncoded
    @POST("upload key, object")
    Call<JsonObject> callNormal(@FieldMap Map<String, Object> body);

    @POST("upload file")
    Call<JsonObject> callFiles(@Body RequestBody file);

    @POST("upload list")
    Call<JsonObject> callList(@Body List<BaseModel> body);

    @GET("not param")
    Call<JsonObject> callNotParams();

    //rxjava + retrofit
    @FormUrlEncoded
    @POST("mobile/login")
    Observable<JsonObject> callRx(@FieldMap Map<String, Object> body);
}

package com.utildev.arch.basemvvm.common.network;

import com.google.gson.JsonObject;
import com.utildev.arch.basemvvm.common.base.BaseModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    //retrofit
    @POST("post text")
    Call<JsonObject> callExampleNormal(@Body Map<String, Object> body);

    @POST("upload file")
    Call<JsonObject> callExampleFiles(@Body RequestBody file);

    @POST("upload list")
    Call<JsonObject> callExampleList(@Body List<BaseModel> body);

    @GET("not param")
    Call<JsonObject> callExampleNotParams();

    //rxjava + retrofit
    @GET("not param")
    Observable<BaseModel> callExampleRxJava(@Body Map<String, Object> body);
}

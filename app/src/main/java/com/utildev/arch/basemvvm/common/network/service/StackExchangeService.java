package com.utildev.arch.basemvvm.common.network.service;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackExchangeService {
    //https://api.stackexchange.com/2.2/users?order=desc&sort=reputation&site=stackoverflow
    @GET("users")
    Call<JsonObject> requestUsers(@Query("order") String order,
                                  @Query("sort") String sort,
                                  @Query("site") String site);

    @GET("users")
    Observable<JsonObject> requestUsersRx(@Query("order") String order,
                                          @Query("sort") String sort,
                                          @Query("site") String site);
}

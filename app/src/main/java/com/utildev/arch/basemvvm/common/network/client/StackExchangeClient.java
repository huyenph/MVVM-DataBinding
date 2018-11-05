package com.utildev.arch.basemvvm.common.network.client;

import com.google.gson.reflect.TypeToken;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.network.ApiRequestListener;
import com.utildev.arch.basemvvm.common.network.builder.ApiClientBuilder;
import com.utildev.arch.basemvvm.common.network.builder.ApiGenerator;
import com.utildev.arch.basemvvm.common.network.service.StackExchangeService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class StackExchangeClient extends ApiClientBuilder {
    public StackExchangeClient(ApiRequestListener requestListener) {
        super(requestListener);
    }

    public void getAllUser(String v1, String v2, String v3) {
        StackExchangeService stackExchangeService = ApiGenerator.getInstance().createService(StackExchangeService.class);
        requestApi(new TypeToken<BaseModel>() {
        }.getType(), stackExchangeService.requestUsers(v1, v2, v3));
    }

    public void getAllUserRx(String v1, String v2, String v3) {
        StackExchangeService stackExchangeService = ApiGenerator.getInstance().createService(StackExchangeService.class);
        requestApiRx(new TypeToken<BaseModel>() {
                }.getType(),
                stackExchangeService.requestUsersRx(v1, v2, v3)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()));
    }
}

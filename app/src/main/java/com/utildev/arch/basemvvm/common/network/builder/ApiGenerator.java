package com.utildev.arch.basemvvm.common.network.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utildev.arch.basemvvm.common.base.BaseApplication;
import com.utildev.arch.basemvvm.common.network.connect.NetworkConfig;
import com.utildev.arch.basemvvm.common.network.connect.NetworkConfigType;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiGenerator {
    private static ApiGenerator apiGenerator = new ApiGenerator();
    private Retrofit retrofit;

    static synchronized ApiGenerator getApiGenerator() {
        if (apiGenerator == null) {
            apiGenerator = new ApiGenerator();
        }
        return apiGenerator;
    }

    private ApiGenerator() {
        retrofit = createRetrofit(BaseApplication.networkConfigType);
    }

    private Retrofit createRetrofit(NetworkConfigType type) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.createConnectionDetail(type))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}

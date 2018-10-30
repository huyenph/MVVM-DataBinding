package com.utildev.arch.basemvvm.common.network.builder;

import com.google.gson.reflect.TypeToken;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.network.ApiParams;
import com.utildev.arch.basemvvm.common.network.ApiRequestListener;
import com.utildev.arch.basemvvm.common.network.service.ApiService;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ApiClient extends ApiClientBuilder {
    public ApiClient(ApiRequestListener requestListener) {
        super(requestListener);
    }

    public void exampleNormal(String v1, String v2) {
        ApiParams params = new ApiParams();
        params.add("key1", v1);
        params.add("key2", v2);
        ApiService apiService = ApiGenerator.getApiGenerator().createService(ApiService.class);
        requestApi(new TypeToken<BaseModel>() {
        }.getType(), apiService.callNormal(params.getParams()));
    }

    public void requestList(List<BaseModel> list) {
        ApiService apiService = ApiGenerator.getApiGenerator().createService(ApiService.class);
        requestApi(new TypeToken<BaseModel>() {
        }.getType(), apiService.callList(list));
    }

    public void requestWithNotParams() {
        ApiService apiService = ApiGenerator.getApiGenerator().createService(ApiService.class);
        requestApi(new TypeToken<BaseModel>() {
        }.getType(), apiService.callNotParams());
    }

    public void requestFiles(List<String> fileUri) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        int fileCount = fileUri.size();
        for (int i = 0; i < fileCount; i++) {
            File file = new File(fileUri.get(i));
            builder.addFormDataPart("file[]", file.getAbsolutePath(),
                    RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        //region TODO: Call other type
        //builder.addFormDataPart("key", "value");
        //endregion

        MultipartBody requestBody = builder.build();
        ApiService apiService = ApiGenerator.getApiGenerator().createService(ApiService.class);
        requestApi(new TypeToken<BaseModel>() {
        }.getType(), apiService.callFiles(requestBody));
    }
}

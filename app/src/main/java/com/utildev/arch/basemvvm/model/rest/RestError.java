package com.utildev.arch.basemvvm.model.rest;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.utildev.arch.basemvvm.common.base.BaseModel;

import okhttp3.Response;

public class RestError extends BaseModel {
    @SerializedName("message")
    private String message;
    @SerializedName("status_code")
    private int code;

    public String getMessage() {
        if (TextUtils.isEmpty(message)) {
            return "Some things wrong.";
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static RestError parseData(String json) {
        RestError restError;
        try {
            Gson gson = new Gson();
            restError = gson.fromJson(json, RestError.class);
            if (restError != null) {
                return restError;
            }
        } catch (Exception e) {
            restError = new RestError();
            restError.setMessage(json);
        }
        return restError;
    }

    public static String getErrorString(Response response) {
        RestError restError = new RestError();
        restError.setCode(response.code());
        if (response.body() != null) {
            String body = response.body().toString();
            if (!body.startsWith("<!DOCTYPE HTML")) {
                restError.setMessage(body);
            } else {
                restError.setMessage("");
            }
        }
        return restError.toString();
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

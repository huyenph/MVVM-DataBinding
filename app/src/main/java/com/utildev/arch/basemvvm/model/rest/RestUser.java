package com.utildev.arch.basemvvm.model.rest;

import com.google.gson.annotations.SerializedName;
import com.utildev.arch.basemvvm.common.base.BaseModel;

public class RestUser extends BaseModel {
    @SerializedName("auth_token")
    private String authToken;
    private String userName, password;

    public RestUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getAuthToken() {
        return authToken != null ? authToken : "";
    }

    public String getUserName() {
        return userName != null ? userName : "";
    }

    public String getPassword() {
        return password != null ? password : "";
    }
}

package com.utildev.arch.basemvvm.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utildev.arch.basemvvm.common.base.BaseModel;

import java.util.List;

public class RestUserSE extends BaseModel {
    @SerializedName("items")
    @Expose
    private List<RestItemSE> items = null;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    private int quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private int quotaRemaining;

    public List<RestItemSE> getItems() {
        return items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public int getQuotaRemaining() {
        return quotaRemaining;
    }
}

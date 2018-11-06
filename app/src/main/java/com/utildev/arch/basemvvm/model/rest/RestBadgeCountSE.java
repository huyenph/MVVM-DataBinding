package com.utildev.arch.basemvvm.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utildev.arch.basemvvm.common.base.BaseModel;

public class RestBadgeCountSE extends BaseModel {
    @SerializedName("bronze")
    @Expose
    private int bronze;
    @SerializedName("silver")
    @Expose
    private int silver;
    @SerializedName("gold")
    @Expose
    private int gold;

    public int getBronze() {
        return bronze;
    }

    public int getSilver() {
        return silver;
    }

    public int getGold() {
        return gold;
    }
}

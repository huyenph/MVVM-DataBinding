package com.utildev.arch.basemvvm.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utildev.arch.basemvvm.common.base.BaseModel;

public class RestItemSE extends BaseModel {
    @SerializedName("badge_counts")
    @Expose
    private RestBadgeCountSE badgeCounts;
    @SerializedName("account_id")
    @Expose
    private int accountId;
    @SerializedName("is_employee")
    @Expose
    private Boolean isEmployee;
    @SerializedName("last_modified_date")
    @Expose
    private int lastModifiedDate;
    @SerializedName("last_access_date")
    @Expose
    private int lastAccessDate;
    @SerializedName("reputation_change_year")
    @Expose
    private int reputationChangeYear;
    @SerializedName("reputation_change_quarter")
    @Expose
    private int reputationChangeQuarter;
    @SerializedName("reputation_change_month")
    @Expose
    private int reputationChangeMonth;
    @SerializedName("reputation_change_week")
    @Expose
    private int reputationChangeWeek;
    @SerializedName("reputation_change_day")
    @Expose
    private int reputationChangeDay;
    @SerializedName("reputation")
    @Expose
    private int reputation;
    @SerializedName("creation_date")
    @Expose
    private int creationDate;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("accept_rate")
    @Expose
    private int acceptRate;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("display_name")
    @Expose
    private String displayName;

    public RestBadgeCountSE getBadgeCounts() {
        return badgeCounts;
    }

    public int getAccountId() {
        return accountId;
    }

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public int getLastModifiedDate() {
        return lastModifiedDate;
    }

    public int getLastAccessDate() {
        return lastAccessDate;
    }

    public int getReputationChangeYear() {
        return reputationChangeYear;
    }

    public int getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public int getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public int getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public int getReputationChangeDay() {
        return reputationChangeDay;
    }

    public int getReputation() {
        return reputation;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public String getUserType() {
        return userType != null ? userType : "";
    }

    public int getUserId() {
        return userId;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public String getLocation() {
        return location != null ? location : "";
    }

    public String getWebsiteUrl() {
        return websiteUrl != null ? websiteUrl : "";
    }

    public String getLink() {
        return link != null ? link : "";
    }

    public String getProfileImage() {
        return profileImage != null ? profileImage : "";
    }

    public String getDisplayName() {
        return displayName != null ? displayName : "";
    }
}

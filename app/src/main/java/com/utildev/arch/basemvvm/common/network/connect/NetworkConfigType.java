package com.utildev.arch.basemvvm.common.network.connect;

public enum NetworkConfigType {
    DEV("dev"),
    TEST("test"),
    PRODUCTION("production");

    private String type;

    NetworkConfigType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

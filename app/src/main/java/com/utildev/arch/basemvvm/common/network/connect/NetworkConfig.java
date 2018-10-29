package com.utildev.arch.basemvvm.common.network.connect;

public class NetworkConfig {
    public static String createConnectionDetail(NetworkConfigType type) {
        if (type == null) {
            type = NetworkConfigType.DEV;
        }
        switch (type) {
            case DEV:
                return "http://dev";
            case STAGING:
                return "http://staging";
            case PRODUCTION:
                return "http://production";
            default:
                return "http://production";
        }
    }
}

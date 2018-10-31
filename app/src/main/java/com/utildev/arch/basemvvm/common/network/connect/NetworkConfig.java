package com.utildev.arch.basemvvm.common.network.connect;

public class NetworkConfig {
    public static String createConnectionDetail(NetworkConfigType type) {
        if (type == null) {
            type = NetworkConfigType.DEV;
        }
        switch (type) {
            case DEV:
                return "https://api.stackexchange.com/2.2/";
            case TEST:
                return "http://test";
            case PRODUCTION:
                return "http://production";
            default:
                return "http://production";
        }
    }
}

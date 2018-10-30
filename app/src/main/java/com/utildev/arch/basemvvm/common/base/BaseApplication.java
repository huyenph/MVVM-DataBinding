package com.utildev.arch.basemvvm.common.base;

import android.app.Application;

import com.utildev.arch.basemvvm.common.network.connect.NetworkConfigType;

public class BaseApplication extends Application {
    public static NetworkConfigType networkConfigType = NetworkConfigType.DEV;
}

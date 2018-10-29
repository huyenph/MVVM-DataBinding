package com.utildev.arch.basemvvm.common.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = null;
        if (manager != null) {
            info = manager.getActiveNetworkInfo();
        }
        return info != null && info.isConnectedOrConnecting();
    }
}

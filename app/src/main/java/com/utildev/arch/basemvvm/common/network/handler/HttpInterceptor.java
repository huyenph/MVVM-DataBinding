package com.utildev.arch.basemvvm.common.network.handler;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.utildev.arch.basemvvm.model.rest.RestError;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.code() >= 400) {
            throw new IOException(RestError.getErrorString(response));
        }
        if (response.body() != null) {
            String rp = response.body().string();

            //region TODO: Custom response when return special result
            if (TextUtils.equals(rp, "[]")) {
                rp = "{\n" + "  \"message\": successful" + "\n}";
            }
            //endregion

            try {
                JSONObject rootObject = new JSONObject(rp);
                if (rootObject.has("error")) {
                    throw new IOException(rootObject.getString("error"));
                } else {
                    return response.newBuilder()
                            .message("successful")
                            .body(ResponseBody.create(response.body().contentType(), rp))
                            .build();
                }
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
        return null;
    }
}

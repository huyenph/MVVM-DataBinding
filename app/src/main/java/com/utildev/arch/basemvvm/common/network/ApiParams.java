package com.utildev.arch.basemvvm.common.network;

import java.util.HashMap;
import java.util.Map;

public class ApiParams {
    private Map<String, Object> params = new HashMap<>();

    public void add(String key, Object value) {
        params.put(key, value);
    }

    public Map<String, Object> getParams() {
        return params;
    }
}

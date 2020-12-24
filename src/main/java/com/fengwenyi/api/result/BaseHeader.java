package com.fengwenyi.api.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erwin Feng
 * @since 2020-12-24
 */
public class BaseHeader extends HashMap<String, Object> {

    /** 追溯ID */
    private String traceId;

    /** 请求ID */
    private String requestId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

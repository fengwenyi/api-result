package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erwin Feng
 * @since 2020-12-24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseHeader extends HashMap<String, Object> {

    /** 追溯ID */
    private static final String TRACE_ID = "traceId";

    /** 请求ID */
    private static final String REQUEST_ID = "requestId";

    public void setTraceId(String traceId) {
        this.put(TRACE_ID, traceId);
    }

    public void setRequestId(String requestId) {
        this.put(REQUEST_ID, requestId);
    }
}

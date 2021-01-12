package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     响应头
 * </p>
 *
 * @author Erwin Feng
 * @since 2.3.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultHeader extends HashMap<String, Object> {

    private static final long serialVersionUID = 6187327761077399909L;

    /** 追溯ID */
    private static final String TRACE_ID = "traceId";

    public void setTraceId(String traceId) {
        this.put(TRACE_ID, traceId);
    }

    public String getTraceId() {
        return (String) this.get(TRACE_ID);
    }
}

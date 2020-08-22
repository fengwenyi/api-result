package com.fengwenyi.api.result;

import java.io.Serializable;

/**
 * 请求基类
 * @author Erwin Feng
 * @since 2020/8/22
 */
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = 5756679793483342431L;

    /** 请求码 */
    private String requestId;

    public BaseRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

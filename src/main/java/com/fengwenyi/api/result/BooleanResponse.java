package com.fengwenyi.api.result;

import java.io.Serializable;

/**
 * Boolean 结果响应类
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-31
 */
public class BooleanResponse implements Serializable {

    private static final long serialVersionUID = -5745710206906492721L;

    /** 是否成功 */
    private Boolean success;

    /** 信息 */
    private String msg;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

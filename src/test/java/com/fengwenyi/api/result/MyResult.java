package com.fengwenyi.api.result;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-02
 */
public enum MyResult implements Result {

    CUSTOM_ERROR("CUSTOM_ERROR", "自定义错误")

    ;

    /* 错误码 */
    private final String code;

    /* 描述 */
    private final String msg;

    MyResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

package com.fengwenyi.api.result;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-02
 */
public enum ReturnCode implements IReturnCode {

    CUSTOM_ERROR(-9, "自定义错误")

    ;

    /* 错误码 */
    private final Integer code;

    /* 描述 */
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

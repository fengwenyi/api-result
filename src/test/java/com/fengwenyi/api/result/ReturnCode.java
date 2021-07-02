package com.fengwenyi.api.result;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-02
 */
public enum ReturnCode implements IReturnCode {

    ERROR("Error", "自定义错误")

    ;

    /* 错误码 */
    private final String errCode;

    /* 描述 */
    private final String msg;

    ReturnCode(String errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

package com.fengwenyi.api_result.enums;

/**
 * 响应码枚举
 * @author Erwin Feng
 * @since 2.1.0
 */
public enum ResponseCodeEnum {

    /* -----------------成功---------------------------- */
    SUCCESS(100000, "Success")

    /* ------------------101xxx 请求错误--------------------------- */
    , ERROR_REQUEST_METHOD_NOT_SUPPORT(101001, "请求方法不支持")

    /* ------------------102xxx 参数错误--------------------------- */

    /* ------------------103xxx 数据错误：数据保存失败，数据修改失败，数据删除失败，--------------------------- */

    /* ------------------104xxx 用户相关的错误：用户不存在，密码不正确，用户被锁定，用户已过期，用户已欠费--------------------------- */

    /* ------------------105xxx 账户相关的错误：账户不存在，密码不正确，账户被锁定，账户已过期，账户已欠费--------------------------- */

    /* ------------------999xxx 系统错误--------------------------- */
    , ERROR_SYSTEM_EXCEPTION(999001, "系统异常")
    ;

    private Integer code;

    private String value;

    ResponseCodeEnum() {
    }

    ResponseCodeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

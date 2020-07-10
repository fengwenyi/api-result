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
    , ERROR_PARAM_NOT_NULL(102001, "参数不能为空")
    , ERROR_PARAM_EXCEPTION(102002, "参数异常")
    , ERROR_PARAM_ILLEGAL(102003, "参数非法")

    /* ------------------103xxx 数据错误--------------------------- */
    , ERROR_DATA_SAVE_FAILURE(103001, "数据保存失败")
    , ERROR_DATA_UPDATE_FAILURE(103002, "数据修改失败")
    , ERROR_DATA_DELETE_FAILURE(103003, "数据删除失败")

    /* ------------------104xxx 用户相关的错误--------------------------- */
    , ERROR_USER_NOT_EXIST(104001, "用户不存在")
    , ERROR_USER_PASSWORD_INCORRECT(104002, "用户密码不正确")
    , ERROR_USER_LOCKED(104003, "用户被锁定")
    , ERROR_USER_EXPIRE(104004, "用户已过期")
    , ERROR_USER_ARREARS(104005, "用户已欠费")

    /* ------------------105xxx 账户相关的错误--------------------------- */
    , ERROR_ACCOUNT_NOT_EXIST(105001, "账户不存在")
    , ERROR_ACCOUNT_PASSWORD_INCORRECT(105002, "账户密码不正确")
    , ERROR_ACCOUNT_LOCKED(105003, "账户被锁定")
    , ERROR_ACCOUNT_EXPIRE(105004, "账户已过期")
    , ERROR_ACCOUNT_ARREARS(105005, "账户已欠费")

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

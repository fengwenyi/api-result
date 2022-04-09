package com.fengwenyi.api.result;

/**
 * <p>
 *     返回码及信息接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2.5.0
 */
public interface IReturnCode {

    /**
     * 返回码
     * @return 返回码
     * @since 2.6.0
     */
    String getCode();

    /**
     * 提示信息
     * @return 提示信息
     */
    String getMessage();

    /**
     * 默认
     */
    @SuppressWarnings("all")
    enum Default implements IReturnCode {

        /* -----------------成功---------------------------- */
        SUCCESS("SUCCESS", "Success")

        /* ------------------错误--------------------------- */
        , ERROR("ERROR", "错误")

        /* ------------------101xxx 请求错误--------------------------- */
        , REQUEST_METHOD_NOT_SUPPORT("REQUEST_METHOD_NOT_SUPPORT", "请求方法不支持")

        /* ------------------102xxx 参数错误--------------------------- */
        , PARAM_NOT_NULL("PARAM_NOT_NULL", "参数不能为空")
        , PARAM_EXCEPTION("PARAM_EXCEPTION", "参数异常")
        , PARAM_ILLEGAL("PARAM_ILLEGAL", "参数非法")
        , PARAM_MISS("PARAM_MISS", "参数缺失")
        , PARAM_VALIDATED("PARAM_VALIDATED", "参数校验失败")

        /* ------------------103xxx 数据错误--------------------------- */
        , DATA_SAVE_FAILURE("DATA_SAVE_FAILURE", "数据保存失败")
        , DATA_UPDATE_FAILURE("DATA_UPDATE_FAILURE", "数据修改失败")
        , DATA_DELETE_FAILURE("DATA_DELETE_FAILURE", "数据删除失败")

        /* ------------------104xxx 用户相关的错误--------------------------- */
        , USER_NOT_EXIST("USER_NOT_EXIST", "用户不存在")
        , USER_PASSWORD_INCORRECT("USER_PASSWORD_INCORRECT", "用户密码不正确")
        , USER_LOCKED("USER_LOCKED", "用户被锁定")
        , USER_EXPIRE("USER_EXPIRE", "用户已过期")
        , USER_ARREARS("USER_ARREARS", "用户已欠费")

        /* ------------------105xxx 账户相关的错误--------------------------- */
        , ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST", "账户不存在")
        , ACCOUNT_PASSWORD_INCORRECT("ACCOUNT_PASSWORD_INCORRECT", "账户密码不正确")
        , ACCOUNT_LOCKED("ACCOUNT_LOCKED", "账户被锁定")
        , ACCOUNT_EXPIRE("ACCOUNT_EXPIRE", "账户已过期")
        , ACCOUNT_ARREARS("ACCOUNT_ARREARS", "账户已欠费")

        /* ------------------106xxx 服务调用相关的错误--------------------------- */
        , SERVICE_CALL_EXCEPTION("SERVICE_CALL_EXCEPTION", "服务调用异常")
        , SERVICE_RESPONSE_EXCEPTION("SERVICE_RESPONSE_EXCEPTION", "服务响应异常")
        ;

        /** 返回码 */
        private final String code;

        /** 提示信息 */
        private final String message;

        /**
         * 构造方法
         * @param code 返回码
         * @param message 提示信息
         */
        Default(String code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * {@code errCode} get方法
         * @return 错误码
         */
        @Override
        public String getCode() {
            return code;
        }

        /**
         * {@code msg} get方法
         * @return 描述
         */
        @Override
        public String getMessage() {
            return message;
        }
    }

}

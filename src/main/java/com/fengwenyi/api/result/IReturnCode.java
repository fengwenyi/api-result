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
     */
    Integer getCode();

    /**
     * 提示信息
     * @return 提示信息
     */
    String getMessage();

    /**
     * 默认
     */
    enum Default implements IReturnCode {

        /* -----------------成功---------------------------- */
        SUCCESS(0, "Success")

        /* ------------------错误--------------------------- */
        , ERROR(-1, "错误")

        /* ------------------101xxx 请求错误--------------------------- */
        , REQUEST_METHOD_NOT_SUPPORT(101001, "请求方法不支持")

        /* ------------------102xxx 参数错误--------------------------- */
        , PARAM_NOT_NULL(102001, "参数不能为空")
        , PARAM_EXCEPTION(102002, "参数异常")
        , PARAM_ILLEGAL(102003, "参数非法")

        /* ------------------103xxx 数据错误--------------------------- */
        , DATA_SAVE_FAILURE(103001, "数据保存失败")
        , DATA_UPDATE_FAILURE(103002, "数据修改失败")
        , DATA_DELETE_FAILURE(103003, "数据删除失败")

        /* ------------------104xxx 用户相关的错误--------------------------- */
        , USER_NOT_EXIST(104001, "用户不存在")
        , USER_PASSWORD_INCORRECT(104002, "用户密码不正确")
        , USER_LOCKED(104003, "用户被锁定")
        , USER_EXPIRE(104004, "用户已过期")
        , USER_ARREARS(104005, "用户已欠费")

        /* ------------------105xxx 账户相关的错误--------------------------- */
        , ACCOUNT_NOT_EXIST(105001, "账户不存在")
        , ACCOUNT_PASSWORD_INCORRECT(105002, "账户密码不正确")
        , ACCOUNT_LOCKED(105003, "账户被锁定")
        , ACCOUNT_EXPIRE(105004, "账户已过期")
        , ACCOUNT_ARREARS(105005, "账户已欠费")

        /* ------------------106xxx 服务调用相关的错误--------------------------- */
        , SERVICE_CALL_EXCEPTION(106001, "服务调用异常")
        , SERVICE_RESPONSE_EXCEPTION(106002, "服务响应异常")
        ;

        /** 返回码 */
        private final Integer code;

        /** 提示信息 */
        private final String message;

        /**
         * 构造方法
         * @param code 返回码
         * @param message 提示信息
         */
        Default(int code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * {@code errCode} get方法
         * @return 错误码
         */
        @Override
        public Integer getCode() {
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

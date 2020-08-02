package com.fengwenyi.api.result;

/**
 * @author Erwin Feng
 * @since 2020/8/2
 */
public interface IError {

    String getCode();

    String getMessage();

    public static enum Default implements IError {

        /* -----------------成功---------------------------- */
        SUCCESS("111111", "Success")

        /* ------------------888xxx 通用错误--------------------------- */
        , ERROR_COMMON_EXCEPTION("080001", "通用错误")

        /* ------------------999xxx 系统错误--------------------------- */
        , ERROR_SYSTEM_EXCEPTION("090001", "系统异常")

        /* ------------------101xxx 请求错误--------------------------- */
        , ERROR_REQUEST_METHOD_NOT_SUPPORT("001001", "请求方法不支持")

        /* ------------------102xxx 参数错误--------------------------- */
        , ERROR_PARAM_NOT_NULL("002001", "参数不能为空")
        , ERROR_PARAM_EXCEPTION("002002", "参数异常")
        , ERROR_PARAM_ILLEGAL("002003", "参数非法")

        /* ------------------103xxx 数据错误--------------------------- */
        , ERROR_DATA_SAVE_FAILURE("003001", "数据保存失败")
        , ERROR_DATA_UPDATE_FAILURE("003002", "数据修改失败")
        , ERROR_DATA_DELETE_FAILURE("003003", "数据删除失败")

        /* ------------------104xxx 用户相关的错误--------------------------- */
        , ERROR_USER_NOT_EXIST("004001", "用户不存在")
        , ERROR_USER_PASSWORD_INCORRECT("004002", "用户密码不正确")
        , ERROR_USER_LOCKED("004003", "用户被锁定")
        , ERROR_USER_EXPIRE("004004", "用户已过期")
        , ERROR_USER_ARREARS("004005", "用户已欠费")

        /* ------------------105xxx 账户相关的错误--------------------------- */
        , ERROR_ACCOUNT_NOT_EXIST("005001", "账户不存在")
        , ERROR_ACCOUNT_PASSWORD_INCORRECT("005002", "账户密码不正确")
        , ERROR_ACCOUNT_LOCKED("005003", "账户被锁定")
        , ERROR_ACCOUNT_EXPIRE("005004", "账户已过期")
        , ERROR_ACCOUNT_ARREARS("005005", "账户已欠费")

        /* ------------------106xxx 服务调用相关的错误--------------------------- */
        , ERROR_SERVICE_CALL_EXCEPTION("006001", "服务调用失败")
        ;

        private String code;

        private String message;

        Default(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return null;
        }

        @Override
        public String getMessage() {
            return null;
        }
    }

}

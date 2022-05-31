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

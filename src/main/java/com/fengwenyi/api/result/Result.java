package com.fengwenyi.api.result;

/**
 * <p>
 *     结果码接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2.7.0
 */
public interface Result {

    /**
     * 结果码
     * @return 结果码
     */
    String getCode();

    /**
     * 描述
     * @return 描述
     */
    String getMsg();

    /**
     * 默认
     */
    enum Default implements Result {

        /* -----------------成功---------------------------- */
        SUCCESS("SUCCESS", "Success")

        /* ------------------错误--------------------------- */
        , ERROR("ERROR", "错误")
        ;

        /** 结果码 */
        private final String code;

        /** 提示信息 */
        private final String msg;

        /**
         * 构造方法
         * @param code 返回码
         * @param msg 提示信息
         */
        Default(String code, String msg) {
            this.code = code;
            this.msg = msg;
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
        public String getMsg() {
            return msg;
        }
    }

}

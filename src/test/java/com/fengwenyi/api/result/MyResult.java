package com.fengwenyi.api.result;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-14
 */
public class MyResult extends Result.Default {

    /**
     * 构造方法
     *
     * @param code 返回码
     * @param msg  提示信息
     */
    MyResult(String code, String msg) {
        super(code, msg);
    }

    public static final Result BIZ_ERROR = new MyResult("BIZ_ERROR", "业务异常");

}

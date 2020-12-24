package com.fengwenyi.api.result;

/**
 * 示例
 * @author Erwin Feng
 * @since 2020/8/2
 */
public class CommonResponseTests {

    public ResultTemplate<?> testOk() {
        return ResultTemplate.ok();
    }

    public ResultTemplate<?> testError() {
        return ResultTemplate.error();
    }

}

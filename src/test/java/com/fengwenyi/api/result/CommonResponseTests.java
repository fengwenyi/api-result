package com.fengwenyi.api.result;

/**
 * 示例
 * @author Erwin Feng
 * @since 2020/8/2
 */
public class CommonResponseTests {

    public CommonResponse<?> testOk() {
        return CommonResponse.ok();
    }

    public CommonResponse<?> testError() {
        return CommonResponse.error();
    }

}

package com.fengwenyi.api_result.helper;

import com.fengwenyi.api_result.model.ApiResultModel;

/**
 * 结果返回
 * @author Erwin Feng
 * @since 2019-08-02 18:14
 */
public class ResultHelper {

    /**
     * 成功，并返回数据
     * @param code 返回码
     * @param message 描述信息
     * @param data 数据
     * @param <S> 返回码类型
     * @param <T> 数据类型
     * @return 返回结果封装 {@link com.fengwenyi.api_result.model.ApiResultModel}
     */
    public static <S, T> ApiResultModel<S, T> success(S code, String message, T data) {
        return new ApiResultModel<>(code, message, data);
    }

    /**
     * 成功，无数据返回
     * @param code 返回码
     * @param message 描述信息
     * @param <S> 返回码类型
     * @param <T> 数据类型
     * @return 返回结果封装 {@link com.fengwenyi.api_result.model.ApiResultModel}
     */
    public static <S, T> ApiResultModel<S, T> success(S code, String message) {
        return new ApiResultModel<>(code, message, null);
    }

    /**
     * 失败，无数据返回
     * @param code 返回码
     * @param message 描述信息
     * @param <S> 返回码类型
     * @param <T> 数据类型
     * @return 返回结果封装 {@link com.fengwenyi.api_result.model.ApiResultModel}
     */
    public static <S, T> ApiResultModel<S, T> error(S code, String message) {
        return new ApiResultModel<>(code, message);
    }

}

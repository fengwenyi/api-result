package com.fengwenyi.api_result.helper;

import com.fengwenyi.api_result.model.ResultApiPageModel;

/**
 * 接口数据分页工具类
 * @author Erwin Feng
 * @since 2.0.4
 */
public class ResultApiPageHelper {

    /**
     * 错误，请填写详细的错误描述
     * @param code      返回码
     * @param message   详细的错误描述信息
     * @param <C>       返回码类型
     * @return 返回结果封装 {@link ResultApiPageModel}
     */
    public static <C> ResultApiPageModel<C, Void> error(C code, String message) {
        return new ResultApiPageModel<>(code, message);
    }

    /**
     * 成功，无数据
     * @param code      返回码
     * @param message   提示信息
     * @param <C>       返回码类型
     * @return 返回结果封装 {@link ResultApiPageModel}
     */
    public static <C> ResultApiPageModel<C, Void> success(C code, String message) {
        return new ResultApiPageModel<>(code, message, null);
    }

    /**
     * 成功，并返回数据
     * @param code              返回码
     * @param message           提示信息
     * @param data              数据
     * @param totalElements     总条数
     * @param totalPages        总页数
     * @param pageSize          分页大小
     * @param currentPage       当前页
     * @param <C>               返回码类型
     * @param <T>               数据类型
     * @return 返回结果封装 {@link ResultApiPageModel}
     */
    public static <C, T> ResultApiPageModel<C, T> success(C code, String message, T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {
        return new ResultApiPageModel<>(code, message, data, totalElements, totalPages, pageSize, currentPage);
    }

}

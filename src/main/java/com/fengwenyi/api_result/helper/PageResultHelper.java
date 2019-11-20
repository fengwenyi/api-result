package com.fengwenyi.api_result.helper;

import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.api_result.model.PageResultModel;

/**
 * @author Erwin Feng<xfsy_2015@163.com>
 * @since 2019/11/20 12:13
 */
public class PageResultHelper {

    /**
     * 成功，并返回数据
     * @param message  信息
     * @param data     数据
     * @param total    数据总条数
     * @param size     每页显示条数
     * @param pages    总页数
     * @param current  当前页数
     * @param <T>      数据类型
     * @return 返回结果封装 {@link ApiResultModel}
     */
    public static <T> PageResultModel<T> success(String message, T data, long total, int size, long pages, int current) {
        return new PageResultModel<>(message, data, total, size, pages, current);
    }

    /**
     * 失败
     * @param message 错误信息
     * @return 返回结果封装 {@link ApiResultModel}
     */
    public static PageResultModel error(String message) {
        return new PageResultModel(message);
    }

}

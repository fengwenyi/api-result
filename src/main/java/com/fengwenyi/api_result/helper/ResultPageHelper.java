package com.fengwenyi.api_result.helper;

import com.fengwenyi.api_result.model.ResultApiModel;
import com.fengwenyi.api_result.model.ResultPageModel;

/**
 * 分页结果返回封装帮助工具类
 *
 * <p>
 *     该工具类操作的实体类是：{@link ResultPageModel}
 * </p>
 *
 * <p>
 *     我们提供了如下三个方法：
 * </p>
 *
 * <ul>
 *     <li>success(String message, T data, long total, int size, long pages, int current)：成功，并返回分页数据</li>
 *     <li>error(String message)：失败</li>
 * </ul>
 *
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/20 12:13
 * @deprecated {@link com.fengwenyi.api_result.util.ResponseUtils}
 */
public class ResultPageHelper {

    /**
     * 成功，携带描述信息
     * @param message  信息
     * @return 返回结果封装 {@link ResultApiModel}
     * @since 2.0.2
     */
    public static <T> ResultPageModel<T> success(String message) {
        return new ResultPageModel<>(message, null);
    }

    /**
     * 成功，携带描述信息和数据
     * @param message  信息
     * @param data     数据
     * @param <T>      数据类型
     * @return 返回结果封装 {@link ResultApiModel}
     * @since 2.0.2
     */
    public static <T> ResultPageModel<T> success(String message, T data) {
        return new ResultPageModel<>(message, data);
    }

    /**
     * 成功，携带描述信息、数据、总数、每页条数、总页数、当前页
     * @param message           信息
     * @param data              数据
     * @param totalElements     总条数
     * @param totalPages        总页数
     * @param pageSize          每页显示条数
     * @param currentPage       当前页数
     * @param <T>               数据类型
     * @return 返回结果封装 {@link ResultApiModel}
     */
    public static <T> ResultPageModel<T> success(String message, T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {
        return new ResultPageModel<>(message, data, totalElements, totalPages, pageSize, currentPage);
    }


    /**
     * 错误，携带详细的描述信息
     * @param message 错误信息
     * @return 返回结果封装 {@link ResultApiModel}
     */
    public static <T> ResultPageModel<T> error(String message) {
        return new ResultPageModel<>(message);
    }

}

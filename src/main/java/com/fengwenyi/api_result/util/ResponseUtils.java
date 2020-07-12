package com.fengwenyi.api_result.util;

import com.fengwenyi.api_result.entity.ResponseEntity;
import com.fengwenyi.api_result.entity.ResponsePageEntity;

import static com.fengwenyi.api_result.constant.ApiResultConstant.DEFAULT_FAILURE_MESSAGE;
import static com.fengwenyi.api_result.constant.ApiResultConstant.DEFAULT_SUCCESS_MESSAGE;

/**
 * 响应工具类<br>
 *
 * <br>
 *
 * 关于返回属性说明：<br>
 * <ul>
 *     <li>success：返回结果标识。true为成功； false为失败。一定返回</li>
 *     <li>code：响应码。可选。如果不指定，不返回</li>
 *     <li>message：描述信息，一定返回</li>
 *     <li>data：数据，成功并且需要返回数据时，才有该参数</li>
 *     <li>page：分页实体类，分页时，才会返回。可选</li>
 * </ul>
 *
 * @author Erwin Feng
 * @since 2.1.0
 */
public class ResponseUtils {

    /**
     * 成功
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success() {
        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 成功，携带数据
     * @param data 响应数据
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success(T data) {
        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 成功
     * @param message   响应码描述
     * @param data      响应数据
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success(String message, T data) {
        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setMessage(message)
                .setData(data);
    }

    /**
     * 成功
     * @param code      响应码
     * @param message   响应码描述
     * @param data      响应数据
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success(C code, String message, T data) {
        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }

    /**
     * 成功
     * @param code          响应码
     * @param message       响应码描述
     * @param data          响应数据
     * @param totalElements 总条数
     * @param totalPages    总页数
     * @param pageSize      分页大小
     * @param currentPage   当前页
     * @param <C>           响应码类型
     * @param <T>           响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success(C code, String message, T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {

        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setCode(code)
                .setMessage(message)
                .setData(data)
                .setPage(
                        new ResponsePageEntity()
                                .setTotalElements(totalElements)
                                .setTotalPages(totalPages)
                                .setPageSize(pageSize)
                                .setCurrentPage(currentPage));
    }

    /**
     * 成功
     * @param message       响应码描述
     * @param data          响应数据
     * @param totalElements 总条数
     * @param totalPages    总页数
     * @param pageSize      分页大小
     * @param currentPage   当前页
     * @param <C>           响应码类型
     * @param <T>           响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success(String message, T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {

        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setMessage(message)
                .setData(data)
                .setPage(
                        new ResponsePageEntity()
                                .setTotalElements(totalElements)
                                .setTotalPages(totalPages)
                                .setPageSize(pageSize)
                                .setCurrentPage(currentPage));
    }

    /**
     * 成功
     * @param data          响应数据
     * @param totalElements 总条数
     * @param totalPages    总页数
     * @param pageSize      分页大小
     * @param currentPage   当前页
     * @param <C>           响应码类型
     * @param <T>           响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> success(T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {

        return new ResponseEntity<C, T>()
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data)
                .setPage(
                        new ResponsePageEntity()
                                .setTotalElements(totalElements)
                                .setTotalPages(totalPages)
                                .setPageSize(pageSize)
                                .setCurrentPage(currentPage));
    }

    /**
     * 失败
     * @param code      响应码
     * @param message   响应码描述
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> failure(C code, String message) {
        return new ResponseEntity<C, T>()
                .setSuccess(false)
                .setCode(code)
                .setMessage(message);
    }

    /**
     * 失败
     * @param message   响应码描述
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> failure(String message) {
        return new ResponseEntity<C, T>()
                .setSuccess(false)
                .setMessage(message);
    }

    /**
     * 失败
     * @param <C>       响应码类型
     * @param <T>       响应数据类型
     * @return {@link ResponseEntity}
     */
    public static <C, T> ResponseEntity<C, T> failure() {
        return new ResponseEntity<C, T>()
                .setSuccess(false)
                .setMessage(DEFAULT_FAILURE_MESSAGE);
    }

}

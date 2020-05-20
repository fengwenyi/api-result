package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口数据分页实体类
 *
 * <p>
 * 关于类型的说明：
 * </p>
 * <ul>
 *     <li>{@code C}：表示返回码的类型</li>
 *     <li>{@code T}：表示返回的数据类型</li>
 * </ul>
 *
 * @author Erwin Feng
 * @since 2020/5/21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultPageApiModel<C, T> extends ResultPageModel<T> {

    /**
     * 返回码
     */
    private C code;

    /**
     * 无参数构造方法
     */
    public ResultPageApiModel() {
    }

    /**
     * 构造方法
     * @param code    返回码
     * @param message 提示信息
     */
    public ResultPageApiModel(C code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造方法
     * @param code          返回码
     * @param message       提示信息
     * @param data          数据
     * @param totalElements 总条数
     * @param totalPages    总页数
     * @param pageSize      分页大小
     * @param currentPage   当前页
     */
    public ResultPageApiModel(C code, String message, T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {
        super(message, data, totalElements, totalPages, pageSize, currentPage);
        this.code = code;
    }

    /**
     * 构造方法
     * @param code      返回码
     * @param message 提示信息
     * @param data      数据
     */
    public ResultPageApiModel(C code, String message, T data) {
        super(message, data);
        this.code = code;
    }
}

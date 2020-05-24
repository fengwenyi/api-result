package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口数据分页封装模型类
 *
 * <p>
 * 你可以使用该模型类在接口中进行数据分页返回结果
 * </p>
 *
 * <p>
 * 关于泛型的说明：
 * </p>
 * <ul>
 *     <li>{@code C}：表示返回码的类型</li>
 *     <li>{@code T}：表示返回的数据类型</li>
 * </ul>
 *
 * @author Erwin Feng
 * @since 2.0.4
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultPageApiModel<C, T> extends ResultPageModel<T> {

    private static final long serialVersionUID = -4889932150977741960L;

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
     *
     * @param code    返回码
     * @param message 提示信息
     */
    public ResultPageApiModel(C code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造方法
     *
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
     *
     * @param code    返回码
     * @param message 提示信息
     * @param data    数据
     */
    public ResultPageApiModel(C code, String message, T data) {
        super(message, data);
        this.code = code;
    }

    /**
     * 重写 toString()
     *
     * @return 有值的参数拼接成的一个字符串
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PageResultModel {");
        // code
        stringBuilder.append("\"code\"").append(":").append(code);
        // success
        stringBuilder.append(", ").append("\"success\"").append(":").append(super.getSuccess());
        // message
        stringBuilder.append(", ").append("\"message\"").append(":")
                .append("\"").append(super.getMessage()).append("\"");
        // data
        stringBuilder.append(", ").append("\"data\"").append(":").append(super.getData());
        // page
        stringBuilder.append(", page {");
        // totalElements
        stringBuilder.append("\"totalElements\"").append(":").append(super.getPage().getTotalElements());
        // totalPages
        stringBuilder.append(", ").append("\"totalPages\"").append(":").append(super.getPage().getTotalPages());
        // pageSize
        stringBuilder.append(", ").append("\"pageSize\"").append(":").append(super.getPage().getPageSize());
        // currentPage
        stringBuilder.append(", ").append("\"currentPage\"").append(":").append(super.getPage().getCurrentPage());
        stringBuilder.append("}");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

}

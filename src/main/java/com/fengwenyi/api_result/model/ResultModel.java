package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 结果实体封装模型
 *
 * <p>
 *     包含三个属性：
 * </p>
 *
 * <ul>
 *     <li>success：返回结果标识，true / false（成功 / 失败）</li>
 *     <li>message：描述信息，错误时，可以在这里填写错误的详细信息</li>
 *     <li>data：数据，成功并且需要返回数据时，才有该参数</li>
 * </ul>
 *
 * <p>
 *     错误时，只会返回success和message，成功并且需要返回数据时，才会返回三个参数，即success、message和data
 * </p>
 *
 * <p>
 *     数据是一个泛型(T)，可以是基本数据类型，Map，对象或是一个数组（数组里面可以包含多个对象）
 * </p>
 *
 * @author Erwin Feng
 * @since 2019-07-23
 * @deprecated {@link com.fengwenyi.api_result.entity.ResponseEntity}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = 6555943285979897107L;

    /**
     * 成功的标志，true / false
     */
    private Boolean success = false;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 无参数构造方法
     */
    public ResultModel() {
    }

    /**
     * 构造方法
     * @param message 描述信息
     * @param data 数据
     */
    public ResultModel(String message, T data) {
        this.success = true;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造方法
     * @param message 描述信息
     */
    public ResultModel(String message) {
        this.message = message;
    }

    /**
     * 参数success的Get方法
     * @return 结果标识，true / false（成功 / 失败）
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 参数message的Get方法
     * @return 描述信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 参数data的Get方法
     * @return 数据
     */
    public T getData() {
        return data;
    }

    /**
     * 重写 toString()
     * @return 有值的参数拼接成的一个字符串
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("resultModel {");
        // success
        stringBuilder.append("\"success\"").append(":").append(success)
                .append(", ");
        // message
        stringBuilder.append("\"message\"").append(":")
                .append("\"").append(message).append("\"");
        // data
        if (data != null)
            stringBuilder.append(", ").append("\"data\"").append(":")
                    .append("\"").append(data).append("\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

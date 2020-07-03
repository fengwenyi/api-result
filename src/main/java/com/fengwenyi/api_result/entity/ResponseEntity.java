package com.fengwenyi.api_result.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

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
 * @author Erwin Feng
 * @since 2.1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity<C, T> implements Serializable {

    private static final long serialVersionUID = -4186783016544888615L;

    /** 响应码 */
    private C code;

    /** 响应码描述信息 */
    private String message;

    /** 响应结果状态，{@code true} 表示成功；{@code false} 表示失败 */
    private Boolean success;

    /** 响应数据 */
    private T data;

    /** 分页 */
    private ResponsePageEntity page;

    public C getCode() {
        return code;
    }

    public ResponseEntity<C, T> setCode(C code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEntity<C, T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ResponseEntity<C, T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseEntity<C, T> setData(T data) {
        this.data = data;
        return this;
    }

    public ResponsePageEntity getPage() {
        return page;
    }

    public ResponseEntity<C, T> setPage(ResponsePageEntity page) {
        this.page = page;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity<?, ?> that = (ResponseEntity<?, ?>) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(success, that.success) &&
                Objects.equals(data, that.data) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, success, data, page);
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                ", page=" + page +
                '}';
    }
}

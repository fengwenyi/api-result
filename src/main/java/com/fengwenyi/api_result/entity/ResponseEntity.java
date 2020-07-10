package com.fengwenyi.api_result.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

/**
 * 接口响应实体类 </br>
 *
 * </br>
 *
 * 属性介绍：</br>
 * <ul>
 *     <li>success：返回结果标识。true为成功； false为失败</li>
 *     <li>code：响应码，可根据项目业务指定错误码，便于业务处理</li>
 *     <li>message：描述信息，错误时，可以在这里填写错误的详细信息</li>
 *     <li>data：数据，成功并且需要返回数据时，才有该参数</li>
 *     <li>page：分页实体类，接口返回时，会以对象的形式返回</li>
 * </ul>
 *
 * </br>
 *
 * 关于泛型的说明：</br>
 * 响应实体类，用到了两个泛型，分别是响应码(C)和数据(T)。</br>
 * 响应码(C)，可根据业务系统自行指定类型，可以是数字，也可以是字符串。</br>
 * 数据是一个泛型(T)，可以是基本数据类型，Map，对象或是一个数组（数组里面可以包含多个对象）</br>
 *
 * </br>
 *
 * 另外，该实体类使用了构建者模式，你可以一直set下去，非常方便。
 *
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

    /**
     * 获取属性 {@code code} 的值
     * @return 获取属性 {@code code} 的值
     */
    public C getCode() {
        return code;
    }

    /**
     * 给属性 {@code code} 赋值
     * @param code {@code code}
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<C, T> setCode(C code) {
        this.code = code;
        return this;
    }

    /**
     * 获取属性 {@code message} 的值
     * @return 获取属性 {@code message} 的值
     */
    public String getMessage() {
        return message;
    }

    /**
     * 给属性 {@code message} 赋值
     * @param message {@code message}
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<C, T> setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 获取属性 {@code success} 的值
     * @return 获取属性 {@code success} 的值
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 给属性 {@code success} 赋值
     * @param success {@code success}
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<C, T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * 获取属性 {@code data} 的值
     * @return 获取属性 {@code data} 的值
     */
    public T getData() {
        return data;
    }

    /**
     * 给属性 {@code data} 赋值
     * @param data {@code data}
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<C, T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * 获取属性 {@code page} 的值
     * @return 获取属性 {@code page} 的值
     */
    public ResponsePageEntity getPage() {
        return page;
    }

    /**
     * 给属性 {@code page} 赋值
     * @param page {@code page}
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<C, T> setPage(ResponsePageEntity page) {
        this.page = page;
        return this;
    }

    /**
     * 重写 {@code equals} 方法
     * @param o 待比对的对象
     * @return 返回两个对象是否是相等，true：相等；false：不相等
     */
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

    /**
     * 重写 {@code hashCode} 方法
     * @return 返回对象的 hash 值
     */
    @Override
    public int hashCode() {
        return Objects.hash(code, message, success, data, page);
    }

    /**
     * 重写 {@code toString} 方法
     * @return 返回由对象各个属性的值拼接的字符串
     */
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

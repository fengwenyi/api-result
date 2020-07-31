package com.fengwenyi.api.result.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fengwenyi.api.result.enums.ResponseCodeEnum;

import java.io.Serializable;
import java.util.Map;

/**
 * 这是顶层，不能再添加其他属性进行返回。
 * 如果需要，解决方案：
 * 如果是请求相关的，可以添加到 {@code header} 里面，这是一个 {@link Map}
 * 如果是数据，必须保存到body里
 * @author Erwin Feng
 * @since 2.2.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> implements Serializable {

    private static final long serialVersionUID = -4206473602305400988L;

    /** 响应码 */
    private String code;

    /** 响应码描述信息 */
    private String message;

    /** 响应结果状态，{@code true} 表示成功；{@code false} 表示失败 */
    private Boolean success = false;

    /** 追溯ID */
    private String traceId;

    /** 可以存放请求相关的信息 */
    private Map<String, String> header;

    /** 响应数据 */
    private T body;

    public ResponseModel() {
    }

    public ResponseModel(String code, String message, Boolean success, String traceId, Map<String, String> header, T body) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.traceId = traceId;
        this.header = header;
        this.body = body;
    }

    public static <T> ResponseModel<T> ok() {
        return new ResponseModel<T>()
                .setSuccess(true)
                .setCode(ResponseCodeEnum.SUCCESS.getCode())
                .setMessage(ResponseCodeEnum.SUCCESS.getValue());
    }

    public static <T> ResponseModel<T> ok(T body) {
        return new ResponseModel<T>()
                .setSuccess(true)
                .setCode(ResponseCodeEnum.SUCCESS.getCode())
                .setMessage(ResponseCodeEnum.SUCCESS.getValue())
                .setBody(body);
    }


    public static <T> ResponseModel<T> error() {
        return new ResponseModel<T>()
                .setCode(ResponseCodeEnum.ERROR_COMMON_EXCEPTION.getCode())
                .setMessage(ResponseCodeEnum.ERROR_COMMON_EXCEPTION.getValue());
    }

    public static <T> ResponseModel<T> error(String message) {
        return new ResponseModel<T>()
                .setCode(ResponseCodeEnum.ERROR_COMMON_EXCEPTION.getCode())
                .setMessage(message);
    }

    public static <T> ResponseModel<T> error(String code, String message) {
        return new ResponseModel<T>()
                .setCode(code)
                .setMessage(message);
    }

    public String getCode() {
        return code;
    }

    public ResponseModel<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseModel<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ResponseModel<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getTraceId() {
        return traceId;
    }

    public ResponseModel<T> setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public ResponseModel<T> setHeader(Map<String, String> header) {
        this.header = header;
        return this;
    }

    public T getBody() {
        return body;
    }

    public ResponseModel<T> setBody(T body) {
        this.body = body;
        return this;
    }
}

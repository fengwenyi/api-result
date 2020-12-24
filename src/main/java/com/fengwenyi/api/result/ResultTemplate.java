package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Map;

/**
 * 封装接口响应实体类
 *
 * <p>
 * 预设属性及介绍：
 * </p>
 *
 * <ul>
 *     <li>{@code code} ：返回码</li>
 *     <li>{@code message} ：返回码描述信息</li>
 *     <li>{@code success} ：响应结果状态，{@code true} 表示成功；{@code false} 表示失败</li>
 *     <li>{@code traceId} ：追溯码，json格式返回时，字段为：{@code trace_id}</li>
 *     <li>{@code header} ：响应头</li>
 *     <li>{@code body} ：响应体</li>
 * </ul>
 *
 * <p>
 *     值得注意的是，如果属性没有值，则属性的值为null，
 *     那么在返回json格式的数据中，将不会出现改属性。
 *     这是因为这个实体类加了
 *     {@code @JsonInclude(JsonInclude.Include.NON_NULL)}
 * </p>
 *
 * <p>
 *     另外，{@code success} 属性，默认是false，
 *     如果你在返回的时候没有使用给定的 {@code ok()} 方法。
 *     那么，你需要手动修改值。
 *     否则返回的值可能依旧是 {@code false}.
 *     那么在做出判断时，使用该属性，可能不准确。
 * </p>
 *
 * <p>
 *     关于设计的说明：
 * </p>
 *
 * <p>
 *     这是顶层，不能再添加其他属性进行返回。
 *     如果需要，解决方案：
 *     如果是请求相关的，可以添加到 {@code header} 里面，这是一个 {@link Map}
 *     如果是数据，必须保存到body里
 * </p>
 *
 * @author Erwin Feng
 * @since 2.2.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultTemplate<T> implements Serializable {

    private static final long serialVersionUID = -4206473602305400988L;

    /**
     * 默认操作成功
     */
    private static final IError DEFAULT_SUCCESS = IError.Default.SUCCESS;

    /**
     * 默认操作失败
     */
    private static final IError DEFAULT_ERROR = IError.Default.ERROR_COMMON_EXCEPTION;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应码描述信息
     */
    private String message;

    /**
     * 响应结果状态，{@code true} 表示成功；{@code false} 表示失败
     */
    private Boolean success = false;

    /**
     * 响应头：可以存放请求相关的信息
     */
    private BaseHeader header;

    /**
     * 响应体
     */
    private T body;

    /**
     * 构造方法：无参数
     */
    public ResultTemplate() {
    }

    /**
     * 构造方法
     *
     * @param code    返回码
     * @param message 描述信息
     * @param success 操作结果，true / false
     * @param header  响应头
     * @param body    响应体
     */
    public ResultTemplate(String code, String message, Boolean success, BaseHeader header, T body) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.header = header;
        this.body = body;
    }

    /**
     * 构造方法
     *
     * @param code    返回码
     * @param message 描述信息
     * @param success 操作结果，true / false
     * @param body    响应体
     */
    public ResultTemplate(String code, String message, Boolean success, T body) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.body = body;
    }

    /**
     * 构造方法
     *
     * @param iError  {@link IError}
     * @param success 操作结果，true / false
     * @param body    响应体
     */
    public ResultTemplate(IError iError, Boolean success, T body) {
        this.code = iError.getCode();
        this.message = iError.getMessage();
        this.success = success;
        this.body = body;
    }

    /**
     * 操作成功
     *
     * @param <T> 响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> ok() {
        return new ResultTemplate<T>()
                .setSuccess(true)
                .setCode(DEFAULT_SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS.getMessage());
    }

    /**
     * 操作成功
     *
     * @param body 响应体
     * @param <T>  响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> ok(T body) {
        return new ResultTemplate<T>()
                .setSuccess(true)
                .setCode(DEFAULT_SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS.getMessage())
                .setBody(body);
    }

    /**
     * 操作成功
     *
     * @param code    响应码
     * @param message 响应信息
     * @param <T>     响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> ok(String code, String message) {
        return new ResultTemplate<T>()
                .setSuccess(true)
                .setCode(code)
                .setMessage(message);
    }

    /**
     * 操作成功
     *
     * @param code    响应码
     * @param message 响应信息
     * @param body    响应体
     * @param <T>     响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> ok(String code, String message, T body) {
        return new ResultTemplate<T>()
                .setSuccess(true)
                .setCode(code)
                .setMessage(message)
                .setBody(body)
                ;
    }

    /**
     * 操作失败
     *
     * @param <T> 响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> error() {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getCode())
                .setMessage(DEFAULT_ERROR.getMessage());
    }

    /**
     * 操作失败
     *
     * @param message 响应信息
     * @param <T>     响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> error(String message) {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getCode())
                .setMessage(message);
    }

    /**
     * 操作失败
     *
     * @param code    响应码
     * @param message 响应信息
     * @param <T>     响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> error(String code, String message) {
        return new ResultTemplate<T>()
                .setCode(code)
                .setMessage(message);
    }

    /**
     * 操作失败
     *
     * @param error {@link IError}
     * @param <T>   响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> error(IError error) {
        return new ResultTemplate<T>()
                .setCode(error.getCode())
                .setMessage(error.getMessage());
    }

    /**
     * {@code code} 的get方法
     *
     * @return {@code code} 的值
     */
    public String getCode() {
        return code;
    }

    /**
     * {@code code} 的get方法
     *
     * @param code 响应码
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * {@code message} 的get方法
     *
     * @return {@code message} 的值
     */
    public String getMessage() {
        return message;
    }

    /**
     * {@code message} 的get方法
     *
     * @param message 响应信息
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * {@code success} 的get方法
     *
     * @return {@code success} 的值
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * {@code success} 的get方法
     *
     * @param success 操作结果
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * {@code header} 的get方法
     *
     * @return {@code header} 的值
     */
    public BaseHeader getHeader() {
        return header;
    }

    /**
     * {@code header} 的get方法
     *
     * @param header 响应头
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setHeader(BaseHeader header) {
        this.header = header;
        return this;
    }

    /**
     * {@code body} 的get方法
     *
     * @return {@code body} 的值
     */
    public T getBody() {
        return body;
    }

    /**
     * {@code body} 的get方法
     *
     * @param body 响应体
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setBody(T body) {
        this.body = body;
        return this;
    }
}
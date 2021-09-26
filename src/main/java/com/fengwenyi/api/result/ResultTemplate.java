package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Map;

/**
 * 封装接口响应实体类 <br><br><br>
 *
 * <p>
 * 属性介绍：
 * </p>
 *
 * <ul>
 *     <li>{@code code} ：返回码</li>
 *     <li>{@code errCode} ：错误码</li>
 *     <li>{@code msg} ：描述</li>
 *     <li>{@code errMsg} ：错误信息</li>
 *     <li>{@code success} ：响应结果状态</li>
 *     <li>{@code header} ：响应头</li>
 *     <li>{@code body} ：响应体</li>
 * </ul>
 *
 * <br>
 *
 * <p>
 *     code，取值范围是 0 或者 1，其中 0-失败；1-成功。
 * </p>
 *
 * <p>
 *     errCode（错误码）和 msg（描述），可根据系统进行自定义。
 * </p>
 *
 * <p>
 *     注意：属性 {@code errCode} 会在 {@code success=false} 时，返回
 * </p>
 *
 * <p>
 *     success， {@code true}-表示成功；{@code false}-表示失败
 * </p>
 *
 * <br><br><br>
 *
 * <p>
 *     如果属性没有值，则属性的值为null，<br>
 *     那么在返回json格式的数据中，将不会出现改属性。<br>
 *     这是因为这个实体类加了
 *     {@code @JsonInclude(JsonInclude.Include.NON_NULL)}
 * </p>
 *
 * <br>
 *
 * <p>
 *     特注需要提醒的是，{@code success} 属性，默认是false，<br>
 *     如果你在返回的时候没有使用给定的 {@code success(...)} 方法。<br>
 *     那么，你需要手动修改值。<br>
 *     否则返回的值可能依旧是 {@code false}.<br>
 *     那么在做出判断时，使用该属性，可能不准确。
 * </p>
 *
 * <br>
 *
 * <p>
 *     关于设计的说明：
 * </p>
 *
 * <p>
 *     这是顶层，不能再添加其他属性进行返回。<br>
 *     如果需要，解决方案：<br>
 *     如果是请求相关的，可以添加到 {@code header} 里面，这是一个 {@link Map}<br>
 *     如果是数据，必须保存到body里<br>
 * </p>
 *
 * <br>
 *
 * @author Erwin Feng
 * @since 2.4.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultTemplate<T> implements Serializable {

    private static final long serialVersionUID = -4206473602305400988L;

    /**
     * 默认操作成功
     */
    private static final IReturnCode DEFAULT_SUCCESS = IReturnCode.Default.SUCCESS;

    /**
     * 默认操作失败
     */
    private static final IReturnCode DEFAULT_ERROR = IReturnCode.Default.ERROR;

    /**
     * 响应码
     */
    private String code;

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 描述
     */
    private String msg;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 响应结果状态，{@code true} 表示成功；{@code false} 表示失败
     */
    private Boolean success = Boolean.FALSE;

    /**
     * 响应头：可以存放请求相关的信息
     */
    private ResultHeader header;

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
     * 操作成功
     *
     * @param <T> {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> success() {
        return new ResultTemplate<T>()
                .setSuccess(Boolean.TRUE)
                .setCode(DEFAULT_SUCCESS.getErrCode())
                .setMsg(DEFAULT_SUCCESS.getMsg());
    }

    /**
     * 操作成功
     *
     * @param body 响应体
     * @param <T>  响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> success(T body) {
        return new ResultTemplate<T>()
                .setSuccess(Boolean.TRUE)
                .setCode(DEFAULT_SUCCESS.getErrCode())
                .setMsg(DEFAULT_SUCCESS.getMsg())
                .setBody(body);
    }

    /**
     * 操作失败
     *
     * @param <T> {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail() {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getErrCode())
                .setErrCode(DEFAULT_ERROR.getErrCode())
                .setMsg(DEFAULT_ERROR.getMsg())
                .setErrMsg(DEFAULT_ERROR.getMsg());
    }


    /**
     * 操作失败
     *
     * @param msg 响应信息
     * @param <T> {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail(String msg) {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getErrCode())
                .setErrCode(DEFAULT_ERROR.getErrCode())
                .setMsg(msg)
                .setErrMsg(msg);
    }


    /**
     * 操作失败
     *
     * @param returnCode {@link IReturnCode}
     * @param <T>        {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail(IReturnCode returnCode) {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getErrCode())
                .setErrCode(returnCode.getErrCode())
                .setMsg(returnCode.getMsg())
                .setErrMsg(returnCode.getMsg());
    }

    /**
     * 操作失败
     *
     * @param returnCode {@link IReturnCode}
     * @param msg        描述信息
     * @param <T>        {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail(IReturnCode returnCode, String msg) {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getErrCode())
                .setErrCode(returnCode.getErrCode())
                .setMsg(returnCode.getMsg())
                .setErrMsg(msg);
    }


    /**
     * 操作失败
     *
     * @param errCode 错误码
     * @param msg     响应信息
     * @param <T>     {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail(String errCode, String msg) {
        return new ResultTemplate<T>()
                .setCode(DEFAULT_ERROR.getErrCode())
                .setErrCode(errCode)
                .setMsg(msg)
                .setErrMsg(msg);
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
    private ResultTemplate<T> setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * {@code msg} 的get方法
     *
     * @return {@code msg} 的值
     */
    public String getMsg() {
        return msg;
    }

    /**
     * {@code msg} 的get方法
     *
     * @param msg 响应信息
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setMsg(String msg) {
        this.msg = msg;
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
    public ResultHeader getHeader() {
        return header;
    }

    /**
     * {@code header} 的get方法
     *
     * @param header 响应头
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setHeader(ResultHeader header) {
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
     * {@code body} 的set方法
     *
     * @param body 响应体
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setBody(T body) {
        this.body = body;
        return this;
    }

    /**
     * {@code errCode} 的get方法
     *
     * @return {@code errCode} 的值
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * {@code errCode} 的set方法
     *
     * @param errCode 错误码
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    /**
     * errMsg的get方法
     * @return errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * errMsg的set方法
     * @param errMsg 错误信息
     * @return this
     */
    public ResultTemplate<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    @Override
    public String toString() {
        return "ResultTemplate{" +
                "code='" + code + '\'' +
                ", errCode='" + errCode + '\'' +
                ", msg='" + msg + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", success=" + success +
                ", header=" + header +
                ", body=" + body +
                '}';
    }
}

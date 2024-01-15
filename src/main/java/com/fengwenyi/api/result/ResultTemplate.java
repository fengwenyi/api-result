package com.fengwenyi.api.result;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * 结果模板
 *
 * <br><br><br>
 *
 * <p>
 * 属性介绍：
 * </p>
 *
 * <ul>
 *     <li>{@code code}     ：结果码</li>
 *     <li>{@code msg}      ：描述</li>
 *     <li>{@code success}  ：成功标志</li>
 *     <li>{@code header}   ：响应头</li>
 *     <li>{@code body}     ：响应体</li>
 * </ul>
 *
 * <br>
 *
 * <p>
 *     当 code（结果码）为 SUCCESS 时，表示成功。此时 success（成功标志）为 {@code true}，表示成功。
 * </p>
 *
 * <p>
 *     反之，当 code（结果码）不为 SUCCESS 时，表示失败。此时 success（成功标志）为 {@code false}，表示失败。
 * </p>
 *
 * <br><br><br>
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
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2.7.0
 */
public class ResultTemplate<T> implements Serializable {

    private static final long serialVersionUID = 2694678370842576448L;

    /**
     * 结果码
     */
    private String code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 结果状态，{@code true}-成功；{@code false}-失败
     */
    private Boolean success = Boolean.FALSE;

    /**
     * 结果头
     */
    private ResultHeader header;

    /**
     * 结果体
     */
    private T body;

    /**
     * 时间
     *
     * <p>格式示例：2022-11-17T22:11:33.436</p>
     */
    private String date = LocalDateTime.now().toString();

    /**
     * 默认操作成功
     */
    private static final IResult SUCCESS = IResult.Default.SUCCESS;

    /**
     * 默认操作失败
     */
    private static final IResult ERROR = IResult.Default.ERROR;

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
                .setCode(SUCCESS.getCode())
                .setMsg(SUCCESS.getMsg())
                ;
    }

    /**
     * 操作成功
     *
     * @param body 响应体
     * @param <T>  响应体类型
     * @return 响应封装类 {@link ResultTemplate}
     */
    @SuppressWarnings("all")
    public static <T> ResultTemplate<T> success(T body) {
        return new ResultTemplate<T>()
                .setSuccess(Boolean.TRUE)
                .setCode(SUCCESS.getCode())
                .setMsg(SUCCESS.getMsg())
                .setBody(body)
                ;
    }

    /**
     * 操作失败
     *
     * @param <T> {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail() {
        return new ResultTemplate<T>()
                .setCode(ERROR.getCode())
                .setMsg(ERROR.getMsg())
                ;
    }


    /**
     * 操作失败
     *
     * @param msg 描述信息
     * @param <T> {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    @SuppressWarnings("all")
    public static <T> ResultTemplate<T> fail(String msg) {
        msg = StringUtils.isBlank(msg) ? ERROR.getMsg() : msg;
        return new ResultTemplate<T>()
                .setCode(ERROR.getCode())
                .setMsg(msg)
                ;
    }


    /**
     * 操作失败
     *
     * @param returnCode {@link IResult}
     * @param <T>        {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    public static <T> ResultTemplate<T> fail(IResult returnCode) {
        return new ResultTemplate<T>()
                .setCode(returnCode.getCode())
                .setMsg(returnCode.getMsg())
                ;
    }

    /**
     * 操作失败
     *
     * @param returnCode {@link IResult}
     * @param msg    描述信息
     * @param <T>        {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    @SuppressWarnings("all")
    public static <T> ResultTemplate<T> fail(IResult returnCode, String msg) {
        msg = StringUtils.isBlank(msg) ? returnCode.getMsg() : msg;
        return new ResultTemplate<T>()
                .setCode(returnCode.getCode())
                .setMsg(msg)
                ;
    }


    /**
     * 操作失败
     *
     * @param code      返回码
     * @param msg   描述信息
     * @param <T>       {@link Void}
     * @return 响应封装类 {@link ResultTemplate}
     */
    @SuppressWarnings("all")
    public static <T> ResultTemplate<T> fail(String code, String msg) {
        return new ResultTemplate<T>()
                .setCode(code)
                .setMsg(msg)
                ;
    }

    /**
     * {@code code} 的get方法
     *
     * @return {@code code} 的值
     */
    @SuppressWarnings("all")
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
     * {@code msg} 的get方法
     *
     * @return {@code msg} 的值
     */
    @SuppressWarnings("all")
    public String getMsg() {
        return msg;
    }

    /**
     * {@code msg} 的get方法
     *
     * @param msg 信息
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
    @SuppressWarnings("all")
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
    @SuppressWarnings("all")
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
    @SuppressWarnings("all")
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
     * {@code date} 的get方法
     * @return {@code date} 的值
     */
    public String getDate() {
        return date;
    }

    /**
     * {@code date} 的set方法
     *
     * @param date 日期，注意类型为 {@link LocalDateTime}
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setDate(LocalDateTime date) {
        if (Objects.nonNull(date)) {
            this.date = date.toString();
        }
        return this;
    }

    /**
     * {@code date} 的set方法
     *
     * @param date 日期，日期格式建议为：{@code uuuu-MM-dd'T'HH:mm:ss.SSS}
     * @return {@link ResultTemplate}
     */
    public ResultTemplate<T> setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "ResultTemplate{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                ", header=" + header +
                ", body=" + body +
                ", date=" + date +
                '}';
    }
}

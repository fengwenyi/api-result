package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口结果实体封装模型
 *
 * <p>
 *     该实体模型继承了ResultModel，所以具备它的全部属性
 * </p>
 *
 * <p>
 *     有时我们关注结果是否成功，如果错误，不作处理；
 *     有时，我们需要对错误进行处理，考虑到这个问题，
 *     我们增加了这个实体，并且增加了属性：code
 * </p>
 *
 * <p>
 *     参数code的类型，我们允许是泛型，可以根据自己的系统进行合理规划
 * </p>
 *
 * @author Erwin Feng
 * @since 2019-07-23 15:03
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResultModel<S, T> extends ResultModel<T> {

    private static final long serialVersionUID = 1777994529493739156L;

    /**
     * 返回码
     */
    private S code;

    /**
     * 无参数构造方法
     */
    public ApiResultModel() {
    }

    /**
     * 构造方法
     * @param code 返回码
     * @param message 描述信息
     */
    public ApiResultModel(S code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造方法
     * @param code 返回码
     * @param message 描述信息
     * @param data 数据
     */
    public ApiResultModel(S code, String message, T data) {
        super(message, data);
        this.code = code;
    }

    /**
     * 参数code的Get方法
     * @return 返回码
     */
    public S getCode() {
        return code;
    }

    /**
     * 重写 toString()
     * @return 有值的参数拼接成的一个字符串
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("resultModel {");
        // code
        if (code != null)
        stringBuilder.append("\"code\"").append(":").append(code)
                .append(", ");
        // success
        stringBuilder.append("\"success\"").append(":").append(super.getSuccess())
                .append(", ");
        // message
        stringBuilder.append("\"message\"").append(":")
                .append("\"").append(super.getSuccess()).append("\"");
        // data
        if (super.getData() != null)
            stringBuilder.append(", ").append("\"data\"").append(":")
                    .append("\"").append(super.getData()).append("\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

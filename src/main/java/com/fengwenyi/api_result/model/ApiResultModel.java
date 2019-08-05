package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口返回实体
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

    public ApiResultModel() {
    }

    public ApiResultModel(S code, String message) {
        super(message);
        this.code = code;
    }

    public ApiResultModel(S code, String message, T data) {
        super(message, data);
        this.code = code;
    }

    public S getCode() {
        return code;
    }
}

package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     响应头
 * </p>
 *
 * @author Erwin Feng
 * @since 2.5.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeader extends HashMap<String, Object> {

    private static final long serialVersionUID = 6187327761077399909L;

}

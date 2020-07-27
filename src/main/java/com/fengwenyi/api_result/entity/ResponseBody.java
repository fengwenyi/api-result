package com.fengwenyi.api_result.entity;

import java.util.HashMap;

/**
 * @author Erwin Feng
 * @since 2020/7/27
 */
public class ResponseBody<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = 5253428176675031900L;

    private T data;
}

package com.fengwenyi.api.result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Erwin Feng
 * @since 2020/7/31
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponseModel<T> extends ResponseModel<PageModel<T>> {

    private static final long serialVersionUID = 2015137413009569064L;

}

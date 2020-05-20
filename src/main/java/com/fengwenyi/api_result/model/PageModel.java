package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 分页实体类
 * <p>
 *     这个类主要是存放分页的一些属性，包含一些几个字段
 * </p>
 * <ul>
 *     <li>totalElements：总条数</li>
 *     <li>totalPages：总页数</li>
 *     <li>pageSize：每页显示条数</li>
 *     <li>currentPage：当前页</li>
 * </ul>
 * <p>
 *     新版变化：
 * </p>
 * <ul>
 *     <li>对属性进行重新命名，意思更明确</li>
 * </ul>
 * @author Erwin Feng
 * @since 2.0.4
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageModel {

    /**
     * 总条数
     */
    private Long totalElements;

    /**
     * 总页数
     */
    private Long totalPages;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 当前页
     * <p>
     *     将Integer改为Long的原因：假如你的总页数远远大于整数的最大数，
     *     那么这样就很难处理了。但修改之后，并不会影响我们现有的业务
     * </p>
     */
    private Long currentPage;

    /**
     * 参数构造方法
     * @param totalElements     总条数
     * @param totalPages        总页数
     * @param pageSize          每页显示条数
     * @param currentPage       当前页
     */
    public PageModel(Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    /**
     * 无参数构造方法
     */
    public PageModel() {
    }

    /**
     * 参数 {@code totalElements} 的Get方法
     * @return 总条数
     */
    public Long getTotalElements() {
        return totalElements;
    }

    /**
     * 参数 {@code totalPages} 的Get方法
     * @return 总页数
     */
    public Long getTotalPages() {
        return totalPages;
    }

    /**
     * 参数 {@code pageSize} 的Get方法
     * @return 每页显示条数
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 参数 {@code currentPage} 的Get方法
     * @return 当前页
     */
    public Long getCurrentPage() {
        return currentPage;
    }
}

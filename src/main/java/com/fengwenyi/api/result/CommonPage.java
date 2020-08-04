package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 分页实体类
 * <p>
 * 这个类主要是存放分页的一些属性，包含如下字段：
 * </p>
 * <ul>
 *     <li>{@code currentPage}      ：当前页</li>
 *     <li>{@code pageSize}         ：每页显示条数</li>
 *     <li>{@code totalElements}    ：总条数</li>
 *     <li>{@code totalPages}       ：总页数</li>
 *     <li>{@code content}          ：数据</li>
 * </ul>
 *
 * @author Erwin Feng
 * @since 2.2.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonPage<T> implements Serializable {

    private static final long serialVersionUID = 2335780119721719031L;

    /**
     * 当前页
     * <p>
     * 将Integer改为Long的原因：假如你的总页数远远大于整数的最大数，
     * 那么这样就很难处理了。但修改之后，并不会影响我们现有的业务
     * </p>
     */
    private Long currentPage;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long totalElements;

    /**
     * 总页数
     */
    private Long totalPages;

    /**
     * 响应数据
     */
    private T content;

    /**
     * 构造方法：无参数
     */
    public CommonPage() {
    }

    /**
     * 参数构造方法
     *
     * @param totalElements 总条数
     * @param totalPages    总页数
     * @param pageSize      每页显示条数
     * @param currentPage   当前页
     * @param content       数据
     */
    public CommonPage(Long currentPage, Integer pageSize, Long totalElements, Long totalPages, T content) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }

    /**
     * 参数 {@code totalElements} 的Get方法
     *
     * @return 总条数
     */
    public Long getTotalElements() {
        return totalElements;
    }

    /**
     * 参数 {@code totalPages} 的Get方法
     *
     * @return 总页数
     */
    public Long getTotalPages() {
        return totalPages;
    }

    /**
     * 参数 {@code pageSize} 的Get方法
     *
     * @return 每页显示条数
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 参数 {@code currentPage} 的Get方法
     *
     * @return 当前页
     */
    public Long getCurrentPage() {
        return currentPage;
    }

    /**
     * 参数 {@code totalElements} 的Get方法
     *
     * @return {@link CommonPage}
     */
    public CommonPage setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    /**
     * 参数 {@code totalPages} 的Set方法
     *
     * @return {@link CommonPage}
     */
    public CommonPage setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    /**
     * 参数 {@code pageSize} 的Set方法
     *
     * @return {@link CommonPage}
     */
    public CommonPage setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 参数 {@code currentPage} 的Set方法
     *
     * @return {@link CommonPage}
     */
    public CommonPage setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * 参数 {@code content} 的Get方法
     *
     * @return 数据
     */
    public T getContent() {
        return content;
    }

    /**
     * 参数 {@code content} 的Set方法
     *
     * @return {@link CommonPage}
     */
    public CommonPage setContent(T content) {
        this.content = content;
        return this;
    }
}

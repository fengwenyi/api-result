package com.fengwenyi.api_result.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

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
 * @since 2.1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePageEntity implements Serializable {

    private static final long serialVersionUID = 2092000914567749624L;

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

    private T content;

    /**
     * 获取属性 {@code totalElements} 的值
     * @return 获取属性 {@code totalElements} 的值
     */
    public Long getTotalElements() {
        return totalElements;
    }

    /**
     * 给属性 {@code totalElements} 赋值
     * @param totalElements {@code totalElements}
     * @return {@link ResponsePageEntity}
     */
    public ResponsePageEntity setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    /**
     * 获取属性 {@code totalPages} 的值
     * @return 获取属性 {@code totalPages} 的值
     */
    public Long getTotalPages() {
        return totalPages;
    }

    /**
     * 给属性 {@code totalPages} 赋值
     * @param totalPages {@code totalPages}
     * @return {@link ResponsePageEntity}
     */
    public ResponsePageEntity setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    /**
     * 获取属性 {@code pageSize} 的值
     * @return 获取属性 {@code pageSize} 的值
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 给属性 {@code pageSize} 赋值
     * @param pageSize {@code pageSize}
     * @return {@link ResponsePageEntity}
     */
    public ResponsePageEntity setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 获取属性 {@code currentPage} 的值
     * @return 获取属性 {@code currentPage} 的值
     */
    public Long getCurrentPage() {
        return currentPage;
    }

    /**
     * 给属性 {@code currentPage} 赋值
     * @param currentPage {@code currentPage}
     * @return {@link ResponsePageEntity}
     */
    public ResponsePageEntity setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * 重写 {@code equals} 方法
     * @param o 待比对的对象
     * @return 返回两个对象是否是相等，true：相等；false：不相等
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsePageEntity that = (ResponsePageEntity) o;
        return Objects.equals(totalElements, that.totalElements) &&
                Objects.equals(totalPages, that.totalPages) &&
                Objects.equals(pageSize, that.pageSize) &&
                Objects.equals(currentPage, that.currentPage);
    }

    /**
     * 重写 {@code hashCode} 方法
     * @return 返回对象的 hash 值
     */
    @Override
    public int hashCode() {
        return Objects.hash(totalElements, totalPages, pageSize, currentPage);
    }

    /**
     * 重写 {@code toString} 方法
     * @return 返回由对象各个属性的值拼接的字符串
     */
    @Override
    public String toString() {
        return "ResponsePageEntity{" +
                "totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }
}

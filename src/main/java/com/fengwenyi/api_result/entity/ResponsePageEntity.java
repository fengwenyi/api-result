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

    public Long getTotalElements() {
        return totalElements;
    }

    public ResponsePageEntity setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public ResponsePageEntity setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public ResponsePageEntity setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public ResponsePageEntity setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        return this;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(totalElements, totalPages, pageSize, currentPage);
    }

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

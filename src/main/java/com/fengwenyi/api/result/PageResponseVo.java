package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fengwenyi.javalib.jk.IBuilder;

import java.io.Serializable;

/**
 *
 * 分页响应 VO 类 <br><br><br>
 *
 * <p>
 * 这个类主要是存放分页的一些属性，包含如下字段：
 * </p>
 *
 * <ul>
 *     <li>{@code currentPage}      ：当前页</li>
 *     <li>{@code pageSize}         ：每页显示条数</li>
 *     <li>{@code totalRows}        ：总条数</li>
 *     <li>{@code totalPages}       ：总页数</li>
 *     <li>{@code content}          ：数据</li>
 * </ul>
 *
 * <p>
 *     改动说明：属性与之前保持不变，只是改了类名。另外，增加构建者模式
 * </p>
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.4.1
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponseVo<T> implements Serializable {

    private static final long serialVersionUID = 7772247147295029134L;

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
    private Long totalRows;

    /**
     * 总页数
     */
    private Long totalPages;

    /**
     * 响应数据
     */
    private T content;


    public PageResponseVo() {
    }

    public PageResponseVo(Long currentPage, Integer pageSize, Long totalRows, Long totalPages, T content) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
        this.content = content;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public PageResponseVo<T> setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageResponseVo<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public PageResponseVo<T> setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
        return this;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public PageResponseVo<T> setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public T getContent() {
        return content;
    }

    public PageResponseVo<T> setContent(T content) {
        this.content = content;
        return this;
    }


    public static class Builder<T> implements IBuilder<PageResponseVo<T>> {

        private final PageResponseVo<T> pageResponseVo;

        public Builder() {
            pageResponseVo = new PageResponseVo<>();
        }

        public Builder<T> currentPage(long currentPage) {
            this.pageResponseVo.currentPage = currentPage;
            return this;
        }

        public Builder<T> pageSize(int pageSize) {
            this.pageResponseVo.pageSize = pageSize;
            return this;
        }

        public Builder<T> totalRows(long totalRows) {
            this.pageResponseVo.totalRows = totalRows;
            return this;
        }

        public Builder<T> totalPages(long totalPages) {
            this.pageResponseVo.totalPages = totalPages;
            return this;
        }

        public PageResponseVo<T> build() {
            return this.pageResponseVo;
        }
    }

    @Override
    public String toString() {
        return "PageResponseVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", content=" + content +
                '}';
    }
}

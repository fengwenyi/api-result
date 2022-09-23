package com.fengwenyi.api.result;

import java.util.List;

/**
 *
 * 分页响应类 <br><br><br>
 *
 * <p>
 * 这个类主要是存放分页的一些属性，包含如下字段：
 * </p>
 *
 * <ul>
 *     <li>{@code current}          ：当前页</li>
 *     <li>{@code pageSize}         ：每页显示条数</li>
 *     <li>{@code totalRow}         ：总条数 rows</li>
 *     <li>{@code totalPage}        ：总页数</li>
 *     <li>{@code content}          ：数据</li>
 * </ul>
 *
 * <p>
 *     改动说明：属性与之前保持不变，只是改了类名。另外，增加构建者模式
 * </p>
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.7.0
 */
public class PageTemplate<T> extends ListTemplate<T> {

    private static final long serialVersionUID = -4253922988693797927L;

    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long totalRow;

    /**
     * 总页数
     */
    private Long totalPage;


    /**
     * 无参数构造方法
     */
    public PageTemplate() {
    }

    /**
     * 构造方法
     * @param current 当前页
     * @param pageSize 分页大小
     * @param totalRow 总行数
     * @param totalPage 总页数
     * @param content 数据
     */
    public PageTemplate(Long current, Integer pageSize, Long totalRow, Long totalPage, List<T> content) {
        this.current = current;
        this.pageSize = pageSize;
        this.totalRow = totalRow;
        this.totalPage = totalPage;
        super.setContent(content);
    }

    /**
     * 获取当前页
     * @return 返回当前页
     */
    public Long getCurrent() {
        return current;
    }

    /**
     * 设置当前页
     * @param current 当前页
     * @return PageResponseVo
     */
    public PageTemplate<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    /**
     * 获取分页大小
     * @return 分页大小
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置分页大小
     * @param pageSize 分页大小
     * @return PageResponseVo
     */
    public PageTemplate<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 获取总条数
     * @return 总条数
     */
    public Long getTotalRow() {
        return totalRow;
    }

    /**
     * 设置总条数
     * @param totalRow 总条数
     * @return PageResponseVo
     */
    public PageTemplate<T> setTotalRow(long totalRow) {
        this.totalRow = totalRow;
        return this;
    }

    /**
     * 获取总页数
     * @return 总页数
     */
    public Long getTotalPages() {
        return totalPage;
    }

    /**
     * 设置总页数
     * @param totalPage 总页数
     * @return PageResponseVo
     */
    public PageTemplate<T> setTotalPage(long totalPage) {
        this.totalPage = totalPage;
        return this;
    }


    /**
     * PageResponse构造者，可通过该类构造出PageResponseVo
     * @param <T> 范型
     */
    public static class Builder<T> implements IBuilder<PageTemplate<T>> {

        // PageResponseVo 对象
        private final PageTemplate<T> pageTemplate;

        /**
         * 无参数构造方法，new一个 PageResponseVo 对象
         */
        public Builder() {
            pageTemplate = new PageTemplate<>();
        }

        /*public static <T> Builder<T> newBuilder() {
            return new Builder<>();
        }*/

        /**
         * 设置当前页
         * @param current 当前页
         * @return Builder
         */
        public Builder<T> current(long current) {
            this.pageTemplate.current = current;
            return this;
        }

        /**
         * 设置分页大小
         * @param pageSize 分页大小
         * @return Builder
         */
        public Builder<T> pageSize(int pageSize) {
            this.pageTemplate.pageSize = pageSize;
            return this;
        }

        /**
         * 设置总条数
         * @param totalRow 总条数
         * @return Builder
         */
        public Builder<T> totalRow(long totalRow) {
            this.pageTemplate.totalRow = totalRow;
            return this;
        }

        /**
         * 设置总页数
         * @param totalPage 总页数
         * @return Builder
         */
        public Builder<T> totalPage(long totalPage) {
            this.pageTemplate.totalPage = totalPage;
            return this;
        }

        /**
         * 设置内容
         * @param content 内容
         * @return Builder
         */
        public Builder<T> content(List<T> content) {
            this.pageTemplate.setContent(content);
            return this;
        }

        /**
         * 给属性赋值完成，调该方法可构造出PageResponseVo的对象
         * @return PageResponseVo
         */
        @Override
        public PageTemplate<T> build() {
            return this.pageTemplate;
        }
    }

    /**
     * toString方法
     * @return 将属性及对应值拼接成字符串
     */
    @Override
    public String toString() {
        return "PageTemplate{" +
                "current=" + current +
                ", pageSize=" + pageSize +
                ", totalRow=" + totalRow +
                ", totalPage=" + totalPage +
                ", content=" + getContent() +
                '}';
    }
}

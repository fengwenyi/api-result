package com.fengwenyi.api.result;

import java.util.List;

/**
 * @author Erwin Feng
 * @since 2020-12-24
 */
public class PageRequest<T> {

    /** 当前页 */
    private Long currentPage;

    /** 每页显示条数 */
    private Integer pageSize;

    /** 查询条件 */
    private T query;

    /** 升序排序字段：数组 */
    private List<String> ascColumnNames;

    /** 降序排列字段：数组 */
    private List<String> descColumnNames;

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public List<String> getAscColumnNames() {
        return ascColumnNames;
    }

    public void setAscColumnNames(List<String> ascColumnNames) {
        this.ascColumnNames = ascColumnNames;
    }

    public List<String> getDescColumnNames() {
        return descColumnNames;
    }

    public void setDescColumnNames(List<String> descColumnNames) {
        this.descColumnNames = descColumnNames;
    }
}

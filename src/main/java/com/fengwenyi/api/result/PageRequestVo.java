package com.fengwenyi.api.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 分页请求类
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.4.1
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageRequestVo<T> implements Serializable {

    private static final long serialVersionUID = -6056923744875775355L;

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

    public PageRequestVo() {
    }

    public PageRequestVo(Long currentPage, Integer pageSize, T query, List<String> ascColumnNames, List<String> descColumnNames) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.query = query;
        this.ascColumnNames = ascColumnNames;
        this.descColumnNames = descColumnNames;
    }

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

    @Override
    public String toString() {
        return "PageRequestVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", query=" + query +
                ", ascColumnNames=" + ascColumnNames +
                ", descColumnNames=" + descColumnNames +
                '}';
    }
}

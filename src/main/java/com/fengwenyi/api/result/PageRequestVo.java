package com.fengwenyi.api.result;

import java.io.Serializable;

/**
 *
 * 分页请求类
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.4.1
 */
@SuppressWarnings("all")
public class PageRequestVo implements Serializable {

    private static final long serialVersionUID = -6056923744875775355L;

    /** 当前页 */
    private Long currentPage;

    /** 每页显示条数 */
    private Integer pageSize;

    public PageRequestVo() {
    }

    public PageRequestVo(Long currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
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

    @Override
    public String toString() {
        return "PageRequestVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}

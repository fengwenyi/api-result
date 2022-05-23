package com.fengwenyi.api.result;

import java.io.Serializable;

/**
 *
 * 分页请求类
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.7.0
 */
public class PageRequestVo implements Serializable {

    private static final long serialVersionUID = -6056923744875775355L;

    /** 当前页 */
    private Long current;

    /** 每页显示条数 */
    private Integer pageSize;

    public PageRequestVo() {
    }

    public PageRequestVo(Long current, Integer pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
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
                "current=" + current +
                ", pageSize=" + pageSize +
                '}';
    }
}

package com.fengwenyi.api.result;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-13
 */
public class ListTemplate<T> implements Serializable {

    private static final long serialVersionUID = 1673060065136736928L;

    /** 列表数据 */
    private List<T> content;

    /** 用时 */
    private Long timeCost;

    public List<T> getContent() {
        return content;
    }

    public ListTemplate<T> setContent(List<T> content) {
        this.content = content;
        return this;
    }

    public Long getTimeCost() {
        return timeCost;
    }

    public ListTemplate<T> setTimeCost(Long timeCost) {
        this.timeCost = timeCost;
        return this;
    }
}

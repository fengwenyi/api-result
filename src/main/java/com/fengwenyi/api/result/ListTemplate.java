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

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}

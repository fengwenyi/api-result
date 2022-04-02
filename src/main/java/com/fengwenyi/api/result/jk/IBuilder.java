package com.fengwenyi.api.result.jk;

/**
 * 构造者模式接口
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.5.2
 */
public interface IBuilder<T> {

    /**
     * 构建一个对象
     * @return 构建对象
     */
    @SuppressWarnings("all")
    T build();

}

package com.fengwenyi.api_result.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * 分页结果实体封装模型
 *
 * <p>
 *     该实体模型继承了{@link com.fengwenyi.api_result.model.ResultModel}，所以具备它的全部属性
 * </p>
 *
 * <p>
 *     在这里，我们增加有关分页的一些属性，比如：数据总条数，总页数，每页显示大小，当前页。如下：
 * </p>
 *
 * <ul>
 *     <li>total  : 数据总条数</li>
 *     <li>size   : 每页显示条数</li>
 *     <li>pages  : 总页数</li>
 *     <li>current: 当前页</li>
 * </ul>
 *
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/20 11:37
 * @see com.fengwenyi.api_result.model.ResultModel
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResultModel<T> extends ResultModel<T> {

    private static final long serialVersionUID = 5001896963554548570L;

    /**
     * 总数
     */
    private Long total;

    /**
     * 每页显示条数，默认 10
     */
    private Integer size;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 无参数构造方法
     */
    public PageResultModel() {
    }

    /**
     * 带参数构造方法
     * @param message 信息
     * @param data    数据
     * @param total   数据总条数
     * @param size    每页显示条数
     * @param pages   总页数
     * @param current 当前页
     */
    public PageResultModel(String message, T data, long total, int size, long pages, int current) {
        super(message, data);
        this.total = total;
        this.size = size;
        this.pages = pages;
        this.current = current;
    }

    /**
     * 带参数构造方法
     * @param message 信息
     */
    public PageResultModel(String message) {
        super(message);
    }

    /**
     * 重写 toString()
     * @return 有值的参数拼接成的一个字符串
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PageResultModel {");
        // success
        stringBuilder.append("\"success\"").append(":").append(super.getSuccess())
                .append(", ");
        // message
        stringBuilder.append("\"message\"").append(":")
                .append("\"").append(super.getSuccess()).append("\"");
        // data
        if (super.getData() != null)
            stringBuilder.append(", ").append("\"data\"").append(":")
                    .append("\"").append(super.getData()).append("\"");
        // total
        if (total != null)
            stringBuilder.append(", ").append("\"total\"").append(":").append(total);
        // size
        if (size != null)
            stringBuilder.append(", ").append("\"size\"").append(":").append(size);
        // pages
        if (pages != null)
            stringBuilder.append(", ").append("\"pages\"").append(":").append(pages);
        // current
        if (current != null)
            stringBuilder.append(", ").append("\"current\"").append(":").append(current);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

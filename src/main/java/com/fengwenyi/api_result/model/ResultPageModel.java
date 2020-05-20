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
 * @author Erwin Feng
 * @since 2019/11/20
 * @see com.fengwenyi.api_result.model.ResultModel
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultPageModel<T> extends ResultModel<T> {

    private static final long serialVersionUID = 5001896963554548570L;

    /** 分页信息 */
    private PageModel page;

    /**
     * 无参数构造方法
     */
    public ResultPageModel() {
    }

    /**
     * 带参数构造方法
     * @param message 信息
     * @param data    数据

     */
    public ResultPageModel(String message, T data, Long totalElements, Long totalPages, Integer pageSize, Long currentPage) {
        super(message, data);
        page = new PageModel(totalElements, totalPages, pageSize, currentPage);
    }

    /**
     * 带参数构造方法
     * @param message 信息
     * @param data    数据
     */
    public ResultPageModel(String message, T data) {
        super(message, data);
    }

    /**
     * 带参数构造方法
     * @param message 信息
     */
    public ResultPageModel(String message) {
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
        // page
        if (page != null) {
            stringBuilder.append("page {");
            // totalElements
            if (page.getTotalElements() != null)
                stringBuilder.append(", ").append("\"totalElements\"").append(":").append(page.getTotalElements());
            // totalPages
            if (page.getTotalPages() != null)
                stringBuilder.append(", ").append("\"totalPages\"").append(":").append(page.getTotalPages());
            // pageSize
            if (page.getPageSize() != null)
                stringBuilder.append(", ").append("\"pageSize\"").append(":").append(page.getPageSize());
            // currentPage
            if (page.getCurrentPage() != null)
                stringBuilder.append(", ").append("\"currentPage\"").append(":").append(page.getCurrentPage());
            stringBuilder.append("}");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

package com.fengwenyi.api.result;

import com.fengwenyi.javalib.convert.JsonUtils;
import org.junit.Test;

import java.util.*;

/**
 * 示例
 * @author Erwin Feng
 * @since 2020/8/2
 */
public class ResultTemplateTests {

    @Test
    public void testSuccess() {
        ResultTemplate<Object> resultTemplate = ResultTemplate.success();
        System.out.println(resultTemplate);
    }

    @Test
    public void testFail() {
        ResultTemplate<Object> resultTemplate = ResultTemplate.fail();
        System.out.println(resultTemplate);
    }

    @Test
    public void testSuccessFull() {
        BaseHeader header = new BaseHeader();
        header.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));

        PageTemplate<List<Map<String, Object>>> pageTemplate = new PageTemplate<>();
        pageTemplate.setCurrentPage(1L);
        pageTemplate.setPageSize(10);
        pageTemplate.setTotalPages(100L);
        pageTemplate.setTotalElements(979L);

        List<Map<String, Object>> users = new ArrayList<>();
        pageTemplate.setContent(users);

        Map<String, Object> user1 = new HashMap<>();
        users.add(user1);

        user1.put("id", 1);
        user1.put("name", "Fabiola");
        user1.put("age", "10");
        user1.put("gender", "女");

        ResultTemplate<Object> resultTemplate = ResultTemplate.success()
                .setHeader(header)
                .setBody(pageTemplate)
                ;

        System.out.println(JsonUtils.convertString(resultTemplate));
    }

}

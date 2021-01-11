package com.fengwenyi.api.result;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.javalib.generate.IdUtils;
import com.fengwenyi.javalib.util.PrintUtils;
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
        PrintUtils.info(JsonUtils.convertString(resultTemplate));
    }

    @Test
    public void testFail() {
        ResultTemplate<Object> resultTemplate = ResultTemplate.fail();
        PrintUtils.info(resultTemplate);
    }

    @Test
    public void testSuccessFull() {
        ResultHeader header = new ResultHeader();
        header.setTraceId(IdUtils.getIdByUUID());

        PageTemplate<List<Map<String, Object>>> pageTemplate = new PageTemplate<>();

        List<Map<String, Object>> users = new ArrayList<>();
        pageTemplate.setContent(users);

        Map<String, Object> user1 = new HashMap<>();
        users.add(user1);

        Map<String, Object> user2 = new HashMap<>();
        users.add(user2);

        Map<String, Object> user3 = new HashMap<>();
        users.add(user3);

        user1.put("id", 1);
        user1.put("name", "Fabiola");
        user1.put("age", 20);
        user1.put("gender", "女");

        user2.put("id", 2);
        user2.put("name", "Finnguala");
        user2.put("age", 16);
        user2.put("gender", "女");

        user3.put("id", 3);
        user3.put("name", "Fuller");
        user3.put("age", 30);
        user3.put("gender", "男");

        long currentPage = 1L;
        int pageSize = 10;
        long totalRows = users.size();
        long totalPages = (totalRows + pageSize - 1) / pageSize;

        pageTemplate.setCurrentPage(currentPage);
        pageTemplate.setPageSize(pageSize);
        pageTemplate.setTotalPages(totalPages);
        pageTemplate.setTotalRows(totalRows);

        ResultTemplate<Object> resultTemplate = ResultTemplate.success()
                .setHeader(header)
                .setBody(pageTemplate)
                ;

        PrintUtils.info(JsonUtils.convertString(resultTemplate));
    }

}

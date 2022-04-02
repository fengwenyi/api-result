package com.fengwenyi.api.result;

import org.junit.Test;

import java.util.*;

/**
 * 示例
 * @author Erwin Feng
 * @since 2021-10-22
 */
@SuppressWarnings("all")
public class ResponseTemplateTests {

    @Test
    public void testSuccess() {
        ResponseTemplate<Object> resultTemplate = ResponseTemplate.success();
//        PrintUtils.info(JsonUtils.convertString(resultTemplate));
    }

    @Test
    public void testFail() {
        ResponseTemplate<Object> resultTemplate = ResponseTemplate.fail();
//        PrintUtils.info(JsonUtils.convertString(resultTemplate));
    }

    @Test
    public void testSuccessFull() {
        ResponseHeader header = new ResponseHeader();
        header.put("traceId", UUID.randomUUID().toString());

        PageResponseVo<List<Map<String, Object>>> pageResponseVo = new PageResponseVo<>();

        List<Map<String, Object>> users = new ArrayList<>();
        pageResponseVo.setContent(users);

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

        pageResponseVo.setCurrentPage(currentPage);
        pageResponseVo.setPageSize(pageSize);
        pageResponseVo.setTotalPages(totalPages);
        pageResponseVo.setTotalRows(totalRows);

        ResponseTemplate<Object> response = ResponseTemplate.success()
                .setHeader(header)
                .setBody(pageResponseVo)
                ;

//        PrintUtils.info(JsonUtils.convertString(response));
    }

    @Test
    public void testCustomReturnCode() {
        ResponseTemplate<Object> response = ResponseTemplate.fail(ReturnCode.CUSTOM_ERROR);
//        PrintUtils.info(JsonUtils.convertString(response));
    }

}

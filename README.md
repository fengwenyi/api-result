# Api Result

`api-result` ，是RESTful风格的API接口响应参数规范化的一套解决方案。

## 特点

- 规范化。
- 统一化。
- 标准化。


## 快速开始

### Maven

```xml
<dependency>
    <groupId>com.fengwenyi</groupId>
    <artifactId>api-result</artifactId>
    <version>2.4.0</version>
</dependency>
```

### 代码示例

```java
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @RequestMapping("/demo")
    public ResultTemplate<Void> demo() {
        return ResultTemplate.success();
    }
}
```

### 响应示例
```json
{
    "code": "1",
    "message": "Success",
    "success": true
}
```

### 错误示例

```json
{
    "code":"0",
    "errCode":"0",
    "msg":"错误",
    "success":false
}
```

## 自定义错误码

编写一个枚举类， `com.fengwenyi.api.result.IReturnCode` 接口，即可使用。

### ReturnCode

```java
package com.fengwenyi.api.result;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-02
 */
public enum ReturnCode implements IReturnCode {
    
    ERROR("Error", "自定义错误")
    
    ;
    
    /* 错误码 */
    private final String errCode;
    
    /* 描述 */
    private final String msg;

    ReturnCode(String errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
```

### 测试示例

```
ResultTemplate<Object> result = ResultTemplate.fail(ReturnCode.ERROR);
PrintUtils.info(JsonUtils.convertString(result));
```

打印：

```json
{
    "code":"0",
    "errCode":"Error",
    "msg":"自定义错误",
    "success":false
}
```


## 完整响应示例

```json
{
  "code":"1",
  "msg":"Success",
  "success":true,
  "header":{
    "traceId":"3f99c4d97ba3498d96207dc990f075c4"
  },
  "body":{
    "currentPage":1,
    "pageSize":10,
    "totalRows":3,
    "totalPages":1,
    "content":[
      {
        "gender":"女",
        "name":"Fabiola",
        "id":1,
        "age":20
      },
      {
        "gender":"女",
        "name":"Finnguala",
        "id":2,
        "age":16
      },
      {
        "gender":"男",
        "name":"Fuller",
        "id":3,
        "age":30
      }
    ]
  }
}
```

## 文档

- [wiki](https://github.com/fengwenyi/api-result/wiki)
- [maven.org](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav)
- [mvnrepository.com](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 
- [更新日志](LOG.md) 


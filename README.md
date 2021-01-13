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
    <version>2.3.1</version>
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
    "code": "111111",
    "message": "Success",
    "success": true
}
```

## 完整响应示例

```json
{
  "code": "111111",
  "message": "Success",
  "success": true,
  "header": {
    "traceId": "cc15c517a91349c8b1269943e537a26d"
  },
  "body": {
    "currentPage": 1,
    "pageSize": 10,
    "totalRows": 3,
    "totalPages": 1,
    "content": [
      {
        "gender": "女",
        "name": "Fabiola",
        "id": 1,
        "age": 20
      },
      {
        "gender": "女",
        "name": "Finnguala",
        "id": 2,
        "age": 16
      },
      {
        "gender": "男",
        "name": "Fuller",
        "id": 3,
        "age": 30
      }
    ]
  }
}
```

## Wiki

- [中文文档](https://github.com/fengwenyi/api-result/wiki)


## 中央仓库

- [maven.org](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav)

- [mvnrepository.com](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 


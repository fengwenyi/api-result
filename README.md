<h1 align="center">
    api-result
</h1>

<p align="center">
	<strong>一套RESTful风格API接口响应参数规范化的解决方案。</strong>
</p>


## 特性

- 规范化。
- 统一化。
- 标准化。


## 快速开始

### Maven

```xml
<dependency>
    <groupId>com.fengwenyi</groupId>
    <artifactId>api-result</artifactId>
    <version>2.7.4</version>
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

### 请求

```shell
curl http://localhost:8080/api/demo
```

### 响应示例
```json
{
  "code":"SUCCESS",
  "message":"Success",
  "success":true,
  "header":null, 
  "body":null, 
  "date":"2022-07-16T20:21:23.017"
}
```

## 其他

- [文档](https://www.yuque.com/fengwenyi/api-result)
- [Maven仓库](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 
- [更新日志](LOG.md) 


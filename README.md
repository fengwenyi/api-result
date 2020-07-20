# Api Result

`api-result` ，是RESTful风格的API接口响应参数规范化的一套解决方案。

## 快速开始

### Maven依赖

```xml
<dependency>
  <groupId>com.fengwenyi</groupId>
  <artifactId>api-result</artifactId>
  <version>2.1.1.RELEASE</version>
</dependency>
```

### REST ful API Sample

```java
package sample.api_result.controller;

import com.fengwenyi.api_result.entity.ResponseEntity;
import com.fengwenyi.api_result.util.ResponseUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用 {@code api-result} 写一个RESTful风格的API样例
 * @author Erwin Feng
 * @since 2020/7/20
 */
@RestController
@RequestMapping(value = "/sample",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    /**
     * 接口示例
     * @return 只返回处理结果，无数据
     */
    @GetMapping("/api")
    public ResponseEntity<Void, Void> api() {
        return ResponseUtils.success();
    }

}
```

### 测试

#### 请求

```http
GET http://localhost:8080/sample/api
Content-Type: application/json
```

#### 响应

```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 36

{
  "message": "Success",
  "success": true
}
```

## Wiki

如果你想了解更多，点击这里 [Wiki](https://github.com/fengwenyi/api-result/wiki) 


## 版本标识说明

### BUILD

开发版本：用于标识该版本正在构建或者开发中。

### SNAPSHOT

预览版本：开发已经完成，开始进入测试阶段。

### RELEASE

稳定版本：已发布到中央仓库。


## 中央仓库

去 [maven.org](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav) 查看

去 [mvnrepository.com](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 查看


# Api Result

`api-result` ，是一套RESTful风格API接口响应参数规范化的解决方案。

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
    <version>2.5.0</version>
</dependency>
```

### 代码示例

```java
package com.fengwenyi.api.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fengwenyi.api.result.ResponseTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @RequestMapping("/demo")
    public ResponseTemplate<Void> demo() {
        return ResponseTemplate.success();
    }
}
```

### 响应示例
```json
{
    "code": "0",
    "message": "Success",
    "success": true
}
```

## 其他

- [文档](https://github.com/fengwenyi/api-result/wiki)
- [Maven仓库](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 
- [更新日志](LOG.md) 


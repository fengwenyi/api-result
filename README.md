# Api Result

Api Result，是一套API接口响应参数规范化解决方案。

## 中央仓库

去 [maven.org](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav) 查看

去 [mvnrepository.com](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 查看


## Maven依赖

```xml
<dependency>
  <groupId>com.fengwenyi</groupId>
  <artifactId>api-result</artifactId>
  <version>2.0.4.RELEASE</version>
</dependency>
```

## 简单示例

### ResponseUtils

```java
package sample.api_result.util;

import com.fengwenyi.api_result.helper.ResultHelper;
import com.fengwenyi.api_result.model.ResultModel;

/**
 * 响应工具类
 * @author Erwin Feng
 * @since 2020/6/13
 */
public class ResponseUtils {

    /** 成功信息提示 */
    private static final String SUCCESS_MESSAGE = "Success";

    /**
     * 成功，并返回数据
     * @param data  数据
     * @param <T>   数据类型
     * @return  接口响应成功，并返回数据
     * @see com.fengwenyi.api_result.model.ResultModel
     */
    public static <T>ResultModel<T> success(T data) {
        return ResultHelper.success(SUCCESS_MESSAGE, data);
    }
}
```

### UserController

```java
package sample.api_result.controller;

import com.fengwenyi.api_result.model.ResultModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.api_result.util.ResponseUtils;
import sample.api_result.vo.response.UserResponseVo;

import java.util.Arrays;
import java.util.List;

/**
 * 用户接口示例
 * @author Erwin Feng
 * @since 2020/6/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 查询所有用户
     * @return 返回数据：包含用户信息的列表
     */
    @GetMapping
    public ResultModel<List<UserResponseVo>> users() {
        List<UserResponseVo> responseVos = Arrays.asList(
                new UserResponseVo().setUid("x001").setRealName("关羽").setNickname("云长"),
                new UserResponseVo().setUid("x002").setRealName("张飞").setNickname("翼德"),
                new UserResponseVo().setUid("x003").setRealName("赵云").setNickname("子龙")
        );
        return ResponseUtils.success(responseVos);
    }
}
```

### UserResponseVo

```java
package sample.api_result.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户响应VO
 * @author Erwin Feng
 * @since 2020/5/26
 */
@Data
@Accessors(chain = true)
public class UserResponseVo {

    /** 用户ID */
    private String uid;

    /** 用户真实姓名 */
    private String realName;

    /** 用户昵称 */
    private String nickname;

}
```

### 测试

### 请求

```
GET http://localhost:8080/user
Accept: application/json
```

### 响应

```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 210
```

```json
{
    "success":true,
    "message":"Success",
    "data":[
        {
            "uid":"x001",
            "realName":"关羽",
            "nickname":"云长"
        },
        {
            "uid":"x002",
            "realName":"张飞",
            "nickname":"翼德"
        },
        {
            "uid":"x003",
            "realName":"赵云",
            "nickname":"子龙"
        }
    ]
}
```

> 点击这里 [Spring Boot结合api-result使用示例](https://github.com/fengwenyi/APIExample/tree/api-result-sample) 查看完整版示例

## Wiki

如果你想了解更多 `api-result`，点击这里 [Wiki](https://github.com/fengwenyi/api-result/wiki) 


## 版本标识说明

### BUILD

开发版本：用于标识该版本正在构建或者开发中。

### SNAPSHOT

预览版本：开发已经完成，开始进入测试阶段。

### RELEASE

稳定版本：已发布到中央仓库。


# Api Result

Api Result，是一套API接口返回结果规范化解决方案。它是在实际应用环境下产生了，并不断更新和完善。
结合Spring Boot进行开发，让接口响应结果变得更加规范。


[中央仓库](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav)


## Maven

```xml
<dependency>
  <groupId>com.fengwenyi</groupId>
  <artifactId>api-result</artifactId>
  <version>2.0.4.RELEASE</version>
</dependency>
```

## Gradle

```gradle
implementation 'com.fengwenyi:api-result:2.0.4.RELEASE'
```

## Sample

### ResultUtils

```java
package siample.api_result.result;

import com.fengwenyi.api_result.helper.ResultApiHelper;
import com.fengwenyi.api_result.model.ResultApiModel;

/**
 * 接口响应结果封装工具类
 * @author Erwin Feng
 * @since 2020/5/26
 */
public class ResultUtils {

    /**
     * 成功，无数据
     * @return {@link ResultApiModel}
     */
    public static ResultApiModel<Integer, Void> success() {
        return ResultApiHelper.success(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 成功，携带数据
     * @param data 响应数据
     * @param <T>  响应数据类型
     * @return {@link ResultApiModel}
     */
    public static <T> ResultApiModel<Integer, T> success(T data) {
        return ResultApiHelper.success(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 失败，返回具体的错误码和详细的错误信息
     * @param resultCodeEnum 返回码枚举类，{@link ResultCodeEnum}
     * @return {@link ResultApiModel}
     */
    public static ResultApiModel<Integer, Void> error(ResultCodeEnum resultCodeEnum) {
        return ResultApiHelper.error(resultCodeEnum.getCode(), resultCodeEnum.getMessage());
    }

}
```

### ResultCodeEnum
```java
package siample.api_result.result;

import lombok.Getter;

/**
 * 返回结果码枚举
 * @author Erwin Feng
 * @since 2020/5/24
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(0, "Success");

    /** 返回码 */
    private Integer code;

    /** 描述信息 */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
```

### ApiController

```java
package siample.api_result.controller;

import com.fengwenyi.api_result.model.ResultApiModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siample.api_result.result.ResultUtils;
import siample.api_result.vo.response.UserResponseVo;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * API
 * @author Erwin Feng
 * @since 2020/5/26
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * 查询所有用户，返回所有用户列表
     * @return {@link ResultApiModel}
     */
    @GetMapping("/users")
    public ResultApiModel<Integer, List<UserResponseVo>> users() {
        List<UserResponseVo> userResponseVos = Arrays.asList(
                new UserResponseVo().setUid(UUID.randomUUID().toString()).setRealName("关羽").setNickname("云长"),
                new UserResponseVo().setUid(UUID.randomUUID().toString()).setRealName("张飞").setNickname("翼德"),
                new UserResponseVo().setUid(UUID.randomUUID().toString()).setRealName("赵云").setNickname("子龙")
        );
        return ResultUtils.success(userResponseVos);
    }

}
```

### UserResponseVo

```java
package siample.api_result.vo.response;

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

> [Spring Boot结合api-result使用示例](https://github.com/fengwenyi/APIExample/tree/api-result-sample)

## Wiki

[Api Result Wiki](./wiki)


## 版本标识说明

### BUILD

开发版本：用于标识该版本正在构建或者开发中。

### SNAPSHOT

预览版本：开发已经完成，开始进入测试阶段。

### RELEASE

稳定版本：已发布到中央仓库。



<p align="center">
    <img src="./images/api-result-logo.png">
</p>

<p align="center">
    <strong>对API接口返回结果规范封装解决方案</strong>
</p>

`api-result`，是对API接口返回结果规范化处理的一个解决方案，是在实际应用环境下产生了，并不断更新和完善。
结合Spring Boot可快速开发API接口，返回结果是标准、规范的JSON格式。

## 快速开始

已经将jar发布到 [中央仓库](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav)

添加依赖后，我们写如下的代码

```java
package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.api_result.helper.ApiResultHelper;
import com.fengwenyi.api_result.model.ApiResultModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Api Result Example
 * @author Erwin Feng
 * @since 2019-08-21 12:17
 */
@RestController
@RequestMapping("/example")
public class Example {

    @RequestMapping("/data")
    public ApiResultModel data() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "Zhangsan");
        map1.put("age", "18");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "Lisi");
        map2.put("age", "20");
        list.add(map2);
        return ApiResultHelper.success(0, "Success", list);
    }

}
```

响应结果是一个标准、规范的JSON格式，如下：

```json
{
    "success":true,
    "message":"Success",
    "data":[
        {
            "name":"Zhangsan",
            "age":"18"
        },
        {
            "name":"Lisi",
            "age":"20"
        }
    ],
    "code":0
}
```

## 实体类

#### ResultModel

包名：com.fengwenyi.api_result.model

属性：

| 参数 | 类型 | 说明 | 默认值 |
| --- | --- | ---  | ---   |
| success | Boolean | 返回结果标识，true / false（成功 / 失败） | false |
| message | String | 描述信息 | - |
| success | T | 数据，有数据时，才返回该参数 | - |

#### ApiResultModel

包名：com.fengwenyi.api_result.model

继承：ResultModel

属性：

| 参数 | 类型 | 说明 | 默认值 |
| --- | --- | ---  | ---   |
| code | S | 返回码 | - |

## ResultHelper

#### 成功，无数据

`public static <T> ResultModel<T> success(String message)`

#### 成功，有数据

`public static <T> ResultModel<T> success(String message, T data)`

#### 失败

`public static <T> ResultModel<T> error(String message)`

## ApiResultHelper

#### 成功，无数据

`public static <S, T> ApiResultModel<S, T> success(S code, String message)`

#### 成功，有数据

`public static <S, T> ApiResultModel<S, T> success(S code, String message, T data)`

#### 失败

`public static <S, T> ApiResultModel<S, T> error(S code, String message)`


<p align="center">
    <img src="./images/api-result-logo.png">
</p>

<p align="center">
    <strong>API接口返回结果规范化解决方案</strong>
</p>

`api-result`，是API接口返回结果规范化解决方案，是在实际应用环境下产生了，并不断更新和完善。
结合Spring Boot可快速开发API接口，返回结果是标准、规范的JSON格式。

[中央仓库](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav)

## API讲解

### 实体类

提供了满足各场景使用的实体类，如下：



#### ResultModel

这个类是基础实体类，有如下属性：

success：返回结果标识，是一个布尔值，true / false（成功 / 失败）

message：描述信息，错误时，可以在这里填写错误的详细信息

data：数据，是一个泛型，可以是数组或者对象等等，成功并且需要返回数据时，才有该参数



##### ApiResultModel

结构关系如下：

```
 ResultModel
 └── ApiResultModel
```

在这个类里面增加了 `code` 属性，也是一个泛型，你可以自定义你的返回码类型，可以是整数，或者字符串。



##### PageResultModel 

结构关系如下：

```
 ResultModel
 └── PageResultModel
```

这个类主要主要分页返回结果，所以，增加了以下属性：

total：数据总条数，Long型

size：每页条数，整数

pages：总页数，Long型

current：当前页，Long型



### Helper工具类

帮助我们操作实体类，具体有哪些helper呢？如下：



#### ResultHelper

ResultHelper是与ResultModel对应的



##### success(String message)

成功，携带描述信息



##### success(String message, T data)

成功，携带描述信息和数据



##### error(String message)

错误，携带详细的描述信息



#### ApiResultHelper

ApiResultHelper是与ApiResultModel对应的



##### success(S code, String message)

成功，携带返回码和描述信息



##### success(S code, String message, T data)

成功，携带返回码、描述信息和数据



##### error(S code, String message)

错误，携带错误码和详细描述信息



#### PageResultHelper

PageResultHelper是与PageResultModel对应的



##### success(String message)

成功，携带描述信息



##### success(String message, T data)

成功，携带描述信息和数据



##### success(String message, T data, long total, int size, long pages, long current)

成功，携带描述信息、数据、总数、每页条数、总页数、当前页



##### error(String message)

错误，携带详细的描述信息



## 快速入门

我们为你提供了三个实体类，以满足不同场景，ResultModel适用于通常返回结果，ApiResultModel适用于接口开发返回结果，PageResultModel适用于分页返回结果。也分别为这三个实体类提供了各自的Helper，所以，你可以直接使用这些Helper进行返回。当然，我推荐的使用方式是，先为各Helper编写工具类，再通过工具类进行返回，这样可能更加合理定制自己的返回工具类。

### 利用Helper进行返回

首先我们来看一个简单的示例代码：

```java
/**
 * 添加方法示例
 * @return {@link ResultModel}
 */
@ApiOperation(value = "添加方法示例")
@PostMapping
public ResultModel<?> add() {
  return ResultHelper.success("添加成功");
}
```

返回结果：

```json
{
  "success": true,
  "message": "添加成功"
}
```

 注：这只是一个接口返回示例，而不是说添加接口应该这样写。



### 编写返回结果工具类

比如，我们可以写一个ResultUtils工具类来操作ResultHelper。如下示例：

```java
/**
 * 成功示例
 * @return {@link ResultModel}
 */
public static ResultModel <?> success() {
    return ResultHelper.success("Success");
}
```



### 使用返回结果工具类

我门就可以调用ResultUtils类里面的方法，如下示例：

 ```java
/**
 * 成功示例
 * @return {@link ResultModel}
 */
@ApiOperation(value = "成功示例")
@DeleteMapping
public ResultModel<?> success() {
    return ResultUtils.success();
}
 ```

印象结果：

 ```json
{
  "success": true,
  "message": "Success"
}
 ```





## 使用示例

### 示例图

#### 测试接口预览

![接口示例](https://images.fengwenyi.com/1201140376645267458)



#### Models

![Models](https://images.fengwenyi.com/1201141528468254721)

### 返回成功结果示例

```java
/**
 * 删除方法示例
 * @return {@link ResultModel}
 */
@ApiOperation(value = "删除方法示例")
@DeleteMapping
public ResultModel<?> delete() {
    return ResultUtils.success();
}
```

响应结果：

```json
{
  "success": true,
  "message": "Success"
}
```





### 返回失败结果示例

如果操作出错了，我们怎么返回呢？我们来看一下：

```java
/**
 * 修改方法示例
 * @return {@link ResultModel}
 */
@ApiOperation(value = "修改方法示例")
@PutMapping
public ResultModel<?> update() {
    return ResultUtils.error("修改失败");
}
```

返回结果：

```json
{
  "success": false,
  "message": "修改失败"
}
```



### 返回查询结果示例

 值得一提的话，就是查询方法了，我们看一下吧

```java
/**
 * 查询方法示例
 * @return {@link ResultModel}
 */
@ApiOperation(value = "查询方法示例")
@GetMapping
public ResultModel<?> get() {
    List<Map<String, String>> list = new ArrayList<>();
    Map<String, String> map1 = new HashMap<>();

    map1.put("name", "张飞");
    map1.put("desc", "燕人张飞");
    list.add(map1);

    Map<String, String> map2 = new HashMap<>();
    map2.put("name", "赵云");
    map2.put("desc", "常山赵子龙");
    list.add(map2);

    Map<String, String> map3 = new HashMap<>();
    map3.put("name", "关羽");
    map3.put("desc", "温酒斩华雄");
    list.add(map3);

    return ResultUtils.success(list);
}
```

看一下响应结果吧，是否如你所愿：

```json
{
  "success": true,
  "message": "Success",
  "data": [
    {
      "name": "张飞",
      "desc": "燕人张飞"
    },
    {
      "name": "赵云",
      "desc": "常山赵子龙"
    },
    {
      "name": "关羽",
      "desc": "温酒斩华雄"
    }
  ]
}
```



### 接口返回数据示例

 ```java
/**
 * 接口返回数据示例
 * @return {@link ApiResultModel}
 */
@ApiOperation(value = "接口返回数据示例")
@GetMapping("/api-data")
public ApiResultModel<Integer, ?> apiData() {
    return ApiResultUtils.success(getData());
}
 ```

响应结果：

```json
{
  "success": true,
  "message": "Success",
  "data": [
    {
      "name": "张飞",
      "desc": "燕人张飞"
    },
    {
      "name": "赵云",
      "desc": "常山赵子龙"
    },
    {
      "name": "关羽",
      "desc": "温酒斩华雄"
    }
  ],
  "code": 0
}
```

### 接口返回失败结果示例

```java
/**
 * API接口错误返回示例
 * @return {@link ApiResultModel}
 */
@ApiOperation(value = "API接口错误返回示例")
@GetMapping("/api-error")
public ApiResultModel<Integer, ?> apiError() {
    return ApiResultUtils.error(1101, "API接口错误返回示例");
}
```

响应结果：

```json
{
  "success": false,
  "message": "API接口错误返回示例",
  "code": 1101
}
```



### 分页返回数据示例

```java
/**
 * 分页返回数据示例
 * @return {@link ApiResultModel}
 */
@ApiOperation(value = "分页返回数据示例")
@GetMapping("/page")
public PageResultModel<?> page() {
    return PageResultUtils.success(getData(), 100, 10, 10, 1);
}
```

响应结果：

```json
{
  "success": true,
  "message": "Success",
  "data": [
    {
      "name": "张飞",
      "desc": "燕人张飞"
    },
    {
      "name": "赵云",
      "desc": "常山赵子龙"
    },
    {
      "name": "关羽",
      "desc": "温酒斩华雄"
    }
  ],
  "total": 100,
  "size": 10,
  "pages": 10,
  "current": 1
}
```





## 工具类示例

### 返回结果工具类

```java
package com.fengwenyi.api_example.util;

import com.fengwenyi.api_result.helper.ResultHelper;
import com.fengwenyi.api_result.model.ResultModel;

/**
 * 返回结果封装工具类
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/30 13:54
 */
public class ResultUtils {

    /**
     *  成功
     * @return {@link ResultModel}
     */
    public static ResultModel <?> success() {
        return ResultHelper.success("Success");
    }

    /**
     *  成功，携带数据
     * @param data 数据
     * @param <T>  数据的类型
     * @return {@link ResultModel}
     */
    public static <T> ResultModel <T> success(T data) {
        return ResultHelper.success("Success", data);
    }

    /**
     *  错误，携带详细的错误描述信息
     * @param message 详细的错误描述信息
     * @return {@link ResultModel}
     */
    public static ResultModel <?> error(String message) {
        return ResultHelper.error(message);
    }

}
```



### API接口返回结果工具类

```java
package com.fengwenyi.api_example.util;

import com.fengwenyi.api_result.helper.ApiResultHelper;
import com.fengwenyi.api_result.model.ApiResultModel;

/**
 * API接口返回结果工具类
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/1 20:10
 */
public class ApiResultUtils {

    /**
     * 成功，携带返回码和描述信息
     * @return {@link ApiResultModel}
     */
    public static ApiResultModel<Integer, ?> success() {
        return ApiResultHelper.success(0, "Success");
    }

    /**
     * 成功，携带返回码、描述信息和数据
     * @param data 数据
     * @param <T>  数据的类型
     * @return {@link ApiResultModel}
     */
    public static <T> ApiResultModel<Integer, T> success(T data) {
        return ApiResultHelper.success(0, "Success", data);
    }

    /**
     * 出错，携带错误吗和详细描述信息
     * @param code 返回码
     * @param message 相信描述信息
     * @return {@link ApiResultModel}
     */
    public static ApiResultModel<Integer, ?> error(int code, String message) {
        return ApiResultHelper.error(code, message);
    }
}
```



### 分页返回结果工具类

```java
package com.fengwenyi.api_example.util;

import com.fengwenyi.api_result.helper.PageResultHelper;
import com.fengwenyi.api_result.model.PageResultModel;

/**
 * 分页返回结果工具类
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/1 20:32
 */
public class PageResultUtils {

    /**
     * 成功，携带分页相关数据以及信息
     * @param data     数据
     * @param total    数据总条数
     * @param size     每页条数
     * @param pages    总页数
     * @param current  当前页
     * @param <T>      数据类型
     * @return {@link PageResultModel}
     */
    public static <T> PageResultModel<T> success(T data, long total, int size, long pages, long current) {
        return PageResultHelper.success("Success", data, total, size, pages, current);
    }

}
```


## 解析返回结果示例

这里补充一下，关于如何解析返回的json字符串，谈谈我的看法吧。返回的是一个json格式的字符串，这里我用fastjson来写解析示例。我们通常会将请求数据封装为一个通用方法或者工具类，只需要返回数据，当然，如果失败，或者出现异常，都在这里处理。

### 常用返回结果解析示例

```java
/**
 * 解析常用返回结果示例
 * @return 数据
 */
public Object parseResult() {
    String result = "";
    ResultModel<?> resultModel = JSON.parseObject(result, ResultModel.class);
    Boolean success = resultModel.getSuccess();
    if (success != null && success) {
        return resultModel.getData();
    } else {
        // 异常信息
        String message = resultModel.getMessage();
        // 异常处理
        throw new DataParseException(message);
    }
}
```

### 接口返回结果解析示例

```java
/**
 * 解析接口返回结果示例
 * @return 数据
 */
public Object parseApiResult() {
    String apiResult = "";
    ApiResultModel<?, ?> apiResultModel = JSON.parseObject(apiResult, ApiResultModel.class);
    Boolean success = apiResultModel.getSuccess();
    if (success != null && success) {
        return apiResultModel.getData();
    } else {
        Object code = apiResultModel.getCode();
        String message = apiResultModel.getMessage();
        // 根据接口错误码分别进行处理
        // ...
        return null;
    }
}
```

### 分页返回结果解析示例

这里与上面略有不同，因为，增加了一些字段，所以，我们可以借助bean来返回。

```java
/**
 * 解析分页返回结果示例
 * @return {@link PageResultDataBean}
 */
public PageResultDataBean parsePageResult() {
    String pageResult = "";
    PageResultModel<List<?>> pageResultModel = JSON.parseObject(pageResult, PageResultModel.class);
    Boolean success = pageResultModel.getSuccess();
    if (success != null && success) {
        List<?> data = pageResultModel.getData();
        Long total = pageResultModel.getTotal();
        Integer size = pageResultModel.getSize();
        Long pages = pageResultModel.getPages();
        Long current = pageResultModel.getCurrent();
        return new PageResultDataBean()
                .setTotal(total)
                .setSize(size)
                .setPages(pages)
                .setCurrent(current)
                .setData(data);
    } else {
        // 异常信息
        String message = pageResultModel.getMessage();
        // 异常处理
        throw new DataParseException(message);
    }
}
```
# Doc Version 2.0.1

## 概述

- 增加。PageResultHelper增加success(String message, T data)方法

- 增加。PageResultHelper增加success(String message)方法

- 修改。PageResultModel.current 的类型 Integer -> Long



## PageResultHelper

#### success()

参数：

| 属性    | 类型    | 描述         |
| ------- | ------| ------------|
| message | String | 信息  |
| data    | T | 数据 |

返回：PageResultModel

#### success()

参数：

| 属性    | 类型    | 描述         |
| ------- | ------| ------------|
| message | String | 信息  |

返回：PageResultModel
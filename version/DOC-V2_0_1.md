# Doc Version 2.0.1

## PageResultModel

分页返回结果封装模型

| 属性    | 类型    | 描述         |
| ------- | ------- | ------------ |
| success | Boolean | 是否成功     |
| message | String  | 信息         |
| data    | T       | 数据         |
| total   | Long    | 数据总条数   |
| size    | Integer | 每页显示条数 |
| pages   | Long    | 总页数       |
| current | Integer | 当前页数     |

## PageResultHelper

#### success()

参数：

| 属性    | 类型    | 描述         |
| ------- | ------| ------------|
| message | String | 信息  |
| data    | T | 数据 |
| total   | long | 数据总条数 |
| size    | int | 每页显示条数 |
| pages   | long | 总页数 |
| current | int | 当前页数 |

返回：PageResultModel


#### error()

参数：

| 属性    | 类型    | 描述         |
| ------- | ------| ------------|
| message | String | 信息  |

返回：PageResultModel
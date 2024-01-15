# 版本更新日志

## v2.7.5

:bug: Bug Fixes

- 修复 ResultTemplate#setCode 属性为 private 错误 ([#3](https://github.com/fengwenyi/api-result/issues/3))


## v2.7.4

2022.11.20

:bug: Bug Fixes

- 修复 ResultTemplate.date 转json，可能出现无法被序列化的问题



## v2.7.3

2022.07.31 ~ 2022.11.17

:star: New Features

- 新增 Boolean 结果类型响应类：`BooleanResponse`
- `com.fengwenyi.api.result.StringUtils` 改为只为本包使用
- `Builder` -> `IBuilder`
- `Result` -> `IResult`

:bug: Bug Fixes

- 修复 ResultTemplate.date 转json，可能出现无法被序列化的问题

:memo: Document

- 修复文档示例代码不正确的问题


## v2.7.2

2022.07.16 ~ 2022.07.17

:bug: Bug Fixes

- 修复 Result.Default 无法被继承的问题



## v2.7.1

2022.07.06 ~ 2022.07.16

:star: New Features

- ResultTemplate 新增 `date(时间)` 字段
- ListTemplate 新增 `timeCost(用时)` 字段
- Result.Default 由枚举类改成 类，支持继承

:bug: Bug Fixes

- 修复 ResultTemplate 中 `msg` 字段 set 方法命名不规范的问题



## v2.7.0

2022.05.16 ~ 2022.06.24

:star: New Features

- 概念变更，响应改为结果，即 Response -> Result
- 对分页返回参数进行调整
- 新增列表模板类 `ListTemplate`

## v2.6.0

2022.04.03 ~ 2022.04.09

- 【变更】ResponseTemplate 属性 code 类型变由 Integer 变更为 String
- 【变更】IReturnCode 方法 getCode() 返回类型变由 Integer 变更为 String
- 【变更】IReturnCode.Default 中的返回码也做了变更
- 【变更】PageRequestVo 希望被继承，所以只保留 currentPage 和 pageSize
- 【优化】有些方法没有被使用，为避免编辑器警告提示，增加 @SuppressWarnings("all")
- 【优化】优化文案描述

## v2.5.3

2022.02.08 ~ 2022.04.03

- 【优化】返回的属性为空时不再自动隐藏，交由业务系统自行配置
- 【修复】ResponseTemplate 无参数构造方法 private > public，解决无法被继承的问题
- 【删除】删除依赖 jackson-annotations

## v2.5.2

2021.12.28

- 【修复】修复在没有引入 `JavaLib` 的情况下，会报错的问题 [#I4OBC8](https://gitee.com/fengwenyi/api-result/issues/I4OBC8)
- 【依赖】新增依赖 jackson-annotations 2.13.1
- 【新增】新增字符串工具类 StringUtils
- 【新增】新增构建者接口 IBuilder
- 【优化】PageResponse set 方法参数类型改用基本数据类型，不使用包装类
- 【删除】删除依赖 JavaLib

## v2.5.1

2021.10.23

这个是一个BUG修复版本

- 【新增】新增参数缺失和参数校验失败的返回码。
- 【修复】修复ResponseTemplate中fail相关的方法，code和message参数没有被赋值的问题。
- 【文档】README文档更新
- 【删除】删除images目录
- 【删除】删除version目录

## v2.5.0

2021.10.11

- 【变更】ResultTemplate，code类型改为Integer
- 【变更】ResultTemplate，msg改为message
- 【变更】IReturnCode，getErrCode()改为getCode()
- 【变更】IReturnCode，getMsg()改为getMessage()
- 【变更】IReturnCode，getErrCode()返回类型改为Integer
- 【变更】IReturnCode，成功的返回码改为0
- 【变更】IReturnCode，错误的返回码改为-1
- 【变更】IReturnCode，Default，枚举错误去掉前缀ERROR
- 【变更】ResultTemplate更名为ResponseTemplate
- 【变更】ResultHeader更名为ResponseHeader
- 【删除】ResultTemplate，删除errCode
- 【删除】ResultTemplate，删除errMsg
- 【删除】IReturnCode，删除ERROR_SYSTEM_EXCEPTION
- 【删除】ResultHeader，删除默认的traceId属性

## v2.4.2

2021.08.27

- 【升级】JavaLib 由2.1.1版本升级到2.1.4版本
- 【新增】新增分页请求类：PageRequestVo
- 【新增】新增分页响应类：PageResponseVo
- 【过时】分页请求类：PageRequest
- 【过时】分页请求类：PageTemplate

## v2.4.0

- 【新增】返回结果增加errCode属性。
- 【优化】将属性 message 修改为 msg。
- 【优化】成功时code为1，失败是code为0。
- 【优化】IReturnCode中属性code改为errCode。
- 【优化】IReturnCode中属性message改为msg。
- 【优化】ResultTemplate中的构造方法做了优化。
- 【优化】ResultTemplate中setCode(xxx)变为private。
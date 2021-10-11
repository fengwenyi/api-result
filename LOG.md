# 版本更新日志

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
- 【删除】ResultTemplate，删除errCode
- 【删除】ResultTemplate，删除errMsg
- 【删除】IReturnCode，删除ERROR_SYSTEM_EXCEPTION

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
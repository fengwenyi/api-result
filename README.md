# Api Result

`api-result` ，是RESTful风格的API接口响应参数规范化的一套解决方案。

## 示例

### 简单示例
```json
{
    "code": "111111",
    "message": "Success",
    "success": true
}
```


### 完整示例

```json
{
  "code": "111111",
  "message": "Success",
  "success": true,
  "header": {
    "requestId": "cc15c517a91349c8b1269943e537a26d"
  },
  "body": {
    "currentPage": 1,
    "pageSize": 10,
    "totalRows": 3,
    "totalPages": 1,
    "content": [
      {
        "gender": "女",
        "name": "Fabiola",
        "id": 1,
        "age": 20
      },
      {
        "gender": "女",
        "name": "Finnguala",
        "id": 2,
        "age": 16
      },
      {
        "gender": "男",
        "name": "Fuller",
        "id": 3,
        "age": 30
      }
    ]
  }
}
```

## Wiki

- [中文文档](https://github.com/fengwenyi/api-result/wiki) 


## 版本标识说明

### BUILD

开发版本：用于标识该版本正在构建或者开发中。

### SNAPSHOT

预览版本：开发已经完成，开始进入测试阶段。

### RELEASE

稳定版本：已发布到中央仓库。


## 中央仓库

- [maven.org](https://search.maven.org/search?q=g:com.fengwenyi%20AND%20a:api-result&core=gav)

- [mvnrepository.com](https://mvnrepository.com/artifact/com.fengwenyi/api-result) 


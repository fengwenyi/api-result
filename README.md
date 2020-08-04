# Api Result

`api-result` ，是RESTful风格的API接口响应参数规范化的一套解决方案。

## 示例

```json
{
    "code":"111111",
    "message":"Query Success",
    "success":true,
    "trace_id":"edf36a73796356d5bc9b6d81f4eb83d6",
    "body":{
        "categoryData":[
            {
                "id":"1265200246055809026",
                "categoryName":"公告"
            },
            {
                "id":"1257301514647777282",
                "categoryName":"Java"
            },
            {
                "id":"1257694082590060546",
                "categoryName":"开发"
            },
            {
                "id":"1257255039406452737",
                "categoryName":"前端"
            },
            {
                "id":"1257687302015299586",
                "categoryName":"计划"
            },
            {
                "id":"1258792800529727490",
                "categoryName":"网站更新日志"
            },
            {
                "id":"1257256132635013121",
                "categoryName":"日志"
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


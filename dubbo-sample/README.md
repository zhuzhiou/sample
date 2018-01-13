# dubbo sample

启动provider与consumer项目的main函数后，使用postman访问`http://localhost:8082/sample`。

    POST http://localhost:8082/sample
    Content-Type: application/json
    {
    	"field1": "a",
    	"field2": "b",
    	"field3": "c"
    }
# 使用swagger2 生成api文档
 
安装swagger2

```groovy
compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.7.0'
```
swagger配置

```java
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2 Sample")
                .version("1.0")//版本
                .contact(new Contact("朱志欧", "https://user.qzone.qq.com/18403796", "zhuzhiou@qq.com"))//作者
                .license("unlicensed")
                .licenseUrl("http://unlicense.org")
                .build();
    }
}
```

# 通过XML装配swagger2

如果公司一些项目，虽然使用了spring4但使用xml配置，如果能扫描到这个@Configuration，也无须其他配置，如果无法扫描到此类，去掉@Configuration在xml里加下面的配置。

```xml
<bean class="samples.swagger.config.SwaggerConfiguration"></bean>
```

`swagger`的注解将生成接口的描述服务，默认地址为`http://localhost:8080/v2/api-docs`。
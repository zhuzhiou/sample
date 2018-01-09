# 通过XML装配swagger2

公司还有很多遗留系统，虽然使用了spring4，但项目里到处都是xml文件，因此这里做一个没有spring boot示例。

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

XML装配

```xml
<bean class="org.swagger.sample.config.SwaggerConfiguration"></bean>
```
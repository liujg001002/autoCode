package com.yintu.supply.core.configurer;

import com.yintu.supply.core.constant.ProjectConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description:Swagger2 配置文件
 * @time 2018/4/20 22:42
 */
@Configuration
//@EnableSwagger2
public class SwaggerConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(ProjectConstant.CONTROLLER_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口")
                .description("http://127.0.0.1:8088")
                .termsOfServiceUrl("http://127.0.0.1:8088")
                .contact(new Contact("yintu", "url地址", null))
                .version("1.0")
                .build();
    }
}

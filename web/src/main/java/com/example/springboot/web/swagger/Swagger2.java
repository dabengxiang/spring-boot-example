package com.example.springboot.web.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Date:2018/11/18
 * Author:gyc
 * Desc:
 */
@EnableSwagger2
@Configuration
public class Swagger2 {


    @Bean
    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.web.controller"))
//                .paths(PathSelectors.any())
//                .build();


        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        System.err.println("1234234324");
        return new ApiInfoBuilder()
                .title("测试项目 RESTful APIs")
                .description("测试项目后台api接口文档")
                .version("1.0")
                .licenseUrl("http://127.0.0.1:8080/v2/api-docs")
                .build();
    }

}

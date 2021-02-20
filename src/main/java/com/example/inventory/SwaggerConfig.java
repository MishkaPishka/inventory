package com.example.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket swaggerConfiguration() {
        return new Docket (DocumentationType.SWAGGER_2)
                .select()
//                .paths(PathSelectors.ant("/items"))
//                .paths(PathSelectors.any())

                .apis(RequestHandlerSelectors.basePackage(("com.example.inventory")))
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Inventory API",
                "Spring Boot Swagger Rest Service + Docker",
                "1.0",
                "Terms of Service",
                "Shkapish",
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }



}

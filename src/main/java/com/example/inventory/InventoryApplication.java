package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication

public class InventoryApplication {

    public static void main(String[] args) {

        SpringApplication.run(InventoryApplication.class, args);
    }

//    @Bean
//    public Docket swaggerConfiguration() {
//        return new Docket (DocumentationType.SWAGGER_2)
//                .select()
////                .paths(PathSelectors.ant("/items"))
////                .paths(PathSelectors.any())
//
//                .apis(RequestHandlerSelectors.basePackage(("com.example.inventory")))
//                .build()
//                .apiInfo(metaInfo());
//    }
//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot Swagger Example API",
//                "Spring Boot Swagger Example API for Youtube",
//                "1.0",
//                "Terms of Service",
//               "Shkapish",
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html"
//        );
//
//        return apiInfo;
//    }
}

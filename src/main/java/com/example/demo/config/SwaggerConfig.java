package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("no.ya.topaz.consentmanager.restcontroller"))
                .apis((RequestHandlerSelectors.withClassAnnotation(RestController.class)))
                //.paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/consentmanager/consents/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Demo rest API",
                "Dette API eksponerer rest tjenester til backend.",
                "API Demo",
                "",
                new Contact("", "ya.no", "dragerot"),
                "License of API", "API license URL", Collections.emptyList());
    }
}

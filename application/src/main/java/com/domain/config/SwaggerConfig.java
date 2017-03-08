package com.domain.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private ServletContext servletContext;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    protected String applicationPath() {
                        return servletContext.getContextPath() + "/restapi";
                    }
                    @Override
                    protected String getDocumentationPath() {
                        return "/";
                    }})
                .useDefaultResponseMessages(false);


    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Template REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("dev", "url", "email"),
                "License of API",
                "API license URL");
    }
}

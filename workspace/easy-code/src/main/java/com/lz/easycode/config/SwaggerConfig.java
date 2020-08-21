package com.lz.easycode.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
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
 * @ClassName SwaggerConfig
 * @Description TODO    Swagger3配置
 * @Author LZ
 * @Date 2020/8/12 14:45
 * @Version 1.0
 **/
@Configuration
public class SwaggerConfig {

    @Value("${swagger.restApi.enable}")
    private Boolean enable;

    @Value("${swagger.restApi.title}")
    private String title;

    @Value("${swagger.restApi.description}")
    private String description;

    @Value("${swagger.restApi.version}")
    private String version;

    @Value("${swagger.restApi.contact.name}")
    private String name;

    @Value("${swagger.restApi.contact.url}")
    private String url;

    @Value("${swagger.restApi.contact.email}")
    private String email;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(name,url,email))
                .version(version)
                .build();
    }
}

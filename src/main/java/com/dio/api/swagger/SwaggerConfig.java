package com.dio.api.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket apiAdmin() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dio.api"))
//                .paths(PathSelectors.ant("/**"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    @Bean
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("API-REST")
//                .description(" Sistema de controle de ponto e acesso com Spring Boot")
//                .version("1.0.0")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                .contact(new Contact("João Marques", "https://www.linkedin.com/in/jjoaomarques/", ""))
//                .build();
//    }


    @Bean
    public OpenAPI customOpeAPI(@Value("${application.description}") String description,
                                @Value("${application.version}") String version) {
        return new OpenAPI().info(new Info()
                .title(description)
                .version(version)
                .termsOfService("http://swagger.io/terms")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}

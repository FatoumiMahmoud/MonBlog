package org.fatoumi.exercice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final HashSet<String> JSON = new HashSet<>(Arrays.asList("application/json"));

    @Bean
    public Docket teamboardApi() {
        // available at http://localhost:xxxx/v2/api-docs
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.fatoumi.exercice"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(teamboardApiInfo())
                .produces(JSON)
                .consumes(JSON);
    }

    private ApiInfo teamboardApiInfo() {
        return new ApiInfo(
                "Mon Blog API",
                "API provided for Blog management",
                "0.1",
                "For test only",
                new Contact(
                        "Mahmoud Fatoumi",
                        "https://github.com/FatoumiMahmoud/MonBlog",
                        "fatoumimahmoud[at]gmail.com"
                ),
                "",
                "",
                Collections.emptyList()
        );
    }
}

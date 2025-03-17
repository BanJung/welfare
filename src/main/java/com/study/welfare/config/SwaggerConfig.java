package com.study.welfare.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "WELFARE PLATFORM API Docs",
                description = "스프링 부트 스터디 : 복지몰 공동구매 & 중고 거래 플랫폼",
                version = "v1"
        )
)
@Configuration
public class SwaggerConfig {
//    private static final String BEARER_TOKEN_PREFIX = "Bearer";
//
//    @Bean
//    public OpenAPI openAPI() {
//        String securityJwtName = "JWT";
//        SecurityRequirement securityRequirement = new SecurityRequirement().addList(securityJwtName);
//        Components components = new Components()
//                .addSecuritySchemes(securityJwtName, new SecurityScheme()
//                        .name(securityJwtName)
//                        .type(SecurityScheme.Type.HTTP)
//                        .scheme(BEARER_TOKEN_PREFIX)
//                        .bearerFormat(securityJwtName));
//
//        return new OpenAPI()
//                .addSecurityItem(securityRequirement)
//                .components(components);
//    }
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components());
    }
}

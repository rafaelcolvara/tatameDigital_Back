package com.tatame.conf


import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConf {

    @Bean
    fun api(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("tatame-digital")
            .packagesToScan("com.tatame.categoria.controller")
            .build()
    }

    @Bean
    fun springOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Micro service").description("APIs for Test Console service").version("1.0")
                    .license(License().name("Dev Team").url("https://github.com"))
            )
            .externalDocs(ExternalDocumentation().description("Test Documentation").url("https://github.com"))
    }
}
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
            .packagesToScan("com.tatame.categoria.controller",
                "com.tatame.pessoas.competidor.controller",
                "com.tatame.evento.controller",
                "com.tatame.endereco.controller")
            .build()
    }

    @Bean
    fun springOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Tatame Digital - API").description("APIs do Tatame Digital").version("1.0")
                    .license(License().name("TatameDigital.com").url("http://www.tatameDigital.com.br"))
            )
            .externalDocs(ExternalDocumentation().description("Test Documentation").url("https://github.com"))
    }
}
package br.com.ericluis.devflow_timer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DevFlow Timer API")
                        .description("API para gerenciamento de sessões de foco com regras de negócio")
                        .version("1.0.0"));
    }
}

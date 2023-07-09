package stock.random.rank.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Stock-Random-Rank")
                .pathsToMatch("/stock/random/rank/**")
                .build();
    }
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("랜덤 주식 순위")
                        .description("랜덤 주식 순위 API")
                        .version("v0.0.1"));
    }
}

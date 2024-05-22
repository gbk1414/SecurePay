package global.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@OpenAPIDefinition(
	info = @Info(
		title = "Back Material API",
		description = "Back Material 서버 API 문서",
		version = "V1"
	)
)
@Configuration
class SwaggerConfig {
	@Bean
	public OpenAPI openApi() {

		SecurityScheme securityScheme = new SecurityScheme()
			.type(SecurityScheme.Type.APIKEY)
			.in(SecurityScheme.In.HEADER).name("Authorization");
		SecurityRequirement securityRequirement = new SecurityRequirement().addList("Auth");

		return new OpenAPI()
			.components(new Components().addSecuritySchemes("Auth", securityScheme))
			.security(List.of(securityRequirement));
	}
}

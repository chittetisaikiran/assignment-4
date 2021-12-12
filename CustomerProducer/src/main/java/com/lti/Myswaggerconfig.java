package com.lti;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Myswaggerconfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/bank.*")).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Assessment for Week 4")
				.description("API reference guide BANK Application using MICROSERVICES")
				.termsOfServiceUrl("https://chittetisaikiran").contact("LNTBank user").version("1.0").build();
	}
}
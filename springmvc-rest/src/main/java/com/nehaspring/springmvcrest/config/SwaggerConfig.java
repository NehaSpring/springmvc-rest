package com.nehaspring.springmvcrest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  
{

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.apiInfo(metaData());
	
	}
	private ApiInfo metaData() {
		
		Contact contact = new Contact("Neha Spring", "https://someurl.com", "nehaspring@gmail.com");
		return new ApiInfo("Spring RESTFul Service",
							"Frit Shop Api using Spring Boot", 
							"Version 1.0", "Terms Of Service", 
							contact, 
							"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
							new ArrayList<>());
	}
	

}

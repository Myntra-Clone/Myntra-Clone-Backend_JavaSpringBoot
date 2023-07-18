package com.myntra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class Config {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(getInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.myntra.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .useDefaultResponseMessages(false);                                           
    }

	@SuppressWarnings("deprecation")
	private ApiInfo getInfo() {
		return new ApiInfo("Myntra Clone : JAVA Backend API Documentation", "API Documentation for Myntra Clone JAVA Backend", "1.0.1", ".", ".", ".", ".");
	}


}

package com.nagarro.LibraryManagementFrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * This is the main class running the Spring Boot Frontend Application.
 *
 *
 */
@SpringBootApplication
@ComponentScan("com.nagarro.LibraryManagementFrontend")
public class LibraryManagementFrontendApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LibraryManagementFrontendApplication.class);
	}

	/**
	 * This method is for creating RestTemplate for application that uses RESTful
	 * Web Services.
	 * 
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * This is the main class running the Spring Boot Frontend Application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementFrontendApplication.class, args);
	}

}

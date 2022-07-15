package com.nagarro.LibraryManagementBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main class running the Spring Boot Backend Application
 *
 */
@SpringBootApplication
@ComponentScan({ "com.nagarro.LibraryManagementBackend" })
public class LibraryManagementApplication {

	/**
	 * This is the main class running the Spring Boot Backend Application
	 */
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

}

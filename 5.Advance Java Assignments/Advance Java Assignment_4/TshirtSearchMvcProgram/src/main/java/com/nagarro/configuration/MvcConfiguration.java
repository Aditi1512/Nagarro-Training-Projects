package com.nagarro.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class is used for servlet mapping.
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "com.nagarro.controller" })
public class MvcConfiguration extends WebMvcConfigurerAdapter {

}
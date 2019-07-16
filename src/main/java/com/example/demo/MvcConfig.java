package com.example.demo;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

	public void addViewContorollers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("Login");
	}
}

package com.springboot.initialize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com")
@EnableWebMvc
public class SpringBootInitialize {
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootInitialize.class, args);
	}
}

package com.newgig.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableConfigServer
@Configuration
@EnableWebMvc
@ComponentScan("com.newgig")
public class OneConfigBootStrap {

	public static void main(String[] args) {
		SpringApplication.run(OneConfigBootStrap.class, args);
	}

}

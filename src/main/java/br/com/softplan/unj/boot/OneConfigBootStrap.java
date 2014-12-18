package br.com.softplan.unj.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableConfigServer
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("br.com.softplan.unj")
public class OneConfigBootStrap {

	public static void main(String[] args) {
		SpringApplication.run(OneConfigBootStrap.class, args);
	}
	
}

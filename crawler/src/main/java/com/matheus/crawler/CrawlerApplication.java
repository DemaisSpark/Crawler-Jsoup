package com.matheus.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//annotation responsavel pelo Spring Boot
@SpringBootApplication
public class CrawlerApplication {

	//metodo principal da projeto de Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);
	}

}

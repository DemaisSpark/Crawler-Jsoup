package com.matheus.crawler.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.crawler.scrapping.Crawler;

//Annotation responsavel por fazer com qe o Spring Boot reconheça esta classe como controlador
@RestController
//Classe de controle do projeto
public class CrawlerController {
	
	//declaração necessaria para a chamada do Crawler
	Crawler crawler;

	//Annotation responsavel pelo mapeamento deste metodo, tornando este um web service 
	@RequestMapping
	//chamada do Crawler
	public Crawler test() throws IOException {
		 crawler = new Crawler();
		 ArrayList<ArrayList<String>> list= crawler.getList();
	     return crawler;
	}
}


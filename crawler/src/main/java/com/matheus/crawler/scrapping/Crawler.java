package com.matheus.crawler.scrapping;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//Classe responsavel pelo crawling do XML file
public class Crawler {

	//Declaração da lista craida para conter outra lista
	private ArrayList<ArrayList<String>> listOLists;
	//Declaração da lista criada para conter os elementos da varredura
	private ArrayList<String> feed;
	//
	public Crawler() throws IOException {

		//Variavel string que contem o endereço do site em que queremos utilizar o crawler
		final String url = "https://autoesporte.globo.com/rss/autoesporte/";
		
		//Variavel document que contem a conexao com o Jsoup, que ira realizar a leitura do site
		final Document doc = Jsoup.connect(url).get();

		//Chamada da lista craida para conter outra lista
		listOLists = new ArrayList<ArrayList<String>>();

		//Estrutura de repeticao que ira realizar a varredura dos elementos dentro de tags item
	    for(Element item : doc.select("item"))
	    { 

	    	//Chamada da lista craida para conter elementos da varredura
	    	feed = new ArrayList<String>();
	    	//Variavel string que contem o conteudo da tag title
	        final String title = item.select("title").first().text().toString();
	        //Variavel string que contem o conteudo da tag link
	        final String link = item.select("link").first().text().toString();
	        //Variavel string que contem o conteudo da tag description, mais precisamente o texto de descrição, o link de imagem foi filtrado
	        final String description1 = item.select("description").first().text().replaceAll("\\<.*?\\>","").toString();
	        //Variavel string que contem o conteudo da tag description, que será usado para obter o link de imagem contido neste
	        final String description2 = item.select("description").first().text().toString();
	        //Variavel string que contem o conteudo de description2, onde o link da imagem foi isolado
	        final String img = StringUtils.substringBetween(description2, "img src=", " /").replace("\"", "").toString();

	        //Adiciona elementos a lista feed
	        feed.add("Titulo da Materia: "+title);
	        feed.add("Url da Materia: "+link);
	        feed.add("Conteudo:"+description1);
	        feed.add("Image Link: "+img);
	        //Adiciona o feed e seus elementos a lista listOLists
	        listOLists.add(feed);
	    }
	}

	//metodo para a passagem da lista listOLists
	public ArrayList<ArrayList<String>> getList() {
		   return listOLists;
	}
}

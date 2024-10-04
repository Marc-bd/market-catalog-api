package com.marcos.market_catalog;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MarketCatalogApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MarketCatalogApplication.class, args);
	}

	@Value("${server.port}")
	private String serverPort;


	@Override
	public void run(String... args) throws Exception {
		// Loga a URL da API local
		System.out.println("API is running at: http://localhost:" + serverPort);
	}
}

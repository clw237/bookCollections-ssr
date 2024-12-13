package com.bookCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = { "com.bookCollection", "com.bookCollection.controller", "com.bookCollection.repository",
		"com.bookCollection.entity", "com.bookCollection.service" })
public class BookCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCollectionApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

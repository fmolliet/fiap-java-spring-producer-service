package br.com.tomatch.producers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories
@EnableCaching
@EnableSwagger2
// @EnableWebSecurity
public class ProducersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducersApplication.class, args);
	}

}

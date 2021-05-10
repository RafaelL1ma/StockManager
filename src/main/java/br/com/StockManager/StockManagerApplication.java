 package br.com.StockManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"br.com.models"})
@EnableJpaRepositories(basePackages = {"br.com.repository"})
@EnableAutoConfiguration
@Configuration
@ComponentScan({"br.com"})
@SpringBootApplication(scanBasePackages = {"br.com"})
public class StockManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockManagerApplication.class, args);
	}
	
}

 package br.com.StockManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
@ComponentScan({"br.com"})
@SpringBootApplication(scanBasePackages = {"br.com"})
public class StockManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockManagerApplication.class, args);
	}
	
}

package br.com.valid.bio.conveniadas.abis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.EnableIntegrationManagement;

@EnableIntegration
@SpringBootApplication
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
@IntegrationComponentScan
@EnableIntegrationManagement
public class App {

	public App() {
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
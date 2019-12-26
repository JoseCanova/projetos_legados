package org.nanotek;

import javax.annotation.Resource;

import org.nanotek.service.http.AsyncHttpClientServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.EnableIntegrationManagement;

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
@EnableIntegrationManagement
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
public class App {


	Logger log = LoggerFactory.getLogger(this.getClass().getName());


	@Resource 
	private AsyncHttpClientServices services;


	public App() {
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

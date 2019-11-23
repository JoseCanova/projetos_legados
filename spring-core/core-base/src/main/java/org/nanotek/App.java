package org.nanotek;

import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.nanotek.service.http.AsyncHttpClientServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
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
public class App {//implements CommandLineRunner


	Logger log = LoggerFactory.getLogger(this.getClass().getName());


	@Resource 
	private AsyncHttpClientServices services;


	public App() {
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Future<String> process1 = services.process();
//		Future<String> process2 = services.process();
//		Future<String> process3 = services.process();
//		Future<String> process4 = services.process();
//		Future<String> process5 = services.process();
//		Future<String> process6 = services.process();
//		Future<String> process7 = services.process();
//		Future<String> process8 = services.process();
//		Future<String> process9 = services.process();
//		Future<String> process10 = services.process();
//
//		// Wait until They are all Done
//		// If all are not Done. Pause 2s for next re-check
//		while(!(process1.isDone() 
//				&& process2.isDone() 
//				&& process3.isDone()
//				&& process4.isDone()
//				&& process5.isDone()
//				&& process6.isDone()
//				&& process7.isDone()
//				&& process8.isDone()
//				&& process9.isDone()
//				&& process10.isDone()
//				)){
//			Thread.sleep(2000);
//		}
//		log.info("All Processes are DONE!");
//		// Log results
//		log.info("Process 1: " + process1.get());
//		log.info("Process 2: " + process2.get());
//		log.info("Process 3: " + process3.get());
//		log.info("Process 4: " + process4.get());
//		log.info("Process 5: " + process5.get());
//		log.info("Process 6: " + process6.get());
//		log.info("Process 7: " + process7.get());
//		log.info("Process 8: " + process8.get());
//		log.info("Process 9: " + process9.get());
//		log.info("Process 10: " + process10.get());
//	}


}

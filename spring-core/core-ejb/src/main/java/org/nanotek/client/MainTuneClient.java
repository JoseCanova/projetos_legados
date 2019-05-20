package org.nanotek.client;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@Configuration
@EnableIntegration
@ImportResource(value="classpath:META-INF/spring/musicbrainz-tune-artist-integration.xml")
public class MainTuneClient {

	public static void main(String[] args) {
		SpringApplication.run(MainTuneClient.class, args);
	}
	
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8888);
        factory.setSessionTimeout(50, TimeUnit.MINUTES);
        return factory;
    }
}

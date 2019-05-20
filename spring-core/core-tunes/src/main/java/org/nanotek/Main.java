package org.nanotek;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
/*@EnableIntegration*/
@ImportResource(value={"classpath:META-INF/spring/musicbrainz-tune-artist-integration.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class , HibernateJpaAutoConfiguration.class , ActiveMQAutoConfiguration.class , JmsAutoConfiguration.class})
public class Main implements CommandLineRunner {

	@Autowired 
	ConfigurableApplicationContext applicationContext; 
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8082);
        factory.setSessionTimeout(50, TimeUnit.MINUTES);
        return factory;
    }

	@Override
	public void run(String... args) throws Exception {
		Optional.of(applicationContext).ifPresent(p -> collectAsList(p.getBeanDefinitionNames()).stream().forEach(b ->print("Bean Name :" +b)));
		Optional.of(args).ifPresent(p -> collectAsList(p).stream().forEach(e ->print(" Parameter Argument : " + e)));
	}

	private Object print(String p) {
		return System.out.printf("\n%s", p);
	}

	private  List<String> collectAsList(String[] values) {
		return Arrays.asList(values);
	}
    
}

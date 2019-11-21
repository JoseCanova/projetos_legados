package org.nanotek;

import java.util.concurrent.Executor;

import javax.persistence.EntityManagerFactory;

import org.nanotek.beans.ArtistAlias;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import au.com.bytecode.opencsv.bean.CsvToBean;


@Configuration
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "org.nanotek.repository")
public class BaseConfiguration {


	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("org.nanotek");
	    factory.setPersistenceUnitName("spring-core-music-brainz");
//	    factory.setDataSource(dataSource());
	    return factory;
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory);
	    return txManager;
	  }
	  
	  @Bean(name = "threadPoolTaskExecutor")
	  public Executor getAsyncExecutor() {
		    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		      executor.setCorePoolSize(10);
		      executor.setMaxPoolSize(20);
		      executor.setQueueCapacity(100000);
		      executor.setThreadNamePrefix("AsyncThreadPoolExecutor");
		      executor.initialize();
		      return executor;    
	  }

	  
	  @Bean
	  @Qualifier(value = "ArtistCsvToBean")
	  public CsvToBean<ArtistName> csvToBean(){ 
		  return new CsvToBean<>();
	  }
	  
	  @Bean
	  @Qualifier(value = "ArtistAliasCsvToBean")
	  public CsvToBean<ArtistAlias> csvAliasToBean(){ 
		  return new CsvToBean<>();
	  }

	  @Bean
	  @Qualifier(value = "ArtistCreditCsvToBean")
	  public CsvToBean<ArtistCredit> csvArtistCreditToBean(){ 
		  return new CsvToBean<>();
	  }

	  @Bean
	  @Qualifier(value = "ArtistCreditNameCsvToBean")
	  public CsvToBean<ArtistCreditName> csvArtistCreditNameToBean(){ 
		  return new CsvToBean<>();
	  }
}

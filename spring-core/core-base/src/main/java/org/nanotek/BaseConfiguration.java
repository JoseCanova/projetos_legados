package org.nanotek;

import javax.persistence.EntityManagerFactory;

import org.nanotek.base.maps.ArtistAliasBaseMap;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.ArtistAlias;
import org.nanotek.beans.ArtistName;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.service.parser.BaseMapParser;
import org.nanotek.service.parser.BaseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import au.com.bytecode.opencsv.bean.CsvToBean;


@Configuration
@EnableConfigurationProperties
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
}

package org.nanotek;

import java.util.concurrent.Executor;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.validation.Validator;

import org.nanotek.beans.ArtistAlias;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.beans.csv.RecordingBean;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.beans.csv.ReleaseGroupBean;
import org.nanotek.beans.csv.TrackBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationInterceptor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import au.com.bytecode.opencsv.bean.CsvToBean;

@Configuration
@ComponentScan("org.nanotek")
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class BaseConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}

	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() { 
		return new LocalValidatorFactoryBean();
	}
	
	@Bean 
	public Validator validator()
	{ 
		return validatorFactoryBean().getValidator();
	}
	
	@Bean(name = "MethodValidationInterceptor")
	@Qualifier(value="MethodValidationInterceptor")
	MethodValidationInterceptor methodValidationInterceptor(@Autowired Validator validator) { 
		return new MethodValidationInterceptor(validator);
	}
	
    @Bean
    public MethodValidationPostProcessor getMethodValidationPostProcessor(@Autowired LocalValidatorFactoryBean validatorFactoryBean){
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
         processor.setValidator(validatorFactoryBean.getValidator());
         processor.setValidatorFactory(validatorFactoryBean);
         return processor;
     }
	
    
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoproxyCreator(@Autowired MethodValidationInterceptor interceptor) { 
    	BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
    	proxyCreator.setBeanNames(new String[] {"ArtistCreditMediator"});
    	proxyCreator.setInterceptorNames(new String[] {"MethodValidationInterceptor"});
    	return proxyCreator;
    }
    
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("org.nanotek");
		factory.setPersistenceUnitName("spring-core-music-brainz");
		factory.setDataSource(dataSource());
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(@Autowired EntityManagerFactory entityManagerFactory) { 
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory); 
		return txManager; 
	}


	@Bean(name = "serviceTaskExecutor")
	public ThreadPoolTaskExecutor getServiceTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(100000);
		executor.setThreadNamePrefix("ServiceThreadPoolExecutor");
		executor.initialize();
		return executor;
	}

	@Bean(name = "threadPoolTaskExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(100000);
		executor.setThreadNamePrefix("AsyncThreadPoolExecutor");
		executor.initialize();
		return executor;
	}

	@Bean
	@Qualifier(value = "ArtistBeanCsvToBean")
	public CsvToBean<ArtistBean> csvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "ArtistAliasCsvToBean")
	public CsvToBean<ArtistAlias> csvAliasToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "ArtistCreditCsvToBean")
	public CsvToBean<ArtistCreditBean> csvArtistCreditToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "ArtistCreditNameCsvToBean")
	public CsvToBean<ArtistCreditName> csvArtistCreditName() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "ArtistCreditNameBeanCsvToBean")
	public CsvToBean<ArtistCreditNameBean> csvArtistCreditNameBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "ReleaseBeanCsvToBean")
	public CsvToBean<ReleaseBean> releaseBeanCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "ReleaseGroupCsvToBean")
	public CsvToBean<ReleaseGroupBean> releaseGroupBeanCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "RercordingBeanCsvToBean")
	public CsvToBean<RecordingBean> recordingBeanCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value = "TrackBeanCsvToBean")
	public CsvToBean<TrackBean> trackBeanCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}

	@Bean
	public RequestMappingInfo artistRequestMappingInfo() { 
		return RequestMappingInfo
						.paths("/request_artist")
						.mappingName("request_artist")
						.methods(RequestMethod.GET).build();
	}
	
}

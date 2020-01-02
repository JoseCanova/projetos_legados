package test.org.nanotek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.BasicJdbcConverter;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.convert.RelationResolver;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;


@Configuration
@EnableConfigurationProperties
@EnableJdbcRepositories(basePackages = {"org.nanotek.repository.jdbc"})
public class TestConfiguration {
	
	@Bean
	RelationalMappingContext context() { 
		return new RelationalMappingContext();
	}
	
}

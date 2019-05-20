package org.hubotek;

import javax.cache.CacheFactory;
import javax.xml.xpath.XPathFactory;
import org.hubotek.google.cache.CacheFactorySupplier;
import org.hubotek.google.news.GoogleNewsFeed;
import org.hubotek.google.news.feed.DomParser;
import org.hubotek.google.xpath.XPathFactorySupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc
public class Application {

    @Bean
    GoogleNewsFeed createGoogleNewsFeedParser()
    { 
    	return new GoogleNewsFeed();
    }
    
    @Bean(name="cacheFactoryBase")
    CacheFactory createCacheFactory(){ 
    	return new CacheFactorySupplier().get();
    }
    
    @Bean(name="xpathFactoryBase")
    XPathFactory createXPathFactory()
    { 
    	return new XPathFactorySupplier().get();
    }
    
    @Bean
    DomParser createFeedParser()
    { 
    	return new DomParser();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/news").allowedOrigins("*");
                registry.addMapping("/search").allowedOrigins("*");
            }
        };
    }
}
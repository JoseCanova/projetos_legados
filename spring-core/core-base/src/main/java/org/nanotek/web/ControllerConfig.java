package org.nanotek.web;

import java.util.HashMap;
import java.util.Map;

import org.nanotek.beans.entity.Artist;
import org.nanotek.controller.entity.EntityResponseController;
import org.nanotek.service.jpa.ArtistJpaService;
import org.nanotek.service.jpa.BasePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

@Configuration
public class ControllerConfig {

//	@Autowired ArtistJpaService artistJpaService;
	
	public ControllerConfig() {
	}
	
	/*
	 * @Bean public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
	 * SimpleUrlHandlerMapping simpleUrlHandlerMapping = new
	 * SimpleUrlHandlerMapping();
	 * 
	 * Map<String, Object> urlMap = new HashMap<>();
	 * urlMap.put("/artist_controller/*", baseArtistControllerConfig());
	 * simpleUrlHandlerMapping.setUrlMap(urlMap); return simpleUrlHandlerMapping; }
	 * 
	 * @Bean public EntityResponseController<Artist,Long>
	 * baseArtistControllerConfig(){ return new
	 * EntityResponseController<Artist,Long>(){
	 * 
	 * @Override public BasePersistenceService<Artist, Long> getBaseService() {
	 * return artistJpaService; }
	 * 
	 * }; }
	 */

}

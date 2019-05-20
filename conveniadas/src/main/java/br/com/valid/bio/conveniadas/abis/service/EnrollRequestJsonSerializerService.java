package br.com.valid.bio.conveniadas.abis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EnrollRequestJsonSerializerService {

	@Autowired
	private ObjectMapper objectMapper;
	
	public EnrollRequestJsonSerializerService() {
	}

	public <T> String serialize (T source) {
		String result = null; 
		try{ 
			result = objectMapper.writeValueAsString(source);
		}catch (JsonProcessingException jpEx) { 
			throw new MessagingException(new StringBuilder().append("Problem to serialize the object ").append(source.toString()).toString() , jpEx);
		}
		return result;
	}
}

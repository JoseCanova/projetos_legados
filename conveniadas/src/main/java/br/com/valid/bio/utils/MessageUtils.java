package br.com.valid.bio.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.MessageHeaders;

public class MessageUtils {

	public static Map<String, Object> getMessageHeaders(MessageHeaders headers) {
		Map<String,Object> originalHeaders = new HashMap<>();
		headers.keySet().stream().forEach(hk -> originalHeaders.put(hk, headers.get(hk)));
		return originalHeaders;
	}
	
}

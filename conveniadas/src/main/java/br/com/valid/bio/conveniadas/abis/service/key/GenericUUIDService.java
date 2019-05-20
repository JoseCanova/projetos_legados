package br.com.valid.bio.conveniadas.abis.service.key;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class GenericUUIDService extends BaseKeyService<UUID> {

	@Override
	public UUID getKey() {
		return UUID.randomUUID();
	}

	public UUID getKey(String val) 
	{ 
		return UUID.fromString(val);
	}
	
	public UUID getKey (byte[] bytes) 
	{ 
		return UUID.nameUUIDFromBytes(bytes);
	}
}
package br.com.valid.bio.conveniadas.abis.service.key;

import java.rmi.server.UID;

import org.springframework.stereotype.Component;

/**
 * 
 * @author JoseCanova
 * Generates a unique indentifier based on host id and current time in millis.
 *
 */
@Component
public class UIDService extends BaseKeyService<UID>{

	@Override
	public UID getKey() {
		return new UID();
	}

}

package br.com.valid.bio.conveniadas.abis.service.key;

import java.rmi.server.ObjID;

import org.springframework.stereotype.Component;

@Component
public class ObjIDService extends BaseKeyService<ObjID> {

	@Override
	public ObjID getKey() {
		return new ObjID();
	}

}
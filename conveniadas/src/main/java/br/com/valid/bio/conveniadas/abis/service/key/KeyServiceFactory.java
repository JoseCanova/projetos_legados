package br.com.valid.bio.conveniadas.abis.service.key;


import java.rmi.server.ObjID;
import java.rmi.server.UID;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyServiceFactory{
	
	@Autowired
	private UIDService uidService; 
	@Autowired
	private GenericUUIDService uuidService; 
	@Autowired
	private ObjIDService objIDService; 
	
	public KeyServiceFactory() 
	{}
	
	public synchronized Object getKey (Class <? extends Object> clazz) throws KeyServiceFactoryException
	{ 
		if (clazz.equals(UID.class))
			return uidService.getKey();
		if (clazz.equals(UUID.class)) 
			return uuidService.getKey();
		if (clazz.equals(ObjID.class))
			return objIDService.getKey();
		throw new KeyServiceFactoryException("No defined factory service for provided class");
	}

	public UIDService getUidService() {
		return uidService;
	}

	public void setUidService(UIDService uidService) {
		this.uidService = uidService;
	}

	public GenericUUIDService getUuidService() {
		return uuidService;
	}

	public void setUuidService(GenericUUIDService uuidService) {
		this.uuidService = uuidService;
	}

	public ObjIDService getObjIDService() {
		return objIDService;
	}

	public void setObjIDService(ObjIDService objIDService) {
		this.objIDService = objIDService;
	}

}

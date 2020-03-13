package org.nanotek;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.UUID;

public interface UUIDBaseBase extends UUIDImutableBase {

	default UUID withUUID() { 
		UUID uuid = null;
		try { 
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				ObjectOutputStream oos =  new ObjectOutputStream(bao);
				oos.writeObject(this);
				oos.flush();
				uuid = UUID.nameUUIDFromBytes(bao.toByteArray());
				oos.close();
		}catch (Exception ex) { 
		}
		return Optional.ofNullable(uuid).orElseThrow(BaseException::new);
	}
	
}

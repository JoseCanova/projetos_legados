package org.nanotek;

import java.util.UUID;

public interface UUIDBaseBase extends ImmutableBase<UUIDBaseBase> {

	String getName();
	
	void setName(String name);
	
	void setUUID(UUID uuid);
	
	default UUIDBaseBase  withName(String name) { 
		setName(name);
		withUUID();
		return this;
	}
	
	@Override
	default UUID withUUID() {
		UUID uuid = ImmutableBase.super.withUUID();
		setUUID(uuid);
		return uuid;
	}
	
	
}

package org.nanotek;

import java.util.UUID;

public class UUIDNameBase implements UUIDBaseBase {

	private static final long serialVersionUID = 2692875536991084184L;

	private String name; 
	
	private UUID uuid;
	
	
	
	public UUIDNameBase() {
		withUUID();
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "UUIDNameBase [name=" + name + ", uuid=" + uuid.toString() + "]";
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}
	
}

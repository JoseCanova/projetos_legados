package org.nanotek;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class UUIDNameBase implements NameBase<String> , UUIDBase , Base{

	private static final long serialVersionUID = 2692875536991084184L;

	private String name; 
	
	private UUID uuid;
	
	public UUIDNameBase() {
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public String toString() {
		return "UUIDNameBase [name=" + name + ", uuid=" + uuid.toString() + "]";
	}

	@Override
	public UUID withUUID() {
		return this.uuid = UUIDBase.super.withUUID();
	}

	public <K extends NameBase<String>> K withName(String name) {
		return NameBase.super.withName(name);
	}
	
}

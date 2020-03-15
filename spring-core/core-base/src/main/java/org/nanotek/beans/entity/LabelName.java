package org.nanotek.beans.entity;

import java.util.function.Consumer;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.LongBase;
import org.nanotek.LongIdEntityBase;

@SuppressWarnings("serial")
@Entity
@Table(name="label_name")
public class LabelName implements LongIdEntityBase {

	private Long id; 
	
	private String name; 
	
	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

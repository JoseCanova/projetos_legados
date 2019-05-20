package org.hubotek.model.cse.attributes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="attribute_base")
public class AttributeBase implements Base<Long> {

	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	protected AttributeTypeEnum attributeType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}

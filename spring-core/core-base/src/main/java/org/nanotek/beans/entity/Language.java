package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="language")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Language extends  EntityLongBase {

	private static final long serialVersionUID = 3416483640256915L;

	@Column(name="isoCode2t" , length=3)
	private String isoCode2t; 
	
	@Column(name="isoCode2b" , length=3)
	private String isoCode2b; 
	
	@Column(name="isoCode1" , length=2)
	private String isoCode1; 
	
	@NotBlank
	@Column(name="name" , length=100, nullable=false)
	private String name; 
	
	@Column(name="frequency")
	private Long frequency;
	
	@Column(name="isoCode3", length=3)
	private String isoCode3;
	
	public Language() {}
	
	public Language(Long id, String isoCode2t, String isoCode2b, String isoCode1, @NotBlank String name, Long frequency,
			String isoCode3) {
		super(id);
		this.isoCode2t = isoCode2t;
		this.isoCode2b = isoCode2b;
		this.isoCode1 = isoCode1;
		this.name = name;
		this.frequency = frequency;
		this.isoCode3 = isoCode3;
	}


	public String getIsoCode2t() {
		return isoCode2t;
	}

	public void setIsoCode2t(String isoCode2t) {
		this.isoCode2t = isoCode2t;
	}

	public String getIsoCode2b() {
		return isoCode2b;
	}

	public void setIsoCode2b(String isoCode2b) {
		this.isoCode2b = isoCode2b;
	}

	public String getIsoCode1() {
		return isoCode1;
	}

	public void setIsoCode1(String isoCode1) {
		this.isoCode1 = isoCode1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

	public String getIsoCode3() {
		return isoCode3;
	}

	public void setIsoCode3(String isoCode3) {
		this.isoCode3 = isoCode3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Language [isoCode2t=" + isoCode2t + ", isoCode2b=" + isoCode2b + ", isoCode1=" + isoCode1 + ", name="
				+ name + ", frequency=" + frequency + ", isoCode3=" + isoCode3 + ", id=" + id + "]";
	}
	
}

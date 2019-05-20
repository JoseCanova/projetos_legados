package org.nanotek.beans.musicbrainz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
public class TuneGenre implements Base<Long>{

	@Id
	private Long id; 
	
	@Column(name="name" , length=255)
	private Long name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getName() {
		return name;
	}

	public void setName(Long name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TuneGenre other = (TuneGenre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TuneGenre [id=" + id + ", name=" + name + "]";
	} 
	
	
}

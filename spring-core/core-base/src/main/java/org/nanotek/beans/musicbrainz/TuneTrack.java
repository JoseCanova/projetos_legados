package org.nanotek.beans.musicbrainz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
public class TuneTrack implements Base<Long>{

	@Id
	private Long id; 
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="checked",nullable=false)
	private Boolean tuneSChecked;

	public TuneTrack(){} 
	
	public TuneTrack(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.tuneSChecked = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTuneSChecked() {
		return tuneSChecked;
	}

	public void setTuneSChecked(Boolean tuneSChecked) {
		this.tuneSChecked = tuneSChecked;
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
		TuneTrack other = (TuneTrack) obj;
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
		return "TuneTrack [id=" + id + ", name=" + name + ", tuneSChecked="
				+ tuneSChecked + "]";
	}
	
	
}

package org.nanotek.beans.musicbrainz;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
public class TuneRecord  implements Base<Long>{

	@Id
	private Long id; 
	
	@Column(name="name",nullable=false , length=2500)
	private String name;
	
	@Column(name="checked",nullable=false)
	private Boolean tuneSChecked;


	@OneToMany(fetch=FetchType.LAZY)
	private Set<TuneTrack> tracks;
	
	public TuneRecord(){} 
	
	public TuneRecord(Long id, String name) {
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

	public Set<TuneTrack> getTracks() {
		return tracks = tracks != null ? tracks : (tracks = newAnyType(HashSet::new));
	}

	public void setTracks(Set<TuneTrack> tracks) {
		this.tracks = tracks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((tuneSChecked == null) ? 0 : tuneSChecked.hashCode());
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
		TuneRecord other = (TuneRecord) obj;
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
		if (tuneSChecked == null) {
			if (other.tuneSChecked != null)
				return false;
		} else if (!tuneSChecked.equals(other.tuneSChecked))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TuneRecord [id=" + id + ", name=" + name + ", tuneSChecked="
				+ tuneSChecked + ", tracks=" + tracks + "]";
	}

}

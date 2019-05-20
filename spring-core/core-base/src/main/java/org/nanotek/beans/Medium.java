package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="medium")
public class Medium implements Base<Long>{

	@Id
	@GeneratedValue(generator="medium_id_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="medium_id_seq" , sequenceName="medium_id_seq")
	private Long id; 
	@Column(name="MEDIUM_ID")
	private Long mediumId; 
	@Column(name="RELEASE")
	private Long release;
	@Column(name="POSITION",nullable=true)
	private Long position;
	@Column(name="FORMAT")
	private Long format;
	@Column(name="NAME" , length=2500 , nullable=true)
	private String name; 
	@Column(name="TRACK_COUNT")
	private Long trackCount; 
	

	@Override
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getMediumId() {
		return mediumId;
	}


	public void setMediumId(Long mediumId) {
		this.mediumId = mediumId;
	}
	

	public Long getTrackCount() {
		return trackCount;
	}


	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}


	public Long getRelease() {
		return release;
	}


	public void setRelease(Long release) {
		this.release = release;
	}


	public Long getPosition() {
		return position;
	}


	public void setPosition(Long position) {
		this.position = position;
	}


	public Long getFormat() {
		return format;
	}


	public void setFormat(Long format) {
		this.format = format;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mediumId == null) ? 0 : mediumId.hashCode());
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
		Medium other = (Medium) obj;
		if (mediumId == null) {
			if (other.mediumId != null)
				return false;
		} else if (!mediumId.equals(other.mediumId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Medium [id=" + id + ", mediumId=" + mediumId + ", trackCount="
				+ trackCount + ", release=" + release + ", position=" + position
				+ ", format=" + format + ", name=" + name + "]";
	}

	
}

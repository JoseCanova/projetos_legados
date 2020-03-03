package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.nanotek.LongBase;

@Entity
@Table(name="artist_type")
public class ArtistType implements LongBase{

	private static final long serialVersionUID = 962190613873549033L;
	
	@Id
	@GeneratedValue(generator="artist_type_id_seq",strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name = "artist_type_id_seq", sequenceName = "artist_type_id_seq")
	private Long id; 
	@NotNull
	@Column(name="artist_type_id",nullable=false,unique=true)
	private Long artistTypeId;
	@NotNull
	@Column(name="name",length=255,nullable=false,unique=true)
	private String name; 
	@Column(name="parent",nullable=false,unique=false)
	private Long parent; 
	@Column(name="child_order",nullable=false,unique=false)
	private Long childOrder;
	@Column(name="description",length=2000,nullable=true,unique=false)
	private String description;
	@Column(name="gid",length=100,nullable=false,unique=false)
	private String gid;
	
	public ArtistType() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArtistTypeId() {
		return artistTypeId;
	}

	public void setArtistTypeId(Long artistTypeId) {
		this.artistTypeId = artistTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Long getChildOrder() {
		return childOrder;
	}

	public void setChildOrder(Long childOrder) {
		this.childOrder = childOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistTypeId == null) ? 0 : artistTypeId.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
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
		ArtistType other = (ArtistType) obj;
		if (artistTypeId == null) {
			if (other.artistTypeId != null)
				return false;
		} else if (!artistTypeId.equals(other.artistTypeId))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
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
		return "ArtistType [id=" + id + ", artistTypeId=" + artistTypeId + ", name=" + name + ", parent=" + parent
				+ ", childOrder=" + childOrder + ", description=" + description + ", gid=" + gid + "]";
	}
	
}

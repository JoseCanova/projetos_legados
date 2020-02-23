package org.nanotek.beans.csv;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.nanotek.LongBase;

@SuppressWarnings("serial")
public class ArtistCreditBean implements LongBase{

	@NotNull
	Long id; 
	@NotNull
	@NotEmpty
	@Length(min = 1 , max = 1000)
	String name; 
	@NotNull
	Integer artistCount;
	@NotNull
	Integer refCount; 
	@NotNull
	String created; 
	@NotNull
	Integer editsPending;
	
	public ArtistCreditBean(){}
	
	public ArtistCreditBean(Long id, String name, Integer artistCount, Integer refCount, String created,
			Integer editsPending) {
		super();
		this.id = id;
		this.name = name;
		this.artistCount = artistCount;
		this.refCount = refCount;
		this.created = created;
		this.editsPending = editsPending;
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

	public Integer getArtistCount() {
		return artistCount;
	}

	public void setArtistCount(Integer artistCount) {
		this.artistCount = artistCount;
	}

	public Integer getRefCount() {
		return refCount;
	}

	public void setRefCount(Integer refCount) {
		this.refCount = refCount;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Integer getEditsPending() {
		return editsPending;
	}

	public void setEditsPending(Integer editsPending) {
		this.editsPending = editsPending;
	}

	@Override
	public String toString() {
		return "ArtistCreditBean [id=" + id + ", name=" + name + ", artistCount=" + artistCount + ", refCount="
				+ refCount + ", created=" + created + ", editsPending=" + editsPending + "]";
	}

}

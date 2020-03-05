package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="release")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Release extends EntityLongBase {

	private static final long serialVersionUID = 8526436903189806951L;
	
	@NotBlank
	@Column(name="gid" , nullable=false, length=50 , insertable=true)
	private String gid; 
	
	@NotBlank
	@Size(min=1 , max=4000)
	@Column(name="name" , insertable=true , nullable=false , length=4000)
	private String name; 

	@Column(name="barCode" , length=255)
	private String barCode;
	
	@Column(name="comment" , length=255)
	private String comment; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_id")
	private ReleaseStatus status; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="packaging_id")
	private ReleasePackaging packaging;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="language_id")
	private Language language; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="release_group_id" , insertable=true , nullable=false)
	private ReleaseGroup releaseGroup; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_credit_id" , referencedColumnName="id")
	private ArtistCredit artistCredit;

	public Release() { 
	}

	public Release(@NotNull Long id, @NotBlank String gid, @NotBlank @Size(min = 1, max = 4000) String name, String barCode,
			String comment, ReleaseStatus status, ReleasePackaging packaging, Language language,
			ReleaseGroup releaseGroup, ArtistCredit artistCredit) {
		super(id);
		this.gid = gid;
		this.name = name;
		this.barCode = barCode;
		this.comment = comment;
		this.status = status;
		this.packaging = packaging;
		this.language = language;
		this.releaseGroup = releaseGroup;
		this.artistCredit = artistCredit;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ReleaseStatus getStatus() {
		return status;
	}

	public void setStatus(ReleaseStatus status) {
		this.status = status;
	}

	public ReleasePackaging getPackaging() {
		return packaging;
	}

	public void setPackaging(ReleasePackaging packaging) {
		this.packaging = packaging;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public ReleaseGroup getReleaseGroup() {
		return releaseGroup;
	}

	public void setReleaseGroup(ReleaseGroup releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
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
		Release other = (Release) obj;
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
		return "Release [gid=" + gid + ", name=" + name + ", barCode=" + barCode + ", comment=" + comment + ", id=" + id
				+ "]";
	}
	

}

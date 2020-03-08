package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="release_alias")
public class ReleaseAlias extends LongIdSortNameEntity {

	private static final long serialVersionUID = -4420910201637029585L;
	
	@Column(name="relase_alias_id" , nullable=false)
	private Long releaseAliasId;
	
	@OneToOne(optional=true)
	@JoinTable(
			  name = "release_alias_locale_join", 
			  joinColumns = @JoinColumn(name = "release_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "locale_id",referencedColumnName = "id"))
	private ReleaseAliasLocale locale;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "release_id")
	private Release release; 
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name="type_id")
	private ReleaseAliasType type;

    @OneToOne(optional=true)
	@JoinTable(
			  name = "release_alias_begin_date_join", 
			  joinColumns = @JoinColumn(name = "release_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id"))
    private ReleaseAliasBeginDate beginDate;
    
    @OneToOne(optional=true)
	@JoinTable(
			  name = "release_alias_end_date_join", 
			  joinColumns = @JoinColumn(name = "release_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id"))
    private ReleaseAliasEndDate endDate;

	public ReleaseAlias() {
	}
	
	public ReleaseAlias(@NotNull Long id , @NotBlank String name, @NotBlank String sortName) {
		super(name, sortName);
		this.releaseAliasId = id;
	}
	
	public ReleaseAlias(
			@NotNull Long id, 
			@NotBlank String name, 
			ReleaseAliasLocale locale, 
			@NotNull Release release,
			ReleaseAliasType type, 
			@NotBlank String sortName, 
			ReleaseAliasBeginDate beginDate,
			ReleaseAliasEndDate endDate) {
		this.releaseAliasId = id;
		this.name = name;
		this.locale = locale;
		this.release = release;
		this.type = type;
		this.sortName = sortName;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public ReleaseAliasType getType() {
		return type;
	}

	public void setType(ReleaseAliasType type) {
		this.type = type;
	}

	public Long getReleaseAliasId() {
		return releaseAliasId;
	}

	public void setReleaseAliasId(Long releaseAliasId) {
		this.releaseAliasId = releaseAliasId;
	}

	public ReleaseAliasLocale getLocale() {
		return locale;
	}

	public void setLocale(ReleaseAliasLocale locale) {
		this.locale = locale;
	}

	public ReleaseAliasBeginDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(ReleaseAliasBeginDate beginDate) {
		this.beginDate = beginDate;
	}

	public ReleaseAliasEndDate getEndDate() {
		return endDate;
	}

	public void setEndDate(ReleaseAliasEndDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ReleaseAlias [releaseAliasId=" + releaseAliasId + ", locale=" + locale + ", release=" + release
				+ ", type=" + type + ", beginDate=" + beginDate + ", endDate=" + endDate + ", sortName=" + sortName
				+ ", name=" + name + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((releaseAliasId == null) ? 0 : releaseAliasId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ReleaseAlias other = (ReleaseAlias) obj;
		if (releaseAliasId == null) {
			if (other.releaseAliasId != null)
				return false;
		} else if (!releaseAliasId.equals(other.releaseAliasId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}

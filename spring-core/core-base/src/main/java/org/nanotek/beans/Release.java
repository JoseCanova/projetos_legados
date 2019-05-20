package org.nanotek.beans;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="RELEASE")
public class Release implements Base<Long> {

	@Id
	@GeneratedValue(generator="release_seq" , strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="release_seq", sequenceName="release_id_seq")
	private Long id; 
	@Column(name="RELEASE_ID" , nullable=false)
	private Long releaseId; 
	@Column(name="GID" , nullable=false)
	private String gid; 
	@Column(name="RELEASE_GROUP" , insertable=true , nullable=false)
	private Long releaseGroup; 
	@Column(name="ARTIST_CREDIT" , insertable=true , nullable=false)
	private Long artistCredit; 
	//TODO REFACTOR TABLE
	@Column(name="NAME" , insertable=true , nullable=false , length=2500)
	private String name; 
	
	@Column(name="BAR_CODE" , insertable=true , nullable=true)
	private String barCode; 
	@Column(name="DATE_YEAR" , insertable=true , nullable=true)
	private String dateYear; 
	@Column(name="DATE_MONTH" , insertable=true , nullable=true)
	private String dateMonth; 
	@Column(name="DATE_DAY" , insertable=true , nullable=true)
	private String dateDay; 
	
	@Column(name="COUNTRY" , insertable=true , nullable=true)
	private String country; 
	@Column(name="STATUS" , insertable=true , nullable=true)
	private String status; 
	@Column(name="PACKAGING" , insertable=true , nullable=true)
	private String packaging;
	@Column(name="LANGUAGE" , insertable=true , nullable=true)
	private String language; 
	@Column(name="SCRIPT" , insertable=true , nullable=true)
	private String script; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_credit" , referencedColumnName="artist_credit_id")
	private ArtistCredit artistCreditReference;
	
	
	@Override
	public Long getId() {
		return id;
	}
	

	public Long getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Long getReleaseGroup() {
		return releaseGroup;
	}

	public void setReleaseGroup(Long releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public Long getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
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

	public String getDateYear() {
		return dateYear;
	}

	public void setDateYear(String dateYear) {
		this.dateYear = dateYear;
	}

	public String getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}

	public String getDateDay() {
		return dateDay;
	}

	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ArtistCredit getArtistCreditReference() {
		return artistCreditReference;
	}


	public void setArtistCreditReference(ArtistCredit artistCreditReference) {
		this.artistCreditReference = artistCreditReference;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((releaseId == null) ? 0 : releaseId.hashCode());
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
		Release other = (Release) obj;
		if (releaseId == null) {
			if (other.releaseId != null)
				return false;
		} else if (!releaseId.equals(other.releaseId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Release [id=" + id + ", releaseId=" + releaseId + ", gid="
				+ gid + ", releaseGroup=" + releaseGroup + ", artistCredit="
				+ artistCredit + ", name=" + name + ", barCode=" + barCode
				+ ", dateYear=" + dateYear + ", dateMonth=" + dateMonth
				+ ", dateDay=" + dateDay + ", country=" + country + ", status="
				+ status + ", packaging=" + packaging + ", language="
				+ language + ", script=" + script + "]";
	}

}

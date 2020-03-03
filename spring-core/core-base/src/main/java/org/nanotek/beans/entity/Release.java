package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.nanotek.MutableBase;


@Entity
@Table(name="release")
public class Release extends EntityLongBase implements MutableBase<Long>{

	private static final long serialVersionUID = 8526436903189806951L;
//
//	@Id
//	@GeneratedValue(generator="release_seq" , strategy=GenerationType.SEQUENCE)
//	@SequenceGenerator(name="release_seq", sequenceName="release_id_seq")
//	private Long id; 
	@Column(name="gid" , nullable=false)
	private String gid; 
	//	@Column(name="ARTIST_CREDIT" , insertable=true , nullable=false)
	//	private Long artistCredit; 
	//TODO REFACTOR TABLE
	@Column(name="name" , insertable=true , nullable=false , length=2500)
	private String name; 

	@Column(name="barCode" , insertable=true , nullable=true)
	private String barCode; 
	@Column(name="dateYear" , insertable=true , nullable=true)
	private String dateYear; 
	@Column(name="dateMonth" , insertable=true , nullable=true)
	private String dateMonth; 
	@Column(name="dateDay" , insertable=true , nullable=true)
	private String dateDay; 

	@Column(name="country" , insertable=true , nullable=true)
	private String country; 
	@Column(name="status" , insertable=true , nullable=true)
	private String status; 
	@Column(name="packaging" , insertable=true , nullable=true)
	private String packaging;
	@Column(name="language" , insertable=true , nullable=true)
	private String language; 
	@Column(name="script" , insertable=true , nullable=true)
	private String script; 

	
	@Column(name="RELEASE_GROUP" , insertable=true , nullable=false)
	private Long releaseGroup; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_credit" , referencedColumnName="id")
	private ArtistCredit artistCredit;

	public Release() { 
		super();
	}

	/*
	 * @Override public Long getId() { return id; }
	 */

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


	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

}

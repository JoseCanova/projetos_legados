package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@SuppressWarnings("serial")
@Entity
@Table(name="track")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Track extends LongIdGidNameEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="track_id_seq")
	 * 
	 * @SequenceGenerator(name="track_id_seq",sequenceName="track_id_seq") private
	 * Long id;
	 */ 
	@Column(name="MEDIUM")
	private Long medium; 
	@Column(name="POSITION")
	private Integer position;
	@Column(name="NUMBER")
	private String number; 
	@Column(name="ARTIST_CREDIT")
	private Long artistCredit; 
	@Column(name="LENGTH")
	private Long length;
	
	@ManyToOne(fetch=FetchType.LAZY , optional = false)
	@JoinColumn(name="recordingId" , referencedColumnName="id")
	private Recording recording;
	
	/*
	 * public Long getId() { return id; }
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMedium() {
		return medium;
	}
	public void setMedium(Long medium) {
		this.medium = medium;
	}
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getArtistCredit() {
		return artistCredit;
	}
	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}
	
//	public Long getRecordingId() {
//		return recordingId;
//	}
//	
//	public void setRecordingId(Long recordingId) {
//		this.recordingId = recordingId;
//	}
	
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}

}

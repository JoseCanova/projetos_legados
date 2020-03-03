package org.nanotek.beans.csv;

import org.nanotek.LongBase;

public class TrackBean implements LongBase{

	private static final long serialVersionUID = 7327347644746001993L;
	
	private Long id; 
	private String gid; 
	private Long recordingId; 
	private Long medium; 
	private Integer position; 
	private String number; 
	private String name; 
	private Long artistCreditId; 
	private Long length; 
	private Long editsPending; 
	private String lastUpdate;
	private String isDataTrack;
	
	public TrackBean() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Long getRecordingId() {
		return recordingId;
	}
	public void setRecordingId(Long recordingId) {
		this.recordingId = recordingId;
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
	public Long getArtistCreditId() {
		return artistCreditId;
	}
	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public Long getEditsPending() {
		return editsPending;
	}
	public void setEditsPending(Long editsPending) {
		this.editsPending = editsPending;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getIsDataTrack() {
		return isDataTrack;
	}
	public void setIsDataTrack(String isDataTrack) {
		this.isDataTrack = isDataTrack;
	}
	@Override
	public String toString() {
		return "TrackBean [id=" + id + ", gid=" + gid + ", recordingId=" + recordingId + ", medium=" + medium
				+ ", position=" + position + ", number=" + number + ", name=" + name + ", artistCreditId="
				+ artistCreditId + ", length=" + length + ", editsPending=" + editsPending + ", lastUpdate="
				+ lastUpdate + ", isDataTrack=" + isDataTrack + "]";
	} 
	
}

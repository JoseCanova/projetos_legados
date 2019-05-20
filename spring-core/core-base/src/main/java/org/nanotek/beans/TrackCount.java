package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="track_count")
public class TrackCount implements Base<String> {

	private String id; 
	private String trackCount; 
	private String lastUpdate; 
	
	@Override
	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}

	
	public String getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(String trackCount) {
		this.trackCount = trackCount;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	
}

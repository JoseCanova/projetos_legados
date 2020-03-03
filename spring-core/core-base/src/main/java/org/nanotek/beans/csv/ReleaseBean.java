package org.nanotek.beans.csv;

import org.nanotek.LongBase;

/**
 * 
 * @author josecanova
 *
 */
public class ReleaseBean implements LongBase{

	private static final long serialVersionUID = -11618084576388817L;
	private Long id; 
	private String gid; 
	private String name;
	private Long artistCreditId; 
	private Long releaseGroup; 
	private Long status; 
	private Integer  packaging; 
	private Integer  language; 
	private Integer script;
	private String barcode; 
	private String comment; 
	private Integer editsPending; 
	private Integer quality; 
	private String lastUpdated;
	
	
	public ReleaseBean() {}
	
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
	public Long getReleaseGroup() {
		return releaseGroup;
	}
	public void setReleaseGroup(Long releaseGroup) {
		this.releaseGroup = releaseGroup;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Integer getPackaging() {
		return packaging;
	}
	public void setPackaging(Integer packaging) {
		this.packaging = packaging;
	}
	public Integer getLanguage() {
		return language;
	}
	public void setLanguage(Integer language) {
		this.language = language;
	}
	public Integer getScript() {
		return script;
	}
	public void setScript(Integer script) {
		this.script = script;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getEditsPending() {
		return editsPending;
	}
	public void setEditsPending(Integer editsPending) {
		this.editsPending = editsPending;
	}
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "ReleaseBean [id=" + id + ", gid=" + gid + ", name=" + name + ", artistCreditId=" + artistCreditId
				+ ", releaseGroup=" + releaseGroup + ", status=" + status + ", packaging=" + packaging + ", language="
				+ language + ", script=" + script + ", barcode=" + barcode + ", comment=" + comment + ", editsPending="
				+ editsPending + ", quality=" + quality + ", lastUpdated=" + lastUpdated + "]";
	} 
	
}

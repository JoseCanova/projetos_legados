package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.ArtistAlias;

public class ArtistAliasBean  extends Result<ArtistAliasBean,ArtistAlias<ArtistAliasBean>> {

	private static final long serialVersionUID = -2745888243978330408L;
	
	private Long artistAliasId; 
	private Long artistId; 
	private String name; 
	private String locale; 
	private Integer editsPending;
	private String lastUpdated; 
	private Long type; 
	private String sortName;
	private Integer beginDateYear; 
	private Integer beginDateMonth;
	private Integer beginDateDay;
	private Integer endDateYear; 
	private Integer endDateMonth;
	private Integer endDateDay;
	private String primaryForLocale;
	private String ended;
	
	
	public ArtistAliasBean() {
	}

	public Long getArtistId() {
		return artistId;
	}


	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocale() {
		return locale;
	}


	public void setLocale(String locale) {
		this.locale = locale;
	}


	public Integer getEditsPending() {
		return editsPending;
	}


	public void setEditsPending(Integer editsPending) {
		this.editsPending = editsPending;
	}


	public String getLastUpdated() {
		return lastUpdated;
	}


	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	public Long getType() {
		return type;
	}


	public void setType(Long type) {
		this.type = type;
	}


	public String getSortName() {
		return sortName;
	}


	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	public Integer getBeginDateYear() {
		return beginDateYear;
	}


	public void setBeginDateYear(Integer beginDateYear) {
		this.beginDateYear = beginDateYear;
	}


	public Integer getBeginDateMonth() {
		return beginDateMonth;
	}


	public void setBeginDateMonth(Integer beginDateMonth) {
		this.beginDateMonth = beginDateMonth;
	}


	public Integer getBeginDateDay() {
		return beginDateDay;
	}


	public void setBeginDateDay(Integer beginDateDay) {
		this.beginDateDay = beginDateDay;
	}


	public Integer getEndDateYear() {
		return endDateYear;
	}


	public void setEndDateYear(Integer endDateYear) {
		this.endDateYear = endDateYear;
	}


	public Integer getEndDateMonth() {
		return endDateMonth;
	}


	public void setEndDateMonth(Integer endDateMonth) {
		this.endDateMonth = endDateMonth;
	}


	public Integer getEndDateDay() {
		return endDateDay;
	}


	public void setEndDateDay(Integer endDateDay) {
		this.endDateDay = endDateDay;
	}


	public String getPrimaryForLocale() {
		return primaryForLocale;
	}


	public void setPrimaryForLocale(String primaryForLocale) {
		this.primaryForLocale = primaryForLocale;
	}


	public String getEnded() {
		return ended;
	}


	public void setEnded(String ended) {
		this.ended = ended;
	}




	public Long getArtistAliasId() {
		return artistAliasId;
	}




	public void setArtistAliasId(Long artistAliasId) {
		this.artistAliasId = artistAliasId;
	}

}

package org.nanotek.beans.csv;

import org.nanotek.IdBase;
import org.nanotek.beans.entity.Area;

public class AreaBean<K extends AreaBean<K,ID>,ID extends Area<?>> implements IdBase<K,ID> {

	private static final long serialVersionUID = 1708381486272333902L;
	
	public ID id;
	
	private Long areaId; 
	private String gid; 
	private String name; 
	private Long type; 
	private Integer editsPending; 
	private String lastUpdated; 
	private Integer beginDateYear; 
	private Integer beginDateMonth; 
	private Integer beginDateDay; 
	private Integer endDateYead; 
	private Integer endDateMonth; 
	private Integer endDateDay;
	private String ended; 
	private String comment; 


	public AreaBean() {}
	
	public AreaBean(ID area) { 
		this.id = area;
	}

	public ID getId() { 
		return id;
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


	public Long getType() {
		return type;
	}


	public void setType(Long type) {
		this.type = type;
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


	public Integer getEndDateYead() {
		return endDateYead;
	}


	public void setEndDateYead(Integer endDateYead) {
		this.endDateYead = endDateYead;
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


	public String getEnded() {
		return ended;
	}


	public void setEnded(String ended) {
		this.ended = ended;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Long getAreaId() {
		return areaId;
	}


	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

}

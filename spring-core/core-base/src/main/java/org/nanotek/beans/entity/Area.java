package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.MutableAreaBeginDateEntity;
import org.nanotek.MutableAreaEndDateEntity;
import org.nanotek.MutableAreaIdEntity;
import org.nanotek.TypeEntity;

@Entity
@Table(name="area" , 
uniqueConstraints= {
		@UniqueConstraint(name="uk_area_id",columnNames={"area_id"})
		})
public class Area<E extends Serializable> extends LongIdGidName<String,E> implements 
															TypeEntity<AreaType<E>>,
															MutableAreaCommentEntity<AreaComment<E>>,
															MutableAreaIdEntity<Long>,
															MutableAreaBeginDateEntity<AreaBeginDate>,
															MutableAreaEndDateEntity<AreaEndDate>	{

	private static final long serialVersionUID = -7073321340141567106L;
	
	@NotNull
	@Column(name="area_id",nullable=false)
	private Long areaId; 
	
	@NotNull
	@ManyToOne(optional=false, fetch = FetchType.LAZY )
	private AreaType<E> type; 
	
	@OneToOne
	@JoinTable(
			  name = "area_begin_date_join", 
			  joinColumns = @JoinColumn(name = "area_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private AreaBeginDate areaBeginDate; 
	
	@OneToOne
	@JoinTable(
			  name = "area_end_date_join", 
			  joinColumns = @JoinColumn(name = "area_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private AreaEndDate areaEndDate;
	

	@OneToOne
	@JoinTable(
			  name = "area_comment_join", 
			  joinColumns = @JoinColumn(name = "area_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "comment_id",referencedColumnName = "id") )
	private AreaComment<E> areaComment;
	
	public Area() {}
	
	public Area(@NotNull Long id, @NotBlank String name, @NotBlank  String gid) {
		this.name = name;
		this.gid = gid;
		this.areaId = id;
	}

	public Area(@NotNull Long id, 
			@NotBlank String name, @NotBlank  String gid,
			@NotNull AreaType<E> type, AreaBeginDate areaBeginDate, AreaEndDate areaEndDate, AreaComment<E> areaComment) {
		this.name = name;
		this.gid = gid;
		this.type = type;
		this.areaBeginDate = areaBeginDate;
		this.areaEndDate = areaEndDate;
		this.areaComment = areaComment;
		this.areaId = id;
	}

	public String getName() {
		return name;
	}

	public AreaType<E> getType() {
		return type;
	}

	public void setType(AreaType<E> type) {
		this.type = type;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public AreaBeginDate getAreaBeginDate() {
		return areaBeginDate;
	}

	public void setAreaBeginDate(AreaBeginDate areaBeginDate) {
		this.areaBeginDate = areaBeginDate;
	}

	public AreaEndDate getAreaEndDate() {
		return areaEndDate;
	}

	public void setAreaEndDate(AreaEndDate areaEndDate) {
		this.areaEndDate = areaEndDate;
	}

	public AreaComment getAreaComment() {
		return areaComment;
	}

	public void setAreaComment(AreaComment areaComment) {
		this.areaComment = areaComment;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

}
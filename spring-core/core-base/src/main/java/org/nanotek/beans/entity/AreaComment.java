package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.nanotek.Base;
import org.nanotek.ImmutableLongBase;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="area_comment")
public class AreaComment implements ImmutableLongBase,Base{

	private static final long serialVersionUID = 5715488911104999603L;

	@Id
	private Long id; 
	
	@Column(name="comment" , length=1000 , insertable=true , updatable=true , nullable=true)
	private String comment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Area area;

	public AreaComment() {}
	
	public AreaComment(String comment) {
		super();
		this.comment = comment;
	}

	public AreaComment(String comment, Area area) {
		super();
		this.comment = comment;
		this.area = area;
		this.id = area.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
		this.id = area.getId();
	}

}

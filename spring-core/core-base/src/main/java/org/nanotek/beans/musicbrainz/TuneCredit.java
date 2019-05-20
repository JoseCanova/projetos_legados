package org.nanotek.beans.musicbrainz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
public class TuneCredit implements Base<Long> {

	@Id
	private Long id; 
	
	@Column(name="name",nullable=false , length=1000)
	private String name;
	
	@Column(name="checked",nullable=false)
	private Boolean tuneSChecked;

	public TuneCredit(){}
	
	public TuneCredit(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.tuneSChecked = false;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTuneSChecked() {
		return tuneSChecked;
	}

	public void setTuneSChecked(Boolean tuneSChecked) {
		this.tuneSChecked = tuneSChecked;
	}
	
}

package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class ArtistComment implements Base<Artist> {

	
	private Artist id;

	public Artist getId() {
		return id;
	}

	public void setId(Artist id) {
		this.id = id;
	}
	

}

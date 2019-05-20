package org.nanotek.web.spring;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.nanotek.beans.Release;

@Named
@ViewScoped
public class ReleaseController {

	private List<Release> releases; 
	
	private Long artistCreditId;

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public Long getArtistCreditId() {
		return artistCreditId;
	}

	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	} 
	
	
	
}

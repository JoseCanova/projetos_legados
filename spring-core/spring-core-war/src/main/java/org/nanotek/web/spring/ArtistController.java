package org.nanotek.web.spring;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.nanotek.beans.ArtistName;
import org.nanotek.service.ArtistService;

@SuppressWarnings("serial")
@Named 
@ViewScoped
public class ArtistController extends QueryInitializer{

	@Inject
	private ArtistService artistService; 

	private List<ArtistName> artists;

	private String artistName;

	private QueryChoice queryChoice = QueryChoice.BY_NAME; 


	public void findArtistByName() 
	{ 
		artists = artistService.findByNameLike(artistName);
	}

	public List<ArtistName> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistName> artists) {
		this.artists = artists;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void find()
	{ 
		switch (queryChoice) { 
		case BY_NAME: 
			artists = artistService.findByNameLike(artistName);
			break; 
		case BY_NAME_IGNORECASE:
			artists = artistService.findByNameIgnoreCase(artistName);
			break; 
		case BY_NAME_LIKEIGNORECASE: 
			artists = artistService.findByNameLikeIgnoreCase(artistName);
			break;
		}
	}

	public QueryChoice getQueryChoice() {
		return queryChoice;
	}

	public void setQueryChoice(QueryChoice queryChoice) {
		this.queryChoice = queryChoice;
	}

	public List<SelectItem> getQueryChoices()
	{ 
		return this.choices;
	}

}

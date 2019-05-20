package org.nanotek.web.spring;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.ArtistCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ArtistCreditController extends QueryInitializer{

	@EJB
	private ArtistCreditService artistCreditService; 
	
	private List<ArtistCredit> credits;

	private QueryChoice queryChoice = QueryChoice.BY_NAME;

	public List<ArtistCredit> getCredits() {
		return credits;
	}

	public void setCredits(List<ArtistCredit> credits) {
		this.credits = credits;
	}


	public List<ArtistCredit> findByNameLike(String name) {
		return artistCreditService.findByNameLike(name);
	}


	public ArtistCredit findById(Long id) {
		return artistCreditService.findById(id);
	}


	public List<ArtistCredit> findByNameIgnoreCase(String name) {
		return artistCreditService.findByNameIgnoreCase(name);
	}


	public List<ArtistCredit> findByNameLikeIgnoreCase(String name) {
		return artistCreditService.findByNameLikeIgnoreCase(name);
	}
	
	
	public QueryChoice getQueryChoice() {
		return queryChoice ;
	}

	public void setQueryChoice(QueryChoice queryChoice) {
		this.queryChoice = queryChoice;
	}

	public List<SelectItem> getQueryChoices()
	{ 
		return this.choices;
	}
	
}

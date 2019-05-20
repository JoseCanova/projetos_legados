package org.hubotek.model.cse;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.url.NamedUrl;

/**
 * Class storing the basic attributes by a "CSE"configured with 
 * Google AdSense for search. 
 * 
 * @author JoseCanova
 *
 */
@Entity
@Table(name="gse_base")
@SuppressWarnings("serial")
public class GoogleSearchEngineBase extends CseBase{

	@Column(name="name" , length=50 , insertable=true , unique=true , updatable=false)
	private String name;
	
	@Column(name="description" , length=250 , insertable=true , updatable=true)
	private String description;
	
	@OneToOne(fetch=FetchType.EAGER)
	private NamedUrl searchEngineUrl;
	
	@OneToMany
	private List<CseSite> sites;

	public GoogleSearchEngineBase(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NamedUrl getSearchEngineUrl() {
		return searchEngineUrl;
	}

	public void setSearchEngineUrl(NamedUrl searchEngineUrl) {
		this.searchEngineUrl = searchEngineUrl;
	}

	public List<CseSite> getSites() {
		return sites;
	}

	public void setSites(List<CseSite> sites) {
		this.sites = sites;
	} 
	
}

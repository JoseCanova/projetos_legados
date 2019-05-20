package org.hubotek.model.rss;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//TODO: refactor this class to use the namedurl attribute on url and link.
@SuppressWarnings("serial")
@Entity
@Table(name="rss_image")
public class RssImage extends RssBase
{
	@Column(name="title" , length=255 , insertable=true , updatable=true)
	private String title; 
	@Column(name="url" , length=1000 , insertable=true , updatable=true)
	private String url; 
	@Column(name="link" , length=1000 , insertable=true , updatable=true)
	private String link; 
	
	public RssImage(){}

	public RssImage(String title, String url, String link) {
		super();
		this.title = title;
		this.url = url;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}
	
}
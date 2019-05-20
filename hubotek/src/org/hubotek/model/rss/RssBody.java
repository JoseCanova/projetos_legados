package org.hubotek.model.rss;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//This is not the best practice use a standard format to persist the content, 
//but need to think that what is important is that the message remains cached and could be located and transformed to other format 
//at any time. And ATOM , RSS and JSON Search Result differs on structure.
//TODO: Change name to RssHeader
@SuppressWarnings("serial")
@Entity
@Table(name="rss_body")
public class RssBody  extends RssBase
{ 
	
	@Column(name="generator" , length=40 , insertable=true , updatable=false)
	private String generator;
	@Column(name="title" , length=255 , insertable=true , updatable=false)
	private String title;
	@Column(name="link" , length=1000 , insertable=true , updatable=false)
	private String link;
	@Column(name="language" , length=20 , insertable=true , updatable=false)
	private String language; 
	@Column(name="webmaster" , length=255 , insertable=true , updatable=false)
	private String webMaster; 
	@Column(name="copyright" , length=255 , insertable=true , updatable=false)
	private String copyright;
	@Column(name="pub_date" , length=55 , insertable=true , updatable=false)
	private String pubDate; 
	@Column(name="last_build_date" , length=55 , insertable=true , updatable=false)
	private String lastBuildDate; 

	public RssBody(){}
	
	

	public RssBody(String generator, String title, String link, String language, String webMaster, String copyright,
			String pubDate, String lastBuildDate) {
		super();
		this.generator = generator;
		this.title = title;
		this.link = link;
		this.language = language;
		this.webMaster = webMaster;
		this.copyright = copyright;
		this.pubDate = pubDate;
		this.lastBuildDate = lastBuildDate;
	}



	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	
}
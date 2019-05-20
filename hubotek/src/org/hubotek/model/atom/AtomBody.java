package org.hubotek.model.atom;

public class AtomBody {

	private String version = "1.0";
	private String id;
	private String title; 
	private String link; 
	private String rights;
	private String logo;
	private String updated;
	
	private Author author;
	
	public AtomBody(){}
	
	public AtomBody(String id, String title, String rights, String logo, String updated) {
		super();
		this.id = id;
		this.title = title;
		this.rights = rights;
		this.logo = logo;
		this.updated = updated;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}

package org.hubotek.model.atom;

public class AtomEntry {

	private String id;
	private String title;
	private String link; 
	private String content;
	private String updated;
	private String category;
	
	public AtomEntry(){}
	
	public AtomEntry(String id, String title, String link, String content, String updated , String category) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.content = content;
		this.updated = updated;
		this.category = category;
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
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdated() {
		return updated;
	}
	
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	} 

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

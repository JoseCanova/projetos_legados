package org.hubotek.google.blog;

import java.util.List;

public class ContentBlogPost extends BlogPost{

	private String content; 
	private List<?> items;
	private List<?> labels;
	
	public ContentBlogPost(){}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<?> getItems() {
		return items;
	}
	public void setItems(List<?> items) {
		this.items = items;
	}
	public List<?> getLabels() {
		return labels;
	}
	public void setLabels(List<?> labels) {
		this.labels = labels;
	}
}

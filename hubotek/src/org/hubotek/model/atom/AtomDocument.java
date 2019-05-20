package org.hubotek.model.atom;

import java.util.List;

import org.hubotek.model.HubDocument;

public class AtomDocument implements HubDocument{

	private AtomBody body;
	
	private List<AtomEntry> entries;
	
	public AtomDocument(){}
	
	public AtomBody getBody() {
		return body;
	}

	public void setBody(AtomBody body) {
		this.body = body;
	}

	public List<AtomEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<AtomEntry> entries) {
		this.entries = entries;
	}

}

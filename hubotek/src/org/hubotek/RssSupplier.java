package org.hubotek;

import java.util.function.Supplier;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.w3c.dom.Document;

//TODO: Change the name of the class.
public class RssSupplier implements Supplier<RssDocument> //extends HttpRequestAccessor<RssDocument>
{
	
	private Document sourceDocument;

	public RssSupplier (Document document)
	{ 
		this.sourceDocument = document;
	}
	
	public RssDocument get()
	{ 
		return new RssDocumentBuilder().withDocument(sourceDocument).build();
	}
	
}

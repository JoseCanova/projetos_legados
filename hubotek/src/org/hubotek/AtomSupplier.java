package org.hubotek;

import java.util.function.Supplier;

import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.w3c.dom.Document;

public class AtomSupplier  implements Supplier<AtomDocument> //extends HttpRequestAccessor<AtomDocument>
{
	private Document sourceDocument;
	
	public AtomSupplier(Document adomDocument )
	{ 
		this.sourceDocument = adomDocument;
	}

	@Override
	public AtomDocument get() {
		return new AtomDocumentBuilder().withDocument(sourceDocument).build();
	}

}
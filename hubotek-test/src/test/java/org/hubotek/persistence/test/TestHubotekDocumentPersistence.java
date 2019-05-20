package org.hubotek.persistence.test;

import java.util.List;
import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.document.HubotekDocument;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.test.BaseModelTransactionDelimiter;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestHubotekDocumentPersistence extends BaseModelTransactionDelimiter{

	@Inject @Named("hubotekAtomDocumentTransformer")
	Function<AtomDocument , HubotekDocument> hubotekAtomDocumentTransformer;// = a -> new HubotekAtomDocumentTransformer().apply(a);
	
	@Inject @Named("hubotekRssDocumentTransformer")
	Function<RssDocument , HubotekDocument> hubotekRssDocumentTransformer;// = r -> new HubotekRssDocumentTransformer().apply(r);
	
	@Inject
	BasePersistentConsumer basePersistentConsumer;
	
	@Test
	public void should_persist_hubotek_document()
	{ 
		retrieveAtomDocuments().stream().map(hubotekAtomDocumentTransformer).forEach(basePersistentConsumer);
		retrieveRssDocuments().stream().map(hubotekRssDocumentTransformer).forEach(basePersistentConsumer);
	}

	private List<AtomDocument> retrieveAtomDocuments() {
		String query = "Select ad from AtomDocument ad";
		return entityManager.createQuery(query , AtomDocument.class).getResultList();
	}

	private List<RssDocument> retrieveRssDocuments() {
		String query = "Select rss from RssDocument rss";
		return entityManager.createQuery(query , RssDocument.class).getResultList();
	}
	
}

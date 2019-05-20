package org.hubotek.persistence.test;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hubotek.model.lob.RssItemDescription;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.model.rss.RssItem;
import org.hubotek.test.BaseModelTransactionDelimiter;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRssItemPersistence extends BaseModelTransactionDelimiter{

	private static final String fileLocation = "C:/Java/git_repo/model/src/test/resources/xml/google_news_feed1.xml";
	
	@Test
	public void should_parse_rss_file() throws Exception
	{ 
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(generateDocumentFromSource(fileLocation)).build();
		assertNotNull(rssDocument);
		persistBase(rssDocument);
	}
	
	/**
	 * Not yet finished.
	 */
	@Test
	public void should_verify_record_integrity()
	{ 
		List<RssDocument> rssDocuments = retrieveRssRecords();
		RssDocument rssDocument = rssDocuments.get(0);
		List<RssItem> items = rssDocument.getRssItems();
		assertNotNull(items); 
		assertNotEquals(0, items.size());
		items.stream().forEach(i -> verifyRssDescription(i));
	}

	private void verifyRssDescription(RssItem item) {
		RssItemDescription itemDescription = item.getRssItemDescription();
		assertNotNull(itemDescription);
	}

	private List<RssDocument> retrieveRssRecords() {
		return  entityManager.createQuery("Select rd from RssDocument rd" , RssDocument.class).getResultList();
	}

}

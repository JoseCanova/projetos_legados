package org.hubotek.test;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.atom.AtomBase;
import org.hubotek.model.document.DocumentBase;
import org.hubotek.model.document.transformer.HubotekAtomDocumentTransformer;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.cse.GoogleSearchEngine;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.lob.AtomDocumentContent;
import org.hubotek.model.lob.GoogleResultItem;
import org.hubotek.model.lob.HubotekDocumentContent;
import org.hubotek.model.lob.RssItemDescription;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.search.GoogleSearchResult;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.persistence.test.TestRssItemPersistence;
import org.hubotek.util.DOMElementExtratorUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.nanotek.Base;

public abstract class BaseModelDeployer extends BaseTest{
	
	
	@Deployment
	public static JavaArchive createDeployment() {

		/*File[] files = Maven.resolver().loadPomFromFile("pom.xml")
				.importRuntimeDependencies().resolve().withTransitivity().asFile();*/

		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(HubotekAtomDocumentTransformer.class.getPackage())
				.addPackage(FeedUrl.class.getPackage())
				.addPackage(AtomDocumentContent.class.getPackage())
				.addPackage(AtomBase.class.getPackage())
				.addPackage(BaseModelPersistenceTestClass.class.getPackage())
				.addPackage(Base.class.getPackage())
				.addPackage(GoogleApiKey.class.getPackage())
				.addPackage(DOMElementExtratorUtil.class.getPackage())
				.addPackage(ElementEnum.class.getPackage())
				.addPackage(HubDocument.class.getPackage())
				.addPackage(RssDocument.class.getPackage())
				.addPackage(RssItemDescription.class.getPackage())
				.addPackage(NamedUrl.class.getPackage())
				.addPackage(GoogleSearchEngine.class.getPackage())
				.addPackage(GoogleBase.class.getPackage())
				.addPackage(NewsTopic.class.getPackage())
				.addPackage(GoogleResultItem.class.getPackage())
				.addPackage(GoogleSearchResult.class.getPackage())
				.addPackage(DocumentBase.class.getPackage())
				.addPackage(TestRssItemPersistence.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addPackage(HubotekDocumentContent.class.getPackage())
				.addAsResource("log4j.properties", "log4j.properties")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsResource("xml/google_news_feed1.xml" , "google_news_feed.xml" );
	}
	
}

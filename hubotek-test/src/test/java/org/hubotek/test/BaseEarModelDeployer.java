package org.hubotek.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.hubotek.ElementEnum;
import org.hubotek.model.HubDocument;
import org.hubotek.model.atom.AtomBase;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.google.cse.GoogleSearchEngine;
import org.hubotek.model.google.news.NewsTopic;
import org.hubotek.model.lob.AtomDocumentContent;
import org.hubotek.model.lob.GoogleResultItem;
import org.hubotek.model.lob.RssItemDescription;
import org.hubotek.model.project.api.GoogleApiKey;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.search.GoogleSearchResult;
import org.hubotek.model.url.NamedUrl;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.data.RssDocumentService;
import org.hubotek.service.ejb.HttpService;
import org.hubotek.service.ejb.HubDocumentService;
import org.hubotek.service.ejb.LocalService;
import org.hubotek.service.ejb.document.HubDocumentServiceImpl;
import org.hubotek.service.ejb.document.HubDocumentType;
import org.hubotek.service.ejb.http.HttpServiceImpl;
import org.hubotek.service.google.news.GoogleNewsService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestReference;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.orm.PersistenceService;
import org.hubotek.test.http.TestHttpRequestProcessor;
import org.hubotek.test.services.TestGoogleNewsService;
import org.hubotek.util.DOMElementExtratorUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.nanotek.Base;

public abstract class BaseEarModelDeployer {

	
	@Deployment
	public static Archive<?> createDeploymentPackage() throws IOException {

		File[] files = Maven.resolver().loadPomFromFile("src/test/resources/ear/test-pom.xml")
				.importRuntimeDependencies().resolve().withTransitivity().asFile();

		Stream<File> jarFilesStream = Arrays.asList(files).stream();//.forEach(s -> print(s.getName()))

		final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
				.setApplicationXML("ear/test-application.xml")
				.addAsModule(prepareEjbJarArchive())
				.addAsModule(prepareWarArchive());
//		retrieveModelJavaArchive().stream().forEach(mod -> ear.addAsModule(mod));
		jarFilesStream.forEach(jf -> ear.addAsLibraries(jf));
		return ear;
	}
	
	protected static List<JavaArchive> retrieveModelJavaArchive() 
	{ 
		return  Arrays.asList(Maven.resolver().resolve("org.hubotek:model:1.0").withoutTransitivity().as(JavaArchive.class));
	}
	
	protected static WebArchive prepareWarArchive() {
		return  ShrinkWrap.create(WebArchive.class, "test.war").addClass(BaseEarModelDeployer.class).addClass(TestHttpRequestProcessor.class).addClass(TestGoogleNewsService.class);
	}

	protected static JavaArchive prepareEjbJarArchive()
	{ 
		
		JavaArchive ejbJar = ShrinkWrap.create(JavaArchive.class, "ejb-jar.jar")
				.addPackage(GoogleNewsService.class.getPackage())
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
				.addPackage(DataBaseService.class.getPackage())
				.addPackage(RssDocumentService.class.getPackage())
				.addPackage(PersistenceService.class.getPackage())
				.addPackage(HttpServiceImpl.class.getPackage())
				.addClass(HubDocumentService.class)
				.addClass(HubDocumentServiceImpl.class)
				.addClass(LocalService.class)
				.addClass(HttpService.class)
				.addClass(HttpServiceImpl.class)
				.addClass(HttpRequestProcessor.class)
				.addClass(HubDocumentType.class)
				.addClass(RequestType.class)
				.addClass(RequestReference.class)
				.addClass(HttpRequestParameters.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("log4j.properties", "log4j.properties");
		
		return ejbJar;
	}

}

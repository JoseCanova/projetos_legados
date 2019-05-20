package org.hubotek.google.news;

import java.util.concurrent.Future;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.service.http.HttpRequestAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;


//Still on design...
@Service
public class GoogleNewsFeed  {
	
	@Autowired
	private HttpRequestAccessor httpRequestAcessor;
	
	public GoogleNewsFeed(){ 
	}

	public HttpRequestAccessor getHttpRequestAcessor() {
		return httpRequestAcessor;
	}

	public void setHttpRequestAcessor(HttpRequestAccessor httpRequestAcessor) {
		this.httpRequestAcessor = httpRequestAcessor;
	}

	@Async
	public Future<RssDocument> requestNewsFeed(String url)
	{ 
		String baseUrl = url !=null ? url : "https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss";
		Document webDocument = httpRequestAcessor.doRequest(baseUrl , null);
		RssDocument rssDocument = new RssDocumentBuilder().withDocument(webDocument).build();
		return new AsyncResult<RssDocument>(rssDocument);
	}

}

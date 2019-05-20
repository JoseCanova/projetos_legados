package org.hubotek.test.http;

import javax.inject.Inject;

import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestType;
import org.hubotek.test.BaseEarModelDeployer;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestHttpRequestProcessor extends BaseEarModelDeployer{

	@Inject
	private HttpRequestProcessor requestProcessor;
	
	@Test
	public void test_http_call()
	{ 
		String response = requestProcessor.processRequest("https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss", new HttpRequestParameters() , RequestType.GET);
		Assert.assertNotNull(response);
		System.err.println(response);
	}
}

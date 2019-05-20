package org.hubotek.tests.google.news;

import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.hubotek.google.news.GoogleNewsUrlBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/org/hubotek/tests/google/news/hubotek-servlet.xml")
public class GoogleNewsUrlBuilderTest extends TestCase {

	private static final Logger logger = Logger.getLogger(GoogleNewsUrlBuilderTest.class);
	
	@Test
	public void testSystemOutput()
	{ 
		logger.debug("Test Done");
	}
	
	@Test
	public void testTopic()
	{ 
		GoogleNewsUrlBuilder ub = new  GoogleNewsUrlBuilder();
		logger.debug("Building Query for Google on technology: "+ ub.withTopic("technology").build());
		assertEquals("https://news.google.com/news?topic=technology", ub.build());
	
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void testQuery()
	{ 
		String query = new  GoogleNewsUrlBuilder().withQuery( URLEncoder.encode("this is a query encode")).build();
		assertEquals("https://news.google.com/news?q=this+is+a+query+encode", query);
		logger.debug(query);
	}
	
	@Test
	public void testOutput()
	{ 
		String output = new GoogleNewsUrlBuilder().withOutput("atom").build();
		assertEquals("https://news.google.com/news?output=atom", output);
		logger.debug(output);
	}
	
	@Test
	public void testTopicOutput()
	{ 
		String output = new GoogleNewsUrlBuilder().withTopic("tc").withOutput("rss").build();
		logger.debug("output="+ output);
		assertTrue(output.contains("output=rss&topic=tc")||output.contains("topic=tc&output=rss"));
	}
	
	@Test
	public void testTopicOutputQuery()
	{ 
		String output = new GoogleNewsUrlBuilder().withOutput("rss").withQuery("spring+framework").build();
		assertTrue(output.contains("q=spring+framework")&&output.contains("output=rss"));
		logger.debug("output="+ output);
	}
}

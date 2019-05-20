package org.hubotek.tests.parser;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.hubotek.google.news.feed.DomParser;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.hubotek.service.database.GoogleCseDAO;
import org.hubotek.tests.TestException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/org/hubotek/tests/controller/google/hubotek-servlet.xml")
public class GoogleAtomParser {

	DocumentBuilderFactory documentBuilderFactory;
	
	@Autowired
	private DomParser feedParser;
	
	@Autowired
	GoogleCseDAO cseDAO;
	
	@Before
	public void AtomParser()
	{
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
	}
	
	@Test
	public void testAtomParser()
	{ 
		try {
			FileInputStream fis = new FileInputStream(new File("C:\\Java\\hubotek\\hubotek\\war\\news_atom.xml"));
			Document atomDocument = feedParser.parseInput(new InputSource(fis));
//			TODO: remove the parser from the request accessor.
			AtomDocumentBuilder	db = new AtomDocumentBuilder();		
			AtomDocument ad =  db.withDocument(atomDocument).build();
			cseDAO.findById("1010");
			System.out.println(ad.toString());
		} catch (Exception e) {
			throw new TestException(e);
		}
		
	}
	
}

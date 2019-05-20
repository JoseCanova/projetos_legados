package org.hubotek.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.hubotek.util.DomParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import junit.framework.TestCase;

public abstract class BaseTest extends TestCase{

	public Document generateDocumentFromSource(String fileLocation) throws Exception
	{ 
		InputStream is =  new FileInputStream(new File(fileLocation));
		DomParser parser = new DomParser();
		return parser.parseInput(new InputSource(is));
	}
	
}

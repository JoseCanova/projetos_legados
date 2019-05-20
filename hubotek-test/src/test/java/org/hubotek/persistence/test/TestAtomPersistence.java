package org.hubotek.persistence.test;

import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.hubotek.test.BaseModelTransactionDelimiter;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAtomPersistence extends BaseModelTransactionDelimiter{

	private static final String fileLocation = "C:/Java/git_repo/model/src/test/resources/xml/news_atom.xml";
	
	@Test
	public void should_parse_atom_file() throws Exception
	{ 
		AtomDocument atomDocument = new AtomDocumentBuilder().withDocument(generateDocumentFromSource(fileLocation)).build();
		assertNotNull(atomDocument);
		persistBase(atomDocument);
	}
	
}

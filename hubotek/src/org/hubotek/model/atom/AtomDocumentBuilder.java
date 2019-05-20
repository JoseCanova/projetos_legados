package org.hubotek.model.atom;

import java.util.ArrayList;
import java.util.List;

import org.hubotek.Builder;
import org.hubotek.HubotekException;
import org.hubotek.google.xpath.DOMElementExtratorUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Construct the object that represent a Feed from an Atom Source.
 * 
 * @author user
 *
 */
public class AtomDocumentBuilder extends DOMElementExtratorUtil<AtomDocumentElementsEnum> implements Builder<AtomDocument>{

	private AtomDocument atomDocument; 

	final String nameExpression = "/feed/author/name";
	final String emailExpression = "/feed/author/email";
	final String entryParentExpression = "/feed/entry";
	
	public AtomDocumentBuilder(){ 
		prepare();
	}

	public void prepare()
	{ 
		atomDocument = new AtomDocument();
	}

	public AtomDocumentBuilder withDocument (Document document){ 
		if (document !=null)
		{ 
			withBody(document);
			withEntries(document);
		}
		return this;
	}
	
	public AtomDocument build()
	{ 
		return atomDocument;
	}
	
	
	private void withAuthor(Document document , AtomBody atomBody) {
		Node nameNode = getNodeWithXPath(nameExpression, document);
		String authorName = nameNode.getTextContent();
		Node emailNode = getNodeWithXPath(emailExpression, document);
		String authorEmail = emailNode.getTextContent();
		Author author = new Author(authorName , authorEmail);
		atomBody.setAuthor(author);
	}

	private void withEntries(Document document) {

			try{ 
				List<AtomEntry> feedEntries = new ArrayList<AtomEntry>(); 
				NodeList entryNodes = getNodeListWithXPath(entryParentExpression , document);
				if (entryNodes!=null)
					for (int i = 0 ; i < entryNodes.getLength();i++)
					{ 
						int nodeposition = i+1;
						String entryChildBaseExpression = new StringBuilder().append(entryParentExpression).append("[").append(nodeposition).append("]").toString();
						
						String id = getChildNodeTextValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.ID);
						String title = getChildNodeTextValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.TITLE);
						String category = getChildNodeTextValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.CATEGORY);
						String content = getChildNodeTextValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.CONTENT);
						String updated = getChildNodeTextValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.UPDATED);
						
						
						StringBuilder linkExpression = new StringBuilder(entryChildBaseExpression).append("/").append(AtomDocumentElementsEnum.LINK.valueOf());
						NodeList linkNodeList = getNodeListWithXPath(linkExpression.toString(),  document);
						String link = "";
						if (linkNodeList.getLength() >0){
							link = getTextAttribute(linkNodeList.item(0) , "href");
						}
						AtomEntry feedEntry = new  AtomEntry(id, title, link, content, updated, category);
						feedEntries.add(feedEntry);					
					}
				atomDocument.setEntries(feedEntries);
			}catch (Exception e){ 
				throw new HubotekException(e);
			}
	}

	@SuppressWarnings("unused")
	private void withBody(Document document) 
	{ 
		String idXPath = "/feed/id"; 
		String titleXPath = "/feed/title";
		//TODO:
		String linkXPath = "/feed/link";
		String rightsXPath = "/feed/rights";
		String updatedXPath = "/feed/updated";
		String logoXPath = "/feed/logo";
		
		String id = getTextContent(getNodeWithXPath(idXPath, document));
		String title = getTextContent(getNodeWithXPath(titleXPath, document));
		String rights = getTextContent(getNodeWithXPath(rightsXPath, document));
		String updated = getTextContent(getNodeWithXPath(updatedXPath, document));
		String logo = getTextContent(getNodeWithXPath(logoXPath, document));
		
		AtomBody atomBody = new AtomBody(id, title, rights, logo, updated);
		
		withAuthor(document , atomBody);		
		atomDocument.setBody(atomBody);
	}

}

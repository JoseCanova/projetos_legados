package org.hubotek.google.xpath;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hubotek.ElementEnum;
import org.hubotek.HubotekException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMElementExtratorUtil<T extends ElementEnum<String>> {

	private XPathFactory xpathFactory;
	
	
	public DOMElementExtratorUtil(){
		prepare();
	}
	
	private void prepare() {
		xpathFactory = XPathFactory.newInstance();
	}

	protected String getFromDocument(Document document , T elementEnum) {
		String value = "";
		NodeList nodeList = document.getElementsByTagName(elementEnum.valueOf());
		Node node = nodeList.item(0);
		if (node !=null)
			value = node.getTextContent();
		return value;
	}
	
	protected NodeList getNodeListWithXPath(String nodeExpression , Document document)
	{ 
		NodeList nodeList = null;
		try {
		XPath xPath = createXPathFromFactory();
		nodeList  = (NodeList) xPath.compile(nodeExpression).evaluate(document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return nodeList;
	}
	
	protected String getTextAttribute(Node node, String attr) {
		return (node.hasAttributes() == true) ? node.getAttributes().getNamedItem(attr).getTextContent():"";
	}
	
	protected Node getNodeWithXPath(String nodeExpression , Document document)
	{ 
		Node node = null;
		try {
				XPath xPath = createXPathFromFactory();
				node = (Node) xPath.compile(nodeExpression).evaluate(document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return node;
	}
	
	protected <T extends ElementEnum<String>> String getChildNodeTextValueWithXPath(Document  document , String parentExpression , T elementEnum) throws XPathExpressionException{
		XPath xPath =  XPathFactory.newInstance().newXPath();
		StringBuilder subExpression = new StringBuilder(parentExpression).append("/").append(elementEnum.valueOf());
		Node idNode = (Node)xPath.compile(subExpression.toString()).evaluate(document, XPathConstants.NODE);
		return getTextContent(idNode);
	}
	
	protected String getTextContent(Node node) {
		return (node!=null && node.hasChildNodes()) ? node.getTextContent() : "";
	}
	
	private XPath createXPathFromFactory() {
		return  xpathFactory.newXPath();
	}
}

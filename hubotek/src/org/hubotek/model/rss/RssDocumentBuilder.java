package org.hubotek.model.rss;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.hubotek.Builder;
import org.hubotek.HubotekException;
import org.hubotek.google.xpath.DOMElementExtratorUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Construct the object that represent a RSS Feed from Google News.
 * 
 * @author user
 *
 */
public class RssDocumentBuilder extends DOMElementExtratorUtil<RssDocumentElementsEnum> implements Builder<RssDocument>{

	private RssDocument rssDocument; 
	private static final Logger logger = Logger.getLogger(RssDocumentBuilder.class);

	public RssDocumentBuilder(){
		prepare();
	}

	public void prepare()
	{ 
		rssDocument = new RssDocument();
	}

	public RssDocumentBuilder  withDocument (@NotNull Document document) throws HubotekException
	{ 
		logger.debug("Starting document tranformation");
		withBody(document);
		withImage(document);
		withItems(document);
		logger.debug("Finished Object transformation");
		return this;
	}

	public RssDocument build()
	{ 
		logger.debug("returning document");
		return rssDocument;
	}

	private RssDocumentBuilder withItems(Document document)  {
		List<RssItem> feedItems = new ArrayList<RssItem>(); 
		String itemParentExpression = "/rss/channel/item";
		NodeList itemNodes = getNodeListWithXPath(itemParentExpression , document);
		try{ 		
			if (itemNodes!=null)
				for (int i = 0 ; i < itemNodes.getLength();i++)
				{ 
					int nodeposition = i+1;
					StringBuilder itemChildBaseExpression = new StringBuilder().append(itemParentExpression).append("[").append(nodeposition).append("]");
					String title = getChildNodeTextValueWithXPath(document , itemChildBaseExpression.toString() , RssDocumentElementsEnum.TITLE);
					String category =  getChildNodeTextValueWithXPath(document , itemChildBaseExpression.toString() , RssDocumentElementsEnum.CATEGORY);
					StringBuilder linkExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.LINK.valueOf());
					NodeList linkNodeList = getNodeListWithXPath(linkExpression.toString(),  document);
					String link = "";
					if (linkNodeList.getLength() >0){
						link = getTextContent(linkNodeList.item(0));
					}
					String guid = getChildNodeTextValueWithXPath(document , itemChildBaseExpression.toString() , RssDocumentElementsEnum.GUID);
					String pubDate = getChildNodeTextValueWithXPath(document , itemChildBaseExpression.toString() , RssDocumentElementsEnum.PUBDATE);
					String description = getChildNodeTextValueWithXPath(document , itemChildBaseExpression.toString() , RssDocumentElementsEnum.DESCRIPTION);
					RssItem rssItem = new RssItem (title , link , guid,category, pubDate , description);
					feedItems.add(rssItem);					
				}
			rssDocument.setRssItems(feedItems);
		}catch (XPathExpressionException e){ 
			throw  new HubotekException(e);
		}
		return this;
	}

	private void withImage(Document document)  {

		try { 

			String imageParentExpression = "/rss/channel/image";
			NodeList imageNodes = getNodeListWithXPath(imageParentExpression , document);

			if (imageNodes.getLength() > 0){

				int nodeposition = 1;
				StringBuilder itemChildBaseExpression = new StringBuilder().append(imageParentExpression).append("[").append(nodeposition).append("]");

				String imageTitle = getChildNodeTextValueWithXPath(document , itemChildBaseExpression.toString() , RssDocumentElementsEnum.TITLE);


				StringBuilder imageUrlExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.URL.valueOf());
				Node imageUrlNode = getNodeWithXPath(imageUrlExpression.toString() , document); 
				String imageUrl = imageUrlNode.getTextContent();

				StringBuilder imageLinkExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.LINK.valueOf());
				Node imageLinkNode = getNodeWithXPath(imageLinkExpression.toString() , document); 
				String imageLink = imageLinkNode.getTextContent();

				RssImage rssImage  = new RssImage(imageTitle , imageUrl , imageLink);
				rssDocument.setRssImage(rssImage);
			}
		}catch (XPathExpressionException e){ 
			throw  new HubotekException(e);
		}
	}


	private RssDocumentBuilder withBody(Document document)
	{ 
		String generator = getFromDocument(document , RssDocumentElementsEnum.GENERATOR);
		String title = getFromDocument(document , RssDocumentElementsEnum.TITLE);
		String link = getFromDocument(document , RssDocumentElementsEnum.LINK);
		String language = getFromDocument(document , RssDocumentElementsEnum.LANGUAGE);
		String webMaster = getFromDocument(document, RssDocumentElementsEnum.WEBMASTER);
		String copyRight = getFromDocument(document, RssDocumentElementsEnum.COPYRIGHT);
		String pubDate = getFromDocument(document , RssDocumentElementsEnum.PUBDATE);
		String lastBuildDate = getFromDocument(document , RssDocumentElementsEnum.LASTBUILDDATE);

		RssBody rssBody = new RssBody(generator,  title,  link,  language,  webMaster,  copyRight,
				pubDate,  lastBuildDate);
		rssDocument.setRssBody(rssBody);
		return this;
	}

}

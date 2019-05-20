package org.hubotek.model.atom;

import org.hubotek.ElementEnum;

/**
 *  <id>tag:news.google.com,2016-09-09:/1/us/en/1473446574600</id>
	<title>Top Stories - Google News</title>
	<link rel="self" type="application/atom+xml"
		href="http://news.google.com/news?hl=en&amp;pz=1&amp;ned=us&amp;output=atom"></link>
	<link rel="alternate" type="text/html"
		href="http://news.google.com/news?hl=en&amp;pz=1&amp;ned=us"></link>
	<author>
		<name>Google Inc.</name>
		<email>news-feedback@google.com</email>
	</author>
	<rights>&amp;copy;2016 Google</rights>
	<updated>2016-09-09T18:42:54Z</updated>
	<logo>https://ssl.gstatic.com/news-static/img/logo/en_us/news.gif
	</logo>
	<entry>
		<id>tag:news.google.com,2005:cluster=52779205063589</id>
		<title type="html">North Korea claims successful test of nuclear
			warhead - CNN</title>
		<category term="Top Stories"></category>
		<updated>2016-09-09T15:30:57Z</updated>
		<link rel="alternate" type="text/html"
			href="http://news.google.com/news/url?sa=t&amp;fd=R&amp;ct2=us&amp;usg=AFQjCNF37YgphoyqZ-KMoi097tC_w08Dcg&amp;clid=c3a7d30bb8a4878e06b80cf16b898331&amp;cid=52779205063589&amp;ei=rgLTV7CQH5HE3QH94LfICQ&amp;url=http://www.cnn.com/2016/09/08/asia/north-korea-seismic-activity/"
			hreflang="en"></link>
		<content type="html">
		</content>
	</entry>
 * @author user
 *
 */
public enum AtomDocumentElementsEnum implements ElementEnum<String>{
	
	ID ("ID"),
	TITLE ("title"),
	LINK ("link"), 
	AUTHOR("author"),
	NAME("name"),
	EMAIL ("email"),
	ENTRY("entry"),
	RIGHTS("rigths"),
	UPDATED("updated"),
	CATEGORY("category"),
	CONTENT("content"),
	VERSION("version"),
	DESCRIPTION("description"),
	LANGUAGE("language");
	
	private String value;
	
	private AtomDocumentElementsEnum(String elementName)
	{ 
		this.value = elementName;
	}

	@Override
	public String valueOf() {
		return value;
	}
}

package org.hubotek.google.news;

/**
 * Google News Search parameters (The Missing Manual)
There is a severe lack of documentation of Google News Search’s query parameters. Here is the most comprehensive list I am aware of. A number of these overlap with Google Search’s query parameters. I exclude any Google Search parameters that don’t make sense in the context of Google News Search. These parameters are primarily of interest to anyone querying Google News for articles using its RSS and Atom output formats.
Search
The following query parameters control Google’s interpretation of keywords. Although as_epqmay be attractive for some use cases, it breaks sorting by date (scoring=n) when output is “rss” or “atom”, so stick with q for consistent sorting. Update: It seems the as_* parameters don’t work when output is “rss” or “atom”.
q=TERMS retrieve results with all of the terms. Alias: as_q
as_epq=TERMS retrieve results with the exact phrase
as_oq=TERMS retrieve results with at least one of the words
as_eq=TERMS retrieve results without the terms
as_qdr=dTERMS retrieve results within specified number of days example &as_qdr=d1 results within one day
as_qdr=wTERMS retrieve results within specified number of weeks example &as_qdr=w1 results within one week
as_qdr=yTERMS retrieve results within specified number of years example &as_qdr=y1 results within one year
as_occt=SECTION retrieve results where my terms occur…
any anywhere in the article
title in the headline of the article (same as using “allintitle:” in q)
body in the body of the article (same as using “allintext:” in q)
url in the URL of the article (same as using “allinurl:” in q)
Filter
The following query parameters filter results by Google News edition, topic, location, date, news source or author.
ned=EDITION limits results to a specific edition. Possible values: editions
topic=TOPIC limits results to a specific topic. Possible values: topics
geo=LOCATION limits results to a specific location
detect_metro_area determines location based on IP
a city, state, country, or US zip code
as_drrb=q retrieves articles added by Google News…
as_qdr=a anytime
as_qdr=h last hour
as_qdr=d last day
as_qdr=w past week
as_qdr=m past month
as_qdr=y past year
as_drrb=b retrieves articles added by Google News between…
as_minm=NUM minimum month. Possible values: [1, 12]
as_mind=NUM minimum day. Possible values: [1, 31]
as_maxm=NUM maximum month. Possible values: [1, 12]
as_maxd=NUM maximum day. Possible values: [1, 31]
as_nsrc=SOURCE limits results to a specific news source (same as using “source:” in q)
as_nloc=LOCATION limits results to news sources from a specific location (same as using “location:” in q)
as_author limits results to a specific author (same as using “author:” in q)
The as_ddrb family of parameters is occasionally set using the tbs parameter when using the web interface. You do not need to learn the tbs syntax. Note that as_nloc and geo are not synonymous.
Boost
I’m not confident that these parameters do anything when output is “rss” or “atom”, but here they are for completeness.
gl=COUNTRY boosts search results from a specific country of origin. Possible values:country codes
gll=LATITUDE,LONGITUDE boosts search results near that point. Latitude and longitude must be integer microdegrees. In otherwords, multiply each number by a million and round to the nearest integer.
gr=REGION boosts search results from a specific region. Possible values: province codes
gm=METRO boosts search results from a specific metropolitan area. Possible values: metro codes
gpc=ZIPCODE boosts search results from a specific zip code. gl must be “us”.
gcs=CITY boosts search results from a specific city. Possible values: city names in theUnited States and worldwide
Order
scoring=ORDER sorts search results. Default: “r”. Alias: “as_scoring”
"r" by relevance
"n" by date (newest first)
"d" by date (newest first) with duplicates
"o" by date (oldest first)
Paginate
num=NUM retrieves NUM results. Default: 10. Possible values: if q present [1,100], otherwise [1, 30]
start=OFFSET retrieves results starting from OFFSET. NUM plus OFFSET must be less than 1000, otherwise you will get zero results. Ignored if output is “rss” or “atom”. Default: 0. Requires q.
Output
output=FORMAT sets the output format
rss retrieves RSS feed
atom retrieves Atom feed
hdlOnly=1 displays headlines only
qsid=ID used in combination with cf=q. Update: This feature has been removed.
In older versions of Google News, it was possible to change the output of the web interface using a cf parameters. It no longer seems to work, but it is here for completeness. Note that when output is set to “rss” or “atom”, this parameter is in fact ignored.
cf=CODE
all retrieve any content
q retrieve only quotes. Requires qsid. Update: This feature has been removed.
i retrieve only images
b retrieve only blogs
Google tracking
Google uses parameters to track how users are using the web interface, which may include aq,authuser, btnmeta_news_search, edchanged, client, rls, oi, oq, resnum, sa, source,sourceid, swrnum, tab. You don’t need to worry about these, unless you want to bias Google’s internal statistics on user behavior.
Google Search
If using the web interface, performing a keyword search from Google News will redirect you to a Google Search page. The tbm=nws query parameter informs Google to display news results only.
Undocumented
I haven’t yet figured out what these do, but their impact seems minimal. If you have a clue, please mention it in the comments!
pz is usually set to 1. Default: 1. Possible values: [0, 1]
ict Possible values: “ln”, “itn0”, “tnv0”
csid
Deprecated
The following parameters work only on the deprecated Google News Search API.
v=1.0 sets the API version. Possible values: “1.0”
rsz=SIZE sets results size
small retrieves four results
large retrieves eight results
userip sets user’s IP as an abuse counter-mesure
callback runs JavaScript callback
context sets callback context
key sets API key
Examples:
To create RSS for US top stories:
http://news.google.com/news?pz=1&cf=all&ned=us&hl=en&output=rss
To create RSS for Topic: Technology:
https://news.google.com/news/section?pz=1&cf=all&topic=tc
Or
https://news.google.com/news/section?pz=1&cf=all&ned=us&hl=en&topicsid=en_us:tc&ict=tnv3
To create RSS for keyword search (google) in Topic: Technology:
https://news.google.com/news/section?pz=1&cf=all&ned=us&hl=en&q=Google&topicsid=en_us:tc&ict=tnv3
To create RSS for keyword search (AT&T) in Topic: Technology:
https://news.google.com/news/section?pz=1&cf=all&ned=us&hl=en&q=AT%26T&topicsid=en_us:tc&ict=tnv5
To create RSS for keyword (google) and sort output by newest:
http://news.google.com/news?pz=1&cf=all&ned=us&hl=en&scoring=n&q=google&output=rss
 * @author user
 *
 */

public enum GoogleNewsUrlParametersEnum {
	
	CODE("cf"), //limited ti q(quotes),i(images),b(blogs)
	QSID("qsid"),//required by CF (case CF then required QSID
	HL("hl"), //en, pt, ... etc... need to check the language code on News Forum.
	PZ("pz"), //limited to 0-1
	NED("ned"),
	QUERY("q"),
	NUM("num"),
	OUTPUT("output"),
	COUNTRY("gl"),
	TOPIC("topic"),
	LATITUDE_LONGITUDE("gll"),
	REGION("gr"),
	METRO("gm"),
	ZIPCODE("gpc"),
	CITY("gcs"),
	RSZ("rsz"),//result set size.
	SCORING("scoring"),//limited to r,n,d,o
	EXACT_PHRASE("as_epq");
	
	private String urlParameter;

	private GoogleNewsUrlParametersEnum(String urlParameter){
		this.urlParameter = urlParameter;
	}
	
	public String getUrlParameter()
	{ 
		return urlParameter;
	}
	
}
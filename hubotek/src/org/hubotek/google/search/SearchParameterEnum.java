package org.hubotek.google.search;

import org.hubotek.ElementEnum;

/**
 * 
 * 
 * Parameter name	Value	Description
Required parameters
q	string	The search expression.
Optional parameters
c2coff	string	Enables or disables Simplified and Traditional Chinese Search. 
The default value for this parameter is 0 (zero), meaning that the feature is enabled. Supported values are:
1: Disabled
0: Enabled (default)
cr	string	Restricts search results to documents originating in a particular country. 
You may use Boolean operators in the cr parameter's value.
Google Search determines the country of a document by analyzing:
the top-level domain (TLD) of the document's URL
the geographic location of the Web server's IP address
See the Country Parameter Values page for a list of valid values for this parameter.
cref	string	The URL of a linked custom search engine specification to use for this request. 
Does not apply for Google Site Search
If both cx and cref are specified, the cx value is used
cx	string	The custom search engine ID to use for this request.
If both cx and cref are specified, the cx value is used.
dateRestrict	string	Restricts results to URLs based on date. Supported values include:
d[number]: requests results from the specified number of past days.
w[number]: requests results from the specified number of past weeks.
m[number]: requests results from the specified number of past months.
y[number]: requests results from the specified number of past years.
exactTerms	string	Identifies a phrase that all documents in the search results must contain.
excludeTerms	string	Identifies a word or phrase that should not appear in any documents in the search results.
fileType	string	Restricts results to files of a specified extension. A list of file types indexable by Google can be found in Webmaster Tools Help Center.
filter	string	Controls turning on or off the duplicate content filter.
See Automatic Filtering for more information about Google's search results filters. Note that host crowding filtering applies only to multi-site searches.
By default, Google applies filtering to all search results to improve the quality of those results.


Acceptable values are:
"0": Turns off duplicate content filter.
"1": Turns on duplicate content filter.
gl	string	Geolocation of end user. 
The gl parameter value is a two-letter country code. The gl parameter boosts search results whose country of origin matches the parameter value. See the Country Codes page for a list of valid values.
Specifying a gl parameter value should lead to more relevant results. This is particularly true for international customers and, even more specifically, for customers in English- speaking countries other than the United States.
googlehost	string	The local Google domain (for example, google.com, google.de, or google.fr) to use to perform the search. 
highRange	string	
Specifies the ending value for a search range.
Use lowRange and highRange to append an inclusive search range of lowRange...highRange  to the query.
hl	string	Sets the user interface language. 
Explicitly setting this parameter improves the performance and the quality of your search results.
See the Interface Languages section of Internationalizing Queries and Results Presentation for more information, and Supported Interface Languages for a list of supported languages.
hq	string	Appends the specified query terms to the query, as if they were combined with a logical AND operator.
imgColorType	string	Returns black and white, grayscale, or color images: mono, gray, and color. 

Acceptable values are:
"color": color
"gray": gray
"mono": mono
imgDominantColor	string	Returns images of a specific dominant color. 

Acceptable values are:
"black": black
"blue": blue
"brown": brown
"gray": gray
"green": green
"pink": pink
"purple": purple
"teal": teal
"white": white
"yellow": yellow
imgSize	string	Returns images of a specified size. 

Acceptable values are:
"huge": huge
"icon": icon
"large": large
"medium": medium
"small": small
"xlarge": xlarge
"xxlarge": xxlarge
imgType	string	Returns images of a type. 

Acceptable values are:
"clipart": clipart
"face": face
"lineart": lineart
"news": news
"photo": photo
linkSite	string	Specifies that all search results should contain a link to a particular URL
lowRange	string	Specifies the starting value for a search range. 
Use lowRange and highRange to append an inclusive search range of lowRange...highRange to the query.
num	unsigned integer	Number of search results to return.
Valid values are integers between 1 and 10, inclusive.
orTerms	string	Provides additional search terms to check for in a document, where each document in the search results must contain at least one of the additional search terms.
relatedSite	string	Specifies that all search results should be pages that are related to the specified URL.
rights	string	Filters based on licensing. Supported values include: cc_publicdomain, cc_attribute, cc_sharealike, cc_noncommercial, cc_nonderived, and combinations of these.
safe	string	Search safety level. 

Acceptable values are:
"high": Enables highest level of SafeSearch filtering.
"medium": Enables moderate SafeSearch filtering.
"off": Disables SafeSearch filtering. (default)
searchType	string	Specifies the search type: image.  If unspecified, results are limited to webpages. 

Acceptable values are:
"image": custom image search.
siteSearch	string	Specifies all search results should be pages from a given site.
siteSearchFilter	string	Controls whether to include or exclude results from the site named in the siteSearch parameter. 

Acceptable values are:
"e": exclude
"i": include
sort	string	The sort expression to apply to the results.
start	unsigned integer	
 * 
 * @author user
 *
 */
public enum SearchParameterEnum implements ElementEnum<String>{

	QUERY("q"),
	C2COFF("c2coff"),
	COUNTRY("cr"),
	CX_ID("cx"),
	USER_LANGUAGE("hl"),
	GEOLOCATION("gl"),
	EXACT_TERMS("exactTerms"),
	EXCLUDE_TERMS("excludeTerms"),
	FILE_TYPE("fileType"),
	IMAGE_TYPE("imgType"),
	DATE_RESTRICT("dateRestrict"),
	GOOGLE_HOST("googlehost"),
	IMAGE_SIZE("imgSize"),
	HQ("hq"), // need to check on future this parameter
	IMAGE_COLOR_TYPE("imgColorType"),
	LOW_RANGE("lowRange"),
	HIGH_RANGE("highRange"),
	SEARCH_TYPE("searchType"),
	SITE_SEARCH("siteSearch"),
	IMAGE_DOMINANT_COLOR("imgDominantColor"),
	SITE_SEARCH_FILTER("siteSearchFilter"),
	SORT("sort"),
	KEY("key"),
	OUTPUT("alt");
	
	private String value;
	
	private SearchParameterEnum(String value)
	{ 
		this.value = value;
	}
	
	@Override
	public String valueOf() {
		// TODO Auto-generated method stub
		return value;
	}
	
}

package org.hubotek.google.news;

import org.springframework.beans.factory.annotation.Autowired;


public class FeedParserProvider {

	@Autowired 
	protected GoogleNewsFeed googleNewsFeed;

	public GoogleNewsFeed getGoogleNewsFeed() {
		return googleNewsFeed;
	}

	public void setGoogleNewsFeed(GoogleNewsFeed googleNewsFeed) {
		this.googleNewsFeed = googleNewsFeed;
	}
	
	
}

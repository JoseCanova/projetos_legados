package org.hubotek.google.blog;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public final class BlogUrlBase {
	
	/*
	 * userid 2045640289942179582
	 * https://www.googleapis.com/blogger/v3/users/g108283864565495942757/blogs
	 * https://www.googleapis.com/blogger/v3/blogs/2045640289942179582
	 */
	private static final Map<String,String> bloggerUrlCollection = new HashMap<String,String>();
	
	static { 
		bloggerUrlCollection.put("userId", "https://www.googleapis.com/blogger/v3/users/{0}");
		bloggerUrlCollection.put("self" , "https://www.googleapis.com/blogger/v3/users/self");
		bloggerUrlCollection.put("userId" ,  "https://www.googleapis.com/blogger/v3/users/{0}/blogs");
		bloggerUrlCollection.put("selfBlogs" , "https://www.googleapis.com/blogger/v3/users/self/blogs");
		bloggerUrlCollection.put("blogId" , "https://www.googleapis.com/blogger/v3/blogs/{0}");
		bloggerUrlCollection.put("byUrl" , "https://www.googleapis.com/blogger/v3/blogs/byurl");
		bloggerUrlCollection.put("posts" , "https://www.googleapis.com/blogger/v3/blogs/{0}/posts");
		bloggerUrlCollection.put("postsByPath" , "https://www.googleapis.com/blogger/v3/blogs/{0}/posts/bypath");
		bloggerUrlCollection.put("postsSearch" , "https://www.googleapis.com/blogger/v3/blogs/{0}/posts/search");
		bloggerUrlCollection.put("postsById"  , "https://www.googleapis.com/blogger/v3/blogs/{0}/posts/{1}");
		bloggerUrlCollection.put("postComments" , "https://www.googleapis.com/blogger/v3/blogs/{0}/posts/{1}/comments");
		bloggerUrlCollection.put("commentsById" , "https://www.googleapis.com/blogger/v3/blogs/{0}/posts/{1}/comments/{2}");
		bloggerUrlCollection.put("blogPages" , "https://www.googleapis.com/blogger/v3/blogs/blogId/pages");
		bloggerUrlCollection.put("pagesById" , "https://www.googleapis.com/blogger/v3/blogs/blogId/pages/{0}");
	}
	
	public static String getBlogUrl(String key , Object... arguments){ 
		return MessageFormat.format(bloggerUrlCollection.get(key), arguments);
	}
}

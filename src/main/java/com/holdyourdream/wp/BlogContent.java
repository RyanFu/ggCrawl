package com.holdyourdream.wp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BlogContent {
	
	@SuppressWarnings("rawtypes")
	public Hashtable post=new Hashtable();

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BlogContent(String post_title,String post_content,String categories_name){
		List<String> categories = new ArrayList<String>();
		  categories.add(categories_name);
		  Hashtable taxonomies=new Hashtable();
		  taxonomies.put("category", categories);
		  Hashtable post1 = new Hashtable();
	      post1.put("post_title", post_title);
	      post1.put("post_content",post_content);
	      post1.put("post_type", "post");
	      post1.put("post_status", "publish");
	      post1.put("comment_status", "open");
	      post1.put("ping_status", "open");
	      post1.put("terms_names", taxonomies);
	      this.post=post1;
	}

}

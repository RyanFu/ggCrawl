package com.holdyourdream.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;


public class PostExample {

	public static void main(String[] args) throws Exception {
    // the url of your xmlrpc.php, typically
    // of the form http://your.domain.here/wordpress/xmlrpc.php
    String xmlRpcUrl = "http://www.holdyourdream.com/a/xmlrpc.php";
    // this key is not used in my wordpress version
    //String apiKey = "";
    String userName = "admin";
    String password = "guavaguava00";
    // in my wordpress version the blogId is "1"
    int blogId = 1;


    BlogInfo blogInfo = new BlogInfo(xmlRpcUrl, userName, password, blogId);

    BlogPoster poster = new BlogPoster(blogInfo);
    //poster.setPostType(PostType.publish);
    poster.post(contents());
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
private static Hashtable contents() throws IOException {
    // According to the wordpress post format the title and
    // category id of the post get some special mark up.
	  Hashtable taxonomies = new Hashtable();
	  List<String> categories = new ArrayList<String>();
	  categories.add("GTD");
	  categories.add("这个分类还没存在");
	  taxonomies.put("category", categories);
	Hashtable post1 = new Hashtable();
      post1.put("post_title", "test好 post");
      post1.put("post_content","试试而已");
      post1.put("post_type", "post");
      post1.put("post_status", "publish");
      post1.put("comment_status", "open");
      post1.put("ping_status", "open");
      post1.put("terms_names", taxonomies);
    return post1;
  }
}
package com.holdyourdream.wp;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;


public class DefaultBlog {
	BlogPoster poster = null;
	public DefaultBlog() throws MalformedURLException{
		String xmlRpcUrl = "http://www.hfzyyx.com/xmlrpc.php";
		String userName = "admin";
	    String password = "guavaguava00";
	    int blogId = 1;
	    BlogInfo blogInfo = new BlogInfo(xmlRpcUrl, userName, password, blogId);
		poster=new BlogPoster(blogInfo);
		// TODO Auto-generated constructor stub
	}
	
	public void post(String title,String content) throws XmlRpcException {
		String[] temp = { "皇冠平台", "皇冠系统", "足球平台", "足球系统", "平台出租", "系统出租"};
	    int index = (int) (Math.random() * temp.length);
	    String cats=temp[index];
	    
	    
	    BlogContent bc=new BlogContent(title,content,cats);	
		this.poster.post(bc.post);
	}

	
}

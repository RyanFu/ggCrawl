package com.holdyourdream.wp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.dom4j.DocumentException;

import ch.dao.BlogDao;
import ch.po.Blog;


public class DefaultBlog {
	BlogPoster poster = null;
	Blog b=null;
	public DefaultBlog() throws IOException, DocumentException{
//		String xmlRpcUrl = "http://www.hfzyyx.com/xmlrpc.php";
//		String userName = "admin";
//	    String password = "guavaguava00";
//	    int blogId = 1;
//	    BlogInfo blogInfo = new BlogInfo(xmlRpcUrl, userName, password, blogId);
		BlogDao bDao=new BlogDao();
		this.b=bDao.getOne();
		BlogInfo blogInfo = new BlogInfo(b.getXmlRpcUrl(), b.getUserName(), b.getPassword(), 1);
		poster=new BlogPoster(blogInfo);
		// TODO Auto-generated constructor stub
	}
	
	public void post(String title,String content) throws XmlRpcException {
//		String[] temp = { "皇冠平台", "皇冠系统", "足球平台", "足球系统", "平台出租", "系统出租"};
//	    int index = (int) (Math.random() * temp.length);
//	    String cats=temp[index];
	    int index=(int) (Math.random() * this.b.getCats().size());
	    String cats=this.b.getCats().get(index);
	    BlogContent bc=new BlogContent(title,content,cats);	
		this.poster.post(bc.post);
	}

	
}

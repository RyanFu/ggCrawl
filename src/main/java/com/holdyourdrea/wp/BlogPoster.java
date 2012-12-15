package com.holdyourdrea.wp;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class BlogPoster {

  private static final String POST_METHOD_NAME = "wp.newPost";

  private XmlRpcClient client;
  private BlogInfo blogInfo;

  //public BlogPoster(XmlRpcClient client, BlogInfo blogInfo) {
  public BlogPoster(BlogInfo blogInfo) throws MalformedURLException {
    //this.client = client;
    this.blogInfo = blogInfo;
    
    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    config.setServerURL(new URL(blogInfo.getUrl()));

    XmlRpcClient client = new XmlRpcClient();
    client.setConfig(config);
    this.client = client;
  }



  public String post(Hashtable hashtable) throws XmlRpcException {
    Object[] params = new Object[] {
        blogInfo.getBlogId(),
        blogInfo.getUserName(),
        blogInfo.getPassword(),
        hashtable
    };
    return (String) client.execute(POST_METHOD_NAME, params);
  }

  
}
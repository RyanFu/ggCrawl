package com.holdyourdrea.wp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;




public class PostExample2 {

	public static void main(String[] args) throws Exception {
    String xmlRpcUrl = "http://www.holdyourdream.com/a/xmlrpc.php";

    String userName = "admin";
    String password = "guavaguava00";
    int blogId = 1;


    BlogInfo blogInfo = new BlogInfo(xmlRpcUrl, userName, password, blogId);

    BlogPoster poster = new BlogPoster(blogInfo);
    //poster.setPostType(PostType.publish);
    BlogContent bc=new BlogContent("重构过的java发布wordpress xmlrpc程序","You need an XML-RPC client, you can use the Apache XML-RPC library Here a list of Wordpress supported API.And finally a short tutorial to get you started.","php");
    poster.post(bc.post);
  }

}
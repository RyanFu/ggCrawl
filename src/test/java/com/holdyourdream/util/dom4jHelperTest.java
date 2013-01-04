package com.holdyourdream.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.*;

import ch.po.NewsSource;

import junit.framework.TestCase;

public class dom4jHelperTest extends TestCase {
	dom4jHelper djHelper =null;
	public void testDom4jHelper() {
		fail("Not yet implemented");
	}

	public void testBianli() {
		fail("Not yet implemented");
	}

	public void testShuxing() throws IOException, DocumentException {
		//fail("Not yet implemented");
		djHelper=new dom4jHelper("newsites.xml");
		djHelper.shuxing();
	}

	public void testGetDocument() {
		fail("Not yet implemented");
	}

	public void testFirstSite() throws IOException, DocumentException {
		djHelper=new dom4jHelper("newsites.xml");
		Element root=djHelper.getRootElement();
		List sites=root.elements();
		Element site1=(Element) sites.get(0);
		System.out.println(site1.getName());
		
	}
	public void testAllsites() throws IOException, DocumentException {
		djHelper=new dom4jHelper("newsites.xml");
		Element root=djHelper.getRootElement();
		for(Object i:root.elements()){
//			List site=((Element)i).elements();
//			for(Object s_i:site){
//				Element kk=(Element)s_i;
//				System.out.println(kk.getText());
//			}
			Element s=(Element)i;
			System.out.println(s.attributeValue("id"));
			//System.out.println(s.asXML());
//			//这个方法成功了
			Node root_url=s.element("list_url");			
			System.out.println(root_url.asXML());
		}
		
	}
	public void testGetsites() throws IOException, DocumentException {
		djHelper=new dom4jHelper("newsites.xml");
		Element root=djHelper.getRootElement();
		List list=new ArrayList();
		
		for(Object i:root.elements()){
			Element s=(Element)i;
			NewsSource ns=new NewsSource();
			//Node node=s.element("list_url");
			ns.setList_url(s.element("list_url").getText());
			ns.setPre_url(s.element("pre_url").getText());
			ns.setList_rule(s.element("list_rule").getText());
			ns.setTitle_rule(s.element("title_rule").getText());
			ns.setContent_rule(s.element("content_rule").getText());

			list.add(ns);
		}
		
		for (Object object : list) {
			NewsSource newsSource=(NewsSource)object;
			System.out.println(newsSource.getContent_rule());
		}
		
	}

}

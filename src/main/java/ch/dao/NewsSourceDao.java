package ch.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import ch.po.NewsSource;

import com.holdyourdream.util.dom4jHelper;

public class NewsSourceDao {
	private List<NewsSource> list=null;
	public NewsSourceDao() throws IOException, DocumentException {
		dom4jHelper djHelper=new dom4jHelper("newsites.xml");
		Element root=djHelper.getRootElement();
		list=new ArrayList();
		
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
	}
	public List<NewsSource> getList() {
		return list;
	}
	
}

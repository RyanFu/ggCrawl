package com.holdyourdream.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupHelper {
	private Document doc=null;
	
	public jsoupHelper(String html){
		this.doc = Jsoup.parse(html);
	}
	public void setHtml(String html){
		this.doc = Jsoup.parse(html);
	}
	
	public String getText(String rule){
		return this.doc.select(rule).text();
	}
	
	public String getAllText(String rule){
		Elements newsHeadlines=this.doc.select(rule);
		String all=null;
		for(Element n:newsHeadlines){
			all=all+n.text();
		}
		return all;
	}
	public String getHTML(String rule){
		return this.doc.select(rule).html();
	}
	public Elements getElements(String rule){
		Elements newsHeadlines =this.doc.select(rule);
		return newsHeadlines;
	}
	public Elements getHerfs(String rule){
		Elements newsHeadlines =this.doc.select(rule);
		return newsHeadlines;
	}

}

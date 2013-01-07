package com.holdyourdream.controler;

import java.io.IOException;
import java.util.List;

import javassist.bytecode.analysis.ControlFlow.Node;

import javax.swing.JSpinner;

import org.apache.http.ParseException;
import org.apache.xmlrpc.XmlRpcException;
import org.dom4j.DocumentException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ch.dao.NewsSourceDao;
import ch.dao.PostTittleDao;
import ch.po.NewsSource;
import ch.po.PostTitle;

import com.holdyourdream.http.httpgetHelper;
import com.holdyourdream.util.GBKdecode;
import com.holdyourdream.util.dom4jHelper;
import com.holdyourdream.util.jsoupHelper;
import com.holdyourdream.wp.BlogContent;
import com.holdyourdream.wp.BlogInfo;
import com.holdyourdream.wp.BlogPoster;
import com.holdyourdream.wp.DefaultBlog;

public class xinwen {

	
//	public static void main(String[] args) throws Exception {
//		//get list page
//		System.out.print("is go?");
//		String list_url="http://news.dayoo.com/guangzhou/";
//		String pre_url="http://news.dayoo.com/guangzhou/";
//		String list_rule="div#m1_li ul li a";
//		String title_rule="h1";
//		String content_rule="div.content";
//		com.holdyourdream.http.httpgetHelper hp=new httpgetHelper(list_url);
//		String html=hp.getHtml();
//		
//		//jsoup解析
//		com.holdyourdream.util.jsoupHelper jh1=new jsoupHelper(html);
//		Elements s=jh1.getElements(list_rule);
//		
//		//开始逐个页面采集发布
//		for (Element i : s) {
////			System.out.println(i.text());
////			System.out.println(i.attr("href"));
//			ch.dao.PostTittleDao ptd=new PostTittleDao();
//			if( ptd.isHave(i.text()) ){
//				System.out.println("the title is in db now");
//			}else{
//				System.out.print(list_url+i.attr("href"));
//				httpgetHelper hp2=new httpgetHelper(pre_url+i.attr("href"));
//				String s2=hp2.getHtml();
//				
//				jh1.setHtml(s2);
//				String title=jh1.getText(title_rule);
//				String content=jh1.getHTML(content_rule);
//				//System.out.println(content);
//				
//				//建立内置blog信息的Blog
//			    DefaultBlog blog=new DefaultBlog();
//			    blog.post(title, content);
//			    
//			    
//			    ch.po.PostTitle pt1=new PostTitle();
//			    pt1.post_tittle=i.text();
//			    
//			    ch.dao.PostTittleDao ptd1=new PostTittleDao();
//			    ptd1.save(pt1);
//			    ptd1.close();
//			    
//			}
//		}
//		
//		
//	}
//	
	public static void main(String[] args) throws Exception {
		NewsSourceDao nsd=new NewsSourceDao();
		List<NewsSource> list=nsd.getList();
		xinwen xw=new xinwen();
		
		for(NewsSource n:list){
			xw.getsAndSent(n);
		}
		System.out.println("guava:over");
	}
	
	public void getsAndSent(NewsSource ns) throws ParseException, IOException, XmlRpcException, DocumentException {
		System.out.print("is go?");
		String list_url=ns.getList_url();
		String pre_url=ns.getPre_url();
		String list_rule=ns.getList_rule();
		String title_rule=ns.getTitle_rule();
		String content_rule=ns.getContent_rule();
		com.holdyourdream.http.httpgetHelper hp=new httpgetHelper(list_url);
		String html=hp.getHtml();
		html=GBKdecode.needUTF8(html);
		//jsoup解析
		com.holdyourdream.util.jsoupHelper jh1=new jsoupHelper(html);
		Elements s=jh1.getElements(list_rule);
		
		//开始逐个页面采集发布
		for (Element i : s) {
//			System.out.println(i.text());
//			System.out.println(i.attr("href"));
			ch.dao.PostTittleDao ptd=new PostTittleDao();
			if( ptd.isHave(i.text()) ){
				System.out.println("the title is in db now");
			}else{
				System.out.print(list_url+i.attr("href"));
				httpgetHelper hp2=new httpgetHelper(pre_url+i.attr("href"));
				String s2=hp2.getHtml();
				s2=GBKdecode.needUTF8(s2);
				
				
				jh1.setHtml(s2);
				String title=jh1.getText(title_rule);
				String content=jh1.getHTML(content_rule);
				//System.out.println(content);
				
				//建立内置blog信息的Blog
			    DefaultBlog blog=new DefaultBlog();
			    blog.post(title, content);
			    
			    
			    ch.po.PostTitle pt1=new PostTitle();
			    pt1.post_tittle=i.text();
			    
			    ch.dao.PostTittleDao ptd1=new PostTittleDao();
			    ptd1.save(pt1);
			    ptd1.close();
			    
			}
		}
	}
}

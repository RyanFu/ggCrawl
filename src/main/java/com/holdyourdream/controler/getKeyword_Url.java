package com.holdyourdream.controler;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.ParseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ch.tool.HibernateUtil;

import com.holdyourdream.http.httpgetHelper;
import com.holdyourdream.util.GBKdecode;
import com.holdyourdream.util.jsoupHelper;
import com.holdyourdream.wp.BlogContent;
import com.holdyourdream.wp.BlogInfo;
import com.holdyourdream.wp.BlogPoster;

public class getKeyword_Url {
	//,String key_rule,String url_rule
	getKeyword_Url(String url) throws Exception{
		//get html
		String html=null;
		httpgetHelper hp=new httpgetHelper(url);
		if(hp.isGetOk()){
			html=hp.getHtml();
			//com.holdyourdream.util.Writer.createCheckFile("s.html", html);
		}
		
		//passer
		jsoupHelper jh=new jsoupHelper(html);
		Elements texts=jh.getElements("dd a");
		int len=texts.size();
		com.holdyourdream.config.ConfigManager cm=new com.holdyourdream.config.ConfigManager("japan_movie.properties");
		cm.setPathRoot("");
		cm.p.setProperty("all", String.valueOf(len));
		int now=Integer.parseInt(cm.p.getProperty("now"));
		cm.save();
		
		//每次运行程序发布2篇文章
		
		int couter=1;
		int isok=0;
		for(int i=now+1;i<len;i++){
			
			//System.out.println("now is in"+String.valueOf(i));
			Element n=texts.get(i);
			System.out.println(n.text()+n.attr("href")+":"+i);
			
			ch.po.Movie mv=new ch.po.Movie();
			mv.keyname=n.text();
			
			mv.iframeUrl=n.attr("href");
			
//			String lhsn="恋爱检定";
//			if(mv.keyname.equals(lhsn) ){
//				isok=1;
//				System.out.println("ni bu shi ba ");
//			}
//			    if(isok==0){
//			    	System.out.println("还没到lhsn");
//			    	continue;
//			    }
			    
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx =session.beginTransaction();
//			try{
//				
//				
//				session.save(mv);
//				tx.commit();
//			}catch(HibernateException e){
//            	System.out.println("something wrong when insert page to db");
//            	tx.rollback();
//                e.printStackTrace();
//			}
//			session.close();
			//采集soso 放到content
			String query_keyword=mv.keyname;
			String ENCODING="utf-8";
			query_keyword=query_keyword.replace(" ", "-");
			query_keyword=URLEncoder.encode(query_keyword, ENCODING).replace("*","*").replace("~", "~").replace("+"," ");
			
			
			String hh="http://www.baidu.com/s?wd=";
			hh=hh+query_keyword;
			String douban="http://www.douban.com/search?cat=1002&q=";
			douban=douban+query_keyword;
			
			
			
			
			
			System.out.println(hh);
			httpgetHelper hp1=new httpgetHelper(hh);
			httpgetHelper hp2=new httpgetHelper(douban);
			
			String baidu_c=hp1.getHtml();
			com.holdyourdream.util.jsoupHelper jh1=new com.holdyourdream.util.jsoupHelper(baidu_c);
			baidu_c=jh1.getText("#container");
			baidu_c=baidu_c.replace("百度", "皇冠");
			//System.out.println("baidu_c?"+baidu_c.replace("百度", "皇冠"));
			
			String douban_c=hp2.getHtml();
			com.holdyourdream.util.jsoupHelper jh2=new com.holdyourdream.util.jsoupHelper(douban_c);
			douban_c=jh2.getHTML("div[class=search-result]");
			douban_c=douban_c.replace("豆瓣", "平台");
			//System.out.println("douban?"+douban_c);
			
			//System.out.println("have?:"+jh1.getText("#container"));
			mv.content="<iframe name='I1' src='http://www.qire123.net" +mv.iframeUrl+
					"' width='990' height='2250' scrolling='no' border='0' frameborder='0'></iframe>"
					+douban_c
					 +baidu_c;
			//System.out.println(mv.content);
			
			
			//String xmlRpcUrl = "http://www.holdyourdream.com/a/xmlrpc.php";
		    String xmlRpcUrl = "http://www.hfzyyx.com/xmlrpc.php";

		    String userName = "admin";
		    String password = "guavaguava00";
		    int blogId = 1;


		    BlogInfo blogInfo = new BlogInfo(xmlRpcUrl, userName, password, blogId);

		    BlogPoster poster = new BlogPoster(blogInfo);
		    //poster.setPostType(PostType.publish);
		    
		    //发布前数据处理
		    String[] temp = { "日剧", "日剧吧", "好看的日剧", "最新日剧", "日剧排行榜", "日剧推荐", "搞笑日剧", "秋季日剧", "看日剧的网站", "经典日剧推荐", "最新日剧推荐" };
		    int index = (int) (Math.random() * temp.length);
		   
		    mv.keyname=mv.keyname+"全集土豆优酷高清版01 02 03 04 05 06 07 08 09 10 11";
		    
		    String cats=temp[index];
		    System.out.println(cats);
		    BlogContent bc=new BlogContent(mv.keyname,mv.content,cats);
		    
		   
		    poster.post(bc.post);

		    
		    //设置采集任务到达的位置
		    com.holdyourdream.config.ConfigManager cm2=new com.holdyourdream.config.ConfigManager("japan_movie.properties");
			cm.setPathRoot("");
			cm.p.setProperty("now", String.valueOf(i));
			cm.save();
			couter+=1;
			 System.out.println(couter);
			if(couter>2)break;
			
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.out.println("what?");
		getKeyword_Url gu=new getKeyword_Url("http://www.qire123.net/japan/");
		
	}
}
package com.holdyourdream.controler;

import java.io.IOException;

import org.apache.http.ParseException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.holdyourdream.http.httpgetHelper;

import ch.dao.NovelPageDao;
import ch.po.Novel;
import ch.po.NovelPage;
import ch.tool.HibernateUtil;

public class UpdateNovelList {
//	public static void main(String[] args) throws ParseException, IOException {
////		Novel nv=new Novel();
////		nv.novelIndexUrl="http://www.mingxingwang.me/0/344/";
////		nv.pageRule="dd";
////		nv.id=1;
////		nv.pagePreUrl="http://www.mingxingwang.me/0/344/";
////		UpdateNovelList ul=new UpdateNovelList();
////		ul.updateOne(nv);
//		
//	}
	public void updateOne(Novel nv) throws ParseException, IOException{
		//获取小说列表页
		httpgetHelper hgh=new httpgetHelper(nv.novelIndexUrl);
		String html=null;
		if(hgh.isGetOk()){
			html=hgh.getHtml();
		}
		
		//获取兴趣URLs
		Document doc = Jsoup.parse(html);
		Elements newsHeadlines = doc.select(nv.pageRule);
		int i=0;
		
		for(Element n:newsHeadlines){
			i=i+1;
			String Interesting_url;
			Interesting_url=n.select("a").attr("href");
			System.out.println(Interesting_url);
			
			//初始化novel_page
			NovelPage np=new NovelPage();
			np.url=nv.pagePreUrl+Interesting_url;
			np.novel_Id=nv.id;
			np.position=i;
			
			NovelPageDao npd=new NovelPageDao();
			npd.insert(np);
			npd.close();
//			//获取标题和内容
//			httpgetHelper hgh2=new httpgetHelper(nv.novelIndexUrl);
//			String html2=null;
//			if(hgh2.isGetOk()){
//				html2=hgh2.getHtml();
//			}
//			Document doc2 = Jsoup.parse(html2);
//			np.titel = doc2.select(nv.titleRule).text();
//			np.content = doc2.s
			
		}
		
		
		
	}

}

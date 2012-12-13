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
		
		NovelPageDao npdv=new NovelPageDao();
		//获取已入库数量
		int num=npdv.getAll(nv.id).size();
		npdv.close();
		System.out.println(nv.novelName+" in db"+num);
		System.out.println("new get result have"+newsHeadlines.size());
		if(num<newsHeadlines.size()){
			System.out.println("have new page need to into");
			for(int i=num;i<newsHeadlines.size();i++){
				String Interesting_url;
				Element n=newsHeadlines.get(i);
				Interesting_url=n.select("a").attr("href");
				System.out.println(Interesting_url);
				
				//初始化novel_page
				NovelPage np=new NovelPage();
				np.url=nv.pagePreUrl+Interesting_url;
				np.novel_Id=nv.id;
				np.position=i;
				
				httpgetHelper hgh2=new httpgetHelper(np.url);
				String html2=null;
				if(hgh2.isGetOk()){
					html2=hgh2.getHtml();
					html2=new String(html2.getBytes("ISO-8859-1"),"GBK");
					//System.out.println(html2);
					//htmlContent=new String(htmlContentBefor.getBytes("ISO-8859-1"),"GBK");
				}
				
				Document doc2 = Jsoup.parse(html2);
				np.titel = doc2.select(nv.titleRule).text();
				System.out.println(np.titel+" is ready get into db");
				np.content = doc2.select(nv.contentRule).html();
				np.isGet=true;
				NovelPageDao npd=new NovelPageDao();
				npd.insert(np);
				npd.close();
			}
			
		}
//		for(Element n:newsHeadlines){
//			i=i+1;
//			String Interesting_url;
//			Interesting_url=n.select("a").attr("href");
//			System.out.println(Interesting_url);
//			
//			//初始化novel_page
//			NovelPage np=new NovelPage();
//			np.url=nv.pagePreUrl+Interesting_url;
//			np.novel_Id=nv.id;
//			np.position=i;
//			
//			NovelPageDao npd=new NovelPageDao();
//			npd.insert(np);
//			npd.close();
////			//获取标题和内容
////			httpgetHelper hgh2=new httpgetHelper(nv.novelIndexUrl);
////			String html2=null;
////			if(hgh2.isGetOk()){
////				html2=hgh2.getHtml();
////			}
////			Document doc2 = Jsoup.parse(html2);
////			np.titel = doc2.select(nv.titleRule).text();
////			np.content = doc2.s
//			
//		}
		
		
		
	}

}

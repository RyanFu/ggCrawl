package com.holdyourdream.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.ParseException;
import org.hibernate.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ch.dao.NovelPageDao;
import ch.po.*;
import ch.tool.HibernateUtil;

public class NovelPageGet {
	public static void getOne(Novel nv,NovelPage np) throws UnsupportedEncodingException{
		httpgetHelper hgh=new httpgetHelper(np.url);
		String html=null;
		if(hgh.isGetOk()){
			try {
				html=hgh.getHtml();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(html!=null){
			html=new String(html.getBytes("ISO-8859-1"),nv.novelEncoding);
			Document doc = Jsoup.parse(html);
			np.titel = doc.select(nv.titleRule).text();
			np.content = doc.select(nv.contentRule).html();
			np.isGet=true;
		}
		
		NovelPageDao npd=new NovelPageDao();
		npd.updata(np);
		npd.close();
		System.out.println("getOne end");
	}
}

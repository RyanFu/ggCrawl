package com.holdyourdream.test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.http.ParseException;

import com.holdyourdream.http.*;
import com.holdyourdream.util.CharsetDetector;
import com.holdyourdream.util.GBKdecode;
import com.holdyourdream.util.Writer;
public class getOne {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
//		httpgetHelper hh=new httpgetHelper("http://www.baidu.com/s?wd="+k);
		
		//utf8 no need decode
		//httpgetHelper hh=new httpgetHelper("http://blog.sina.com.cn/s/blog_48a3708e01017g3f.html?tj=1");
		
		//UTF-8	Big5 GB18030(need to decode)		
		//httpgetHelper hh=new httpgetHelper("http://city.sz.net.cn/city/2012-12/30/content_3093295.htm");
		
		//UTF-8	windows-1252
		//httpgetHelper hh=new httpgetHelper("http://gd.qq.com/");
		
		//UTF-8	windows-1252
		httpgetHelper hh=new httpgetHelper("http://www.gdzjdaily.com.cn/");
		
			
		if(hh.isGetOk()){
			String html=hh.getHtml();
			com.holdyourdream.util.CharsetDetector cDetector=new CharsetDetector();
			String[] strings=cDetector.detectAllCharset(new ByteArrayInputStream(html.getBytes())) ;
			for (String charset : strings)  
	        {  
	            System.out.println(charset);  
	        }
			if(strings.length>1){
				html=GBKdecode.utf8(html);
			}
			
			//System.out.println(html);
			//Writer.createCheckFile("j.html",  html );
			//Writer.w_encoding("/Users/guavatan/temp/j.html",  gb2312, "GBK");
		}else{
			System.out.print("失败");
		}
		
		
	}
	
	public void testCharset() throws IOException {
		CharsetDetector charDect = new CharsetDetector();  
        URL url = new URL("http://blog.sina.com.cn/s/blog_48a3708e01017g3f.html?tj=1");  
        String[] probableSet = charDect.detectChineseCharset(url.openStream());  
        for (String charset : probableSet)  
        {  
            System.out.println(charset);  
        }  
		
	}

}

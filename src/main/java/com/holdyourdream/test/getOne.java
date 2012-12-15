package com.holdyourdream.test;
import java.io.IOException;

import org.apache.http.ParseException;

import com.holdyourdream.http.*;
import com.holdyourdream.molemole.Writer;
public class getOne {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		httpgetHelper hh=new httpgetHelper("http://www.baidu.com/s?wd=恶魔少女&rsv_bp=0&rsv_spt=3&rsv_n=2&rsv_sug3=1&rsv_sug=0&rsv_sug1=1&rsv_sug4=169&inputT=404");
		
		if(hh.isGetOk()){
			//System.out.print("what");
			String html=hh.getHtml();
			System.out.println(html);
			
			Writer.createCheckFile("j.html", html);
		}else{
			System.out.print("失败");
		}
		
		
	}

}

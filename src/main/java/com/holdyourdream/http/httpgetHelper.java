package com.holdyourdream.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class httpgetHelper {
	private DefaultHttpClient httpclient = new DefaultHttpClient();
	private HttpResponse response1 = null;
	private int StatusCode;
	public httpgetHelper(String url){
		
		HttpGet httpGet=new HttpGet(url);
		
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)");  
		httpGet.addHeader("Accept-Encoding", "gzip");
		try {
			this.response1= this.httpclient.execute(httpGet);
			Header[] header = this.response1.getAllHeaders(); 
			
			for(Header i:header){				
				System.out.println(i.getName()+":"+i.getValue());
			}
			this.StatusCode=this.response1.getStatusLine().getStatusCode();
			System.out.println("StatusCode is:"+this.StatusCode);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  boolean isGetOk(){
		if(this.StatusCode==200){
			return true;
		}else{
			return false;
		}
		
	}
	

	public String getHtml() throws ParseException, IOException{
		String htmlcode="";
		HttpEntity entity=this.response1.getEntity();		
		System.out.println("html length:"+entity.getContentLength()); 
		Header ceheader = entity.getContentEncoding();
		
        if (ceheader != null) {
            HeaderElement[] codecs = ceheader.getElements();
            for (int i = 0; i < codecs.length; i++) {
            	System.out.println(codecs[i].getName());
                if (codecs[i].getName().equalsIgnoreCase("gzip")) {
                    response1.setEntity(new GzipDecompressingEntity(response1.getEntity()));
                    System.out.println("GzipDecompressingEntity");
                    
                }
            }
        }
        
		if(entity.getContentLength()>0){
			htmlcode= EntityUtils.toString(response1.getEntity());
		}else{
			
			InputStream st = response1.getEntity().getContent();
			StringWriter writer = new StringWriter();
			IOUtils.copy(st, writer);
			htmlcode = writer.toString();
		}
		System.out.println("encoding:"+response1.getEntity().getContentEncoding());
		return htmlcode;
	}
}

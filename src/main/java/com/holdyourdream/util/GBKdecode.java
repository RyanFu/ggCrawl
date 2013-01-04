package com.holdyourdream.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public  class GBKdecode {
	public static String gbk(String html) throws UnsupportedEncodingException{
		html=new String(html.getBytes("ISO-8859-1"),"GBK");
		return html;
	}
	public static String GB2312(String html) throws UnsupportedEncodingException{
		html=new String(html.getBytes("ISO-8859-1"),"GB2312");
		return html;
	}
	public static String gb18030(String html) throws UnsupportedEncodingException{
		html=new String(html.getBytes("ISO-8859-1"),"gb18030");
		return html;
	}
	public static String windows1252(String html) throws UnsupportedEncodingException{
		html=new String(html.getBytes("ISO-8859-1"),"windows-1252");
		return html;
	}
	public static String utf8(String html) throws UnsupportedEncodingException{
		
		html=new String(html.getBytes("ISO-8859-1"),"UTF-8");
		
		return html;
	}
	
	public static String needUTF8(String html) throws IOException {
		CharsetDetector cDetector=new CharsetDetector();
		String[] strings=cDetector.detectAllCharset(new ByteArrayInputStream(html.getBytes())) ;
		if(strings.length>1){
			html=GBKdecode.utf8(html);
		}
		return html;
	}
	public static String convertString(String gbk){
        String utf8 = "";
        try {
            utf8 = new String(gbk2utf8(gbk),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return utf8;
    }
 
    public static byte[] gbk2utf8(String chenese) {
        char c[] = chenese.toCharArray();
        byte[] fullByte = new byte[3 * c.length];
        for (int i = 0; i < c.length; i++) {
            int m = (int) c[i];
            String word = Integer.toBinaryString(m);
 
            StringBuffer sb = new StringBuffer();
            int len = 16 - word.length();
            for (int j = 0; j < len; j++) {
                sb.append("0");
            }
            sb.append(word);
            sb.insert(0, "1110");
            sb.insert(8, "10");
            sb.insert(16, "10");
 
            String s1 = sb.substring(0, 8);
            String s2 = sb.substring(8, 16);
            String s3 = sb.substring(16);
 
            byte b0 = Integer.valueOf(s1, 2).byteValue();
            byte b1 = Integer.valueOf(s2, 2).byteValue();
            byte b2 = Integer.valueOf(s3, 2).byteValue();
            byte[] bf = new byte[3];
            bf[0] = b0;
            fullByte[i * 3] = bf[0];
            bf[1] = b1;
            fullByte[i * 3 + 1] = bf[1];
            bf[2] = b2;
            fullByte[i * 3 + 2] = bf[2];
 
        }
        return fullByte;
    }
}

package com.holdyourdream.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import junit.framework.TestCase;

public class testEncoder extends TestCase{
	public void testBianli() throws IOException {
		Charset c=Charset.defaultCharset();
		//System.out.println(c.name());
		CharsetDetector cdCharsetDetector=new CharsetDetector();
		
		String iString="a中文";		
		cdCharsetDetector.printCharArray(iString);
		
		String uString=new String(iString.getBytes(),"GBK");
		cdCharsetDetector.printCharArray(uString);
	}
	public void charsetTest() {
		String iString="a中文";
		
		System.out.println(Charset.availableCharsets().size());
		System.out.println("默认字符集:"+Charset.defaultCharset()); 
		
	}
}

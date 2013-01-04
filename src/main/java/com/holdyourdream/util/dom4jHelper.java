package com.holdyourdream.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class dom4jHelper {
	Document document=null;
	Element rootElement=null;
	public dom4jHelper(String s) throws IOException, DocumentException{
		String path=new File(".").getCanonicalPath();
		File f=new File(path+"/"+s);
		
		SAXReader reader = new SAXReader();
	    this.document = reader.read(f);
	    this.rootElement= document.getRootElement();
	}
	
	public void bianli() {
		// 枚举所有子节点
		for ( @SuppressWarnings("rawtypes")
		Iterator i = rootElement.elementIterator(); i.hasNext(); ){
			Element element = (Element) i.next();	
			System.out.println("F:bianli()--"+element.getName());
		}

	}
	
	public void shuxing() {
		// 枚举属性
		for ( @SuppressWarnings("rawtypes")
		Iterator i = rootElement.attributeIterator(); i.hasNext();){
			Attribute attribute = (Attribute) i.next();
			System.out.println(attribute.getName()+":"+attribute.getValue());
		}
	}
	public Document getDocument() {
		return document;
	}
	public Element getRootElement() {
		return rootElement;
	}
	
}

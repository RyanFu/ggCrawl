package com.holdyourdream.molemole;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private String pathRoot="\\config\\";
	private String path="";
	private Properties p;
	public ConfigManager(String filename) throws IOException{
		InputStream is;
		try {
			this.path=new File(".").getCanonicalPath();
			is = new FileInputStream(path+pathRoot+filename);
			this.p = new Properties();
            p.load(is);
            //String value = p.getProperty("age");
            //System.out.println(value); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Properties getPropertieHandle(){
		return this.p;
	}
}

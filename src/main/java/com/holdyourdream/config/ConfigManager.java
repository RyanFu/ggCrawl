package com.holdyourdream.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigManager {
	private String pathRoot="/";
	//private String pathRoot="\\config\\";
	private String path="";
	private String filename="";
	public Properties p;
	public ConfigManager(String filename) throws IOException{
		
		InputStream is;
		try {
			this.path=new File(".").getCanonicalPath();
			this.filename=path+pathRoot+filename;
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
	
	public void save() throws IOException{
		OutputStream os3 = new FileOutputStream(this.filename); 
		this.p.store(os3, "???");
	}

	public String getPathRoot() {
		return pathRoot;
	}


	public void setPathRoot(String pathRoot) {
		this.pathRoot = pathRoot;
	}
}

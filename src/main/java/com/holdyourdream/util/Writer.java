package com.holdyourdream.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Writer {
	public static void createCheckFile(String filePath, String detail)
		    throws Exception {
		   try {
		    File file = new File(filePath);
		    FileWriter filewriter = new FileWriter(file, true);
		    filewriter.write(detail);
		    filewriter.close();
		   } catch (IOException e) {
		    throw e;
		   } catch (Exception ex) {
		    throw ex;
		   }
	}
	
	public static void w_encoding(String filePath, String detail,String encoding) {
		
	     try  { 
	        FileOutputStream fos  =   new  FileOutputStream( filePath ); 
	        OutputStreamWriter osw  =   new  OutputStreamWriter(fos,  encoding); 
	        osw.write(detail); 
	        osw.flush(); 
	    }  catch  (Exception e) { 
	        e.printStackTrace(); 
	    }
		
	}
}

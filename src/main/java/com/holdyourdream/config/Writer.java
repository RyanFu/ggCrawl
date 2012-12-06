package com.holdyourdream.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}

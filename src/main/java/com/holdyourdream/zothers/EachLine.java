package com.holdyourdream.zothers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EachLine {
	public static void main(String[] args) throws FileNotFoundException{
	   Scanner scan=new Scanner(new File("config/k.txt"));
	   while(scan.hasNext()){
	   //System.out.println(scan.nextLine());
		   String string=scan.nextLine();
		   String s[]=string.split("	");
		   String str=s[0];
		   if(str.length()!=str.replaceAll("平台出租", "").length()){
			   System.out.print(s[0].replace("平台出租", "")+"-");
			   System.out.print(s[1]+"-");
			   System.out.println("");
		   }
		   
		   
	   }
	 }
}

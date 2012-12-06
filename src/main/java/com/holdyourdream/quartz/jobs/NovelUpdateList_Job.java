package com.holdyourdream.quartz.jobs;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.apache.http.ParseException;
import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ch.dao.NovelDao;
import ch.dao.NovelPageDao;
import ch.po.Novel;
import ch.po.NovelPage;
import ch.tool.HibernateUtil;

import com.holdyourdream.controler.UpdateNovelList;
import com.holdyourdream.http.NovelPageGet;

public class NovelUpdateList_Job implements Job{
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		NovelDao nd=new ch.dao.NovelDao();
		List<Novel> novels=nd.getAll();
		UpdateNovelList ul=new UpdateNovelList();
		for(Iterator<Novel> ite = novels.iterator(); ite.hasNext();){
        		Novel novel = ite.next();
        
        		System.out.println("finished list begin");
				
					try {
						ul.updateOne(novel);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			

				
		    	System.out.println("finished list update");
		    	
			
		}
        	
		
		
		
			
		
	}

}

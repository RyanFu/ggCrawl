package com.holdyourdream.quartz.jobs;

import static org.quartz.JobBuilder.newJob;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

public class NovelUpdateList_JobDetail{
	public static JobDetail get(){
		JobDetail job = newJob(NovelUpdateList_Job.class)
                .withIdentity("NovelUpdateList_Job", "group1")
                .build();
		return  job;
		
	}

}

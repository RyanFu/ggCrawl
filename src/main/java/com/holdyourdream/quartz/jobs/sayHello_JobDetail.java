package com.holdyourdream.quartz.jobs;

import static org.quartz.JobBuilder.newJob;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class sayHello_JobDetail{
	public static JobDetail job;
	public sayHello_JobDetail(){
		this.job = newJob(sayHello_Job.class)
                .withIdentity("job1", "group1")
                .build();
		
	}

}

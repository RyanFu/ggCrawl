package com.holdyourdream.quartz;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import org.quartz.impl.StdSchedulerFactory;


import com.holdyourdream.quartz.jobs.NovelUpdateList_JobDetail;
import com.holdyourdream.quartz.jobs.sayHello_JobDetail;
import com.holdyourdream.quartz.trigger.halfHour_Ttigger;






public class QuartzTest {

    public static void main(String[] args) {

        try {
            // Grab the Scheduler instance from the Factory 
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();
            
            
            scheduler.scheduleJob(NovelUpdateList_JobDetail.get(), halfHour_Ttigger.get());
            //scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
package com.holdyourdream.quartz.trigger;

import org.quartz.Trigger;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;


public class halfHour_Ttigger{
	public static Trigger get(){
		Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(60*5)
                        .repeatForever())            
                .build();
		
		return trigger;
	}

}

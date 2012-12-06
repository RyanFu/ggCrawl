package com.holdyourdream.quartz.trigger;

import org.quartz.Trigger;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;


public class sayHello_Ttigger{
	public static Trigger trigger;
	public sayHello_Ttigger(){
		this.trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())            
                .build();
	}

}

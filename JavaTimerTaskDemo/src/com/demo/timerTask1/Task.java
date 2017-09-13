package com.demo.timerTask1;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task extends TimerTask {

	private Logger log = LoggerFactory.getLogger(Task.class);
	
    public void run() {          
        log.debug("我被执行啦啦啦~~~");
    }  
}

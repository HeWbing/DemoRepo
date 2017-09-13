package com.demo.timerTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.timerTask1.Task;

/**
 * Java定时任务，每天定时执行任务
 * @author He
 *
 */
public class TimerManager {

	private Logger log = LoggerFactory.getLogger(TimerManager.class);
	private static final long PERIOD_DAY = 24*60*60* 1000;  //间隔时间：单位毫秒
	
	public TimerManager(){
		Calendar calendar = Calendar.getInstance();
		
		//设置开始执行的时间 ：小时：分钟：秒   例如：22点55分0秒
		calendar.set(Calendar.HOUR_OF_DAY, 22);  //设置执行的小时 24小时制
        calendar.set(Calendar.MINUTE, 55);		//设置执行的分钟
        calendar.set(Calendar.SECOND, 0);		//设置执行的秒
        
        Date date = calendar.getTime(); //第一次执行任务时间
        log.debug("第一次执行任务时间： "+date);
        log.debug("before 方法比较："+date.before(new Date()));
        
      //如果第一次执行定时任务的时间 小于 当前的时间
        //此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。循环执行的周期则以当前时间为准
        if (date.before(new Date())) {
            date = this.addDay(date, 1);
            log.debug("==>>>"+date);
        }
        
        Timer timer = new Timer();
        
        NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule(task,date,PERIOD_DAY);
     
	}
	
	
	// 增加或减少天数
    public Date addDay(Date date, int num) {
     Calendar startDT = Calendar.getInstance();
     startDT.setTime(date);
     startDT.add(Calendar.DAY_OF_MONTH, num);
     return startDT.getTime();
    }
    
    
    
    
    public static void main(String[] args) {
		TimerManager timerManager = new TimerManager();
	}
}

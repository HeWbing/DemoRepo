package com.demo.timerTask1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerManager {
private static TimerManager timerManager = null;
	
	public static TimerManager geTimerManager(){
		if (timerManager==null) {
			timerManager = new TimerManager();
		}
		return timerManager;
	}
	
	
	
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        new TimerManager();    
    }  
  
    //时间间隔(一周)  
    private static final long PERIOD_WEEK = 24 * 60 * 60 * 1000 * 7;  
    
    private TimerManager() {  
    	
    	//设置执行任务的时间   时:分:秒
        Calendar calendar = Calendar.getInstance();  
//        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 23); //时  
        calendar.set(Calendar.MINUTE, 9);  //分
        calendar.set(Calendar.SECOND, 10);  //秒
        Date date=calendar.getTime(); //第一次执行定时任务的时间  
        //如果第一次执行定时任务的时间 小于当前的时间  
        //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。  
        if (date.before(new Date())) {  
            date = this.addDay(date, 1);  
        }  
        Timer timer = new Timer();  
        Task task = new Task();  
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
        timer.schedule(task,date,PERIOD_WEEK);    
    }  
    // 增加或减少天数  
    public Date addDay(Date date, int num) {  
        Calendar startDT = Calendar.getInstance();  
        startDT.setTime(date);  
        startDT.add(Calendar.DAY_OF_MONTH, num);  
        return startDT.getTime();  
    }  
  
}

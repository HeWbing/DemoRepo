package com.demo.utils.copy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jmx.snmp.Timestamp;

/**
 * 统计工具类
 * @author He
 *
 */
public class StatisticsUtils {
	private static Logger log = LoggerFactory.getLogger(StatisticsUtils.class);
	private static  ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();
    private final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 设置登录次数
	 */
	public synchronized int dologinTimes(HttpServletRequest request){
		System.out.println("--------------");
		int loginTimes = 0;
		String loginTimeStr = (String) request.getSession().getAttribute("loginTimes");
		String nowTime = new SimpleDateFormat(DATE_FORMAT).format(new Date());
		System.out.println("loginTimeStr:"+loginTimeStr);
//		log.debug("loginTimeStr:"+loginTimeStr);
		if ( "".equals(loginTimeStr)) {
			loginTimes = FileUtils.ReadFile("doc/login.txt");
			String loginMsg = "登录时间： "+nowTime+ "登录IP: "+Tools.getIpAddress(request);
			FileUtils.writeToFile(loginMsg, "doc/login.txt");
		}else{
			loginTimes = Integer.parseInt(loginTimeStr);
		}
		return loginTimes;
	}
	
}

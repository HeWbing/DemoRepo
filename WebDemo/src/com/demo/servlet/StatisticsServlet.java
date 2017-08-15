package com.demo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.utils.FileUtils;
import com.demo.utils.Tools;

public class StatisticsServlet extends HttpServlet{
	
	private static Logger log = LoggerFactory.getLogger(StatisticsServlet.class);
	private final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		request.getServletPath();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	/**
	 * 设置登录次数
	 */
	public synchronized int dologinTimes(HttpServletRequest request){
		int loginTimes = 0;
		String loginTimeStr = (String) request.getSession().getAttribute("loginTimes");
		String nowTime = new SimpleDateFormat(DATE_FORMAT).format(new Date());
		String loginMsg = "登录时间： "+nowTime+ "\t登录IP: "+Tools.getIpAddress(request);
		if ( loginTimeStr == null || "null".equals(loginTimeStr)) {
			loginTimes = FileUtils.ReadFile(request.getSession().getServletContext().getRealPath("/")+"/doc/login.txt");
		}else{
			loginTimes = Integer.parseInt(loginTimeStr);
		}
		FileUtils.writeToFile(loginMsg,request.getSession().getServletContext().getRealPath("/")+"/doc/login.txt");
		return loginTimes;
	}
}

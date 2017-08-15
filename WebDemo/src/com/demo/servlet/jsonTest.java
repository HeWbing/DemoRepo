package com.demo.servlet;

import com.demo.utils.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class jsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int JsonContext = new FileUtils().ReadFile("json/login.txt");
		System.out.println(JsonContext);
	}
}

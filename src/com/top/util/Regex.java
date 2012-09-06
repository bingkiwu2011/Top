package com.top.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Regex().isRegex("163163com"));

	}
	
	public Boolean numberRegex(String number) {
		String regEx = "\\d{11}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		m = p.matcher(number);
		return m.find();
	}
	
	public Boolean nameRegex(String number) {
		String regEx="^(\\d|[\\u4E00-\\u9FFF]|[a-zA-Z]){1,10}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		m = p.matcher(number);
		return m.find();
	}
	
	public Boolean emailRegex(String number) {
		String regEx="[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		m = p.matcher(number);
		return m.find();
	}

	public boolean isRegex(String str){
		String regEx = "[^a-zA-Z_0-9]"; // 表示非数字与英文字
		/*
		 * \D 等於 [^0-9] 非数字 
		 * \s 等於 [ \t\n\x0B\f ] 空白字元 
		 * \S 等於 [^ \t\n\x0B\f ]
		 * 非空白字元 \w 等於 [a-zA-Z_0-9] 数字或是英文字
		 *  \W 等於 [^a-zA-Z_0-9] 非数字与英文字
		 */
		Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		return m.find();
	}
}

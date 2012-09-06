package com.top.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFront {



	public static void main(String[] args) {
		TestFront test = new TestFront();
		long nCurrentTime = System.currentTimeMillis();
		
		Date date=new Date(nCurrentTime-1000*60*60); 
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		System.out.println(df.format(date));  
	}

}

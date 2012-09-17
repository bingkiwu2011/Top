package com.top.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encypter {

	public static void main(String[] args) {
		// 加密
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("bingki");
		String newPassword = textEncryptor.encrypt("customer");
		System.out.println(newPassword);
		
		
		System.out.println("--------------------------");
		// 解密
		BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
		textEncryptor2.setPassword("bingki");
		String oldPassword = textEncryptor2.decrypt("yvzwZkGehSPvShyr7amlmQ==");
		System.out.println(oldPassword);
		System.out.println("--------------------------");
		
		System.out.println(encyName("amadeus"));
	}
	
	public static String encyName(String username){
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("bingki");
		return textEncryptor.encrypt(username);
	}
}

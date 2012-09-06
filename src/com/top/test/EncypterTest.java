package com.top.test;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncypterTest {

	public static void main(String[] args) {
		// 加密
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("bingki");
		String newPassword = textEncryptor.encrypt("bingki1021");
		System.out.println(newPassword);
		
		
		System.out.println("--------------------------");
		// 解密
		BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
		textEncryptor2.setPassword("bingki");
		String oldPassword = textEncryptor2.decrypt(newPassword);
		System.out.println(oldPassword);
		System.out.println("--------------------------");
		
		
	

	}
}

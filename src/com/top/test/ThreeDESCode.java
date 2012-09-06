package com.top.test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.*;

import com.top.common.Constants;

import sun.misc.*;

public class ThreeDESCode {

	private static String charSet = "utf-8";


	public static String encryptThreeDESECB(String src) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		String string = encoder.encode(src.getBytes(charSet));
		DESedeKeySpec dks = new DESedeKeySpec(Constants.DESkey.getBytes(charSet));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, securekey);
		byte[] b = cipher.doFinal(string.getBytes());
		return encoder.encode(b);

	}

	public static String decryptThreeDESECB(String src) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytesrc = decoder.decodeBuffer(src);
		DESedeKeySpec dks = new DESedeKeySpec(Constants.DESkey.getBytes(charSet));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		byte[] retByte = cipher.doFinal(bytesrc);
		String string = new String(retByte);
		byte[] b = decoder.decodeBuffer(string);
		return new String(b, charSet);
	}

	public static void main(String[] args) {
		try {
			String OldStr = "撒旦撒旦撒qwqwq111";
			String encode = ThreeDESCode.encryptThreeDESECB(OldStr);
			System.out.println("加密:"+encode);
			System.out.println("解密："+ThreeDESCode.decryptThreeDESECB(encode));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.top.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyException extends Exception {
	private static Log log = LogFactory.getLog(MyException.class);
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 带自定义错误信息的输出
	 * 
	 * @param message
	 */

	public MyException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * 
	 * 自定义错误信息和异常抛出
	 * 
	 * @param message
	 * 
	 * @param cause
	 */

	public MyException(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
	}

	/**
	 * 
	 * 只有异常抛出
	 * 
	 * @param cause
	 */

	public MyException(Throwable cause) {
		super(cause);
	}

}

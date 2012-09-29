/** 
 * @Title: CacheTest.java 
 * @Package com.jianzhou.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-5-22 上午11:55:39 
 *@version 1.0 
 */
package com.top.test;

import org.springframework.cache.annotation.CacheEvict;


public class CacheTest {
	public static void main(String[] args) {
		CacheTest cacheTest=new CacheTest();
		cacheTest.blackPhone();
		cacheTest.gateWay();
		cacheTest.ispChannel();
	}


	// 清除掉全部缓存
	@CacheEvict(value = "ispChannel", allEntries = true)
	public final void ispChannel() {
		System.out.println("hello andCache deleteall");
	}
	@CacheEvict(value = "gateWay", allEntries = true)
	public final void gateWay() {
		System.out.println("hello andCache deleteall");
	}
	@CacheEvict(value = "blackPhone", allEntries = true)
	public final void blackPhone() {
		System.out.println("hello andCache deleteall");
	}
}

/** 
* @Title: Util.java 
* @Package com.top.security 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-29 下午4:52:13 
*@version 1.0 
*/
package com.top.security;

import org.springframework.security.core.context.SecurityContextHolder;

/** 
 * @ClassName: Util 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author bingki 
 * @date 2012-9-29 下午4:52:13  
 */
public class SecurityUtil {
	//获取当前登录用户信息
	public static UserInfo getUser() {
		return (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}

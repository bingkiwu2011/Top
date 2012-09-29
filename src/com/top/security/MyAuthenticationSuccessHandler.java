/** 
* @Title: MyAuthenticationSuccessHandler2.java 
* @Package com.top.security 
* @Description: TODO(用一句话描述该文件做什么) 
* Copyright: Copyright (c)2009 
* Company:上海建周 
* @author bingki 
* @date 2012-9-29 下午4:08:47 
*@version 1.0 
*/
package com.top.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/** 
 * @ClassName: MyAuthenticationSuccessHandler2 
 * @Description: TODO spring security 登录成后的 Handler
 * @author bingki 
 * @date 2012-9-29 下午4:08:47  
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication arg2) throws IOException, ServletException {
		request.getSession().setAttribute("", "");
	}

}

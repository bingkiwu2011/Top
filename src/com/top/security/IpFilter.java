/** 
 * @Title: IpFilter.java 
 * @Package com.top.security 
 * @Description: TODO(用一句话描述该文件做什么) 
 * Copyright: Copyright (c)2009 
 * Company:上海建周 
 * @author bingki 
 * @date 2012-4-9 下午02:17:20 
 *@version 1.0 
 */
package com.top.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @ClassName: IpFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bingki
 * @date 2012-4-9 下午02:17:20
 */
public class IpFilter extends OncePerRequestFilter {
	private static Log log = LogFactory.getLog(IpFilter.class);
	/*
	 * （非 Javadoc） <p>Title: doFilterInternal</p> <p>Description:</p>
	 * 
	 * @param arg0
	 * 
	 * @param arg1
	 * 
	 * @param arg2
	 * 
	 * @throws ServletException
	 * 
	 * @throws IOException
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */

	private List<String> allowedIPAddresses;

	public void setAllowedIPAddresse(List<String> allowedIPAddresses) {
		this.allowedIPAddresses = allowedIPAddresses;
	}

	public List<String> getAllowedIPAddresses() {
		return allowedIPAddresses;
	}

	public void setAllowedIPAddresses(List<String> allowedIPAddresses) {
		this.allowedIPAddresses = allowedIPAddresses;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if (allowedIPAddresses.size() > 0) {
			boolean shouldAllowe = false;
			for (String ip : allowedIPAddresses) {
				if (request.getRemoteAddr().equals(ip)) {
					System.out.println(ip);
					System.out.println(request.getRemoteAddr());
					shouldAllowe = true;
					break;
				}
			}
			if (shouldAllowe) {
				log.debug("Access has benn denied for your IP:" + request.getRemoteAddr());
				return;
				// throw new
				// AccessDeniedException("Access has benn denied for your IP:"+request.getRemoteAddr());
			}
		}
		filterChain.doFilter(request, response);
	}

}

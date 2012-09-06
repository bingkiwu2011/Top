package com.top.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.top.common.Constants;


/**
 * 
 * @author geloin
 * @date 2012-3-27 下午2:29:35
 */
@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 后台session控制
		String[] noFilters = new String[] { "login.html", "veriCode.html", "index.html", "logout.html" };
		String uri = request.getRequestURI();

		if (uri.indexOf("rest") != -1) {
			boolean beFilter = true;
			for (String s : noFilters) {
				if (uri.indexOf(s) != -1) {
					beFilter = false;
					break;
				}
			}
			if (beFilter) {
				Object obj = request.getSession().getAttribute(Constants.SESSION_USERS);
				if (null == obj) {
					String path = request.getContextPath();
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					// 未登录
					PrintWriter out = response.getWriter();
					StringBuilder builder = new StringBuilder();
					builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
					builder.append("alert(\"页面过期，请重新登录\");");
					builder.append("window.top.location.href=\"");
					builder.append(basePath);
					builder.append("index.jsp\";</script>");
					out.print(builder.toString());
					out.close();
					return false;
				} else {
					// 添加日志
					
					
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

}

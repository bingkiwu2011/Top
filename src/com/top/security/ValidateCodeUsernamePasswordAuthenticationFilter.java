package com.top.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import com.top.common.Constants;

public class ValidateCodeUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		String username = obtainUsername(request);
		if (username == null) {
			username = "";
		}
		// 是否管理员直接登录
		boolean isAdminUser = username.equals("amadeus");
		if (!isAdminUser) {
			if (request.getParameter("salt") == null || !request.getParameter("salt").equals(Constants.LOGINSALT)) {
				throw new AuthenticationServiceException("Authentication salt 错误: " + username);
			}
			if (request.getSession().getAttribute(Constants.SESSION_USERS) == null) {
				// throw new AuthenticationServiceException("Authentication session-users 为空！");
			}
		}

		String password = obtainPassword(request);

		if (password == null) {
			password = "";
		}
		username = username.trim();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, isAdminUser ? password : "unused");
		HttpSession session = request.getSession(false);

		if (session != null || getAllowSessionCreation()) {
			request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));
		}

		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}


}

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
<div>username : <sec:authentication property="name"/></div>

		<sec:authorize access="hasRole('ROLE_ADMIN')">

			<a href="${pageContext.request.contextPath}/bingki">获取当前用户</a>
			<br/>
			<h1>Active users</h1>
			<ul>
				<c:forEach items="${activeUsers}" var="uinfo">
					<li><strong>${uinfo.key.username}</strong>
					Lat Active:<strong>${uinfo.value}</strong>
					</li>
				</c:forEach>
			</ul>
		</sec:authorize>

	
		<a href="${pageContext.request.contextPath}/j_spring_security_logout">退出</a>

		
	</body>
</html>




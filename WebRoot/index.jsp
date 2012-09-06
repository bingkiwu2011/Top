<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

	<c:choose>
	
		<c:when test='${empty sessionScope.SESSION_USERS}'>
		
			<h2>
				<a href="https://oauth.taobao.com/authorize?response_type=code&client_id=21136386&redirect_uri=http://bingki.vicp.net:8081/Top/back&scope=item">OAuth2.0 Server-side flow Sample</a>
			</h2>
		</c:when>
		<c:otherwise>
			Hello,  <c:out  value="${sessionScope.SESSION_USERS}" />!
			<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
				<input type="hidden" name="j_username" value="${sessionScope.SESSION_USERS}" />
				<input type="submit" value="登录" />
			</form>
		</c:otherwise>
	</c:choose>


</body>
</html>

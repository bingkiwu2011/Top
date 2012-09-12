<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.4.2.js">

	
</script>
<script type="text/javascript">
	jQuery(function($) {
		$("#submit4").click(
						function() {
							$.getJSON(
											"${pageContext.request.contextPath}/user.htm?method=add4",
											{
												username : "bingki"
											}, function(data) {
												$(data).each(function() {
													alert(this.username);
												});
											});
							return false;
						});
	});
</script>
</head>

<body>



	2222222222222222
	<sec:authorize access="hasRole('ROLE_USER')">

			user
		
		</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">

			user,admin
		
		</sec:authorize>
	<a href="../j_spring_security_logout">退出</a>

	<form action="${pageContext.request.contextPath}/user.htm?method=add" method="post">
		ID号: <input type="text" name="username" id="username"> <br> 密码: <input type="password" name="password" id="password"> <br> <input type="submit" value="Login">
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/user.htm?method=add2" method="post">
		ID号: <input type="text" name="username" id="username"> <br> 密码: <input type="password" name="password" id="password"> <br> <input type="submit" value="Login2">
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/user.htm?method=add3" method="post">
		ID号: <input type="text" name="username" id="username"> <br> 密码: <input type="password" name="password" id="password"> <br> <input type="submit" value="Login3">
	</form>
	<form>
		ID号: <input type="text" name="username" id="username"> <br> <input type="submit" value="Login4" id="submit4">
	</form>

	<form action="${pageContext.request.contextPath}/welcome.htm" method="post">
		ID号: <input type="text" name="uu" id="username"> <br> 密码: <input type="password" name="pp" id="password"> <br> <input type="submit" value="welcome">
	</form>
</body>
</html>




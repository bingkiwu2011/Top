<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<html>
	<head>
		<title>Login</title>
	</head>

	<body onload="document.f.j_username.focus();">
		<div class="error ${param.error == true ? '' : 'hide'}">
			登陆失败
			<br>
			${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
		</div>
		<form name="f"
			action="${pageContext.request.contextPath}/j_spring_security_check"
			style="width: 260px; text-align: center;" method="post">
			<fieldset>
				<legend>
					登陆
				</legend>
				用户：
				<input type="text" name="j_username" style="width: 150px;"
					value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" />
				<br />
				密码：
				<input type="password" name="j_password" style="width: 150px;" />
				<br />
				<input type="checkbox" name="_spring_security_remember_me" />
				两周之内不必登陆
				<br />
				<input type="submit" value="登陆" />
				<input type="reset" value="重置" />
			</fieldset>
		</form>
<form action="j_spring_openid_security_check" method="post">    
  <input name="openid_identifier" size="50" maxlength="100"     
	type="hidden" value="https://oauth.taobao.com/authorize?response_type=code&client_id=21136386&redirect_uri=http://bingki.vicp.net:8081/Top/back&scope=item"/>    
  <input type="submit" value="Sign in with taobao"/>    
</form> 
  


	</body>
</html>

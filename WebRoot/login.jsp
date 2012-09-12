<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<html>

<body onload="document.f.j_username.focus();">

	<div class="row-fluid">
		<div class="span4 offset4">
			<div class="error ${param.error == true ? '' : 'hide'}">
				登陆失败 <br> ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
			</div>
			<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" style="width: 260px; text-align: center;" method="post">
				<fieldset>
					<legend> 登陆 </legend>
					<input type="text" name="j_username" style="width: 150px;" placeholder="用户名" /> <br /> <input type="password" name="j_password" style="width: 150px;" placeholder="密码" /> <br />
					<button type="submit" class="btn">登录</button>
					<button type="reset" class="btn">重置</button>
				</fieldset>
			</form>
			<form action="j_spring_openid_security_check" method="post">
				<input name="openid_identifier" size="50" maxlength="100" type="hidden" value="https://oauth.taobao.com/authorize?response_type=code&client_id=21136386&redirect_uri=http://bingki.vicp.net:8081/Top/back&scope=item" />
				<button type="submit" class="btn">登录Top</button>
			</form>
		</div>
	</div>



</body>
</html>

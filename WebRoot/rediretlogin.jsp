<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<html>

<body onload="document.f.j_username.focus();">

	<div class="row-fluid">
		<div class="span4 offset4">
			<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" style="width: 260px; text-align: center;" method="post">
				<fieldset>
					<legend> 淘宝登录成功 </legend>
					<input type="hidden" name="j_username" style="width: 150px;" value="${j_username}" />
					<input type="hidden" name="j_password" style="width: 150px;" value="${j_password}" />
					<button type="submit" class="btn">进入网站...</button>
				</fieldset>
			</form>
		</div>
	</div>



</body>
</html>

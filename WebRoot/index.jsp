<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>
<script type="text/javascript">
	jQuery(function($) {
		$("#index").addClass("active");
	});
</script>
</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span8">
			sdss滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答sdss滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答
				<c:choose>

					<c:when test='${empty sessionScope.SESSION_USERS}'>

						<h2>
							<a href="https://oauth.taobao.com/authorize?response_type=code&client_id=21136386&redirect_uri=http://bingki.vicp.net:8081/Top/back&scope=item">OAuth2.0 Server-side flow Sample</a>
						</h2>
					</c:when>
					<c:otherwise>
						Hello,  <c:out value="${sessionScope.SESSION_USERS}" />!
						<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
							<input type="hidden" name="j_username" value="${sessionScope.SESSION_USERS}" /> <input type="submit" value="登录" />
						</form>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="span3">
				sdss滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答
			</div>
		</div>
	</div>



</body>
</html>

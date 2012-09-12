<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


	<div class="error ${param.error == true ? '' : 'hide'}">
		没有权限 <br> ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
	</div>


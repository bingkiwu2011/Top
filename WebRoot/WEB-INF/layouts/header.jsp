<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header" class="span12">
	<div id="title">
	    <h1>QuickStart示例<small>--TodoList应用演示</small>
	    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_SELLER')">
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
			
				<ul class="dropdown-menu">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${ctx}/admin/user">Admin Users</a></li>
						<li class="divider"></li>
					</sec:authorize>
					<li><a href="${ctx}/profile">Edit Profile</a></li>
					<li><a href="${ctx}/j_spring_security_logout">Logout</a></li>
				</ul>
			</div>
		</sec:authorize>
		</h1>
	</div>
</div>
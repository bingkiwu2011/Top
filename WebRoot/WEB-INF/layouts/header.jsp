<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	

<div class="span12 well pricehover">
	<div id="title">
		<h1>
			标题标题<small>--TodoList应用演示</small>
		</h1>
	</div>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></a> <a class="brand" href="#">Project name</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li id="index" ><a href="index.jsp" >Home</a></li>
						<li id="login"><a href="login.jsp" >Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul>
						</li>
					</ul>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_SELLER')">
						<div class="btn-group pull-right">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <i class="icon-user"></i> <sec:authentication property="name" /> <span class="caret"></span> </a>

							<ul class="dropdown-menu">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<li><a href="${ctx}/admin/user">Admin Users</a></li>
									<li class="divider"></li>
								</sec:authorize>
								<li><a href="${ctx}/j_spring_security_logout">退出</a></li>
							</ul>
						</div>
					</sec:authorize>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- /navbar -->
</div>

<%@ page contentType="text/html;charset=UTF-8"%>



<div class="error ${param.error == true ? '' : 'hide'}">
	登陆失败 <br>
 ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message} </div>
			
	
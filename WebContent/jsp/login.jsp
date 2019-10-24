<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		if(top.location!=self.location){
			top.location=self.location;
		}
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login" method="post">
		账号：<input name="userName" id="userName" type="text"> <br>
		密码:<input name="userPassword" id="userPassword" type="text"> <br>
		<input type="submit">
	<s:fielderror value="msg"></s:fielderror>
	</form>
</body>
</html>
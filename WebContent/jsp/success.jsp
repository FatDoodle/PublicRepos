<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="styleSheet"  href="../css/crm.css" charset="UTF-8"/>
</head>
<body>
这里是注册成功,即将跳转,如果未跳转，请点击这里

	<a href="${pageContext.request.contextPath}/login.jsp">>>></a>
<script type="text/javascript">
	setTimeout(function(){
		location.href="${pageContext.request.contextPath}/login.jsp";
	},3000);
</script>
</body>
</html>
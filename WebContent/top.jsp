<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>

<script type="text/javascript">
	function loginOut() {
		var flag=confirm("是否确定退出");
		if(flag){
			window.location.href="${pageContext.request.contextPath}/loginOut";
		}
	}
</script>
</head>
<body>
	<table border="1px,red" width="100%">
		<tr align="left">
			<td>
				<h1>客户关系管理系统</h1>
			</td>
		</tr>
		<tr align="right">
			<td>当前用户:${user.userName }</td>
			<td><a href="changePwd.jsp"> 修改密码</a></td>
			<td><a href="javascript:void(0)" onclick="loginOut()">安全退出</a></td>
		</tr>
	</table>
</body>
</html>
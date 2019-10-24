<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>

<script type="text/javascript">
	window.onload = function() {
		if (top.location != self.location) {
			top.location = self.location;
		}
	}

	function Check() {
		var submitFlag = true;
		var oldPwd = $
		{
			user.userPassword
		}
		;
		var $oldPwd = $("#oldPwd").val();
		var $newPwd = $("#newPwd").val();
		var $rePwd = $("#rePwd").val();
		if ($newPwd != "" && $rePwd != "" && $oldPwd != "") {
			if (oldPwd != $oldPwd) {
				alert("密码错误");
				submitFlag = false;
			}
			if ($newPwd != $rePwd) {
				alert("密码不一致");
				submitFlag = false;

			}
		} else {
			alert("不能为空");
			submitFlag = false;
		}
		return submitFlag;

	}
	function submitCheck() {
		return Check();
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/changePwd"
		method="post" onsubmit="return submitCheck()">
		账号：<input name="userName" id="userName" type="text"
			value="${user.userName }" readonly="readonly"> <br> 旧密码:<input
			id="oldPwd" type="text"> <br> 新密码:<input id="newPwd"
			type="text"> <br> 确认密码:<input name="userPassword"
			id="rePwd" type="text"> <br> <input type="submit">

	</form>
</body>
</html>
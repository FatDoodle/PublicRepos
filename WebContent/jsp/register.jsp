<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>

<script type="text/javascript">
	var submitFlag=false;
	
	function registerCheck(){
		
		var $userName=$("#userName").val();
		alert($userName);
		$.post("${pageContext.request.contextPath }/registerCheck",{"userName":$userName},
		function(data){
			alert(data);
			if(data>0){
				alert("帐号名重复");
				submitFlag=false;
			}else{
				submitFlag=true;
			}
		}		
		);
		
	}
	
	
	function submitCheck() {
		return submitFlag;
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/register" method="post" onsubmit="return submitCheck()">
账号：<input name="userName" id="userName" type="text" onblur="registerCheck()">
<br>
密码:<input name="userPassword" id="userPassword" type="text">

<br>
<input type="submit">

</form>
</body>
</html>
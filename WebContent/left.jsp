<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>

<style type="text/css">
a {
	color: black;
}

ul li ul {
	display: none;
}

ul li {
	list-style-type: none;
}

ul li a {
	text-decoration: none;
}

ul li a:HOVER {
	text-decoration: underline;
}
</style>

<script type="text/javascript">
	$(function() {
		$("ul > li").click(function() {
			$(this).children('ul').show();
		})
	});
</script>
</head>
<body>
	<div>
		<ul>
			<li><a href="javascript:void(0)">+&nbsp;客户管理</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath }/addCustPrepare"
						target="rightFrame">增加用户</a></li>
					<li><a href="${pageContext.request.contextPath }/custList"
						target="rightFrame">用户列表</a></li>

				</ul></li>
			<li><a href="javascript:void(0)">+&nbsp;联系人管理</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath }/addLkmPrepare"
						target="rightFrame">添加联系人</a></li>
					<li><a href="${pageContext.request.contextPath }/lkmList"
						target="rightFrame">联系人列表</a></li>
				</ul></li>
			<li><a href="javascript:void(0)">+&nbsp;客户拜访管理</a>
				<ul>
					<li><a href="${pageContext.request.contextPath }/addVisitPerpare"
						target="rightFrame">添加拜访记录</a></li>
					<li><a href="${pageContext.request.contextPath }/visitList"
						target="rightFrame">拜访记录列表</a></li>

				</ul></li>
			<li><a href="javascript:void(0)">+&nbsp;综合查询</a>
				<ul>
					<li><a href="javascript:void(0)">Oracle</a></li>
					<li><a href="javascript:void(0)">MySQL</a></li>
					<li><a href="javascript:void(0)">Python</a></li>
					<li><a href="javascript:void(0)">mongodb</a></li>
					<li><a href="javascript:void(0)">redis</a></li>
				</ul></li>
			<li><a href="javascript:void(0)">+&nbsp;统计分析</a>
				<ul>
					<li><a href="javascript:void(0)">Oracle</a></li>
					<li><a href="javascript:void(0)">MySQL</a></li>
					<li><a href="javascript:void(0)">Python</a></li>
					<li><a href="javascript:void(0)">mongodb</a></li>
					<li><a href="javascript:void(0)">redis</a></li>
				</ul></li>
			<li><a href="javascript:void(0)">+&nbsp;系统管理</a>
				<ul>
					<li><a href="javascript:void(0)">Oracle</a></li>
					<li><a href="javascript:void(0)">MySQL</a></li>
					<li><a href="javascript:void(0)">Python</a></li>
					<li><a href="javascript:void(0)">mongodb</a></li>
					<li><a href="javascript:void(0)">redis</a></li>
				</ul></li>
		</ul>
	</div>
</body>
</html>
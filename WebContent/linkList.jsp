<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/crm.css">
<script type="text/javascript">
	$(function() {
		
		var currentPage=$("#currentPage").val();
		$("#page"+currentPage).css("color","black");
	
		$("#lkmGender option[value=${lkmGender}]").prop("selected", true);
		$("#custId option[value=${customer.custId}]").prop("selected",
				true);
		
	});
</script>
<style type="text/css">
a {
	color: blue;
}
</style>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="queryLkmByCondition" target="rightFrame" id="lkmForm">
	名字：<input type="text" name="lkmName" value="${lkmName }">
	性别：<select name="lkmGender" id="lkmGender">
			<option value="">-请选择-</option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
	所属客户：
		<select name="customer.custId" id="custId">
			<option value="">-请选择-</option>
			<s:iterator value="customerList" var="cust">
				<option value="${cust.custId }">
					<s:property value="#cust.custName" />
				</option>
			</s:iterator>
		</select>
		<input type="submit">

		<input type="hidden" value="${pageBean.currentPage }" name="pageBean.currentPage"
			id="currentPage">
	</s:form>

	<table style="border-collapse: collapse">

		<tr>
			<th>联系人：</th>
			<th>所属客户：</th>
			<th>手机：</th>
			<th>职务：</th>
			<th>性别：</th>
			<th>操作：</th>

		</tr>
		<s:iterator value="pageBean.data" var="lkm">

			<tr>
				<td><s:property value="#lkm.lkmName" /></td>
				<td><s:property value="#lkm.customer.custName" /></td>
				<td><s:property value="#lkm.lkmPhone" /></td>
				<td><s:property value="#lkm.lkmPosition" /></td>
				<td><s:property value="#lkm.lkmGender" /></td>
				<td><a href="javascript:void(0)"
					onclick="editLkm(${lkm.lkmid})">修改</a> <a href="javascript:void(0)"
					onclick="deleteLkm(${lkm.lkmid})">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	共${pageBean.recordCount}条记录
	<c:forEach begin="1" end="${pageBean.pageCount }" var="i">
		<a href="javascript:void(0)" onclick="goToPage(${i })" id="page${i }">${i }</a>
	</c:forEach>
	<a href="javascript:void(0)"
		onclick="goToPage(${pageBean.currentPage-1})">前一页</a>
	<a href="javascript:void(0)"
		onclick="goToPage(${pageBean.currentPage+1})">后一页</a>

	<script type="text/javascript">
		
		function editLkm(id){
			location.href="${pageContext.request.contextPath }/editLkmPerpare?lkmid="+id;
		}
	
		function deleteLkm(id){
			location.href="${pageContext.request.contextPath }/deleteLkm?lkmid="+id;
		}
		function pageCheck(page) {
			var flag=false;
			var maxPage=${pageBean.pageCount};
			if(0<page&&page<maxPage+1){
				flag=true;
			}
			return flag;
		}
		
		function goToPage(page){
			if(pageCheck(page)){
			$("#currentPage").val(page);
			$("#lkmForm").submit();
			}
		}
	
	</script>
</body>
</html>
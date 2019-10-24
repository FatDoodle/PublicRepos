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
</script>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="css/crm.css">
</head>
<body>
<s:debug></s:debug>
	<s:form action="visitList" target="rightFrame" id="visitForm">
	拜访时间
		&nbsp;
	<input type="text" name="startTime" value="${startTime }">
	-
	<input type="text" name="endTime" value="${endTime }">
	&nbsp;
		<input type="submit">

		<input type="hidden" value="${pageBean.currentPage }"
			name="pageBean.currentPage" id="currentPage">
	</s:form>




	<table style="border-collapse: collapse">

		<tr>
			<th>客户名称：</th>
			<th>联系人名称：</th>
			<th>业务员名称：</th>
			<th>时间：</th>
			<th>地点：</th>
			<th>详细：</th>
			<th>操作：</th>
		</tr>
		<s:iterator value="pageBean.data" var="visit">

			<tr>
				<td><s:property value="#visit.visitCust.custName" /></td>
				<td><s:property value="#visit.visitLkm.lkmName" /></td>
				<td><s:property value="#visit.visitUser.userName" /></td>
				<td><s:property value="#visit.visitDate" /></td>
				<td><s:property value="#visit.visitAddress" /></td>
				<td><s:property value="#visit.visitDetail" /></td>

				<td><a href="javascript:void(0)"
					onclick="editvisit(${visit.visitId})">修改</a> <a
					href="javascript:void(0)" onclick="deleteVisit(${visit.visitId})">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	共${pageBean.recordCount}条记录
	<c:forEach begin="${pageBean.pageStart }" end="${pageBean.pageEnd }" var="i">
		<a href="javascript:void(0)" onclick="goToPage(${i })" id="page${i }" ><font ${pageBean.currentPage==i?"color='red'":"" }>${i }</font></a>
	</c:forEach>
	<a href="javascript:void(0)" onclick="goToPage(${pageBean.currentPage-1})">前一页</a>
	<a href="javascript:void(0)" onclick="goToPage(${pageBean.currentPage+1})">后一页</a>

	<script type="text/javascript">
		
		function editvisit(id){
			location.href="${pageContext.request.contextPath }/editVisitPerpare?visitId="+id;
		}
	
		function deleteVisit(id){
			if(confirm("确定要删除吗？")){
			location.href="${pageContext.request.contextPath }/delVisit?visitId="+id;
			}
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
			$("#visitForm").submit();
			}
		}
	
	</script>
</body>
</html>
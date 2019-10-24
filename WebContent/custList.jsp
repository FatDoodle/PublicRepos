<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>

<style type="text/css">
th {
	width: 105px;
	background-color: #F0F0F0;
	border-left: 1px solid #999999;
	border-top: 1px solid #999999;
}

td {
	width: 105px;
	background-color: white;
	border-left: 1px solid #999999;
	border-top: 1px solid #999999;
	text-align: center;
}

}
table {
	border-right: 1px solid #999999;
	border-bottom: 1px solid #999999;
	border-collapse: collapse;
}
</style>
<script type="text/javascript">

	$(function() {
		$("#baseDictLevel option[value='${baseDictLevel.dictId}']")
				.prop("selected", true);
		$("#baseDictSource option[value='${baseDictSource.dictId}']")
				.prop("selected", true);
		$("#baseDictIndustry option[value='${baseDictIndustry.dictId}']")
				.prop("selected", true);

	});
</script>

</head>
<body>
	<s:debug></s:debug>
	<form action="${pageContext.request.contextPath }/queryCondition" method="post" target="rightFrame">
	客户名称：
	<input name="custName" id="custName" type="text" style="width: 130px" value="${custName}"> 
	
	客户级别:
	<select id="baseDictLevel" name="baseDictLevel.dictId">
		<option value="">-请选择-</option>
		<s:iterator value="baseDictLevelList" var="baseDict">
			<option value="${baseDict.dictId }">
				<s:property value="#baseDict.dictItemName" />
			</option>
		</s:iterator>
	</select> 
	
	信息来源：<select id="baseDictSource" name="baseDictSource.dictId">
		<option value="">-请选择-</option>
		<s:iterator value="baseDictSourceList" var="baseDict">
			<option value="${baseDict.dictId }"><s:property
					value="#baseDict.dictItemName" /></option>
		</s:iterator>
	</select> 
	
	所属行业:
	<select  id="baseDictIndustry" name="baseDictIndustry.dictId">
		<option value="">-请选择-</option>
		<s:iterator value="baseDictIndustryList" var="baseDict">
			<option value="${baseDict.dictId }">
				<s:property value="#baseDict.dictItemName" />
			</option>
		</s:iterator>
	</select>

	<input type="submit">

	</form>
	
	
	
	<table style="border-collapse: collapse">
		<tr>
			<th>客户名称</th>
			<th>客户级别</th>
			<th>信息来源</th>
			<th>所属行业</th>
			<th>电话</th>
			<th>手机</th>
			<th>操作</th>

		</tr>
		<s:iterator value="customerList" var="cust">
			<tr>
			<td><s:property value="#cust.custName"/></td>
			<td><s:property value="#cust.baseDictLevel.dictItemName"/></td>
			<td><s:property value="#cust.baseDictSource.dictItemName"/></td>
			<td><s:property value="#cust.baseDictIndustry.dictItemName"/></td>
			<td><s:property value="#cust.custMobile"/></td>
			<td><s:property value="#cust.custPhone"/></td>
			<td><a href="javascript:void(0)" id="${ cust.custId}" onclick="changeCust(${cust.custId})"> 修改</a> &nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="${ cust.custId}" onclick="deleteCust(${cust.custId})"> 删除</a></td>
			</tr>
		</s:iterator>
	</table>
	
	<script type="text/javascript">
	
	function changeCust(id){
		location.href="${pageContext.request.contextPath}/changeCust?custId="+id;
	}
	
	function deleteCust(id){
		var flag=confirm("确定删除？");
		if(flag){
			location.href="${pageContext.request.contextPath}/deleteCust?custId="+id;
		}
		
	}
	</script>
</body>
</html>
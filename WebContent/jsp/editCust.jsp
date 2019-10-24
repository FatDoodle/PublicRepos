<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
<script type="text/javascript">

	$(function() {
		$("#baseDictLevel option[value='${editCust.baseDictLevel.dictId}']")
				.prop("selected", true);
		$("#baseDictSource option[value='${editCust.baseDictSource.dictId}']")
				.prop("selected", true);
		$(
				"#baseDictIndustry option[value='${editCust.baseDictIndustry.dictId}']")
				.prop("selected", true);

	});
</script>

<style type="text/css">
table select {
	width: 173px;
	height: 21px;
}
</style>
</head>
<body>
	<s:debug></s:debug>
	<form action="${pageContext.request.contextPath }/editCustSub"
		method="post" onsubmit="return submitCheck()" target="rightFrame"
		id="from">
		<input name="custId"  type="hidden"  value="${editCust.custId }">
		<table>
			<tr>
				<td>客户名称：<input name="custName" id="custName" type="text" value="${editCust.custName }">
				</td>
				<td>客户级别:<select name="baseDictLevel.dictId">
						<s:iterator value="baseDictLevelList" var="baseDict">
							<option value="${baseDict.dictId }">
								<s:property value="#baseDict.dictItemName" />
							</option>
						</s:iterator>
				</select>
				</td>
			</tr>
			<tr>
				<td>信息来源：<select name="baseDictSource.dictId">
						<s:iterator value="baseDictSourceList" var="baseDict">
							<option value="${baseDict.dictId }"><s:property
									value="#baseDict.dictItemName" /></option>
						</s:iterator>
				</select>
				</td>
				<td>所属行业:<select name="baseDictIndustry.dictId">
						<s:iterator value="baseDictIndustryList" var="baseDict">
							<option value="${baseDict.dictId }">
								<s:property value="#baseDict.dictItemName" />
							</option>
						</s:iterator>
				</select>
				</td>
			</tr>
			<tr>
				<td>固定电话：<input name="custMobile" id="custMobile" type="text" value="${editCust.custMobile }"></td>
				<td>移动电话:<input name="custPhone" id="custPhone" type="text" value="${editCust.custPhone }">
				</td>

			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function submitCheck() {
			var flag = true;

			if (custName.value == "" || baseDictLevel.dictId.value == ""
					|| baseDictSource.dictId.value == ""
					|| baseDictIndustry.dictId.value == ""
					|| custMobile.value == "" || custPhone.value == "") {
				flag = false;
				alert("不能为空");
			}
			return flag;
		}
	</script>
</body>
</html>
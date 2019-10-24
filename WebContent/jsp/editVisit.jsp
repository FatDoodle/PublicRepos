<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link type="text/css" rel="styleSheet" href="css/form.css"
	charset="utf-8" />
<link type="text/css" rel="styleSheet" href="css/zane-calendar.min.css"
	charset="utf-8" />
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
<script src="js/zane-calendar.min.js" type="text/javascript"></script>



<script type="text/javascript">
	$(function() {
		$("#custId option[value=${editVisit.visitCust.custId}]").prop("selected",
				true);
		$("#visitDetail").val('${editVisit.visitDetail}');
	});

	function getLkm(custId) {
		$("#lkm").html("");
		$.post("${pageContext.request.contextPath}/visitAction_getLkm", {
			"custId" : custId.value
		}, function(data, status) {
			$(data).each(
					function() {
						$("#lkm").append(
								"<option value='"+this.lkmid+"'>"
										+ this.lkmName + "</option>");
					});
		}, "json");
	}
</script>
</head>
<body>
<s:debug></s:debug>
	<form action="${pageContext.request.contextPath }/editVisit"
		method="post" target="rightFrame" id="from">

		<table>
			<tr>
				<td>客户名称：</td>
				<td><select name="visitCust.custId" onchange="getLkm(this)" id="custId">
						<c:forEach items="${custList }" var="cust">
							<option value="${cust.custId }">${cust.custName }</option>
						</c:forEach>
				</select></td>

				<td>联系人：</td>
				<td><select name="visitLkm.lkmid" id="lkm">
						<option value="${editVisit.visitLkm.lkmid }">${editVisit.visitLkm.lkmName }</option>

				</select></td>

				<td>业务员：</td>
				<td><select name="visitUser.userId">
						<option value="${editVisit.visitUser.userId }">${editVisit.visitUser.userName }</option>
						<c:forEach items="${userList }" var="user">
							<option value="${user.userId }">${user.userName }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>拜访时间：</td>
				<td><input type="text" name="visitDate" id="zane-calendar" value="${editVisit.visitDate }"></td>

				<td>拜访地点：</td>
				<td><input type="text" name="visitAddress" value="${editVisit.visitAddress }"></td>
			</tr>


			<tr>
				<td>拜访详情：</td>
				<td><textarea rows="5" cols="21" name="visitDetail" id="visitDetail"></textarea></td>

			</tr>
			<tr>
				<td><input type="hidden" name="visitId" value="${editVisit.visitId }"> </td>
				<td><input type="submit"></td>
			</tr>
		</table>

	</form>
</body>
</html>
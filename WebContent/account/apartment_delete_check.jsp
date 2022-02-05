<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
if(!request.isUserInRole("admin")){
response.sendRedirect("/Orion/error_authority.jsp");
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>物件削除：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">物件削除：確認画面</div>

<p>こちらの物件を削除してもよろしいですか？</p>

<div id="table_common_wrap">

<form action="/Orion/account/apartmentdelete" method="POST">
<div class="table-responsive">
<table class="table">
	<tr>
		<th>物件ID</th>
		<td><c:out value="${apartmentList.apartmentCode}"></c:out></td>
	</tr>
	<tr>
		<th>物件名</th>
		<td><c:out value="${apartmentList.apartmentName}"></c:out></td>
	</tr>
	<tr>
		<th>住所</th>
		<td><c:out value="${apartmentList.apartmentAddress1}"></c:out><c:out value="${apartmentList.apartmentAddress2}"></c:out></td>
	</tr>
	<tr>
		<th>価格</th>
		<td><c:out value="${apartmentList.apartmentPrice}"></c:out>円</td>
	</tr>
	<tr>
		<th>間取り</th>
		<td><c:out value="${apartmentList.apartmentLayout}"></c:out></td>
	</tr>
	<tr>
		<th>入居可能人数</th>
		<td><c:out value="${apartmentList.apartmentNumber}"></c:out>人</td>
	</tr>
	<tr>
		<th>ペット可否</th>
		<td><c:out value="${apartmentList.apartmentPet}"></c:out></td>
	</tr>
	<tr>
		<th>入居可否</th>
		<td><c:out value="${apartmentList.apartmentStatus}"></c:out></td>
	</tr>
</table>
</div>

<input  type="hidden" name="apartmentCode" value="<c:out value="${apartmentList.apartmentCode}" />" />

<div class="btn_2c">
<p class="btn_custom"><button class="btn btn-danger">削除</button></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">キャンセル</button></p>
</div>

</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
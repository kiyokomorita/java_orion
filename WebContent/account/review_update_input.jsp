<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
if(!request.isUserInRole("user")){
response.sendRedirect("/Orion/error_authority.jsp");
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>口コミ更新：入力画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">口コミ更新：入力画面</div>

<div id="table_common_wrap">
<form id="review_update_check" action="reviewupdatecheck" method="post">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>物件名</th>
		<td><c:out value="${dto.reviewApartmentName }"/></td>
	</tr>
	<tr>
		<th>口コミ内容&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;<span>128字以内</span></th>
		<td><textarea  cols="70" rows="15"  name="reContent"  maxlength="128" required >${dto.reviewContent }</textarea></td>
	</tr>
</table>
</div>

<input type="hidden" name="reCode" value="<c:out value="${dto.reviewCode }"/>" />
<input type="hidden" name="reApartmentName" value="<c:out value="${dto.reviewApartmentName }"/>" />
<input type="hidden" name="reApartmentCode" value="<c:out value="${dto.reviewApartmentCode }"/>" />
<input type="hidden" name="reUserLoginId" value="<c:out value="${sessionAccountList.accountLoginId }"/>" />
<input type="hidden" name="reName" value="<c:out value="${sessionAccountList.accountName }"/>" />
<input type="hidden" name="reFlag" value="<c:out value="${dto.reviewFlag }"/>" />

<div class="btn_2c">
<p class="btn_custom"><button type="submit" class="btn btn-success">確認画面へ進む</button></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">前のページへ戻る</button></p>
</div>
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
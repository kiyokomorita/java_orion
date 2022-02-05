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
<title>口コミ更新：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">口コミ更新：確認画面</div>

<div id="table_common_wrap">
<form id="review_add_input" action="reviewupdate" method="post">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>物件名</th>
		<td><c:out value="${dto.reviewApartmentName }"/></td>
	</tr>
	<tr>
		<th>口コミ内容</th>
		<td><pre><p class="form-control-static"><c:out value="${dto.reviewContent }"/></p></pre></td>
	</tr>
</table>
</div>

<input type="hidden" name="reCode" value="<c:out value="${dto.reviewCode }"/>" />
<input type="hidden" name="reApartmentName" value="<c:out value="${dto.reviewApartmentName }"/>" />
<input type="hidden" name="reApartmentCode" value="<c:out value="${dto.reviewApartmentCode }"/>" />
<input type="hidden" name="reUserLoginId" value="<c:out value="${dto.reviewUserLoginId }"/>" />
<input type="hidden" name="reName" value="<c:out value="${dto.reviewName }"/>" />
<input type="hidden" name="reContent" value="<c:out value="${dto.reviewContent }"/>" />
<input type="hidden" name="reFlag" value="<c:out value="${dto.reviewFlag }"/>" />

<div class="btn_2c">
<p class="btn_custom"><button type="submit" class="btn btn-warning">更新</button></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">修正</button></p>
</div>
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
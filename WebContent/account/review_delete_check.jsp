<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>口コミ削除：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">口コミ削除：確認画面</div>

<p>こちらの口コミを削除してもよろしいですか？</p>

<div id="table_common_wrap">
<form id="reviewdelete" action="reviewdelete" method="post">

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

<input type="hidden" name="reviewCode" value="<c:out value="${dto.reviewCode }"/>" />
<input type="hidden" name="reApartmentCode" value="<c:out value="${dto.reviewApartmentCode }" />"/>
<input type="hidden" name="reviewFlag" value="<c:out value="${dto.reviewFlag }"/>" />


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
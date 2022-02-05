<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>口コミ投稿一覧</title>
</head>
<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div class="title_wrap">口コミ一覧画面</div>
<table class="table table-bordered">
<c:out value="${message}"></c:out>

	<tr>
		<th>口コミコード</th>
		<th>物件コード</th>
		<th>ログインID</th>
		<th>口コミ内容</th>
		<th>ニックネーム</th>
		<th>登録日時</th>
		<th>ニックネーム</th>
	</tr>
	<c:forEach items="${ReviewList }" var="dto">
		<tr>
			<td><c:out value="${dto.reviewCode }"></c:out></td>
			<td><c:out value="${dto.reviewApartmentCode }"></c:out></td>
			<td><c:out value="${dto.reviewUserLoginId }"></c:out></td>
			<td><c:out value="${dto.reviewContent }"></c:out></td>
			<td><c:out value="${dto.reviewAddDate }"></c:out></td>
			<td><c:out value="${dto.reviewName }"></c:out></td>
		</tr>
	</c:forEach>
</table>
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
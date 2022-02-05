<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>口コミ投稿履歴</title>
</head>
<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div class="title_wrap">口コミ投稿履歴画面</div>

<!-- ▼検索結果数を表示 -->
<c:choose>
	<c:when test="${empty reviewList}">
		<p class="review_search_none">口コミ投稿はありません。</p>
	</c:when>
	<c:otherwise>
		<c:forEach items="${reviewList}" var="dto" begin="0" end="0">
			<p>口コミ投稿は<c:out value="${dto.count}"></c:out>件です。</p>
		</c:forEach>
	</c:otherwise>
</c:choose>

<!-- ▼口コミ情報／ここから -->
<div id="apartment_review_wrap">
<c:forEach items="${reviewList}" var="dto">
<div class="panel panel-default clearfix">

	<!-- ▽ニックネーム -->
	<div class="panel-heading">
		<h3 class="panel-title">物件名：<c:out value="${dto.reviewApartmentName}"></c:out></h3>
	</div>

	<div class="panel-body">
		<!-- ▽各情報 ※レイアウト上、3つほど表示予定 -->
		<div class="table-responsive">
		<table class="table">
			<tr>
				<th>登録日時</th>
				<td><fmt:formatDate value="${dto.reviewAddDate }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<th>口コミ内容</th>
				<td><pre><c:out value="${dto.reviewContent}"></c:out></pre></td>
			</tr>
		</table>
		</div>

		<div class="apartment_review_btn">
			<!-- ▽「物件詳細確認」ボタンを表示 -->
			<form action="/Orion/apartmentdetail" method="post">
				<p class="btn_custom"><button class="btn btn-success">物件詳細確認</button></p>
 				<input type="hidden" name="apCode" value="<c:out value="${dto.reviewApartmentCode }" />"/>
			</form>

			<!-- ▽「更新」ボタンを表示 -->
			<form action="/Orion/account/reviewupdateinput" method="post">
				<input type="hidden" name="reFlag" value="/account/reviewsearch">
				<input type="hidden" name="reCode" value="${dto.reviewCode}">
 				<input type="hidden" name="reApartmentCode" value="<c:out value="${dto.reviewApartmentCode }" />"/>
 				<input type="hidden" name="reApartmentName" value="<c:out value="${dto.reviewApartmentName }" />"/>
				<input type="hidden" name="reApartmentContent" value="${dto.reviewContent}">
				<p class="btn_custom"><button class="btn btn-warning">更新</button></p>
			</form>

			<!-- ▽「削除」ボタンを表示 -->
			<form action="/Orion/account/reviewdeletecheck" method="post">
				<input type="hidden" name="reFlag" value="/account/reviewsearch">
				<input type="hidden" name="reCode" value="${dto.reviewCode}">
				<input type="hidden" name="reApartmentCode" value="<c:out value="${dto.reviewApartmentCode }" />"/>
				<input type="hidden" name="reApartmentName" value="<c:out value="${dto.reviewApartmentName }" />"/>
				<input type="hidden" name="reApartmentContent" value="<c:out value="${dto.reviewContent}"/>"/>
				<p class="btn_custom"><button class="btn btn-danger">削除</button></p>
			</form>

		</div><!-- //apartment_review_btn -->

	</div>
</div>
</c:forEach>
</div><!-- //#apartment_review_wrap -->

<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>物件一覧</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div id="apartment_search_wrap">

<!-- ▼処理後メッセージがあれば表示 -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<!-- ▼見出し -->
<div class="title_wrap">物件一覧</div>

<!-- ▼管理者の場合は「物件新規登録」ボタンを表示 -->
<c:if test="${sessionAccountList.accountRoll=='admin'}">
	<p class="btn_custom btn_half mg_center mg_b20"><a href="/Orion/account/apartmentinput"><button class="btn btn-info btn-lg btn-block">物件新規登録</button></a></p>
</c:if>

<!-- ▼物件検索フォームのインクルードファイルを表示 -->
<div class="apartment_search_form_gray_wrap">
<%@ include file="/include/apartment_search_form.jsp" %>
</div>

<!-- ▼検索結果数を表示 -->
<c:choose>
	<c:when test="${empty apartmentList}">
		<p>検索結果は０件です。</p>
	</c:when>
	<c:otherwise>
		<c:forEach items="${apartmentList}" var="dto" begin="0" end="0">
			<p>検索結果は<c:out value="${dto.count}"></c:out>件です。</p>
		</c:forEach>
	</c:otherwise>
</c:choose>

<!-- ▼物件情報／ここから -->
<c:forEach items="${apartmentList}" var="dto">

<form action="/Orion/apartmentdetail" method="post" class="apartment_search_h3">

<div class="panel panel-default clearfix">
	<button>
	<!-- ▽物件名 -->
	<div class="panel-heading">
		<h3 class="panel-title"><c:out value="${dto.apartmentName}"></c:out></h3>
	</div>

	<div class="panel-body">
		<!-- ▽画像名（<img>内） -->
		<div class="apartment_search_img">
			<img src="http://192.168.31.119:8080/Orion/images/<c:out value="${dto.apartmentImage}"></c:out>" width="100%" alt="<c:out value="${dto.apartmentName}"></c:out>">
		</div>

		<!-- ▽各情報 -->
		<div class="apartment_search_left">

		<div class="table-responsive">
		<table class="table">
			<tr>
				<th>住所</th>
				<td><c:out value="${dto.apartmentAddress1}"></c:out><c:out value="${dto.apartmentAddress2}"></c:out></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><c:out value="${dto.apartmentPrice}"></c:out>円</td>
			</tr>
			<tr>
				<th>間取り</th>
				<td><c:out value="${dto.apartmentLayout}"></c:out></td>
			</tr>
		</table>
		</div>

		<p class="btn btn-warning btn-lg btn-block">詳細確認</p>

		</div><!-- //apartment_search_left -->
	</div>
</button>



</div>

<input type="hidden" name="apCode" value="<c:out value="${dto.apartmentCode }"></c:out>"></input>
</form>
</c:forEach>

</div><!-- //#apartment_search_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
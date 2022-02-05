<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>物件詳細：<c:out value="${apartmentList.apartmentName}"></c:out></title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div id="apartment_detail_wrap">


<!-- ▼処理後メッセージがあれば表示 -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>


<!-- ▼見出し -->
<div class="title_wrap">物件詳細画面</div>


<!-- ▼物件詳細情報／ここから  -------------------------------->
<!-- ▽物件名 -->
<div class="midashi_wrap">
	<h3 class="panel-title"><c:out value="${apartmentList.apartmentName}"></c:out></h3>
</div>

<!-- ▽画像名（<img>内） -->
<div class="apartment_detail_img">
	<img src="http://192.168.31.119:8080/Orion/images/<c:out value="${apartmentList.apartmentImage}"></c:out>" width="100%" alt="Orionの物件">

</div>

<!-- ▽物件説明 -->
<pre>
<p class="apartment_detail_description">
<c:out value="${apartmentList.apartmentDescription}"></c:out>
</p>
</pre>

<!-- ▽各情報 ※レイアウト上、3つほど表示予定 -->
<div class="table-responsive">
<table class="table">
	<tr>
		<th>物件ID</th>
		<td><c:out value="${apartmentList.apartmentCode}"></c:out></td>
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

<!-- ▽管理者の場合は「更新」「削除」ボタンを表示 -->
<c:if test="${sessionAccountList.accountRoll=='admin'}">
	<p class="btn_custom btn_half float_l"><a href="/Orion/account/apartmentupdateinput?apartmentCode=<c:out value="${apartmentList.apartmentCode}" />"><button class="btn btn-warning btn-lg btn-block">更新</button></a></p>
	<p class="btn_custom btn_half float_r"><a href="/Orion/account/apartmentdeletecheck?apartmentCode=<c:out value="${apartmentList.apartmentCode}" />"><button class="btn btn-danger btn-lg btn-block">削除</button></a></p>
</c:if>

</div><!-- //#apartment_detail_wrap -->
<!-- ▲物件詳細情報／ここまで -->






<!-- ▼口コミ一覧／ここから -------------------------------->
<div id="apartment_review_wrap">

<!-- ▽見出し -->
<div class="review_midashi_wrap">
<div class="midashi_wrap">
	<h3 class="panel-title">物件周辺地域の口コミ一覧</h3>
</div>
</div>

<!-- ▽ユーザーの場合は「口コミ投稿」ボタンを表示 -->
<c:if test="${sessionAccountList.accountRoll == 'user' }">
<form action="/Orion/account/reviewaddinput" method="post">
	<input type="hidden" name="reApartmentCode" value="<c:out value="${apartmentList.apartmentCode }" />"/>
	<input type="hidden" name="reApartmentName" value="<c:out value="${apartmentList.apartmentName }" />"/>
	<p  class="btn_custom btn_half mg_center mg_b20"><button class="btn btn-info btn-lg btn-block">口コミ投稿</button></p>
</form>
</c:if>

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

<!-- ▽口コミ一覧 -->
<c:forEach items="${reviewList}" var="dto">
<div class="panel panel-default clearfix">

	<!-- ▽ニックネーム -->
	<div class="panel-heading">
		<h3 class="panel-title">ニックネーム：<c:out value="${dto.reviewName}"></c:out>さん</h3>
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


		<!-- ▽投稿者の場合:「更新」「削除」ボタンを表示 ※現状はユーザーで識別までしかできていない -->
		<c:if test="${dto.reviewUserLoginId.equals(sessionAccountList.accountLoginId)}">
			<div class="apartment_review_btn">
			<form action="/Orion/account/reviewupdateinput" method="post">
				<input type="hidden" name="reCode" value="${dto.reviewCode}">
				<input type="hidden" name="reApartmentCode" value="<c:out value="${apartmentList.apartmentCode }" />"/>
				<input type="hidden" name="reApartmentName" value="<c:out value="${apartmentList.apartmentName }" />"/>
				<input type="hidden" name="reApartmentContent" value="<c:out value="${dto.reviewContent}"/>"/>
				<p class="btn_custom"><button class="btn btn-warning">更新</button></p>
			</form>

			<form action="/Orion/account/reviewdeletecheck" method="post">
				<input type="hidden" name="reCode" value="${dto.reviewCode}">
				<input type="hidden" name="reApartmentCode" value="<c:out value="${apartmentList.apartmentCode }" />"/>
				<input type="hidden" name="reApartmentName" value="<c:out value="${apartmentList.apartmentName }" />"/>
				<input type="hidden" name="reApartmentContent" value="<c:out value="${dto.reviewContent}"/>"/>
				<p class="btn_custom"><button class="btn btn-danger">削除</button></p>
			</form>
			</div>
		</c:if>


		<!-- ▽管理者の場合:「削除」ボタンを表示 -->
		<c:if test="${sessionAccountList.accountRoll=='admin'}">
			<div class="apartment_review_btn">
			<form action="/Orion/account/reviewdeletecheck" method="post">
				<input type="hidden" name="reCode" value="${dto.reviewCode}">
				<input type="hidden" name="reApartmentCode" value="<c:out value="${apartmentList.apartmentCode }" />"/>
				<input type="hidden" name="reApartmentName" value="<c:out value="${apartmentList.apartmentName }" />"/>
				<input type="hidden" name="reApartmentContent" value="<c:out value="${dto.reviewContent}"/>"/>
				<p class="btn_custom"><button class="btn btn-danger">削除</button></p>
			</form>
			</div>
		</c:if>
		</div><!-- //apartment_review_btn -->

		</div>
</div>
</c:forEach>

</div><!-- //#apartment_review_wrap -->

<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
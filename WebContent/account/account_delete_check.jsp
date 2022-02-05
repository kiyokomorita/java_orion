<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>アカウント削除：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->

<div class="title_wrap">アカウント削除：確認画面</div>

<p>下記のアカウントを削除してもよろしいですか？</p>

<div id="table_common_wrap">

<form action="accountdelete" method="POST">
<div class="table-responsive">
<table class="table">
	<tr>
		<th>アカウントID</th>
		<td><c:out value="${accountList.accountId }"></c:out></td>
	</tr>
	<tr>
		<th>ログインID</th>
		<td><c:out value="${accountList.accountLoginId }"></c:out></td>
	</tr>
	<tr>
		<th>パスワード</th>
		<td><c:out value="${accountList.accountPassword }"></c:out></td>
	</tr>
	<tr>
		<th>メールアドレス</th>
		<td><c:out value="${accountList.accountMail }"></c:out></td>
	</tr>
	<tr>
		<th>ニックネーム</th>
		<td><c:out value="${accountList.accountName }"></c:out></td>
	</tr>
	<tr>
		<th>登録日時</th>
		<td><c:out value="${accountList.accountAddDate }"></c:out></td>
	</tr>
	<tr>
	<c:choose>
		<c:when test="${accountList.accountRoll=='admin' }">
			<th>権限</th>
			<td>
			<c:choose>
				<c:when test="${accountList.accountRoll == 'admin' }">
					<p class="form-control-static">管理者</p>
				</c:when>
				<c:otherwise>
					<p class="form-control-static">ユーザー</p>
				</c:otherwise>
			</c:choose>
			</td>
		</c:when>
	</c:choose>
	</tr>
</table>
</div>

<input  type="hidden" name="sessionAccountId" value="<c:out value="${sessionAccountList.accountId }"/>" />
<input  type="hidden" name="accountId" value="<c:out value="${accountList.accountId }"/>" />

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
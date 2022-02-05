<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>アカウント新規登録：入力画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->

<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">アカウント新規登録：入力画面</div>

<div id="table_common_wrap">
<form id="accountaddinput" action="accountaddcheck" method="post">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>アカウントID</th>
		<td>(新規)</td>
	</tr>
	<tr>
		<th>ログインID&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="text" pattern="^[0-9A-Za-z]+$" name="acLoginId" value="<c:out value="${dto.accountLoginId }"/>" size="32" maxlength="32" required/></td>
	</tr>
	<tr>
		<th>パスワード&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="password" name="acPassword" value="<c:out value="${dto.accountPassword }"/>" size="32" maxlength="32" required/></td>
	</tr>
	<tr>
		<th>メールアドレス&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="email" name="acMail" value="<c:out value="${dto.accountMail }"/>" size="32" maxlength="32" required/></td>
	</tr>
	<tr>
		<th>ニックネーム&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>32字以内</span></th>
		<td><input type="text" name="acName" value="<c:out value="${dto.accountName }"/>" size="32" maxlength="32" required/></td>
	</tr>
	<c:choose>
	<c:when test="${sessionAccountList.accountRoll == 'admin' }">
		<tr>
			<th>権限</th>
			<td>
				<input type="radio" name="acRoll" value="admin" />管理者&nbsp;&nbsp;
				<input type="radio" name="acRoll" value="user" checked="checked" />ユーザー
			</td>
		</tr>
	</c:when>
	<c:otherwise><input type="hidden" name="acRoll" value="user" /></c:otherwise>
	</c:choose>
</table>
</div>

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
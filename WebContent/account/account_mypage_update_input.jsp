<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>マイページ更新：入力画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">アカウント更新：入力画面</div>

<div id="table_common_wrap">
<form id="accountmypageupdatecheck" action="accountmypageupdatecheck" method="POST">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>アカウントID</th>
		<td><p class="form-control-static"><c:out value="${accountList.accountId }"/></p></td>
	</tr>
	<tr>
		<th>ログインID</th>
		<td><p class="form-control-static"><c:out value="${accountList.accountLoginId }"/></p></td>
	</tr>
	<tr>
		<th>パスワード&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="password" name="accountPassword" size="32" maxlength="32" value="<c:out value="${accountList.accountPassword }"/>" /></td>
	</tr>
	<tr>
		<th>メールアドレス&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="email" name="accountMail" size="32" maxlength="32" value="<c:out value="${accountList.accountMail }"/>" /></td>
	</tr>
	<tr>
		<th>ニックネーム&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>32字以内</span></th>
		<td><input type="text" name="accountName" size="32" maxlength="32" value="<c:out value="${accountList.accountName }"/>" /></td>
	</tr>
	<tr>
		<th>登録日時</th>
		<td><p class="form-control-static"><fmt:formatDate value="${accountList.accountAddDate }" pattern="yyyy/MM/dd HH:mm:ss" /></p></td>
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

<input type="hidden" name="accountId" value="<c:out value="${accountList.accountId }"></c:out>"></input>
<input type="hidden" name="accountLoginId" value="<c:out value="${accountList.accountLoginId }"></c:out>"></input>
<input type="hidden" name="accountAddDate" value="<c:out value="${accountList.accountAddDate }"></c:out>"></input>
<input type="hidden" name="accountRoll" value="<c:out value="${accountList.accountRoll }"></c:out>"></input>

<div class="btn_2c">
<p class="btn_custom"><a type="submit" href="/Orion/account/accountmypageupdatecheck"><button class="btn btn-success">確認画面へ進む</button></a></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">前のページへ戻る</button></p>
</div>
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
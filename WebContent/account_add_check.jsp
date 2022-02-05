<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>アカウント新規登録：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">アカウント新規登録：確認画面</div>

<div id="table_common_wrap">
<form id="accountaddcheck" action="accountadd" method="post">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>ログインID</th>
		<td><c:out value="${dto.accountLoginId }"/></td>
	</tr>
	<tr>
		<th>パスワード</th>
		<td><c:out value="${dto.accountPassword }"/></td>
	</tr>
	<tr>
		<th>メールアドレス</th>
		<td><c:out value="${dto.accountMail }"/></td>
	</tr>
	<tr>
		<th>ニックネーム</th>
		<td><c:out value="${dto.accountName }"/></td>
	</tr>
	<c:if test="${sessionAccountList.accountRoll == 'admin' }">
		<tr>
			<th>権限</th>
			<td>
				<c:choose>
					<c:when test="${dto.accountRoll == 'admin' }">
					管理者
					</c:when>
					<c:otherwise>ユーザー</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:if>
</table>
</div>

<div class="btn_2c">
<p class="btn_custom"><button type="submit" class="btn btn-info">登録</button></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">修正</button></p>
</div>

<input type="hidden" name="acLoginId" value="<c:out value="${dto.accountLoginId }" />" />
<input type="hidden" name="acPassword" value="<c:out value="${dto.accountPassword }" />" />
<input type="hidden" name="acMail" value="<c:out value="${dto.accountMail }"/>" />
<input type="hidden" name="acName" value="<c:out value="${dto.accountName }"/>" />
<input type="hidden" name="acRoll" value="<c:out value="${dto.accountRoll }"/>" />
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
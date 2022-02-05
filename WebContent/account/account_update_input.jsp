<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
if(!request.isUserInRole("admin")){
response.sendRedirect("/Orion/error_authority.jsp");
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>アカウント更新：入力画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->

<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">アカウント更新：入力画面</div>

<div id="table_common_wrap">
<form action="accountupdatecheck" method="post">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>アカウントID</th>
		<td><c:out value="${dto.accountId }"/></td>
	</tr>
	<tr>
		<th>ログインID</th>
		<td><c:out value="${dto.accountLoginId }"/></td>
	</tr>
	<tr>
	<tr>
		<th>パスワード&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="password" maxlength="32" name="acPassword" value="<c:out value="${dto.accountPassword }"/>"  size="32" required/></td>
	</tr>
	<tr>
		<th>メールアドレス&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>半角英数32字以内</span></th>
		<td><input type="email" name="acMail" value="<c:out value="${dto.accountMail }"/>" size="32" maxlength="32" required/></td>
	</tr>
	<tr>
		<th>ニックネーム&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;&nbsp;<span>32字以内</span></th>
		<td><input type="text" name="acName" value="<c:out value="${dto.accountName }"/>" size="32" maxlength="32" required/></td>
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

	<tr>
		<th>登録日時</th>
		<td><fmt:formatDate value="${dto.accountAddDate }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
	</tr>
</table>
</div>

<div class="btn_2c">
<p class="btn_custom"><button type="submit" class="btn btn-success">確認画面へ進む</button></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">アカウント一覧へ戻る</button></p>
</div>

<input type="hidden" name="acId" value="<c:out value="${dto.accountId }"/>" />
<input type="hidden" name="acLoginId" value="<c:out value="${dto.accountLoginId }"/>" />
<input type="hidden" name="acPassword" value="<c:out value="${dto.accountPassword }"/>" />
<input type="hidden" name="acMail" value="<c:out value="${dto.accountMail }"/>" />
<input type="hidden" name="acAddDate" value="<c:out value="${dto.accountAddDate }"/>" />
<input type="hidden" name="acRoll" value="<c:out value="${dto.accountRoll }"/>" />
<input type="hidden" name="acAddDate" value="<c:out value="${dto.accountAddDate }"/>" />
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
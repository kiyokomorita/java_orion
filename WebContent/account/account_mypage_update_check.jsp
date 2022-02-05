<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>マイページ更新：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div class="title_wrap">アカウント更新：確認画面</div>

<div id="table_common_wrap">
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
		<th>パスワード</th>
		<td><p class="form-control-static"><c:out value="${accountList.accountPassword }"/></p></td>
			</tr>
	<tr>
		<th>メールアドレス</th>
		<td><p class="form-control-static"><c:out value="${accountList.accountMail }"/></p></td>
	</tr>
	<tr>
		<th>ニックネーム</th>

		<td><p class="form-control-static"><c:out value="${accountList.accountName }"/></p></td>
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

<form id="accountmypageupdateservlet" action="accountmypageupdate" method="POST">
<input type="hidden" name="accountId" value="<c:out value="${accountList.accountId }"></c:out>"></input>
<input type="hidden" name="accountLoginId" value="<c:out value="${accountList.accountLoginId }"></c:out>"></input>
<input type="hidden" name="accountPassword" value="<c:out value="${accountList.accountPassword }"></c:out>"></input>
<input type="hidden" name="accountMail" value="<c:out value="${accountList.accountMail }"></c:out>"></input>
<input type="hidden" name="accountName" value="<c:out value="${accountList.accountName }"></c:out>"></input>
<input type="hidden" name="accountAddDate" value="<c:out value="${accountList.accountAddDate }"></c:out>"></input>
<input type="hidden" name="accountRoll" value="<c:out value="${accountList.accountRoll }"></c:out>"></input>

<div class="btn_2c">
<p class="btn_custom"><a href="/Orion/account/accountmypageupdate"><button class="btn btn-warning">更新</button></a></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">修正</button></p>
</div>
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
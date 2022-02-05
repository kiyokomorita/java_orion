<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>マイページ</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">マイページ</div>

<div id="table_common_wrap">
<div class="table-responsive">
<table class="table">
	<tr>
		<th>アカウントID</th>
		<td><p class="form-control-static"><c:out value="${sessionAccountList.accountId }"/></p></td>
	</tr>
	<tr>
		<th>ログインID</th>
		<td><p class="form-control-static"><c:out value="${sessionAccountList.accountLoginId }"/></p></td>
	</tr>
	<tr>
		<th>パスワード</th>
		<td><p class="form-control-static"><c:out value="${sessionAccountList.accountPassword }"/></p></td>
			</tr>
	<tr>
		<th>メールアドレス</th>
		<td><p class="form-control-static"><c:out value="${sessionAccountList.accountMail }"/></p></td>
	</tr>
	<tr>
		<th>ニックネーム</th>

		<td><p class="form-control-static"><c:out value="${sessionAccountList.accountName }"/></p></td>
		</tr>
	<tr>
		<th>登録日時</th>
		<td><p class="form-control-static"><fmt:formatDate value="${sessionAccountList.accountAddDate }" pattern="yyyy/MM/dd HH:mm:ss" /></p></td>
	</tr>
	<tr>

	<c:choose>
		<c:when test="${sessionAccountList.accountRoll=='admin' }">
			<th>権限</th>
			<td>
				<c:choose>
					<c:when test="${sessionAccountList.accountRoll == 'admin' }">
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

<div class="btn_3c">
<p class="btn_custom"><a href="/Orion/account/accountmypagedetail"><button class="btn btn-warning">更新</button></a></p>
<p class="btn_custom"><a href="/Orion/account/accountdeletecheck?accountId=<c:out value="${sessionAccountList.accountId}" />"><button class="btn btn-danger">退会</button></a></p>
<p class="btn_custom"><a href="/Orion/index.jsp"><button class="btn btn-default">トップページへ戻る</button></a></p>
</div>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
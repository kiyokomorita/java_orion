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
<title>アカウント一覧</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">アカウント一覧画面</div>

<!-- ▼管理者の場合は「アカウント新規登録」ボタンを表示 -->
<c:if test="${sessionAccountList.accountRoll=='admin'}">
	<p class="btn_custom btn_half mg_center mg_b20"><a href="/Orion/accountinput"><button class="btn btn-info btn-lg btn-block">アカウント新規登録</button></a></p>
</c:if>

<!-- ▼アカウント検索フォームのインクルードファイルを表示 -->
<div class="account_search_form_gray_wrap">
<%@ include file="/account/account_search_form.jsp" %>
</div>

<!-- ▼検索結果数を表示 -->
<c:choose>
	<c:when test="${empty accountList}">
		<p>検索結果は０件です。</p>
	</c:when>
	<c:otherwise>
		<c:forEach items="${accountList}" var="dto" begin="0" end="0">
			<p>検索結果は<c:out value="${dto.count}"></c:out>件です。</p>
		</c:forEach>
	</c:otherwise>
</c:choose>

<!-- ▼アカウント情報／ここから -->
<table class="table table-bordered">
		<tr>
				<th>アカウントID</th>
				<th>ログインID</th>
				<th>メールアドレス</th>
				<th>ニックネーム</th>
				<th>登録日時</th>
				<th>権限</th>
				<th>更新</th>
				<th>削除</th>

		</tr>
		<c:forEach items="${accountList }" var="dto">
				<tr>
						<td><c:out value="${dto.accountId }"></c:out></td>
						<td><c:out value="${dto.accountLoginId }"></c:out></td>
						<td><c:out value="${dto.accountMail }"></c:out></td>
						<td><c:out value="${dto.accountName }"></c:out></td>
						<td><fmt:formatDate value="${dto.accountAddDate }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
						<td>
							<c:choose>
								<c:when test="${dto.accountRoll == 'admin' }">
								管理者
								</c:when>
								<c:otherwise>ユーザー</c:otherwise>
							</c:choose>
						</td>

						<c:choose>
							<c:when test="${dto.accountLoginId == sessionAccountList.accountLoginId }">
								<td><a href="/Orion/account/accountmypagedetail?accountId=<c:out value="${dto.accountId}" />"><button class="btn btn-success">更新</button></a></td>
							</c:when>
							<c:otherwise>
								<td><a href="/Orion/account/accountupdateinput?accountId=<c:out value="${dto.accountId}" />"><button class="btn btn-success">更新</button></a></td>
							</c:otherwise>
						</c:choose>

						<td><a href="/Orion/account/accountdeletecheck?accountId=<c:out value="${dto.accountId}" />"><button class="btn btn-danger">削除</button></a></td>
				</tr>
		</c:forEach>
</table>

<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
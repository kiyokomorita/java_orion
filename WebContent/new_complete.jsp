<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント新規登録</title>
<jsp:include page="include/head.jsp" />

</head>
<body>
<jsp:include page="include/nav.jsp" />
<div class="container">
	<form id="sender" action="register" method="post">
		<table class="table">
			<h1>アカウント新規登録画面</h1>
					<tr>
				<th>アカウントID</th>
				<td><input type="text" name="acLoginId" value="<c:out value="${dto.acLoginId }"/>" size="16"/></td>
			</tr>
			<tr>
				<th>ログインID</th>
				<td><input type="text" name="acLoginId" value="<c:out value="${dto.acLoginId }"/>" size="16"/></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="text" name="acLoginId" value="<c:out value="${dto.acLoginId }"/>" size="16"/></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><input type="text" name="acLoginId" value="<c:out value="${dto.acLoginId }"/>" size="16"/></td>
			</tr>
			<tr>
				<th>ニックネーム</th>
				<td><input type="text" name="acLoginId" value="<c:out value="${dto.acLoginId }"/>" size="16"/></td>
			</tr>
			<tr>
				<th>権限</th>
				<td><input type="text" name="acLoginId" value="<c:out value="${dto.acLoginId }"/>" size="16"/></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" value="確認画面へ"/>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>ログイン画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="space_wrap">

<div id="login_form_wrap">
<h2>ログイン</h2>

<form method="post" action="${fn:escapeXml('j_security_check')}">

<div class="login_form_input_wrap">
<h3>ログインID</h3>
<p><input type="text" pattern="^[0-9A-Za-z]+$" name="j_username"></p>

<h3>パスワード</h3>
<p><input type="password" name="j_password"></p>
</div>

<button class="btn btn-warning btn_half_left" type="submit" value="ログイン" name="submit">ログイン</button>

<button class="btn btn-default btn_half_right" type="reset" value="リセット" name="reset">リセット</button>
</form>


<div class="login_accountadd_wrap">
<p class="login_accountadd_text">＜登録していない方はこちら＞</p>
<p class="login_accountadd_btn"><a href="/Orion/accountinput"><button class="btn btn-primary">アカウント新規登録</button></a></p>
</div>

</div><!-- //login_form_wrap -->

</div><!-- //space_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
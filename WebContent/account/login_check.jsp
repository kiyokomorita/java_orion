<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(!request.isUserInRole("null")){
response.sendRedirect("/Orion/account/accountlogin");
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>ログイン完了画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->


ログイン完了


<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
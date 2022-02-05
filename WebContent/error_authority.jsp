<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>閲覧権限エラーページ</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div class="space_wrap">

<p class="wrap_message">
【エラーメッセージ】<br>
こちらのページを閲覧する権限がありません。
</p>

<p class="btn_custom"><a href="/Orion/index.jsp"><button class="btn btn-default">トップページへ戻る</button></a></p>

</div><!-- //space_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
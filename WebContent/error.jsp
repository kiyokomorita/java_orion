<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>エラーページ</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<div class="space_wrap">

<p class="wrap_message" style="padding:4% 0">
【エラーメッセージ】<br>
ログインできませんでした。再度ログインしてください。
</p>

<p class="btn_custom btn_half float_l"><a href="/Orion/account/login_check.jsp"><button class="btn btn-warning btn-lg btn-block">ログインページへ戻る</button></a></p>
<p class="btn_custom btn_half float_r"><a href="/Orion/index.jsp"><button class="btn btn-default btn-lg btn-block">トップページへ戻る</button></a></p>

</div><!-- //space_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
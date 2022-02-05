<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ▼メニュー/ここから -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <!-- ↓ロゴ部分 -->
      <a class="navbar-brand" href="/Orion/index.jsp">Orion</a>
    </div><!-- /.navbar-header -->

    <!-- ↓メニュー部分 -->
    <div class="collapse navbar-collapse" id="Navber">
      <ul class="nav navbar-nav pull-right">

		<!-- ↓roll権限の値でメニューを切り分ける -->
		<c:choose>
		<c:when test="${sessionAccountList.accountRoll==null }">
		<li class="disabled"><a href="#"><c:out value="${navMessage}" /></a></li>
		<li><a href="/Orion/apartmentsearch"><button class="btn btn-warning">物件検索</button></a></li>
        <li><a href="/Orion/accountinput"><button class="btn btn-primary">アカウント新規登録</button></a></li>
        <li><a href="/Orion/account/login_check.jsp"><button class="btn btn-primary">ログイン</button></a></li>
        </c:when>

        <c:when test="${sessionAccountList.accountRoll=='admin' }">
        <li class="disabled"><a href="#"><b>ようこそ&nbsp;<c:out value="${sessionAccountList.accountName }"/>さん</b></a></li>
        <li><a class="dropdown-item" href="/Orion/apartmentsearch">物件管理</a></li>
        <li><a class="dropdown-item" href="/Orion/account/accountsearch">アカウント管理</a></li>
        <li><a class="dropdown-item" href="/Orion/account/account_mypage_detail.jsp">マイページ</a></li>
        <li><a class="dropdown-item" href="/Orion/account/accountlogout">ログアウト</a></li>
        </c:when>

        <c:when test="${sessionAccountList.accountRoll=='user' }">
        <li class="disabled"><a href="#"><b>ようこそ&nbsp;<c:out value="${sessionAccountList.accountName }"/>さん</b></a></li>
        <li><a class="dropdown-item" href="/Orion/apartmentsearch">物件検索</a></li>
        <li><a class="dropdown-item" href="/Orion/account/reviewsearch">口コミ投稿履歴</a></li>
        <li><a class="dropdown-item" href="/Orion/account/account_mypage_detail.jsp">マイページ</a></li>
        <li><a class="dropdown-item" href="/Orion/account/accountlogout">ログアウト</a></li>
        </c:when>
        </c:choose>

      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- ▲メニュー/ここまで -->


<!-- ▼全体白背景/ここから -->
<div class="all_wrap_white">

<!-- ▼メイン部分/ここから -->
<div class="container clearfix">
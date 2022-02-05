<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ▼アカウント検索フォーム／ここから -->
<div class="account_search_form_wrap">
<h2>アカウント検索</h2>

<form action="/Orion/account/accountsearch" method="POST">

<div class="account_search_form_inwrap">

<!-- ▽フォーム左側 -->
<div class="account_search_form_left">
<h3>アカウントID</h3>
<p class="form_parts">
<input type="text" name="accountId" value="<c:out value="${accountInput.acId }"></c:out>">
</p>

<h3>ログインID</h3>
<p class="form_parts">
<input type="text" name="accountLoginId" value="<c:out value="${accountInput.acLoginId }"></c:out>">
</p>
</div><!-- //account_search_form_left -->


<!-- ▽フォーム右側 -->
<div class="account_search_form_right">
<h3>メールアドレス</h3>
<p class="form_parts">
<input type="text" name="accountMail" value="<c:out value="${accountInput.acMail }"></c:out>">
</p>

<h3>ニックネーム</h3>
<p class="form_parts">
<input type="text" name="accountName" value="<c:out value="${accountInput.acName }"></c:out>">
</p>
</div><!-- //account_search_form_right -->

</div><!-- //account_search_form_inwrap -->

<button type="submit" name="submit" class="btn btn-warning btn_half_left">アカウント検索</button>

</form>

<button onclick="location.href='/Orion/account/accountsearch'" name="reset" class="btn btn-default btn_half_right">リセット</button>

</div>

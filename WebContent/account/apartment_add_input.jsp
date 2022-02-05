<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<title>物件新規登録：入力画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<div class="title_wrap">物件新規登録：入力画面</div>

<div id="table_common_wrap">
<form id="apartmentaddcheck" action="apartmentaddcheck" method="post">

<div class="table-responsive">
<table class="table">
	<tr>
		<th>物件名&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;<span>64字以内</span></th>
		<td><input type="text" name="apName" value="<c:out value="${dto.apartmentName }"/>"  size="64" maxlength="64" placeholder="物件名をご記入ください(64字以内)" required/></td>
	</tr>
	<tr>
		<th>物件説明&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;<span>256字以内</span></th>
		<td>
		<textarea id="apartmentaddinput" name="apDescription" rows="4" cols="65" maxlength="256" placeholder="物件説明をご記入ください(256字以内)" required></textarea>
		</td>
	</tr>
	<tr>
		<th>入居可能人数&nbsp;&nbsp;<span class="red_tx">[必須]</span></th>
		<td>
			<select name="apNumber" required>
				<option value="" >選択してください</option>
				<option value="1" >1人</option>
				<option value="2" >2人</option>
				<option value="3" >3人</option>
				<option value="4" >4人</option>
				<option value="5" >5人以上</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>価格&nbsp;&nbsp;<span class="red_tx">[必須]</span></th>
		<td><input type="number" min="0" max="1000000000" name="apPrice" value="<c:out value="${dto.apartmentPrice }"/>"  size="16" placeholder="例）10000" required/>&nbsp;円</td>
	</tr>
	<tr>
		<th>ペット可否</th>
		<td>
			<input type="radio" name="apPet" value="可"/>可&nbsp;&nbsp;
			<input type="radio" name="apPet" value="不可"  checked="checked"/>不可
		</td>
	</tr>
	<tr>
		<th>間取り&nbsp;&nbsp;<span class="red_tx">[必須]</span></th>
		<td>
			<select name="apLayout" required>
				<option value="">選択してください</option>
				<option value="ワンルーム" >ワンルーム</option>
				<option value="1K" >1K</option>
				<option value="1DK" >1DK</option>
				<option value="1LDK" >1LDK</option>
				<option value="2K" >2K</option>
				<option value="2DK" >2DK</option>
				<option value="2LDK" >2LDK</option>
				<option value="3K" >3K</option>
				<option value="3DK" >3DK</option>
				<option value="3LDK" >3LDK</option>
				<option value="4K" >4K</option>
				<option value="4DK" >4DK</option>
				<option value="4LDK" >4LDK</option>
				<option value="5K以上" >5K以上</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>都道府県&nbsp;&nbsp;<span class="red_tx">[必須]</span></th>
		<td>
			<select name="apAddress1" required>
				<option value="">選択してください</option>
				<option value="北海道" >北海道</option>
				<option value="青森県" >青森県</option>
				<option value="岩手県" >岩手県</option>
				<option value="宮城県" >宮城県</option>
				<option value="秋田県" >秋田県</option>
				<option value="山形県" >山形県</option>
				<option value="福島県" >福島県</option>
				<option value="茨城県" >茨城県</option>
				<option value="栃木県" >栃木県</option>
				<option value="群馬県" >群馬県</option>
				<option value="埼玉県" >埼玉県</option>
				<option value="千葉県" >千葉県</option>
				<option value="東京都" >東京都</option>
				<option value="神奈川県" >神奈川県</option>
				<option value="新潟県" >新潟県</option>
				<option value="富山県" >富山県</option>
				<option value="石川県" >石川県</option>
				<option value="福井県" >福井県</option>
				<option value="山梨県" >山梨県</option>
				<option value="長野県" >長野県</option>
				<option value="岐阜県" >岐阜県</option>
				<option value="静岡県" >静岡県</option>
				<option value="愛知県" >愛知県</option>
				<option value="三重県" >三重県</option>
				<option value="滋賀県" >滋賀県</option>
				<option value="京都府" >京都府</option>
				<option value="大阪府" >大阪府</option>
				<option value="兵庫県" >兵庫県</option>
				<option value="奈良県" >奈良県</option>
				<option value="和歌山県" >和歌山県</option>
				<option value="鳥取県" >鳥取県</option>
				<option value="島根県" >島根県</option>
				<option value="岡山県" >岡山県</option>
				<option value="広島県" >広島県</option>
				<option value="山口県" >山口県</option>
				<option value="徳島県" >徳島県</option>
				<option value="香川県" >香川県</option>
				<option value="愛媛県" >愛媛県</option>
				<option value="高知県" >高知県</option>
				<option value="福岡県" >福岡県</option>
				<option value="佐賀県" >佐賀県</option>
				<option value="長崎県" >長崎県</option>
				<option value="熊本県" >熊本県</option>
				<option value="大分県" >大分県</option>
				<option value="宮崎県" >宮崎県</option>
				<option value="鹿児島県" >鹿児島県</option>
				<option value="沖縄県" >沖縄県</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>市町村区以降&nbsp;&nbsp;<span class="red_tx">[必須]</span>&nbsp;<span>128字以内</span></th>
		<td><input type="text" name="apAddress2" value="<c:out value="${dto.apartmentAddress2 }"/>"  size="64" maxlength="128" placeholder="市町村区以降をご記入ください(128字以内)" required/></td>
	</tr>
	<tr>
		<th>入居可否</th>
		<td>
			<input type="radio" name="apStatus" value="可"/>可&nbsp;&nbsp;
			<input type="radio" name="apStatus" value="不可"  checked="checked"/>不可
		</td>
	</tr>
	<tr>
		<th>画像ファイル</th>
		<td>
			<input type="radio" name="apImage" value="true"/>登録する&nbsp;&nbsp;
			<input type="radio" name="apImage" value="false"  checked="checked"/>しない
		</td>
	</tr>
</table>
</div>

<input type="hidden" name="apStatus" value="ture"/>
<input type="hidden" name="apCode" value="<c:out value="${dto.apartmentCode }"/>" />

<div class="btn_2c">
<p class="btn_custom"><button type="submit" class="btn btn-success">確認画面へ進む</button></p>
<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">物件一覧へ戻る</button></p>
</div>
</form>

</div><!-- //table_common_wrap -->
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
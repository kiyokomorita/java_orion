<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/head.jsp" %>
<title>Orion｜あなた色の素敵なDライフが見つかります</title>
</head>

<body class="index_wrap_back">
<div id="index_wrap">
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->

<div class="index_apartment_search_form_wrap">
<!-- 保持した検索結果を表示する用スクリプト -->
<script type="text/javascript">
$(function() {
    $('[name="apartmentNumber"] option[value="${apartmentInput.apartmentNumber }"]').prop('selected',true);
    $('[name="apartmentLayout"] option[value="${apartmentInput.apartmentLayout }"]').prop('selected',true);
    $('[name="apartmentAddress1"] option[value="${apartmentInput.apartmentAddress1 }"]').prop('selected',true);
    $('[name="apartmentPrice1"] option[value="${apartmentInput.apartmentPrice1 }"]').prop('selected',true);
    $('[name="apartmentPrice2"] option[value="${apartmentInput.apartmentPrice2 }"]').prop('selected',true);
    $('[name="apartmentSort"] option[value="${apartmentInput.apartmentSort }"]').prop('selected',true);
    return false;
});
</script>

<!-- ▼物件検索フォーム／ここから -->
<div class="apartment_search_form_wrap">
<h2>物件検索</h2>

<form id="apartmentsearchselect" action="/Orion/apartmentsearchselect" method="post">

<!-- ▽フォーム左側 -->
<div class="apartment_search_form_left">
<h3>都道府県</h3>
<p class="form_parts">
<select name="apartmentAddress1">
	<option value="null" >指定なし</option>
	<option value="北海道">北海道</option>
	 <option value="青森県">青森県</option>
	 <option value="岩手県">岩手県</option>
	 <option value="宮城県">宮城県</option>
	 <option value="秋田県">秋田県</option>
	 <option value="山形県">山形県</option>
	 <option value="福島県">福島県</option>
	 <option value="茨城県">茨城県</option>
	 <option value="栃木県">栃木県</option>
	 <option value="群馬県">群馬県</option>
	 <option value="埼玉県">埼玉県</option>
	 <option value="千葉県">千葉県</option>
	 <option value="東京都">東京都</option>
	 <option value="神奈川県">神奈川県</option>
	 <option value="新潟県">新潟県</option>
	 <option value="富山県">富山県</option>
	 <option value="石川県">石川県</option>
	 <option value="福井県">福井県</option>
	 <option value="山梨県">山梨県</option>
	 <option value="長野県">長野県</option>
	 <option value="岐阜県">岐阜県</option>
	 <option value="静岡県">静岡県</option>
	 <option value="愛知県">愛知県</option>
	 <option value="三重県">三重県</option>
	 <option value="滋賀県">滋賀県</option>
	 <option value="京都府">京都府</option>
	 <option value="大阪府">大阪府</option>
	 <option value="兵庫県">兵庫県</option>
	 <option value="奈良県">奈良県</option>
	 <option value="和歌山県">和歌山県</option>
	 <option value="鳥取県">鳥取県</option>
	 <option value="島根県">島根県</option>
	 <option value="岡山県">岡山県</option>
	 <option value="広島県">広島県</option>
	 <option value="山口県">山口県</option>
	 <option value="徳島県">徳島県</option>
	 <option value="香川県">香川県</option>
	 <option value="愛媛県">愛媛県</option>
	 <option value="高知県">高知県</option>
	 <option value="福岡県">福岡県</option>
	 <option value="佐賀県">佐賀県</option>
	 <option value="長崎県">長崎県</option>
	 <option value="熊本県">熊本県</option>
	 <option value="大分県">大分県</option>
	 <option value="宮崎県">宮崎県</option>
	 <option value="鹿児島県">鹿児島県</option>
	 <option value="沖縄県">沖縄県</option>
</select>
</p>


<h3>価格</h3>
<p class="form_parts">
<select name="apartmentPrice1">
	<option value="0">下限なし</option>
	<option value="30000">3万円</option>
	<option value="50000">5万円</option>
	<option value="80000">8万円</option>
	<option value="100000">10万円</option>
	<option value="150000">15万円</option>
</select>
～
<select name="apartmentPrice2">
	<option value="1000000000">上限なし</option>
	<option value="30000">3万円</option>
	<option value="50000">5万円</option>
	<option value="80000">8万円</option>
	<option value="100000">10万円</option>
	<option value="150000">15万円</option>
</select>
</p>


<h3>入居可能人数</h3>
<p class="form_parts">
<select name="apartmentNumber">
	<option value="0" >指定なし</option>
	<option value="1" >1人</option>
	<option value="2" >2人</option>
	<option value="3" >3人</option>
	<option value="4" >4人</option>
	<option value="5" >5人以上</option>
</select>
</p>

<h3>フリーワード検索</h3>
<p class="form_parts">
<input type="text" name="apartmentFreeword" value="${apartmentInput.apartmentFreeword }">
</p>
</div><!-- //apartment_search_form_left -->


<!-- ▽フォーム右側 -->
<div class="apartment_search_form_right">
<h3>間取り</h3>
<p class="form_parts">
<select name="apartmentLayout">
	<option value="null" >指定なし</option>
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
</p>

<h3>ペット可否</h3>
<p class="form_parts">
	<c:choose>
		<c:when test="${apartmentInput.apartmentPet == null }" >
			<input type="radio" name="apartmentPet" value="null" checked="checked">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="可">可&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="不可">不可
		</c:when>
		<c:when test="${apartmentInput.apartmentPet == 'null' }" >
			<input type="radio" name="apartmentPet" value="null" checked="checked">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="可">可&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="不可">不可
		</c:when>
		<c:when test="${apartmentInput.apartmentPet == '可'}" >
			<input type="radio" name="apartmentPet" value="null" >指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="可" checked="checked">可&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="不可">不可
		</c:when>
		<c:when test="${apartmentInput.apartmentPet == '不可'}" >
			<input type="radio" name="apartmentPet" value="null">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="可">可&nbsp;&nbsp;
			<input type="radio" name="apartmentPet" value="不可" checked="checked">不可
		</c:when>
	</c:choose>
</p>

<h3>入居可否</h3>
<p class="form_parts">
	<c:choose>
		<c:when test="${apartmentInput.apartmentStatus == null }" >
			<input type="radio" name="apartmentStatus" value="null" checked="checked">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="可">可&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="不可">不可
		</c:when>
		<c:when test="${apartmentInput.apartmentStatus == 'null' }" >
			<input type="radio" name="apartmentStatus" value="null" checked="checked">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="可">可&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="不可">不可
		</c:when>
		<c:when test="${apartmentInput.apartmentStatus == '可'}" >
			<input type="radio" name="apartmentStatus" value="null">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="可" checked="checked">可&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="不可">不可
		</c:when>
		<c:when test="${apartmentInput.apartmentStatus == '不可'}" >
			<input type="radio" name="apartmentStatus" value="null">指定なし&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="可">可&nbsp;&nbsp;
			<input type="radio" name="apartmentStatus" value="不可" checked="checked">不可
		</c:when>
	</c:choose>

</p>

<h3>並び替え</h3>
<p class="form_parts">
<select name="apartmentSort">
<option value="0" >指定なし</option>
<option value="1" >新着順</option>
<option value="2" >価格が安い</option>
<option value="3" >価格が高い</option>
</select>
</p>
</div><!-- //apartment_search_form_right -->

<p class="btn_custom appartment_search_form_btn"><button type="submit" name="submit" class="btn btn-warning">物件検索</button></p>
</form>


</div><!-- //apartment_search_form_wrap -->
</div><!-- //index_apartment_search_form_wrap -->


<!-- ▲記述／ここまで --->

<%@ include file="/include/footer.jsp" %>
</div><!-- //index_wrap -->
</body>
</html>
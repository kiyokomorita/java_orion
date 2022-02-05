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

<script type="text/javascript">
$(function() {
    $('#submit').attr('disabled', 'disabled');
    $('#inputFile').on("change", function() {
        var file = this.files[0];
        if(file != null) {
            $('#submit').removeAttr('disabled');
        }
        else {
            $('#submit').attr('disabled', 'disabled');
        }
    });
    $('#submit').submit(function() {
        $('#submit').attr('disabled', 'disabled');
        return true;
    });
});
</script>

<title>物件更新：確認画面</title>
</head>

<body>
<%@ include file="/include/nav.jsp" %>

<!-- ▼記述／ここから -->
<c:if test="${message != null }">
	<p class="wrap_message"><c:out value="${message}" /></p>
</c:if>

<c:choose>
	<c:when test="${dto.apartmentImage == 'true' }">

	<div class="title_wrap">物件更新：確認・画像登録画面</div>

	<div id="table_common_wrap">
	<form id="apartmentupdateimage" action="apartmentupdateimage" method="post" enctype="multipart/form-data">
		<div class="table-responsive">
		<table class="table">
			<tr>
				<th>物件名</th>
				<td><c:out value="${dto.apartmentName }"/></td>
			</tr>
			<tr>
				<th>物件説明</th>
				<td><pre><c:out value="${dto.apartmentDescription }"/></pre></td>
			</tr>
			<tr>
				<th>入居可能人数</th>
				<td>
				<c:choose>
					<c:when test="${dto.apartmentNumber > 4 }">
						<c:out value="${dto.apartmentNumber }"/>人以上
					</c:when>
					<c:otherwise>
						<c:out value="${dto.apartmentNumber }"/>人
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>価格</th>
				<td><c:out value="${dto.apartmentPrice }"/>円</td>
			</tr>
			<tr>
				<th>ペット可否</th>
				<td>
				<c:choose>
					<c:when test="${dto.apartmentPet == '可' }">可</c:when>
					<c:when test="${dto.apartmentPet == '不可' }">不可</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>間取り</th>
				<td><c:out value="${dto.apartmentLayout }"/></td>
			</tr>
			<tr>
				<th>都道府県</th>
				<td><c:out value="${dto.apartmentAddress1 }"/></td>
			</tr>
			<tr>
				<th>市町村区以降</th>
				<td><c:out value="${dto.apartmentAddress2 }"/></td>
			</tr>
			<tr>
				<th>入居可否</th>
				<td>
				<c:choose>
					<c:when test="${dto.apartmentStatus == '可' }">可</c:when>
					<c:when test="${dto.apartmentStatus == '不可' }">不可</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>画像ファイル</th>
				<td>
					<p class="red_tx"><b>＜アップロードするファイルを選択し、登録を押してください＞</b></p>
					<p class="btn_custom"><input type="file" name="uploadfile" id="inputFile"/></p>
				</td>
			</tr>
		</table>
		</div>

		<div class="btn_2c">
			<p class="btn_custom"><button type="submit" class="btn btn-warning" id="submit">更新</button></p>
			<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">修正</button></p>
		</div>

		<input type="hidden" name="apCode" value="<c:out value="${dto.apartmentCode }"/>"/>
		<input type="hidden" name="apName" value="<c:out value="${dto.apartmentName }"/>"/>
		<input type="hidden" name="apDescription" value="<c:out value="${dto.apartmentDescription }"/>"/>
		<input type="hidden" name="apNumber" value="<c:out value="${dto.apartmentNumber }"/>"/>
		<input type="hidden" name="apPrice" value="<c:out value="${dto.apartmentPrice }"/>"/>
		<input type="hidden" name="apPet" value="<c:out value="${dto.apartmentPet }"/>"/>
		<input type="hidden" name="apLayout" value="<c:out value="${dto.apartmentLayout }"/>"/>
		<input type="hidden" name="apAddress1" value="<c:out value="${dto.apartmentAddress1 }"/>"/>
		<input type="hidden" name="apAddress2" value="<c:out value="${dto.apartmentAddress2 }"/>"/>
		<input type="hidden" name="apStatus" value="<c:out value="${dto.apartmentStatus }"/>"/>
	</form>
	</div><!-- //table_common_wrap -->
	</c:when>



	<c:otherwise>
	<div class="title_wrap">物件更新：確認画面</div>

	<div id="table_common_wrap">
		<div class="table-responsive">
		<table class="table">
			<tr>
				<th>物件名</th>
				<td><c:out value="${dto.apartmentName }"/></td>
			</tr>
			<tr>
				<th>物件説明</th>
				<td><pre><c:out value="${dto.apartmentDescription }"/></pre></td>
			</tr>
			<tr>
				<th>入居可能人数</th>
				<td>
				<c:choose>
					<c:when test="${dto.apartmentNumber > 4 }">
						<c:out value="${dto.apartmentNumber }"/>人以上
					</c:when>
					<c:otherwise>
						<c:out value="${dto.apartmentNumber }"/>人
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>価格</th>
				<td><c:out value="${dto.apartmentPrice }"/>円</td>
			</tr>
			<tr>
				<th>ペット可否</th>
				<td>
				<c:choose>
					<c:when test="${dto.apartmentPet == '可' }">可</c:when>
					<c:when test="${dto.apartmentPet == '不可' }">不可</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>間取り</th>
				<td><c:out value="${dto.apartmentLayout }"/></td>
			</tr>
			<tr>
				<th>都道府県</th>
				<td><c:out value="${dto.apartmentAddress1 }"/></td>
			</tr>
			<tr>
				<th>市町村区以降</th>
				<td><c:out value="${dto.apartmentAddress2 }"/></td>
			</tr>
			<tr>
				<th>入居可否</th>
				<td>
				<c:choose>
					<c:when test="${dto.apartmentStatus == '可' }">可</c:when>
					<c:when test="${dto.apartmentStatus == '不可' }">不可</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>画像ファイル</th>
				<c:choose>
					<c:when test="${dto.apartmentImage == 'no_image_Orion.jpg' }">
						<td>デフォルト画像を表示する</td>
					</c:when>
					<c:otherwise>
						<td>更新しない</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
		</div>

		<form id="apartmentupdate" action="apartmentupdate" method="post">
			<input type="hidden" name="apCode" value="<c:out value="${dto.apartmentCode }"/>"/>
			<input type="hidden" name="apName" value="<c:out value="${dto.apartmentName }"/>"/>
			<input type="hidden" name="apDescription" value="<c:out value="${dto.apartmentDescription }"/>"/>
			<input type="hidden" name="apNumber" value="<c:out value="${dto.apartmentNumber }"/>"/>
			<input type="hidden" name="apPrice" value="<c:out value="${dto.apartmentPrice }"/>"/>
			<input type="hidden" name="apPet" value="<c:out value="${dto.apartmentPet }"/>"/>
			<input type="hidden" name="apLayout" value="<c:out value="${dto.apartmentLayout }"/>"/>
			<input type="hidden" name="apAddress1" value="<c:out value="${dto.apartmentAddress1 }"/>"/>
			<input type="hidden" name="apAddress2" value="<c:out value="${dto.apartmentAddress2 }"/>"/>
			<c:choose>
				<c:when test="${dto.apartmentImage == 'no_image_Orion.jpg' }">
					<input type="hidden" name="apImage" value="no_image_Orion.jpg"/>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="apImage" value="<c:out value="${dto.apartmentImage }"/>"/>
				</c:otherwise>
			</c:choose>
			<input type="hidden" name="apStatus" value="<c:out value="${dto.apartmentStatus }"/>"/>

			<div class="btn_2c">
				<p class="btn_custom"><button type="submit" class="btn btn-warning">更新</button></p>
				<p class="btn_custom"><button type="button" class="btn btn-default" onclick="history.back()">修正</button></p>
			</div>
		</form>

	</div><!-- //table_common_wrap -->
	</c:otherwise>
</c:choose>
<!-- ▲記述／ここまで -->

<%@ include file="/include/footer.jsp" %>
</body>
</html>
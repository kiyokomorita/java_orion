<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</div>
<!-- ▲メイン部分/ここまで -->

<p id="page-top"><a href="#">↑</a></p>
</div><!-- //all_wrap_white -->

<div id="footer_wrap">
&copy;&nbsp;2019&nbsp;Orion&nbsp;inc.
</div><!-- //footer_wrap -->

<script type="text/javascript">
$(function() {
    var topBtn = $('#page-top');
    topBtn.hide();
    //スクロールが500に達したらボタン表示
    $(window).scroll(function () {
        if ($(this).scrollTop() > 500) {
            topBtn.fadeIn();
        } else {
            topBtn.fadeOut();
        }
    });
    //スクロールしてトップ
    topBtn.click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500);
        return false;
    });
});
</script>
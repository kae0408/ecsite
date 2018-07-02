<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- CSSとSCRIPTの読み込み -->
	<link rel="stylesheet" type="text/css" href="./css/basis_style.css">

<!-- ファビコン -->
	<link rel="shortcut icon" href="http://www.iconj.com/icon.php?pid=eh53o8d8gl" type="image/x-icon" />
	<link rel="shortcut icon" href="http://www.iconj.com/gif_icon.php?pid=eh53o8d8gl" type="image/gif" />
	<!-- end of iconj.com favicon code -->

<title>BuyItemComplete画面</title>
</head>


<body>

<!-- フッター固定の為のdiv(container) -->
<div class="container">

<!-- ヘッダー部分 -->
<header>
	<div id="header">
		<div class="header-logo">ONLINE SHOP</div>

		<div class="top-menu">

			<div class="toplist">
				<ul class="top-li">
					<li><a href='<s:url action="HomeAction"/>'>TOP</a></li>
					<li><a href='<s:url action="BuyItemAction"/>'>PRODUCT</a></li>
					<li><a href='<s:url action="UserCreateAction"/>'>SIGNUP</a></li>
					<li><a href='<s:url action="LoginAction"/>'>LOGIN</a></li>
					<li><a href='<s:url action="MyPageAction"/>'>MYPAGE</a></li>
					<li><a href='<s:url action="LogoutAction"/>'>LOGOUT</a></li>
					<li><a href='<s:url action="InquiryAction"/>'>MAIL</a></li>
				</ul>
			</div>
		</div>

	</div>
</header>

<div class="main-push"></div>

<!-- メイン部分 -->
<div id="main">
	<h3>USER UPDATE COMPLETE</h3>

	<div class="push"></div>

	<div class="main-content">

	<p>登録情報を変更しました。</p>

	<br><br>

	<img src="./image/pudding2.png" style="width:150px;">

	<div class="icon-push"></div>

	<p><a href='<s:url action="MyPageAction"/>'>マイページへ戻る</a></p>
	<div class="push"></div>

	</div>

	<div id="text-link">
		<p><a href='<s:url action="GoHomeAction"/>'>Homeへ戻る場合はこちら</a></p>
		<p><a href='<s:url action="LogoutAction"/>'>ログアウトする場合はこちら</a></p>
	</div>

</div>

<!-- メインとフッターの間隔調整用div -->
<div class="footer-push"></div>


<!-- フッター部分 -->
<footer>

	<div class="footer-height"></div>

	<div class="footer-message">
		Copyright©2018 SWEETOPIA. All Rights Reserved.
	</div>

</footer>
</div>


</body>
</html>
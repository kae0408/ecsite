<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head> <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<!-- ファビコン -->
	<link rel="shortcut icon" href="http://www.iconj.com/icon.php?pid=eh53o8d8gl" type="image/x-icon" />
	<link rel="shortcut icon" href="http://www.iconj.com/gif_icon.php?pid=eh53o8d8gl" type="image/gif" />
	<!-- end of iconj.com favicon code -->
<title>MyPage画面</title>

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
	<h3>MY PAGE</h3>

	<div class="push"></div>

	<img src="./image/tai.png" style="width:50px;">

	<div class="icon-push"></div>

	<div class="main-content">
		<!-- ユーザー情報 -->
		<div class="push"></div>

		<span>USER INFORMATION</span>
		<br><br><br>

		<div class="user-table">
			<table>
			<s:form>
			<tr>
				<td>ユーザー名:</td>
				<td><s:property value="session.userName"/></td>
			</tr>

			<tr>
				<td>お届け先住所:</td>
				<td><s:property value="session.userAddress"/></td>
			</tr>

			<tr>
				<td>電話番号:</td>
				<td><s:property value="session.userTell"/></td>
			</tr>

			<tr>
				<td>メールアドレス:</td>
				<td><s:property value="session.userMail"/></td>
			</tr>


			</s:form>
			</table>
		</div>

		<div class="push"></div>

		<div id="text-link">
			<p><a href='<s:url action="GoUserUpdateAction"/>'>ユーザー情報を変更する場合はこちら</a></p>
			<p><a href='<s:url action="GoUserDeleteAction"/>'>退会する場合はこちら</a></p>
		</div>

		<div class="contentdown-push"></div>

		<!-- 購入履歴（購入したものがない場合） -->
			<s:if test="myPageList == null">
				<div class="push"></div>

				<span>PURCHASE HISTORY</span>
				<div class="no-purchase">ご購入情報はありません。</div>
				<div class="push"></div>
			</s:if>

		<!-- 購入したものがある場合 -->
			<s:elseif test="message == null">
				<div class="push"></div>

				<span>PURCHASE HISTORY</span>
				<table class="mypage-table">
				<tr>
					<th class="mypage-th">商品名</th>
					<th class="mypage-th">価格</th>
					<th class="mypage-th">購入個数</th>
					<th class="mypage-th">支払方法</th>
					<th class="mypage-th">購入日</th>
				</tr>

				<s:iterator value="myPageList">
				<tr>
					<td class="mypage-td"><s:property value="itemName"/></td>
					<td class="mypage-td"><s:property value="totalPrice"/><span>円</span></td>
					<td class="mypage-td"><s:property value="totalCount"/><span>個</span></td>
					<td class="mypage-td"><s:property value="payment"/></td>
					<td class="mypage-td"><s:property value="insert_date"/></td>
				</tr>
				<div class="push"></div>
				</s:iterator>
				</table>

				<div class="push"></div>

				<!-- 履歴の削除機能 -->
				<s:form action="MyPageAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit class="button" value="履歴の削除" method="delete"/>
				</s:form>
			</s:elseif>

		<!-- message(MyPageActionで定義した変数）に値が入っている場合 -->
			<s:if test="message != null">
				<div class="push"></div>
				<p class="error-message"><s:property value="message"/></p>
			</s:if>
	</div>

	<div class="push"></div>
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
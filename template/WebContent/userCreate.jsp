<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Style-Type" content="javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keyword" content="">
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<title>UserCreate画面</title>
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
					<li><a href='<s:url action="ProductPageAction"/>'>PRODUCT</a></li>
					<li><a href='<s:url action="UserCreateAction"/>'>SIGNUP</a></li>
					<li><a href='<s:url action="LoginAction"/>'>LOGIN</a></li>
					<li><a href='<s:url action="MyPageAction"/>'>MYPAGE</a></li>
					<li><a href='<s:url action="LogoutAction"/>'>LOGOUT</a></li>
					<li><a href='<s:url action="InquiryAction"/>'>MAIL</a></li>
				</ul>
			</div>

	</div>
</header>

<div class="main-push"></div>

<!-- メイン部分 -->
<div id="main">
	<h3>USER CREATE</h3>

	<div class="push"></div>

	<img src="./image/cup1.png" style="width:40px;">

	<div class="icon-push"></div>

	<div class="main-content">
		<p>はじめてご利用される方は新規登録をお願いします。</p>
		<div class="push"></div>

	<!-- エラーメッセージ -->
		<s:if test="errorMessage != ''">
			<div  class="error-message">
			<s:property value="errorMessage" escape="false"/>
			</div>

			<div class="push"></div>
		</s:if>

		<table>
		<s:form action="UserCreateConfirmAction">
		<tr>
			<td><label>ログインID:</label></td>
			<td><input type="text" name="loginUserId" value=""/></td>
		</tr>

		<tr>
			<td><label>ログインPASS:</label></td>
			<td><input type="text" name="loginPassword" value=""/></td>
		</tr>

		<tr>
			<td><label>名前:</label></td>
			<td><input type="text" name="userName" value=""/></td>
		</tr>

		<tr>
			<td><label>性別:</label></td>
			<td>
				<input type="radio" name="userSex" value="男" checked="checked">男
				<input type="radio" name="userSex" value="女">女
			</td>
		</tr>

		<tr>
			<td><label>住所:</label></td>
			<td><input type="text" name="userAddress" value=""/></td>
		</tr>

		<tr>
			<td><label>TEL番号（ハイフン必須）:</label></td>
			<td><input type="text" name="userTell" value=""/></td>
		</tr>

		<tr>
			<td><label>メールアドレス:</label></td>
			<td><input type="text" name="userMail" value=""/></td>
		</tr>

		<tr>
			<td><s:submit class="button" value="登録する"/></td>
		</tr>

		</s:form>
		</table>
	</div>

		<div class="push"></div>

		<div id="text-link">
			<p><a href='<s:url action="GoHomeAction"/>'>Homeへ戻る場合はこちら</a></p>
			<p><a href='<s:url action="GoLoginAction"/>'>すでにIDをお持ちの場合はこちら</a></p>
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
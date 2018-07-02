<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<!-- ファビコン -->
<link rel="shortcut icon" href="http://www.iconj.com/icon.php?pid=eh53o8d8gl" type="image/x-icon" />
<link rel="shortcut icon" href="http://www.iconj.com/gif_icon.php?pid=eh53o8d8gl" type="image/gif" />
<!-- end of iconj.com favicon code -->

<title>UserUpdate画面</title>
</head>


<body>

<!-- フッター固定の為のdiv(container) -->
<div class="container">

<!-- ヘッダー部分 -->
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
	<h3>USER UPDATE</h3>

	<div class="push"></div>

	<img src="./image/pudding.png" style="width:40px;">

	<div class="icon-push"></div>

	<div class="main-content">
		<p>変更情報を入力してください。</p>

		<!-- エラーメッセージ -->
		<div class="error-message">
		<s:if test="errorMessage != ''">
			<s:property value="errorMessage" escape="false"/>
		</s:if>
		</div>

		<div class="push"></div>

		<table>
		<s:form action="UserUpdateAction">
		<tr>
			<td><label>ログインID:</label></td>
			<td><input type="text" name="loginUserId" value="<s:property value="session.loginUserId"/>"/></td>
		</tr>

		<tr>
			<td><label>ログインPASS:</label></td>
			<td><input type="password" name="loginPassword" value="<s:property value='session.loginPassword'/>"/></td>
		</tr>

		<tr>
			<td><label>名前:</label></td>
			<td><input type="text" name="userName" value="<s:property value='session.userName'/>"/></td>
		</tr>

		<tr>
			<td><label>性別:</label></td>
			<td>
				<s:if test='session.userSex == "男"'>
				<input type="radio" name="userSex" value="男" checked="checked">男
				<input type="radio" name="userSex" value="女">女
				</s:if>
				<s:else>
				<input type="radio" name="userSex" value="男">男
				<input type="radio" name="userSex" value="女" checked="checked">女
				</s:else>
			</td>
		</tr>

		<tr>
			<td><label>住所:</label></td>
			<td><input type="text" name="userAddress" value="<s:property value='session.userAddress'/>"/></td>
		</tr>

		<tr>
			<td><label>TEL番号（ハイフン必須）:</label></td>
			<td><input type="text" name="userTell" value="<s:property value='session.userTell'/>"/></td>
		</tr>

		<tr>
			<td><label>メールアドレス:</label></td>
			<td><input type="text" name="userMail" value="<s:property value='session.userMail'/>"/></td>
		</tr>

		<tr>
			<td><s:submit class="button" value="登録する"/></td>
		</tr>

		</s:form>
		</table>
	</div>

	<div class="push"></div>
	<div id="text-link">
		<p><a href='<s:url action="MyPageAction"/>'>マイページへ戻る場合はこちら</a></p>
		<p><a href='<s:url action="GoHomeAction"/>'>Homeへ戻る場合はこちら</a></p>
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
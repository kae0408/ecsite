<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>

<!-- ファビコン -->
	<link rel="shortcut icon" href="http://www.iconj.com/icon.php?pid=eh53o8d8gl" type="image/x-icon" />
	<link rel="shortcut icon" href="http://www.iconj.com/gif_icon.php?pid=eh53o8d8gl" type="image/gif" />
	<!-- end of iconj.com favicon code -->

<title>UserUpdateConfirm画面</title>
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
	<h3>USER UPDATE CONFIRM</h3>

	<div class="push"></div>

	<img src="./image/pudding.png" style="width:40px;">

	<div class="icon-push"></div>

	<div class="main-content">
		<p>登録する内容は以下でよろしいですか。</p>
		<div class="icon-push"></div>

		<table>
		<s:form action="UserUpdateConfirmAction">
			<tr id="box">
				<td><label>ログインID:</label></td>
				<td><s:property value="loginUserId" escape="false"/></td>
			</tr>

			<tr>
				<td><label>ログインPASS:</label></td>
				<td><s:property value="loginPassword" escape="false"/></td>
			</tr>

			<tr>
				<td><label>名前:</label></td>
				<td><s:property value="userName" escape="false"/></td>
			</tr>

			<tr>
				<td><label>性別:</label></td>
				<td><s:property value="userSex" escape="false"/></td>
			</tr>

			<tr>
				<td><label>住所:</label></td>
				<td><s:property value="userAddress" escape="false"/></td>
			</tr>

			<tr>
				<td><label>TEL番号:</label></td>
				<td><s:property value="userTell" escape="false"/></td>
			</tr>

			<tr>
				<td><label>メールアドレス:</label></td>
				<td><s:property value="userMail" escape="false"/></td>
			</tr>

			<tr>
				<td><br></td>
			</tr>

			<tr>
				<td><input type="button" class="button" value="戻る" onclick="submitAction('GoUserUpdateAction')" /></td>
				<td><input type="button" class="button" value="完了" onclick="submitAction('UserUpdateConfirmAction')" /></td>
			</tr>

		</s:form>
		</table>

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
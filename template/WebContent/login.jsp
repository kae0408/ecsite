<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Style-Type" content="javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keyword" content="">
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<title>Login画面</title>


</head>
<body id="login">
<div id="header">
	<div id="pr">
	</div>
</div>

	<div id="main">
		<div id="top">
		<p>Login</p>
		
	
<h3>商品を購入する際にはログインをお願いします。</h3>
	<s:form action="LoginAction">
		<s:textfield name="loginUserId"/>
		<s:password name="loginPassword"/>
		<s:submit value="Login"/>
	</s:form>
<br/>
<div class="newuser">
	<span>新規ユーザー登録は
	<a href='<s:url action="UserCreateAction" />'>こちら</a></span>
	<span>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></span>
	
</div>
</div>
	<div>
</div>
</div>
	<!-- <div id="footer">
		<div id="pr">
		</div> 
	</div> -->
</body>
</html>
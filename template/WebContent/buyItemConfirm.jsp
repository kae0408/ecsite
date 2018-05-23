<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>buyItemConfilm画面</title>


</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

<div id="main">
	<div id="top">
	<p>BuyItemConfirm</p>
	</div>
<div>
<s:form action="BuyItemConfirmAction">
<table>
	<tr>
		<td>商品名</td>
		<td><s:property value="session.buyItem_name" /></td>
	</tr>

	<tr>
	<td>支払い方法</td>
	<td><s:property value="session.pay" /></td>
	</tr>
	
	<tr>
	<td><s:submit value="完了" /></td>
	</tr>
</table>
</s:form>
</div>
</div>

	<div id="footer">
	<div id="pr">
	</div>
	</div>
</body>
</html>
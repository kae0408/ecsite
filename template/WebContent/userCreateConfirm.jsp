<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>UserCreateConfirm画面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />

</head>
<body> 
	<div id="header">
		<div id="pr">
		</div>
	</div>
	
	
	<div id="main">
		<div id="top">
		<p>UserCreateConfirm</p>
		</div>
	<div>
	
	
<p>登録する内容は以下でよろしいですか。</p>
		<p class="error-message">※「戻る」を選択すると入力した情報は消去されます。</p>

		<div class="push"></div>

		<table>
			<s:form action="UserCreateCompleteAction">
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
				<td><input type="button" class="button" value="戻る" onclick="submitAction('UserCreateAction')" /></td>
				<td><input type="button" class="button" value="完了" onclick="submitAction('UserCreateCompleteAction')" /></td>

			</tr>
			</s:form>

		</table>

		<div class="contentdown-push"></div>

		<div id="text-link">
			<p><a href='<s:url action="GoHomeAction"/>'>Homeへ戻る場合はこちら</a>
			<p><a href='<s:url action="GoLoginAction"/>'>すでにIDをお持ちの場合はこちら</a></p>
		</div>
</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
</body>
</html>
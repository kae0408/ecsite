<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
	<meta charset="utf-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- ファビコン -->
	<link rel="shortcut icon" href="http://www.iconj.com/icon.php?pid=eh53o8d8gl" type="image/x-icon" />
	<link rel="shortcut icon" href="http://www.iconj.com/gif_icon.php?pid=eh53o8d8gl" type="image/gif" />
	<!-- end of iconj.com favicon code -->
	<title>BuyItem画面</title>
</head>
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
	<h3>BUY ITEM</h3>

	<div class="push"></div>

	<img src="./img/cart.png" style="width:40px;">

	<div class="icon-push"></div>

	<div class="error-message">
		<s:if test="buyItemErrorMessage != null">
		<s:property value="buyItemErrorMessage"/>
		</s:if>
		<div class="push"></div>
	</div>

	<div class="main-content">
	<!-- カテゴリ表示機能 -->
	<s:form action="CategorySearchAction">
	<tr>
		<td>
		<select name="sortCategory" onchange="submit(this.form)">
			<option value="0" selected="selected">カテゴリ選択</option>
			<option value="cake">ケーキ</option>
			<option value="bake">焼き菓子</option>
			<option value="wagashi">和菓子</option>
		</select>
		</td>
	</tr>
	</s:form>


	<p><a href='<s:url action="ProductPageAction"/>'>検索のリセット</a></p>


	<!-- 商品検索機能 -->
	<s:form action="SearchAction">
	<tr>
		<td><s:textfield name="searchWord" value=""/><s:submit class="button" value="検索"/></td>
	</tr>
	</s:form>

	<!-- エラーーメッセージ -->
	<s:if test="searchMessage != null ">
		<p class="error-message"><s:property value="searchMessage" escape="false"/></p>
	</s:if>


	<div class="push"></div>

<!-- 商品テーブル -->
<div class="item-table">

	<table>
	<s:form action="BuyItemAction">


<!-- カテゴリソート① -->
	<s:if test="session.sortCategory=='cake'">
	<s:iterator value="#session.buyItemDTOList">
		<dl class="dl-list">
			<dd class="dd-list">

			<div class="item_description">
			<a href="#">
			<span class="remark"><s:property value="item_description"/></span>
			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

			<br><br>

			<s:property value="itemName" /><br>

			<span>値段:</span>
			<s:property value="itemPrice" /><span>円</span><br>
			<span>在庫:</span>
			<s:if test="item_stock>0">
				<s:property value="item_stock"/>
			</s:if>
			<s:else>
				<span class="error-message">品切れ</span>
			</s:else>
			</a>
			<br>
			<span>購入個数:</span>
			<s:property value="item_stock"/>個
			<s:if test="item_stock>0">
				<div class="select-box ">
				<select name="count">
					<option value="0" selected="selected">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</div>
			</s:if>
			<s:else>
				<select name="count">
					<option value="0" selected="selected">0</option>
				</select>
			</s:else>

			</div>
			</dd>
		</dl>
	</s:iterator>
	</s:if>

<!-- カテゴリソート② -->
	<s:elseif test="session.sortCategory=='bake'">
	<s:iterator value="#session.buyItemDTOList">
		<dl class="dl-list">
			<dd class="dd-list">

			<div class="item_description">
			<a href="#">
			<span class="remark"><s:property value="item_description"/></span>
			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

			<br><br>

			<s:property value="itemName" /><br>

			<span>値段:</span>
			<s:property value="itemPrice" /><span>円</span><br>
			<span>在庫:</span>
			<s:if test="item_stock>0">
				<s:property value="item_stock"/>
			</s:if>
			<s:else>
				<span class="error-message">品切れ</span>
			</s:else>
			</a>

			<br>
			<span>購入個数:</span>
			<s:if test="item_stock>0">
				<div class="select-box">
				<select name="count">
					<option value="0" selected="selected">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</div>
			</s:if>
			<s:else>
				<select name="count">
					<option value="0" selected="selected">0</option>
				</select>
			</s:else>

			</div>
			</dd>
		</dl>
	</s:iterator>
	</s:elseif>


<!-- カテゴリソート③ -->
	<s:elseif test="session.sortCategory=='wagashi'">
	<s:iterator value="#session.buyItemDTOList">
		<dl class="dl-list">
			<dd class="dd-list">

			<div class="item_description">
			<a href="#">
			<span class="remark"><s:property value="item_description"/></span>
			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

			<br><br>

			<s:property value="itemName" /><br>

			<span>値段:</span>
			<s:property value="itemPrice" /><span>円</span><br>

			<span>在庫:</span>
			<s:if test="item_stock>0">
				<s:property value="item_stock"/>
			</s:if>
			<s:else>
				<span class="error-message">品切れ</span>
			</s:else>
			</a>

			<br>

			<span>購入個数:</span>
			<s:if test="item_stock>0">
				<div class="select-box">
				<select name="count">
					<option value="0" selected="selected">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</div>
			</s:if>
			<s:else>
				<select name="count">
					<option value="0" selected="selected">0</option>
				</select>
			</s:else>

			</div>
			</dd>
		</dl>
	</s:iterator>
	</s:elseif>


<!-- カテゴリソートしない時の表示 -->
	<s:else>
	<s:iterator value="#session.buyItemDTOList">
		<dl class="dl-list">
			<dd class="dd-list">

			<div class="item_description">
			<a href="#">
			<span class="remark"><s:property value="item_description"/></span>
			<img class="image" style="width:100%; height:140px;" src="<s:property value='image_file_path'/>" >

			<br><br>

			<s:property value="itemName" /><br>

			<span>値段:</span>

			<s:property value="itemPrice" /><span>円</span><br>

			<span>在庫:</span>
				<s:if test="item_stock>0">
					<s:property value="item_stock"/>
				</s:if>
				<s:else>
					<span class="error-message">品切れ</span>
				</s:else>
			</a>
			<br>

			<span>購入個数:</span>
				<s:if test="item_stock>0">
					<div class="select-box cp_ipselect cp_sl05">
					<select name="count">
						<option value="0" selected="selected">-</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
			</div>
				</s:if>
				<s:else>
					<select name="count">
						<option value="0" selected="selected">0</option>
					</select>
				</s:else>
			</div>
			</dd>
		</dl>

	</s:iterator>
	</s:else>

<!-- 繰り返し処理ここまで、以下は支払方法選択 -->

<div class="clear"></div>
<div class="pay-push"></div>

	<tr>
		<td><span>支払方法:</span></td>
		<td>
			<input type="radio" name="pay" value="1" checked="checked">現金払い
			<input type="radio" name="pay" value="2">クレジットカード
		</td>
	</tr>

	<tr>
		<td><s:submit class="button" value="購入"/></td>
	</tr>

	</s:form>
	</table>
</div>

	<div class="buyItemDown-push"></div>

	<div id="text-link">
		<p><a href='<s:url action="MyPageAction" />'>マイぺージはこちら</a></p>
		<p><a href='<s:url action="GoHomeAction" />'>Homeへ戻る場合はこちら</a></p>
	</div>
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
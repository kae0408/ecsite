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
<title>管理画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>master</p>
		</div>

		<div>
			<div>
				<a href='<s:url action="GoInsertAction"/>'>新商品追加</a>
				<a href='<s:url action="GoItemUpdateAction"/>'>商品情報更新</a>
				<a href='<s:url action="GoItemDeleteAction"/>'>商品削除</a>
			</div>
			<s:form action="MasterAction">
				<table>
					<s:iterator value="buyItemDTOList">
						<tr>
							<td>
								<h3><s:property value="itemName"/></h3>
							</td>
						</tr>

						<tr>
							<td>
								<span>在庫</span>
							</td>
							<td>
								<s:property value="item_stock"/>
							</td>
						</tr>

						<tr>
							<td>
								<span>商品在庫追加</span>
							</td>
							<td>
								<select name="count">
									<option value="0" selected="selected">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
					</s:iterator>
						<tr>
							<td>
								<s:submit value="追加"/>
							</td>
						</tr>
				</table>
			</s:form>

			<div>
				<p><a href='<s:url action="GoHomeAction" />'>home</a></p>
			</div>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>
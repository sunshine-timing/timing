<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>

<%
 String contengpath = request.getContextPath();
%>
<meta charset="utf-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>顶层模块管理</title>
</head>
<!-- 样式 -->
<link href="${contengpath }/css/bootstrap.min.css" rel="stylesheet" />
<link href="${contengpath }/css/index.css" rel="stylesheet" />
<link href="${contengpath }/css/bootstrap-theme.min.css" rel="stylesheet" /><br>
<body>

<div class="container">
		<div>
			<ul>
				<li>增加</li><li>删除</li>
			</ul>
		</div>
		<div>
			<ul>
				<li><input type="checkbox" name="moduleCk" value="123" />系统管理</li>
				<li><input type="checkbox" name="moduleCk" value="124" />菜单管理</li>
				<li><input type="checkbox" name="moduleCk" value="125" />商品管理</li>
			</ul>
		</div>
	
</div>

<!--js-->
<script src="${contengpath }js/jquery-1.11.2.min.js" ></script>
<script src="${contengpath }js/bootstrap.min.js" ></script>
<script src="${contengpath }js/npm.js" ></script>
<script src="${contengpath }js/html5shiv.min.js" ></script>

<!-- 自定义js -->
</body>
</html>

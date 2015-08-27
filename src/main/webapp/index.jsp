<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>后台系统管理</title>
</head>
<!-- 样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" /><br>
<style>
	body {background-color:#DBEAF9;}
	#abcdefg>.active {background-color:#eee;}
	.loading-mask {height: 100%;width: 100%;position: fixed;_position:fixed;opacity:0.5; filter: alpha(opacity=50);left:0;top:0;z-index:99999;background-color: #000; display: none;}
	.mprogress_bar {width:60%;margin-left:20%;position:fixed;top:40%;}
</style>
<body>

<div class="container">
	<div id="header" style="background:url(images/top_logo.jpg) no-repeat  -22em -5em;height:10em;	">
    </div>
    
    <!--顶部导航-->
    <div class="navbar-collapse collapse navbar-inverse" name="topModules" >  
             <ul class="nav navbar-nav">
               <li class="menuItem active" onclick="home_index()"><a href="javascript:void(0);">主页</a></li>
	               <c:forEach items="${topModules}" var="module">
	               	<li class="menuItem" onclick="moduleChange(this,${module.moduleId})"><a href="javascript:void(0);">${module.moduleName}</a></li>    
	               </c:forEach>  
             </ul>  
     </div>
	
	<div id="index_Dycontent">
		<jsp:include page="user_index.jsp" flush="true"></jsp:include>
	</div>
	
	<!-- 遮罩层 -->
	<div id="loading-mask" class="loading-mask">
	
       <div class="progress mprogress_bar">
           <div class="progress-bar progress-bar-info" role="progressbar"
              aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 
              style="width: 20%;">
           </div>
    	</div>
    
	</div>
	
	
</div>

<!--js-->
<script src="js/jquery-1.11.2.min.js" ></script>
<script src="js/bootstrap.min.js" ></script>
<script src="js/npm.js" ></script>
<script src="js/html5shiv.min.js" ></script>

<!-- 自定义js -->
<script src="js/mshop/index.js" ></script>
</body>
</html>

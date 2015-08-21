<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<!-- 样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" /><br>
<style>
	body {background-color:#DBEAF9;}
	#abcdefg>.active {background-color:#eee;}
}
</style>
<body onload="menuLoaded()">

<!-- 左右分割3:9 -->
<div class="row">

	<!-- 左侧菜单导航 -->
	<div class="col-md-3">
	 <!--左侧导航-->
	 <ul class="nav_class1">
	 
	 	<%-- <c:forEach var="menum" items="${leftMenuBeans }" varStatus="status">
	             <li id="${menum.menuUrl }" class="menuItem <c:if test='${status.index eq 0 }'>active</c:if>"  ><a href="javascript:void(0);" >${menum.menuName }</a></li>
	    </c:forEach> --%>
	                  
    	<li class="active_nav1"><p>一层菜单1<p>
            <ul>
            	<li class="active_nav2"><p>二层菜单11<p></li>
                <li><p>二层菜单12<p></li>
                <li><p>二层菜单13<p></li>
                <li><p>二层菜单14<p></li>
            </ul>
        </li>
        <li><p>一层菜单2<p>
            <ul>
            	<li><p>二层菜单21<p></li>
                <li><p>二层菜单22<p></li>
                <li><p>二层菜单23<p></li>
                <li><p>二层菜单24<p></li>
            </ul>
        </li>
        <li><p>一层菜单3<p>
            <ul>
            	<li><p>二层菜单31<p></li>
                <li><p>二层菜单32<p></li>
                <li><p>二层菜单33<p></li>
                <li><p>二层菜单34<p></li>
            </ul>
        </li>
        <li><p>一层菜单4<p>
            <ul>
            	<li><p>二层菜单41<p></li>
                <li><p>二层菜单42<p></li>
                <li><p>二层菜单43<p></li>
                <li><p>二层菜单44<p></li>
            </ul>
        </li>
    
    </ul>
	 
		<%-- <!--左侧导航-->
         <div class="navbar-collapse collapse navbar-inverse" style="padding-top:0.5em;padding-bottom:0.5em;" >  
                  <ul id="abcdefg" class="nav">
	                  <c:forEach var="menum" items="${leftMenuBeans }" varStatus="status">
	                  <li id="${menum.menuUrl }" class="menuItem <c:if test='${status.index eq 0 }'>active</c:if>"  ><a href="javascript:void(0);" >${menum.menuName }</a></li>
	                  </c:forEach>
                  </ul>  
          </div> --%>
	</div>
	
	<!-- 右侧内容:默认加载菜单第一个 -->
	<div class="col-md-9" name="index_menu_url">
		<%-- <jsp:include page="${leftMenuBeans[0].menuUrl }" flush="true"></jsp:include> --%>
	</div>
</div>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<!-- 样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" />
<br>
<style>
body {
	background-color: #DBEAF9;
}

#abcdefg>.active {
	background-color: #eee;
}
}
</style>
<body onload="menuLoaded()">

	<!-- 左右分割3:9 -->
	<div class="row" id="index_body_div" >

		<!-- 左侧菜单导航 -->
		<div class="col-md-3">
			<!--左侧导航-->
			<ul class="nav_class1">


				<%--循环遍历取出菜单项 --%>
				<c:forEach items="${leftMenuBeans}" var="leftMenu" varStatus="stu">
					<c:if test="${stu.index eq 0 }">
						<li class="active_nav1"><p>${leftMenu.menuName }
							<p>
					</c:if>
					<c:if test="${stu.index ne 0 }">
						<li><p>${leftMenu.menuName }
							<p>
					</c:if>
						<ul>
						<c:forEach items="${leftMenu.subMenuBeans}" var="subLeftMenu" varStatus="substu">
							<c:if test="${substu.index eq 0 }">
								<li class="active_nav2" onclick="chageMenuUrl('${subLeftMenu.menuId}')">
							</c:if>
							<c:if test="${substu.index ne 0 }">
								<li>
							</c:if>
							<p>${subLeftMenu.menuName }<p></li>
						
						</c:forEach>
							
						</ul>
					</li>
				</c:forEach>

			</ul>

		</div>

		<!-- 右侧内容:默认加载菜单第一个 -->
		<div class="col-md-9" name="index_menu_url" >
			<iframe src="${leftMenuBeans[0].subMenuBeans[0].menuUrl }" width="100%" height="100%" name="contentframe"></iframe>
			<%-- <jsp:include page="${leftMenuBeans[0].subMenuBeans[0].menuUrl }" flush="true"></jsp:include>--%>
		</div>
	</div>

<script type="text/javascript">
	alert($("#index_body_div").offset().top);
	alert(parent.document.body.clientHeight);
	var index_content_height = parent.document.body.clientHeight-$("#index_body_div").offset().top;
	alert(index_content_height);
	$("[name=index_menu_url]").css("height",index_content_height);
</script>
</body>
</html>

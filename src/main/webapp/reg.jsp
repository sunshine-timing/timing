<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/reg.css">

</head>

<body>
	<div class="reg_wrap_div font_fami_applied">
		<h2>欢迎注册</h2>
		<form action="reg.action" method="post">
			<div>
				<label>账号</label><input type="text" name="baseUserBean.account"
					maxlength="16" />
			</div>
			<div>
				<label>用户名</label><input type="text" name="baseUserBean.username"
					maxlength="16" />
			</div>
			<div>
				<label>年龄</label><input type="text" name="baseUserBean.age"
					maxlength="16" />
			</div>
			<div>
				<label>性别</label><input type="text" name="baseUserBean.gender"
					maxlength="16" />
			</div>
			<div>
				<label>qq号</label><input type="text" name="baseUserBean.qq"
					maxlength="16" />
			</div>
			<div>
				<label>邮箱</label><input type="text" name="baseUserBean.email"
					maxlength="16" />
			</div>
			<div>
				<label>密码</label><input type="text" name="password1" maxlength="16" />
			</div>
			<div>
				<label>密码确认</label><input type="text" name="password2"
					maxlength="16" />
			</div>
			<div>
				<label>验证码</label><input type="text" name="validateCode"
					maxlength="16" />
			</div>
			<s:token name="user.token"></s:token>
			
			<p style="cursor: pointer;" onclick="reg()"> 注册</p>
		</form>
	</div>
	<script type="text/javascript">
		function reg()
		{
			document.forms[0].submit();
		}
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>后台管理系统</title>
</head>
<!-- 样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" />
<style>
body {
	background: url(images/login_bg.jpg) no-repeat center fixed;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
	margin-top: 300px;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
}
</style>
<body>

	<div class="container">

		<form class="form-signin" action="login.action" method="post">
			<label for="userid" class="sr-only">账户：</label><input type="text"
				id="userid" name="userid" placeholder="请输入账户" class="form-control"
				required autofocus /> <br /> <label for="passwd" class="sr-only">密码：</label><input
				type="password" id="passwd" name="passwd" placeholder="请输入密码"
				class="form-control" required />
			<button class="btn btn-lg btn-block btn-primary" type="button"
				onclick="login()">登陆</button>
		</form>

	</div>

	<!--js-->
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/npm.js"></script>

	<script type="text/javascript">
		//登陆
		function login() {
			var loginReq = $.ajax({
				type : 'post',
				url : 'login.action',
				timeout : 5000,//5秒钟超时 
				cache : false,
				async : false,//同步
				dataType : 'html',
				data : $('form').serialize(),
				success : function(data) {
					//登陆成功
					if ('success' == data) {
						window.location.href = "index.action";
					} else {
						alert('密码错误');
					}
				},
				error : function(XMLHttpRequest, status) {
					if (status == 'timeout') {
						loginReq.abort();
						alert('请求超时');
					}
				}
			});
		}
	</script>
</body>
</html>
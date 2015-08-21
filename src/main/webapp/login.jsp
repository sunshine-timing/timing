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
<body onload="getPubKey()">

	<div class="container">

		<form class="form-signin" method="post">
			
			<!-- 加密参数 -->
			<input type="hidden" id="hid_modulus" value="${modulus }" />
			<input type="hidden" id="hid_exponent" value="${exponent }" />
			
			<label for="userid" class="sr-only">账户：</label>
			<input type="text"
				id="userid" name="userid" placeholder="请输入账户" class="form-control" value=""
				required autofocus /> <br /> 
			<label for="passwd" class="sr-only">密码：</label>
			<input
				type="password" id="passwd" name="passwd" placeholder="请输入密码" value=""
				class="form-control" required />
				
			<button class="btn btn-lg btn-block btn-primary" type="button" name="subbtn" title="注意" 
			data-container="body" data-toggle="popover" data-placement="top"
      data-content="账号或密码错误"
				onclick="login()" disabled>登陆</button>
		</form>

	</div>

	<!--js-->
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/npm.js"></script>
	<script src="js/security.js"></script>
	<script src="js/html5shiv.min.js" ></script>

	<script type="text/javascript">
		function getPubKey()
		{
			$.ajax({
				type : 'post',
				url : 'pubKey.action',
				cache : false,
				async : false,//同步
				dataType : 'json',
				success : function(data) {
					$("#hid_modulus").val(data.modulus);
					$("#hid_exponent").val(data.exponent);
					$('button[name=subbtn]').removeAttr("disabled");
				}
			});
		}
	
		//登陆
		function login() {
			$('button[name=subbtn]').attr("disabled",true);
			if(!validate())
			{
				$('button[name=subbtn]').removeAttr("disabled");
				return false;
			}
			var passwd=$("input[name=passwd]").val();
			// 页面里，Javascript对明文进行加密：
			var modulus = document.getElementById("hid_modulus").value;
			var exponent = document.getElementById("hid_exponent").value; 
			var key = RSAUtils.getKeyPair(exponent, '', modulus);
			passwd = RSAUtils.encryptedString(key, passwd);
			
			$("input[name=passwd]").val(passwd);
			
			
			$.ajax({
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
						$("input[name=passwd]").val('');
						$("[data-toggle='popover']").popover();
						$('button[name=subbtn]').removeAttr("disabled");
					}
				},
				error : function(XMLHttpRequest, status) {
					if (status == 'timeout') {
						$('button[name=subbtn]').removeAttr("disabled");
						loginReq.abort();
					}
				}
			});
		}
		
		function validate()
		{
				var userid=$('input[name=userid]').val();
				var passwd=$('input[name=passwd]').val();
				if(""==userid||""==passwd)
				{
					return false;
				}
				return true;
		}
	</script>
</body>
</html>
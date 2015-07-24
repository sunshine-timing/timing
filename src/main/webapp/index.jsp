<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<!-- 样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" />
<style>
  body {background:url(images/login_bg.jpg) no-repeat center fixed; }
  .form-signin {max-width:330px;padding:15px;margin:0 auto;margin-top:300px;}
  .form-signin .form-control { position:relative; height:auto; padding:10px; font-size:16px;}
  .form-signin input[type="password"] {margin-bottom:10px;}
</style>
<body>

<div class="container">
	
    <form class="form-signin">
    	<label for="userid" class="sr-only"></label><input type="text" id="username" name="username" placeholder="" class="form-control"  required autofocus />
        <br/>
        <label for="passwd" class="sr-only"></label><input type="password" id="passwd" name="passwd" placeholder=""  class="form-control"  required />
        <button class="btn btn-lg btn-block btn-primary" type="submit"></button>
    </form>

</div>

<!--js-->
<script src="js/jquery-1.11.2.min.js" ></script>
<script src="js/bootstrap.min.js" ></script>
<script src="js/npm.js" ></script>
</body>
</html>
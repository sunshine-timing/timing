<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
</style>
<body>
	<!--顶部导航对应的实体内容--> 
    <div id="body" style="margin-top:1em" class="row" >
    	
        <!--左侧布局-->
        <div  class="col-md-3">
        	<div style="max-width:330px;" class="border-info">
            
            	<p class="glyphicon-text-size popover-title" >欢迎登陆：${userInfo.userId }【${userInfo.name }】</p>
                 
                 <!--个人头像-->
                <div style="margin:0 auto;text-align:center;"><img src="images/Koala.jpg"  height="130em"/></div>
               
               <p class="text-center">手机号码：${userInfo.mobileNo }</p>
               <p class="text-center">邮箱地址:${userInfo.email }</p>
               <p class="text-info small text-right" >上次登陆:【${userInfo.lastLogin }】</p>
               <button type="button" class="btn btn-block btn-info" >修改个人信息</button>
               
            </div> 
        </div>
    	
        <!-- 右侧布局具体内容实体 -->
        <div class="col-md-9 bg-info">
        	<div class="border-info">
            	<p class="popover-title">统计信息</p>
                
                <!--指标统计-->
                <div class="row">
                	<div class="col-md-3">
                    <p>销量统计</p>
                    </div>
                    <div class="col-md-3">
                    <p>收入统计</p>
                    </div>
                    <div class="col-md-3">
                    <p>统计</p>
                    </div>
                </div>
                
                <!--提醒信息-->
                <div class="bg-warning">
                	<p >提醒</p>
                    <ul>
                    	<li class="text-warning">商品编号：00122【华为123手机】已经销磬<span class="glyphicon-bitcoin">2015-03-04 </span><button>删除</button><button>已读</button></li>
                        <li class="text-warning">商品编号：00122【华为123手机】已经销磬经销磬<span class="glyphicon-bitcoin">2015-03-04 </span><button>删除</button><button>已读</button></li>
                        <li class="text-warning">商品编号：00122【华为123手机】已经销磬经销磬<span class="glyphicon-bitcoin">2015-03-04 </span><button>删除</button><button>已读</button></li>
                        <li>商品编号：00122【华为123手机】已经销磬经销磬<span class="glyphicon-bitcoin">2015-03-04 </span><button>删除</button></li>
                        <li>商品编号：00122【华为123手机】已经销磬经销磬<span class="glyphicon-bitcoin">2015-03-04 </span><button>删除</button></li>
                    </ul>
                    <p class="text-right margin-right-1">首页  上一页 下一页 尾页</p>
                </div>
                
            </div>
        </div>
    </div>

<!--js-->
<script src="js/jquery-1.11.2.min.js" ></script>
<script src="js/bootstrap.min.js" ></script>
<script src="js/npm.js" ></script>
<script src="js/html5shiv.min.js" ></script>
</body>
</html>

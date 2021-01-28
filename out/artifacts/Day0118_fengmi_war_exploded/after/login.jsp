<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>用户登录</title>

	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

	<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
	<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访 问页面时 Respond.js 不起作用 -->
	<!--[if lt IE 9]>
	<script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
	<![endif]-->
</head>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<!-- 导入用户自定义css -->
<style type="text/css">
	@import url("../css/login.css");
</style>

<body>
<div class="top_div" style="padding-top:100px;text-align:center">
   <span style="font-size:40px;color:white;" class="logo">锋迷网后台管理系统</span>
</div>
<div class="login_div">
	<div style="width: 165px; height: 96px; position: absolute;">
		<div class="tou"></div>
		<div class="initial_left_hand" id="left_hand"></div>
		<div class="initial_right_hand" id="right_hand"></div>
	</div>
	<form action="${pageContext.request.contextPath}/LoginServlet">
		<p style="padding: 30px 0px 10px; position: relative;">
			<span class="u_logo"></span>
			<input class="ipt" id="name" type="text" name="username" placeholder="请输入用户名或邮箱" value="admin"> 
		</p>
		<p style="position: relative;">
			<span class="p_logo"></span>         
			<input class="ipt" id="password" name="password" type="password" placeholder="请输入密码" value="admin">   
		</p>
		<div class="submit_div">
			<p style="margin: 0px 55px 20px 45px;">
				<span style="float: right;">
					<input type="submit" class="submit" value=" 登 录 ">
				</span>
			</p>
		</div>
	</form>
</div>
<div class="copy">Copyright &copy;2019  版权所有</a> 提供技术支持</div>
</body>
</html>
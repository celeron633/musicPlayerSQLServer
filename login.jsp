<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在线音乐播放管理系统V1.0-用户登录</title>
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<br />
	<br />
	<h1 align="center" class="active">帐号密码登录</h1>
	<br />
<body style="background-image: url(img/2.jpg); background-size: cover;">
	<div>
		<form action="./login" method="post" class="form-horizontal"
			role="form" onsubmit="return login()">
			<div class="form-group">
				<label for="firstname" class="col-sm-4 control-label"></label>
				<div class="col-sm-4">
					<input name="username" type="text" class="form-control"
						id="firstname" placeholder="支持QQ号/邮箱/手机登录">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label"></label>
				<div class="col-sm-4">
					<input name="password" type="password" class="form-control"
						id="password" placeholder="密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-6 col-sm-40" style="margin-left: 34.5%;">
					<div class="checkbox">
						<label> <input type="checkbox">下次自动登录
						</label>
					</div>
				</div>
			</div>
			<div class="form-group" style="margin-left: 8%;">
				<div class="col-sm-offset-6 col-sm-40">
					<button type="submit" class="btn btn-default">登录</button>
					<a href="register.jsp" type="button" class="btn btn-default">注册新帐号</a>
				</div>
			</div>
		</form>


	</div>

</body>
<script>
	function login() {
		// console.info("点击了登录");
		var userName = document.getElementById("firstname").value;
		// console.info(userName)
		var userPass = document.getElementById("password").value;
		// console.info(userPass);
		if (userName == "" || userName == null) {
			alert("用户名不能为空");
			return false;
		} else if (userPass == "" || userPass == null) {
			alert("密码不能为空");
			return false;
		} else {
			return true;
		}
	}
</script>
</html>

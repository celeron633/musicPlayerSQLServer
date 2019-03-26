<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在线音乐播放管理系统V1.0-用户注册</title>

<link rel="stylesheet" href="css/bootstrap.min.css" />

</head>
<body style="background-image: url(img/2.jpg); background-size: cover;">
	<%@include file="header.jsp"%>
	<br />
	<br />
	<h1 align="center" class="active">用户注册界面</h1>
	<div>
		<form action="./reg" class="form-horizontal" role="form"
			onsubmit="return register()">
			<div class="form-group">
				<label for="firstname" class="col-sm-4 control-label"></label>
				<div class="col-sm-4">
					<input name="username" type="text" class="form-control"
						id="username" placeholder="请输入您的昵称">
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-4 control-label"></label>
				<div class="col-sm-4">
					<input name="email" type="text" class="form-control" id="email"
						placeholder="请输入您的邮箱">
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
				<label for="password" class="col-sm-4 control-label"></label>
				<div class="col-sm-4">
					<input name="password2" type="password" class="form-control"
						id="password2" placeholder="确认密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4" style="margin-left: 33.5%;">
					<input type="radio" name="sex" value="male">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="female">女
				</div>

			</div>

			<div class="form-group" style="margin-left: 15%;">
				<div class="col-sm-offset-6 col-sm-40">
					<input type="submit" class="btn btn-default" value="提交"> <input
						type="reset" class="btn btn-default" value="重置">

				</div>
			</div>
		</form>


	</div>


</body>
<script>
	function register() {
		var name = document.getElementById("username").value;
		var userPass = document.getElementById("password").value;
		var userRPass = document.getElementById("password2").value;
		var email = document.getElementById("email").value;
		if (name.length<3 || name.length>15) {
			alert("请输入3~15个字符的昵称");
			return false;
		} else if (userPass.length<6 || userPass.length >15) {
			alert("密码长度须在6-15之间!");
			return false;
		} else if (userPass != userRPass) {
			alert("两次密码输入不一致!");
			return false;
		} else if (email == "" || email == null) {
			alert("您没有输入邮箱！");
			return false;
		}
		return true;
	}
</script>
</html>

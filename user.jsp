<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/person.css" type="text/css" />
<title>在线音乐播放管理系统V1.0——个人中心</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="header">
		<div class="wrap">
			<h1 id="logo">
				<a href="#">个人中心</a>
			</h1>

			<ul id="menu">
				<li><a href="./index.jsp">首页</a></li>
				<li><a class="current" href="#">个人信息</a></li>
				<li><a href="./loginout">退出</a></li>
			</ul>
		</div>
	</div>
	<div class="wrap">
		<div class="img">
			<p>
				<img src="image/4.jpg" width="190" height="170" /> <img
					src="image/1.jpg" width="240" height="180" />
			</p>
			<img src="image/3.jpg" width="230" height="180" /> <img
				src="image/2.jpg" width="180" height="160" />

		</div>
		<div id="side">
			<table height="250px">
				<th><p class="th" align="center">
						<span>个人信息 </span>
					</p></th>
				<tr height="70px">
					<td><span>I D：${targetuser.id}</span></td>
				</tr>
				<tr height="70px">
					<td><span>昵称：${targetuser.name}</span></td>
				</tr>
				<tr height="70px">
					<td><span>邮箱：${targetuser.email}</span></td>
				</tr>
			</table>
		</div>
	</div>


</body>
</html>
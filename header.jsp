<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/index.css" />
<div style="background: #FFF; color: #000" class="section_inner">
	<ul class="nav nav-tabs">
		<li class="presentation"><img src="img/QQmusicLogo.jpg"></li>
		<li class="presentation" class="active"><a href="./">音乐馆</a></li>
		<li class="presentation"><c:choose>
				<c:when test="${empty sessionScope.user}">
					<a href="./login.jsp">我的音乐</a>
				</c:when>
				<c:otherwise>
					<a href="./show?uid=${user.id}">我的音乐</a>
				</c:otherwise>
			</c:choose></li>
		<li class="presentation"><a
			href="https://y.qq.com/download/index.html">下载客户端</a></li>
		<li class="presentation"><c:choose>
				<c:when test="${empty sessionScope.user}">
					<a href="./login.jsp">登录</a>
				</c:when>
				<c:otherwise>
					<a href="./show?uid=${user.id}">欢迎您：${sessionScope.user.name}</a>
				</c:otherwise>
			</c:choose></li>

		<li>
			<form action="./search" method="post" class="form-horizontal"
				role="form">
				<input name="searchname" class="geshou" placeholder="支持歌手/歌曲搜索">
				<input type="submit" class="search" value="搜索" alt="Submit">
			</form>
		</li>

	</ul>
	<div>
		<ul class=" nav nav-pills">
			<li class="presention"><a href="./">首页</a></li>
			<li class="presention"><a href="#">歌曲</a></li>
			<li class="presention"><a href="#">歌手</a></li>
			<li class="presention"><a href="#">专辑</a></li>
			<li class="presention"><a href="#">歌单</a></li>
		</ul>
	</div>
</div>


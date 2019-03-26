<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线音乐播放管理系统V1.0-${album.name}</title>
<link rel="stylesheet" href="css/singerinfo.css" />
</head>

<body>
	<%@include file="header.jsp"%>
	<div id="big"
		style="background-image: url(img/1913372.jpg); height: 500px; width: 1500px; float: left;">

		<div id="middle" style="">
			<img
				src="https://y.gtimg.cn/music/photo_new/T002R300x300M000003RMaRI1iFoYd.jpg?max_age=2592000"
				width="200" height="200" />
		</div>
		<div class="small ">

			<p>
				<span style="font-size: 30px">${album.name}</span>
			</p>
			<p>专辑</p>

			<!--
               	<a href="https://y.qq.com/n/yqq/singer/001bv9fL3w7HQj.html#stat=y_new.album.header.singername">吉克隽逸</a>
               	 -->
			<table>
				<tr>
					<td>风格：${album.style}</td>
					<td>语种：${album.language}</td>
					<td>发行日期：${album.date}</td>
					<td>发行公司：${album.company}</td>
				</tr>

			</table>


		</div>
		<div class="little">
			<dl>
				<dt>歌曲</dt>
				<c:forEach items="${sessionScope.tempList}" var="tempsong">
					<dd>
						<a href="./show?songid=${tempsong.id}">${tempsong.name}——${tempsong.singername}</a>
					</dd>
				</c:forEach>
			</dl>
		</div>
	</div>
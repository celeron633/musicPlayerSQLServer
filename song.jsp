<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线音乐播放管理系统V1.0-${song.name}</title>
<link rel="stylesheet" href="css/playmusic.css" />
</head>

<body>
	<%@include file="header.jsp"%>
	<div id="player"
		style="background-image: url(img/1913372.jpg); height: 500px; width: 1500px; float: left;">

		<div id="photo" style="">
			<img src="img/untitled.png" width="200" height="200" />
		</div>
		<div class="neirong ">

			<p>
				<span style="font-size: 30px">${song.name}</span>
			</p>
			<a href="./show?singerid=${song.singer}">${song.singername}</a>
			<table>
				<tr>
					<td>流派：${song.style}</td>
					<td>语种：${song.language}</td>
				</tr>
				<tr>
					<td>发行时间：2017.5.23</td>
					<td>播放量：${song.times}</td>
				</tr>
				<tr>
					<td>歌词：${song.lyric}</td>
				</tr>

			</table>
		</div>
		<div class="kuang">
			<div id="container">
				<input type="button" value="评论">
			</div>
			<div id="content">
				<input type="button" value="收藏" />
			</div>
			<audio src=${song.file } controls="controls" autoplay="autoplay"></audio>
			<!-- <embed src=${song.file} width=200 height=45 type=audio/mpeg loop="false" autostart="false" /> -->
		</div>
	</div>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线音乐播放管理系统V1.0-${singer.name}</title>
<link rel="stylesheet" href="css/singerinfo.css" />
</head>

<body>
	<%@include file="header.jsp"%>
	<div id="big"
		style='background-image: url(img/1913372.jpg); height: 500px; width: 1500px; float: left;'>

		<div id="middle" style="">
			<img src="${singer.image}" width="200" height="200" alt="" />
		</div>
		<div class="small ">

			<p>
				<span style="font-size: 30px">${singer.name}</span>
			</p>
			<p>${singer.introduction}</p>

			<!--
               	<a href="https://y.qq.com/n/yqq/singer/001bv9fL3w7HQj.html#stat=y_new.album.header.singername">吉克隽逸</a>
               	 -->
			<table>
				<tr>
					<td><c:if test="${singer.sex==true}">性别：男</c:if> <c:if
							test="${singer.sex==false}">性别：女</c:if></td>
					<td>生日：${singer.birthday}</td>
					<td>国籍：${singer.nation}</td>
					<td>家乡：${singer.hometown}</td>
				</tr>

			</table>


		</div>
		<div class="little">
			<div id="container">
				<input type="button" value="+关注74.9万" />
			</div>
			<dl>
				<dt>歌曲</dt>
				<c:forEach items="${sessionScope.tempList}" var="tempsong">
					<dd>
						<a href="./show?songid=${tempsong.id}">${tempsong.name}</a>
					</dd>
				</c:forEach>
			</dl>
		</div>
	</div>
</body>
</html>
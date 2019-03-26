<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.qqmusic.entity.Song"%>
<%@page import="com.qqmusic.service.SongService"%>
<%@page import="com.qqmusic.entity.Album"%>
<%@page import="com.qqmusic.service.AlbumService"%>
<%@page import="com.qqmusic.entity.Singer"%>
<%@page import="com.qqmusic.service.SingerService"%>
<%@page import="com.qqmusic.entity.Listq"%>
<%@page import="com.qqmusic.service.ListqService"%>
<%@page import="java.util.*"%>
<% 		
		SongService songService = new SongService();
		List<Song> songList = songService.getAllSongService();
		session.setAttribute("allList", songList);
		
		SingerService singerService= new SingerService();
		List<Singer> singerList = singerService.getAllSingerService();
		session.setAttribute("allList0", singerList);
		
		AlbumService albumService = new AlbumService();
		List<Album> albumList = albumService.getAllAlbumService();
		session.setAttribute("allList2", albumList);
		
		ListqService listqService = new ListqService();
		List<Listq> listqList = listqService.getAllListqService();
		session.setAttribute("allList3", listqList);
		
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线音乐播放管理系统V1.0</title>
<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon">
<link rel="icon" href="./favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="css/indexqq.css" />
<link rel="stylesheet" href="css/layout0323.css" />
<style>
.box {
	width: 98%;
	height: 70%;
	margin: 2%;
	boxder: 1px solid #ccc;
	background: #FFF;
	filter: alpha(opacity : 80);
	opacity: 0.8;
	-moz-opacity: 0.8;
	-khtml-opacity: 0.8
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<div id="toplist_box">
		<div class="mod_index mod_index--top mod_slide_box"
			style="background-image: url(./img/beijing3.jpg);">
			<div class="section_inner">


				<div class="mod_toplist">
					<ul class="toplist__list">

						<li class="toplist__item toplist__item--pop mod_cover">
							<div class="toplist__bg"></div> <i class="mod_cover__mask"></i> <i
							class="mod_cover__icon_play js_play_toplist"></i> <i
							class="toplist__line"></i>
							<h3 class="toplist__hd">
								<a
									href="https://y.qq.com/n/yqq/toplist/4.html?stat=y_new.index.toplist.detail1"
									class="toplist__tit js_toplist"><i class="toplist__tit_top"><i
										class="icon_txt">巅峰榜</i></i><b class="toplist__tit_pop">热门歌曲</b></a>
							</h3>
							<ul class="toplist__songlist">
								<c:forEach items="${sessionScope.allList}" var="tempsong"
									begin="0" end="4" varStatus="status">
									<li class="toplist__song">
										<div class="toplist__number">${status.index+1}</div>
										<div class="toplist__songname">
											<a href="./show?songid=${tempsong.id}" class="js_song">${tempsong.name}</a>
										</div>
										<div class="toplist__artist">
											<a href="./show?singerid=${tempsong.singer}"
												class="js_singer">${tempsong.singername}</a>
										</div>
									</li>
								</c:forEach>
							</ul>
						</li>
						<li class="toplist__item toplist__item--pop mod_cover">
							<div class="toplist__bg"></div> <i class="mod_cover__mask"></i> <i
							class="mod_cover__icon_play js_play_toplist"></i> <i
							class="toplist__line"></i>
							<h3 class="toplist__hd">
								<a
									href="https://y.qq.com/n/yqq/toplist/4.html?stat=y_new.index.toplist.detail1"
									class="toplist__tit js_toplist"><i class="toplist__tit_top"><i
										class="icon_txt">巅峰榜</i></i><b class="toplist__tit_pop">热门歌手</b></a>
							</h3>
							<ul class="toplist__songlist">
								<c:forEach items="${sessionScope.allList0}" var="tempsinger"
									begin="0" end="4" varStatus="status">
									<li class="toplist__song">
										<div class="toplist__number">${status.index+1}</div>
										<div class="toplist__songname">
											<a href="./show?singerid=${tempsinger.id}" class="js_song">${tempsinger.name}</a>
										</div>
										<div class="toplist__artist">.</div>
									</li>
								</c:forEach>
							</ul>
						</li>
						<li class="toplist__item toplist__item--pop mod_cover">
							<div class="toplist__bg"></div> <i class="mod_cover__mask"></i> <i
							class="mod_cover__icon_play js_play_toplist"></i> <i
							class="toplist__line"></i>
							<h3 class="toplist__hd">
								<a
									href="https://y.qq.com/n/yqq/toplist/4.html?stat=y_new.index.toplist.detail1"
									class="toplist__tit js_toplist"><i class="toplist__tit_top"><i
										class="icon_txt">巅峰榜</i></i><b class="toplist__tit_pop">热门专辑</b></a>
							</h3>
							<ul class="toplist__songlist">
								<c:forEach items="${sessionScope.allList2}" var="tempalbum"
									begin="0" end="4" varStatus="status2">
									<li class="toplist__song">
										<div class="toplist__number">${status2.index+1}</div>
										<div class="toplist__songname">
											<a href="./show?albumid=${tempalbum.id}" class="js_song">${tempalbum.name}</a>
										</div>
										<div class="toplist__artist">${tempalbum.company}</div>
									</li>
								</c:forEach>
							</ul>
						</li>
						<li class="toplist__item toplist__item--pop mod_cover">
							<div class="toplist__bg"></div> <i class="mod_cover__mask"></i> <i
							class="mod_cover__icon_play js_play_toplist"></i> <i
							class="toplist__line"></i>
							<h3 class="toplist__hd">
								<a
									href="https://y.qq.com/n/yqq/toplist/4.html?stat=y_new.index.toplist.detail1"
									class="toplist__tit js_toplist"><i class="toplist__tit_top"><i
										class="icon_txt">巅峰榜</i></i><b class="toplist__tit_pop">热门歌单</b></a>
							</h3>
							<ul class="toplist__songlist">
								<c:forEach items="${sessionScope.allList3}" var="templistq"
									begin="0" end="4" varStatus="status">
									<li class="toplist__song">
										<div class="toplist__number">${status.index+1}</div>
										<div class="toplist__songname">
											<a href="./show?listqid=${templistq.id}" class="js_song">${templistq.name}</a>
										</div>
										<div class="toplist__artist">
											<a href="./show?uid=${templistq.uid}" class="js_singer">${templistq.uname}</a>
										</div>
									</li>
								</c:forEach>
							</ul>
						</li>

					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
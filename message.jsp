<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% response.setHeader("refresh","2;URL=index.jsp"); %>
<%response.setHeader("Access-Control-Allow-Origin", "*");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线音乐播放管理系统V1.0-${sessionScope.messageTitle}</title>
</head>
<body>${sessionScope.messageContext}即将返回首页...
</body>

<script type="text/javascript">
  	  //计时
  	  var i=4;
  	  function run(){
  		  i--;
  		  document.getElementById("msg").innerHTML=i+"秒以后自动转到登录页面!";
  		  if(i<1){
  			  window.clearInterval(tm);//清除计时器
  			  window.location.href="${pageContext.request.contextPath }/index.jsp";
  		  }
  	  }
  	  var tm = window.setInterval(run, 1000);
  </script>
</html>
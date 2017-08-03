<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<base href="<%= basePath %>" />
	<title>机井用水计量与水权管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/new_blue_style.css" />
  </head>

  <body class="toppage">
  	<div class="toplogo"></div>
  	
  	<!-- <div class="topmenu">
  		<span><a href="left_sjgl.jsp" target="contents">数据管理</a></span><span><a href="left_map.jsp" target="contents">GIS地图</a></span>
  	</div>
  	 -->
  	<div title="退出登录" class="topuser">
  		<span><a href="logout.jsp" target="main"><img alt="退出登录" src="images/top-exit.png" /></a></span>
  	</div>
  	
  </body>
</html>
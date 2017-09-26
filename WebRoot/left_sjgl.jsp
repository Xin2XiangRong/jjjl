<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.jjjl.data.SysUserB"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SysUserB user = (SysUserB) request.getSession()
			.getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>机井用水计量与水权管理系统</title>
	<base target="main">
	<link rel="stylesheet" type="text/css" href="css/new_blue_style.css" />
	
	<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
	
	<script type="text/javascript">
		var policy="<%=user.getPolicy()%>";	
		$(document).ready(function() {		
			if (policy == 0) $("#userAdm").hide();	
		});
	</script>
  </head>
  <body style="margin: 0px 0px 0px 0px;overflow-x:hidden;overflow-y:auto;">
  	<div class="leftpage">
  		<div class="lefttitle"><span>数据查询</span></div>
  		<div class="leftmenu"><span><a href="JDWell/queryJDWell.jsp">机电井列表查询</a></span></div>
  		<div class="leftmenu"><span><a href="JCWell/queryJCWell.jsp">监测井列表查询</a></span></div>
  		<div class="lefttitle"><span>数据维护</span></div>
  		<div class="leftmenu"><span><a href="WeiHu/queryWellWH.jsp">机电井数据维护</a></span></div>
  		<div class="leftmenu"><span><a href="FenPei/queryWater.jsp">水量分配管理</a></span></div> 
  		<div class="lefttitle"><span>统计汇总</span></div>
  		<div class="leftmenu"><span><a href="huiZong/queryHuiZong.jsp">行政区用水汇总</a></span></div>
  		<div class="leftmenu"><span><a href="huiZong/queryFenXi.jsp">行政区数据分析</a></span></div>	
  		<div class="lefttitle"><span>系统管理</span></div>
  		<div id="userAdm" class="leftmenu"><span><a href="User/queryUser.jsp">用户管理</a></span></div>
  		<div class="leftmenu"><span><a href="xt/logInfo.action" target="_blank">系统日志</a></span></div>
  	</div>
  </body>
</html>

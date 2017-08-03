<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.jjjl.data.SysUserB" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Logger log = Logger.getLogger(this.getClass());
    SysUserB user = (SysUserB) session.getAttribute("user");	
	session.invalidate();	
   // log.info(user.getUserName() + "(" + user.getUserName() + ")" + "退出");
%>
<html>
  <head>
  	<base href="<%= basePath %>">  	
	<title>机井用水计量与水权管理系统</title>
	<link href="css/login.css" rel="stylesheet" type="text/css">	
  </head>
  <body> 
	<table width="968" height="200" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td align="center"><font color="white" size="12">已成功退出系统</font></td></tr> 
		<tr><td align="center"><a href="login.jsp" target="_self"><font size="4">重新登录</font></a></td></tr>
	</table> 
  </body>
</html>



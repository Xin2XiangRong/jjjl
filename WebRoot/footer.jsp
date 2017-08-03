<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  	<base href="<%=basePath%>">
	<title>机井用水计量与水权管理</title>	
	<link href="css/new_blue_style.css" type=text/css rel=stylesheet>
  </head>

  <body leftmargin="0" topmargin="0">
	<div class="footnav">北方工业大学</div>
  </body>
</html>

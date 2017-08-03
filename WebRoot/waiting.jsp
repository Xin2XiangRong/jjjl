<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>等待数据加载页面</title>
  </head>
  
  <body>
    <table width="100%" height="150">
        <tr>
        	<td width="100%" height="100%" align="center" valign="bottom">
        		<img src="images/loading2.gif">
        	</td>
        </tr>
	</table>
  </body>
  
</html>

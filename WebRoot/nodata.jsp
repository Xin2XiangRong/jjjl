<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<base href="<%= basePath %>">
	<title>没有相关数据</title>
  </head>

  <body>
    <table width="100%" height="150">
        <tr>
        	<td width="100%" height="100%" align="center" valign="bottom">
        		<img src="images/error_nodata.gif" />
        	</td>
        </tr>
	</table>
  </body>
</html>
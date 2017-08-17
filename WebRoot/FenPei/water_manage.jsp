<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>水权分配管理</title>

<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<style type="text/css">


</style>

<script type="text/javascript" src="js/jquery-1.6.js"></script>
<script src="js/jquery.jqzoom-core.js" type="text/javascript"></script>

<link rel="stylesheet" href="css/jquery.jqzoom.css" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {
		$('.jqzoom').jqzoom({
            zoomType: 'innerzoom',
            preloadImages: false,
            alwaysOn:false
        });
	});
</script>
<style type="text/css">

	/* td {
		text-align: center;
	} */
	
</style>
</head>
<body>
	<div class="table_content">
	<div class="tb_blue2">
			<table height="90%" width="100%" border="0" cellspacing="0" align="center"
				cellpadding="0" >
				<tr>
					<td width="30%">转出方：</td>
					<td>
						<s:property value="#session.cityB.cityNm"/>
						<s:property value="#session.townXuKe1.jlTownB.jlCountyB.countyNm"/>
						<s:property value="#session.townXuKe1.jlTownB.xiangNm"/>
					</td>
				</tr>
				<tr>
					<td width="30%">转出方交易后水权量：</td>
					<td><s:property value="#session.townXuKe1.xukeW"/></td>
				</tr>
				<tr>
					<td width="30%">转入方：</td>
					<td >
						<s:property value="#session.cityB.cityNm"/>
						<s:property value="#session.townXuKe2.jlTownB.jlCountyB.countyNm"/>
						<s:property value="#session.townXuKe2.jlTownB.xiangNm"/>
					</td>
				</tr>
				<tr>
					<td width="30%">转入方交易后水权量：</td>
					<td><s:property value="#session.townXuKe2.xukeW"/></td>
				</tr>
				<tr>
					<td width="30%">备注：</td>
					<td ><s:property value="#session.townWT.nt"/></td>
				</tr>
				<tr >
					<td colspan="2">协议书扫描件：</td>
					
				</tr>
				<s:iterator var="fileName" value="#session.multiFileFileName" status="st">
				<tr >
				<td colspan="2">
					文件名：<s:property value="fileName"/>&nbsp;&nbsp;<br>
        			<a href="Upload/${fileName }" class="jqzoom"  title="协议扫描件" >
					<img alt="协议扫描件" src="Upload/${fileName }" height="200px" width="50%">
					</a>
				</td>
				</tr>
				</s:iterator>
			</table>
	</div>
	</div>
</body>
</html>

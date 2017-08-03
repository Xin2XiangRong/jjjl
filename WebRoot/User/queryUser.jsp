<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.jjjl.data.SysUserB" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SysUserB user=(SysUserB)request.getSession().getAttribute("user");	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>水量分配管理</title>
<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		
	// 设置jQuery-ui的按钮样式
	$("td").each(function() {
		$(this).css("text-align", "left").css("text-indent", "1em");
	});
	$("input").each(function() {
		$(this).css("height", "30px");
	});	
	
	
	setTimeout(function(){
		$("#form").submit();
	},1000);
});

</script>
</head>

<body class="gray-bg">
	<div class="table_content" style="margin-bottom: 0px;">
		<span>用户管理</span>
		<hr	style="height:1px;border:none;border-top:1px solid #165fd5; margin: 0px 0px 10px 0px;" />
		<form id="form" name="form"  action="xt/query.action" method="post" target="result">
		</form>
	</div>
	<iframe name="result" src="waiting.jsp" width="100%" height="80%"
		frameborder="0"></iframe>
</body>
</html>

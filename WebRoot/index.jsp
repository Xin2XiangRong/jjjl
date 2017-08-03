<%@ page language="java" pageEncoding="UTF-8"%>
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
    <title>机井用水计量与水权管理系统</title>	
  	<script type="text/javascript">
	
		function closeSession() {
			document.location = "logout.jsp";
		}
	
	</script>
  </head>
  
  <frameset rows="78,*,35" framespacing="0" frameborder="0" name="main_frame_top" onbeforeunload="closeSession()">
	<frame name="banner" scrolling="no" noresize target="contents" src="top.jsp" id="main_top">
	<frameset cols="208,10,*" rows="*" name="main_frame" id="main_frame">
		<frame name="contents" target="main" src="left_sjgl.jsp" scrolling="auto" noresize class="frame_border">
		<frame name="botton" src="middle.html" scrolling="no" noresize >
		<frame name="main" src="sjgl.html" scrolling="auto" class="frame_border">
	</frameset>
	<frame src="footer.jsp" name="" frameborder="no" scrolling="No" noresize="NORESIZE" id="" title="topFrame" />

	<noframes> 
		<body>
			<p>此网页使用了框架，但您的浏览器不支持框架。</p>
		</body>
	</noframes>
  </frameset>
</html>
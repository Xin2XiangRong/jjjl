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

<title>水量分配管理</title>
<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript">
	function pageFunc(page) {
		 parent.document.form.currentPage.value=page;
		 window.parent.document.getElementById("form").submit();
		return false;
	}
</script>
</head>

<body>
<body class="gray-bg" style="margin:0px 0px 0px 0px; overflow-y:auto;">
	<div class="white-bg"
		style="margin: 0px 15px 0px 15px; padding-top:10px;">
		<div class="tb_blue2" style="margin:15px 15px 15px 15px;">
			<table id="pageTable" width="80%" border="0" cellspacing="0"
				cellpadding="0" class="border0" align="center">
				<thead>
					<tr>
						<th width="5%">#</th>
						<th width="10%">行政区编码</th>
						<th width="20%">行政区名称</th>
						<th width="20%">许可年用水量</th>
						<th width="15%" colspan="3">操作</th>
					</tr>
				</thead>

				<s:iterator value="#session.waterList" var="water" status="status">
					<tr onMouseOver="this.className='tr_over'"
						onMouseOut="this.className= 'tr_out'">
						<td><s:property value="#status.index + 1" /></td>
						<td><s:property value="#water.jlCityB.cityCd" /></td>
						<td><s:property value="#water.jlCityB.cityNm" />&nbsp;</td>
						<td><s:property value="#water.xukeW" /></td>
						<td><div class="but_blue_small" style="width:70px"><a href="fp/toTransact.action?cityCd=<s:property value="#water.jlCityB.cityCd"/>" target="_self">管理分配</a></div></td>					
					</tr>
				</s:iterator>
			</table>
		</div>

		<div class="page_blue" style="text-align:center">			
			<span style="width: 50px"><a href="#" onclick="return pageFunc(1)"> 首页 </a></span>
			<s:if test="%{#session.page.currentPage > 1}">
			<span style="width: 50px"><a href="#" onclick="return pageFunc(<s:property value="#session.page.currentPage - 1" />)">上一页</a></span>
			</s:if>
			<s:if test="%{#session.page.currentPage < #session.page.totalPage}">
			   <span style="width: 50px"><a href="#" onclick="return pageFunc(<s:property value="#session.page.currentPage + 1" />)"> 下一页 </a></span>
			</s:if>
			<span style="width: 50px"><a href="#" onclick="return pageFunc(<s:property value="#session.page.totalPage" />)"> 尾页 </a></span>
			<span style="width: 150px">第 <s:property value="#session.page.currentPage" /> 页，共 <s:property value="#session.page.totalPage" /> 页</span>
		</div>
		<br>
		<br>
	</div>
</body>
</html>

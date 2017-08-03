<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>监测井</title>    
	<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
    <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    <script type="text/javascript">
       function pageFunc(page) {
		     parent.document.form.currentPage.value=page;
		     window.parent.document.getElementById("form").submit();		     
	   }
    </script>
  </head>  
  <body>
    <body class="gray-bg" style="margin:0px 0px 0px 0px; overflow-y:auto;">
	<div class="white-bg"
		style="margin: 0px 15px 0px 15px; padding-top:10px;">
		<div class="tb_blue2" style="margin:15px 15px 15px 15px;">
			<table id="pageTable" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<thead>
					<tr>
						<th width="5%">#</th>
						<th width="15%">机井编号</th>
						<th width="20%">机井名称</th>						
						<th width="10%">井深(m)</th>
						<th width="10%">当年水量</th>
						<th width="10%">当月水量</th>
						<th width="10%">当日水量</th>
						<th width="10%">监机井详情</th>
						<th width="10%">用水信息</th>
					</tr>
				</thead>

				<s:iterator value="#session.autoWellBList" var="autoWellB" status="status">
					<tr onMouseOver="this.className='tr_over'"
						onMouseOut="this.className= 'tr_out'">
						<td><s:property value="#status.index + 1" /></td>
						<td><s:property value="#autoWellB.wellCd" /></td>
						<td><s:property value="#autoWellB.wellNm" /></td>
						<td><s:property value="#autoWellB.p801004" /></td>
						<td><s:property value="#autoWellB.yearW" /></td>
						<td><s:property value="#autoWellB.monthW" /></td>
						<td><s:property value="#autoWellB.dayW" /></td>					
						<td><div class="but_blue_small" style="width:70px"><a href="autoWellB/detail.action?wellCd=<s:property value="#autoWellB.wellCd"/>" target="_blank">监测井详情</a></div></td>
						<td><div class="but_blue_small" style="width:70px"><a href="autoWellB/yongshui.action?wellCd=<s:property value="#autoWellB.wellCd"/>" target="_blank">用水信息</a></div></td>						
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
	</div>
  </body>
</html>

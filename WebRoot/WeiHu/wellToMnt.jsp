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
<title>添加监测井</title>

<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<link href="ui/theme/base/jquery-ui.css" rel="stylesheet">
<style type="text/css">


</style>

<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="ui/jquery-ui.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		// 设置文本样式
		$("td").each(function() {
			$(this).css("text-align", "left").css("text-indent", "1em");
		});
		$("font").each(function() {
			$(this).attr("font-size", "1.2em");
		});

		// 设置jQuery-ui的可折叠样式
		$(".accordion").accordion({
			collapsible : true, //是否可以收起
			heightStyle : "content", //高度适应内容
			icons : { //自定义图标
				header : "ui-icon-circle-arrow-e",
				activeHeader : "ui-icon-circle-arrow-s"
			}
		});
		
		$("#submit").click(function(){
			$("#form").submit();
	});
	});
	
	/* function clickadd(){
		return confirm("确认添加为监测井请点击确认");
	} */
</script>
<style type="text/css">

	td {
		text-align: center;
	}
	
</style>
</head>
<body>
	<form id="form" name="form" action="wh/doMonitor.action" method="post" >
	<div class="table_content">
		<span>添加监测井信息</span>
		<hr	style="height:1px;border:none;border-top:1px solid #165fd5; margin: 0px 0px 10px 0px;" />
		<div class="tb_blue2">
			<input type="hidden" name="autoWellB.wellCd" value="${ session.wellEdit.wellCd}"/>
			<table height="30" width="60%" border="0" cellspacing="0" align="center"
				cellpadding="0" class="border0">
				<tr>
					<td width="25%">编码</td>
					<td width="75%"><s:property value="wellCd"/></td>
				</tr>
				<tr>
					<td width="25%">名称</td>
					<td width="75%"><s:property  value="#session.wellEdit.wellNm"/>
					</td>
					
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">机井SIM卡号</td>
					<td colspan="3"><input name="autoWellB.sim" type="text" value="13811110001" />
					</td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">机井终端地址</td>
					<td colspan="3"><input name="autoWellB.wellAddress" type="text" value=""/></td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">设站年月</td>
					<td colspan="3"><input name="autoWellB.estYm" type="text" value="201706"/></td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">运行状况</td>
					<td colspan="3"><input name="autoWellB.runCoun" type="text" value=""/></td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">运行维护单位</td>
					<td colspan="3"><input name="autoWellB.engMan" type="text" value=""/></td>
				</tr>
				<tr>
					<td  align="center">备注</td>
					<td   colspan="3"><input name="autoWellB.nt" type="text" value="" /></td>
				</tr>
				<tr></tr>
			</table>
		</div>
	</div>
	<!-- <div id="submit" class="but_blue" style="margin:0 50%" onclick='return clickadd()'>确认添加</div> -->
	<div id="submit" class="but_blue" style="margin:0 50%" >确认添加</div>
	</form>
</body>
</html>

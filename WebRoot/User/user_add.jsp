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
<title>机电井基本信息</title>

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

		
		$("#submit").click(function(){
			$("#form").submit();
		});
	});
	
</script>

</head>

<body>
	<form id="form" name="form" action="xt/doUserAdd.action" method="post" >
	<div id="accordion1" class="accordion">
	<!-- 	<h3 style="font-size: 1.1em; font-weight: bold;">用户信息</h3> -->
		<div class="tb_blue2">
			<table height="30" width="60%" border="0" cellspacing="0" align="center"
				cellpadding="0" class="border0">
				<tr>
					<td width="25%">用户账号</td>
					<td width="75%"><input type="text" name="userB.userid"/></td>
				</tr>
				<tr>
					<td width="25%">用户密码</td>
					<td width="75%"><input type="password" name="userB.password"/></td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">用户姓名</td>
					<td><input name="userB.username" type="text"/></td>
				</tr>
				<tr>
					<td width="25%">所属地编码</td>
					<td width="75%">
						<!-- <input type="text" name="userB.sysUserMap.mapid"> -->
						<select name="userB.sysUserMap.mapid">
							<option value="1400">全省(14)</option>
							<option value="1401">太原市(1401)</option>
							<option value="1402">大同市(1402)</option>
							<option value="1403">阳泉市(1403)</option>
							<option value="1404">长治市(1404)</option>
							<option value="1405">晋城市(1405)</option>
							<option value="1406">朔州市(1406)</option>
							<option value="1407">晋中市(1407)</option>
							<option value="1408">运城市(1408)</option>
							<option value="1409">忻州市(1409)</option>
							<option value="1410">临汾市(1410)</option>
							<option value="1411">吕梁市(1411)</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="25%">所属地编码</td>
					<td width="75%">
						<!-- <input type="text" name="userB.sysUserMap.mapid"> -->
						<select name="userB.policy">
							<option value="0">无用户管理权限</option>
							<option value="1">有用户管理权限</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">电话</td>
					<td><input name="userB.telphone" type="text" value=""/></td>
				</tr>
				<tr>
					<td style="margin:0 auto;text-align:center">备注</td>
					<td ><input name="userB.nt" type="text"/></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="submit" class="but_blue" style="margin:0 50%" >确认添加</div>
	</form>
</body>
</html>

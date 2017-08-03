<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.3.js"></script>

<script type="text/javascript">
	function isTop() {
		if (top.location != self.location) {
			top.location.replace(self.location);
		}
	}
	window.onload = isTop;
	
	function resetPwd1(){
			$("#fmReset").submit();
		};
</script>
<style type="text/css">
	td {
		text-align: center;
	}
</style>
</head>
<body>
	<form method="post" action="sys/login.action">
		<table class="box" width="968" height="617" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div id="tb">
						<table width="260" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="2">
									<div style="color:red">
										<s:actionerror />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" class="text">用户名</td>
								<td height="30"><input type="text" id="userid"
									name="userid" maxlength="20" class="bar" size="20"></td>
							</tr>
							<tr>
								<td height="30" class="text">密 码</td>
								<td height="30"><input type="password" id="password"
									name="password" maxlength="20" class="bar" size="21"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" class="btn" value="登 录"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<form id="fmReset"  action="sys/toReset.action"></form>
</body>
</html>

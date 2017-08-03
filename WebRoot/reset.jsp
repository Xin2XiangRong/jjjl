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
<script type="text/javascript">
	function isTop() {
		if (top.location != self.location) {
			top.location.replace(self.location);
		}
	}
	window.onload = isTop;
	
	$("#reset").click(function(){
			$("#fmReset").submit();
	});
	
	function changePwd() {  
    var password = document.getElementById("password").value;  
    var repassword = document.getElementById("repassword").value;  
         if(password!=repassword){  
             window.alert("您输入的新密码与确认密码确认不一致");  
             signupForm.repassword.focus();  
             return false;  
               
             }  
          return true;  
    }  
</script>
</head>
<body>
	<form method="post" action="sys/doReset.action">
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
								<td height="30"><input name="user.userid" type="text" value="${ session.user.userid}" ></td>
							</tr>
							<tr>
								<td height="30" class="text">新 密 码</td>
								<td height="30"><input type="password" id="password"
									name="user.password" maxlength="20" class="bar" size="21"></td>
							</tr>
							<tr>
								<td height="30" class="text">确 认 密 码</td>
								<td height="30"><input type="password" id="repassword"
									 maxlength="20" class="bar" size="21"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" class="btn" value="确 定" onclick="return changePwd()"></td>
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

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

<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/jlCountyBServiceImpl.js"></script>
<script type="text/javascript" src="dwr/interface/jlTownBServiceImpl.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		
		$("#submit").click(function(){
			$("#form").submit();
		});
		
		queryCounty1();
		queryCounty2();
	});
	
	function queryCounty1(){
	$("#countyCd1").empty();
	$("#countyCd1").append('<option value="">请选择</option>');
	$("#xiangCd1").empty();
	$("#xiangCd1").append('<option value="">请选择</option>');
	alert("");
	jlCountyBServiceImpl.findByCityCd($("#cityCd").val(),countyCallback1);
}
function countyCallback1(data){
	if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#countyCd1").append(
						"<option value="+data[i].countyCd+">" + data[i].countyNm
								+ "</option>");
			}
		}
	}
	function set_Town1() {
		$("#xiangCd1").empty();
		$("#xiangCd1").append('<option value="">请选择</option>');
		jlTownBServiceImpl.findByCountyCd($("#countyCd1").val(), townCallback1);
	}
	function townCallback1(data) {
		if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#xiangCd1").append(
						"<option value="+data[i].xiangCd+">" + data[i].xiangNm
								+ "</option>");
			}
		}
	}
	
	function queryCounty2(){
	$("#countyCd2").empty();
	$("#countyCd2").append('<option value="">请选择</option>');
	$("#xiangCd2").empty();
	$("#xiangCd2").append('<option value="">请选择</option>');
	alert("");
	jlCountyBServiceImpl.findByCityCd($("#cityCd").val(),countyCallback2);
}
function countyCallback2(data){
	if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#countyCd2").append(
						"<option value="+data[i].countyCd+">" + data[i].countyNm
								+ "</option>");
			}
		}
	}
	function set_Town2() {
		$("#xiangCd2").empty();
		$("#xiangCd2").append('<option value="">请选择</option>');
		jlTownBServiceImpl.findByCountyCd($("#countyCd2").val(), townCallback2);
	}
	function townCallback2(data) {
		if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#xiangCd2").append(
						"<option value="+data[i].xiangCd+">" + data[i].xiangNm
								+ "</option>");
			}
		}
	}
	
	$("#submit2").click(function(){
			$("#formUp").submit();
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
	<div class="table_content">
	<form id="form" name="form" action="fp/doTransact.action" method="post">
	<div>
		<div class="tb_blue2">
			<table height="40%" width="100%" border="0" cellspacing="0" align="center"
				cellpadding="0" class="border0">
				<tr>
					<td width="20%">转出方：
						<input type="hidden" id="cityCd" name="cityCd" value="${ session.cityB.cityCd }"> 
					</td>
					<td width="15%">县市</td>
					<td width="25%">
						<select id="countyCd1" class="countyCd" name="countyCd" style="width:70%" onchange="set_Town1()" class="select_gray">
							<option value="">请选择</option>
						</select>
					</td>
					<td width="15%">乡镇</td>
					<td width="25%">
						<select id="xiangCd1" class="xiangCd" name="townWT.jlTownB1.xiangCd" style="width:70%" class="select_gray">
							<option value="">请选择</option>
						</select>
					</td>
					<td width="75%"><s:property value="wellCd"/></td>
				</tr>
				<tr>
					<td width="20%">转入方：</td>
					<td width="15%">县市</td>
					<td width="25%">
						<select id="countyCd2" class="countyCd" name="countyCd" style="width:70%" onchange="set_Town2()" class="select_gray">
							<option value="">请选择</option>
						</select>
					</td>
					<td width="15%">乡镇</td>
					<td width="25%">
						<select id="xiangCd2" class="xiangCd" name="townWT.jlTownB2.xiangCd" style="width:70%" class="select_gray">
							<option value="">请选择</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>交易水权量</td>
					<td colspan="4"><input type="text" name="townWT.TW" value="" style="text-align:left;width:200px"/>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="4"><input type="text" name="townWT.nt" value="" style="width:65%"/></td>
				</tr>
				<!-- <tr>
					<td>协议书扫描件：</td>
					<td colspan="2"><input type="file" multiple size="80" name="multiFile"><br>第一个文件域</td>
					<td colspan="2"><div  class="but_blue" ><a style="text-decoration:none;" href="fp/upload.action">上传</a></div></td>
				</tr> -->
			</table>
		</div>
	</div>
	<!-- <div id="submit" class="but_blue" style="margin:0 50%" >确认添加</div> -->
	</form>
	<s:fielderror></s:fielderror>
	<form id="formUp" name="formUp" action="fp/upload.action" method="post" enctype="multipart/form-data" target="nm_iframe">
		<div class="tb_blue2">
			<table height="10%" width="100%" border="0" cellspacing="0" align="center"
				cellpadding="0" class="border0">
				<tr>
					<td>协议书扫描件：</td>
					<td colspan="2">
						<input type="file" multiple size="80" name="multiFile"><!--第一个文件域-->
						<input type="submit" value="上传">
					</td>
					<!-- <td colspan="2"><input type="submit" value="上传"></td> -->
				</tr>
			</table>
		</div>
	</form>
	<!-- 为了实现页面不跳转 -->
	<iframe id="id_iframe" name="nm_iframe" height="35%" width="100%" frameborder="0" scrolling="auto" ></iframe>
	<div id="submit" class="but_blue" style="margin:0 50%" >确认添加</div>
</div>
</body>
</html>

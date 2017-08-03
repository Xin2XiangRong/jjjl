<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.jjjl.data.SysUserB"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SysUserB user = (SysUserB) request.getSession()
			.getAttribute("user");
			
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>监测井查询</title>
<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/jlCityBServiceImpl.js"></script>
<script type="text/javascript"
	src="dwr/interface/jlCountyBServiceImpl.js"></script>
<script type="text/javascript" src="dwr/interface/jlTownBServiceImpl.js"></script>
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
	$("#div1").click(function(){
		var strtemp=$("#div1").html();		
		if(strtemp=="显示更多条件"){
			$("#div2").css("display","block");
			$("#div1").html("隐层更多条件");
		}else{
			$("#div2").css("display","none");
			$("#div1").html("显示更多条件");
		}
	});
	$("#div3").click(function(){
		$("#form").submit();
	});
	queryCity();
	setTimeout(function(){
		$("#div3").click();
	},1000);
});
function queryCity(){
	var mapid="<%=user.getSysUserMap().getMapid()%>";	
	$("#cityCd").empty();
	$("#cityCd").append('<option value="">请选择</option>');
	$("#countyCd").empty();
	$("#countyCd").append('<option value="">请选择</option>');
	$("#xiangCd").empty();
	$("#xiangCd").append('<option value="">请选择</option>');
	jlCityBServiceImpl.findByMapid(mapid,cityCallback);
}
function cityCallback(data){
	if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#cityCd").append(
						"<option value="+data[i].cityCd+">" + data[i].cityNm
								+ "</option>");
			}
		}
	}
	function set_County() {
		$("#countyCd").empty();
		$("#countyCd").append('<option value="">请选择</option>');
		$("#xiangCd").empty();
		$("#xiangCd").append('<option value="">请选择</option>');
		jlCountyBServiceImpl.findByCityCd($("#cityCd").val(), countyCallback)
	}
	function countyCallback(data) {
		if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#countyCd").append(
						"<option value="+data[i].countyCd+">"
								+ data[i].countyNm + "</option>");
			}
		}
	}
	function set_Town() {
		$("#xiangCd").empty();
		$("#xiangCd").append('<option value="">请选择</option>');
		jlTownBServiceImpl.findByCountyCd($("#countyCd").val(), townCallback);
	}
	function townCallback(data) {
		if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#xiangCd").append(
						"<option value="+data[i].xiangCd+">" + data[i].xiangNm
								+ "</option>");
			}
		}
	}
</script>
</head>
<body>
<body class="gray-bg">
	<div class="table_content" style="margin-bottom: 0px;">
		<span>监测井查询</span>
		<hr	style="height:1px;border:none;border-top:1px solid #165fd5; margin: 0px 0px 10px 0px;" />
		<form id="form" name="form" action="autoWellB/query.action"
			method="post" target="result">
			<div>
					<span style="height: 30px; line-height:30px; font-size: 14px;">市</span>
					<select id="cityCd" name="cityCd" style="width:120px" onchange="set_County()" class="select_gray">
							<option value="">请选择</option>
					</select>
					<input type="hidden" id="currentPage" name="currentPage"
							value=""> 
					<span style="height: 30px; line-height:30px; font-size: 14px;">县</span>
					<select id="countyCd" name="countyCd" style="width:120px" onchange="set_Town()" class="select_gray">
							<option value="">请选择</option>
					</select>
					<span style="height: 30px; line-height:30px; font-size: 14px;">乡</span>
					<select id="xiangCd" name="xiangCd" style="width:120px"  class="select_gray">
							<option value="">请选择</option>
					</select>
					<div id="div1" class="but_blue_border" style="width: 160px">显示更多条件</div>				
			</div>
			<div id="div2" style="display:none;">
			  <br>
			 <span style="height: 30px; line-height:30px; font-size: 14px;">井深(m)</span>
					<select id="p801004" name="p801004" style="width:120px" onchange="" class="select_gray">
							<option value="">请选择</option>
							<option value="1"><50</option>
							<option value="2">50～100</option>
							<option value="3">100～500</option>
							<option value="4">>500</option>
					</select>
					<span style="height: 30px; line-height:30px; font-size: 14px;">额定流量(m<sup>3</sup>/h)</span>
					<select id="p801011" name="p801011" style="width:120px" onchange="" class="select_gray">
							<option value="">请选择</option>
							<option value="1"><20</option>
							<option value="2">20～50</option>
							<option value="3">50～100</option>
							<option value="4">>100</option>
					</select>					
					<span style="height: 30px; line-height:30px; font-size: 14px;">主要取水用途</span>
					<select id="p801022" name="p801022" style="width:120px" onchange="" class="select_gray">
							<option value="">请选择</option>
							<option value="1">农业灌溉</option>
							<option value="2">农村生活</option>
							<option value="3">城镇生活</option>
							<option value="4">工业</option>
					</select>				
			</div>
			<div >
			     <br>				
				<span style="height: 30px; line-height:30px; font-size: 14px;">关键字</span>
				<input id ="wellNm" name="wellNm" type="text" class="input_gray">
				<div id="div3" class="but_blue" >查  询</div>
			</div>			
		</form>
	</div>
	<iframe name="result" src="waiting.jsp" width="100%" height="80%"
		frameborder="0"></iframe>
</body>
</html>

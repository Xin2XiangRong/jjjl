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
<title>机电井基本信息</title>

<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<link href="ui/theme/base/jquery-ui.css" rel="stylesheet">
<style type="text/css">

</style>

<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="ui/jquery-ui.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/jlCityBServiceImpl.js"></script>
<script type="text/javascript" src="dwr/interface/jlCountyBServiceImpl.js"></script>
<script type="text/javascript" src="dwr/interface/jlTownBServiceImpl.js"></script>
<script type="text/javascript" src="dwr/interface/jlVillageBServiceImpl.js"></script>
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
		queryCity();
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
	
	function set_Village() {
		$("#villageCd").empty();
		$("#villageCd").append('<option value="">请选择</option>');
		jlVillageBServiceImpl.findByXiangCd($("#xiangCd").val(), villageCallback);
	}
	function villageCallback(data) {
		if (data != null) {
			for (var i = 0; i < data.length; i++) {
				$("#villageCd").append(
						"<option value="+data[i].villageid+">" + data[i].villagenm
								+ "</option>");
			}
		}
	}
	
	function clickadd(){
		return confirm("添加请点击确认");
	}
</script>

</head>

<body>
	
	<%-- <s:push value="#session.wellEdit"> --%>
	<form id="form" name="form" action="wh/doWellAdd.action" method="post" >
	<div id="accordion1" class="accordion">
		<h3 style="font-size: 1.1em; font-weight: bold;">一、基本情况</h3>
		<div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td colspan="4">1.名称、编码、详细位置及地理坐标</td>
				</tr>
				<tr>
					<td width="25%">名称</td>
					<td width="25%"><input name="wellB.wellNm" type="text" value="" ></input>
					</td>
					
				</tr>
				<tr>
					<td>详细位置</td>
					<td colspan="3">山西省&nbsp;&nbsp;
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
					<select id="xiangCd" name="wellB.jlTownB.xiangCd" style="width:120px" onchange="set_Village()" class="select_gray">
							<option value="">请选择</option>
					</select>
					<select id="villageCd" name="wellB.jlVillageB.villageid" style="width:120px"  class="select_gray">
							<option value="">请选择</option>
					</select>
					<input name="wellB.loc" type="text" value="" ></input>	
					</td>
				</tr>
				<tr>
					<td>地理坐标</td>
					<td colspan="3">东经&nbsp;<input name="wellB.edegrees" type="text" value="" />度
						<input name="wellB.eminutes" type="text" value="" />分<input name="wellB.eseconds" type="text" value="" />秒 &nbsp;&nbsp;
						北纬&nbsp;<input name="wellB.ndegrees" type="text" value="" />度<input name="wellB.nminutes" type="text" value="" />分
						<input name="wellB.nseconds" type="text" value="" />秒
					</td>
				</tr>
				<tr>
					<td colspan="4">2.成井时间、井深及地下水埋深</td>
				</tr>
				<tr>
					<td>成井时间</td>
					<td><input name="wellB.p801003" type="text" value="" />年
					</td>
					<td>井深(米)</td>
					<td><input name="wellB.p801004" type="text" value="" />
					</td>
				</tr>
				<tr>
					<td>地下水埋深(米)</td>
					<td><input name="wellB.p801005" type="text" value="" />
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>3.是否为单位自备井</td>
					<td><input name="wellB.p801006" type="text" value="" />
					</td>
					<td>4.井口井管内径(毫米)</td>
					<td><input name="wellB.p801020" type="text" value="" />
					</td>
				</tr>
				<tr>
					<td>5.井壁管材料</td>
					<td><input name="wellB.p801052" type="text" value="" /></td>
					<td>6.应用状况</td>
					<td><input name="wellB.p801007" type="text" value="" /></td>
				</tr>
				<tr>
					<td>7.是否已配套机电设备</td>
					<td><input name="wellB.p801008" type="text" value="" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>水泵型号</td>
					<td><input name="wellB.p801009" type="text" value="" /></td>
					<td>水泵额定扬程(米)</td>
					<td><input name="wellB.p801010" type="text" value="" /></td>
				</tr>
				<tr>
					<td>水泵额定流量(立方米/小时)</td>
					<td><input name="wellB.p801011" type="text" value="" /></td>
					<td>水泵额定功率(千瓦)</td>
					<td><input name="wellB.p801012" type="text" value="" /></td>
				</tr>
				<tr>
					<td>8.是否已安装水量计量设施</td>
					<td><input name="wellB.p801013" type="text" value="" /></td>
					<td>水量计量设施类型</td>
					<td><input name="wellB.p801014" type="text" value="" /></td>
				</tr>
				<tr>
					<td>9.是否为规模以上 地下水水源地的机电井</td>
					<td><input name="wellB.p801015" type="text" value="" />
					</td>
					<td>所在水源地名称及编码</td>
					<td><input name="wellB.p801017" type="text" value="" />
					</td>
				</tr>
				<tr>
					<td>10.所在地貌类型区</td>
					<td><input name="wellB.p801018" type="text" value="" />
					</td>
					<td>11.所取用地下水的类型</td>
					<td><input name="wellB.p801019" type="text" value="" />
					</td>
				</tr>
				<tr>
					<td>12.所在水资源三级区名称及编码</td>
					<td colspan="3"><input name="wellB.p801021" type="text" value="" />
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div id="accordion2" class="accordion">
		<h3 style="font-size: 1.1em; font-weight: bold;">二、取水情况</h3>
		<div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td>13.水源类型</td>
					<td><input name="wellB.p801027" type="text" value="" />
					</td>
					<td>14.主要取水用途</td>
					<td><input name="wellB.p801022" type="text" value="" /></td>
				</tr>
				<tr>
					<td>乡村实际供水人口(人)</td>
					<td><input name="wellB.p801023" type="text" value="" /></td>
				</tr>
				<tr>
					<td>所在灌区类型</td>
					<td><input name="wellB.p801024" type="text" value="" /></td>
					<td>控制灌溉面积(亩)</td>
					<td><input name="wellB.p801025" type="text" value="" /></td>
					<td>实际灌溉面积(亩)</td>
					<td><input name="wellB.p801026" type="text" value="" /></td>
				</tr>
			</table>
		</div>
	</div>

	<div id="accordion3" class="accordion">
		<h3 style="font-size: 1.1em; font-weight: bold;">三、管理情况</h3>
		<div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td>19.是否已办理取水许可证</td>
					<td><input name="wellB.p801029" type="text" value="" /></td>
					<td></td>
					<td></td>
				</tr>
					<tr>
						<td>取水许可证编号</td>
						<td><input name="wellB.p801030" type="text" value="" /></td>
						<td>年许可取水量(万立方米)</td>
						<td><input name="wellB.p801031" type="text" value="" /></td>
					</tr>
					<tr>
						<td>20.是否已办理采矿许可证</td>
						<td><input name="wellB.p801054" type="text" value="" /></td>
						<td></td>
						<td></td>
					</tr>
						<tr>
							<td>采矿许可证证号</td>
							<td><input name="wellB.p801056" type="text" value="" /></td>
							<td>矿区面积(平方千米)</td>
							<td><input name="wellB.p801057" type="text" value="" /></td>
						</tr>
						<tr>
							<td>生产规模(万立方米/a)</td>
							<td><input name="wellB.p801058" type="text" value="" /></td>
							<td></td>
							<td></td>
						</tr>
				<tr>
					<td colspan="4">21.管理单位名称及隶属关系</td>
				</tr>
				<tr>
					<td>名称</td>
					<td><input name="wellB.p801032" type="text" value="" /></td>
					<td>隶属关系</td>
					<td><input name="wellB.p801033" type="text" value="" /></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- <div id="submit" class="but_blue" style="margin:0 50%" onclick='return clickadd()'>确认添加</div> -->
	<div id="submit" class="but_blue" style="margin:0 50%" >确认添加</div>
	</form>
</body>
</html>

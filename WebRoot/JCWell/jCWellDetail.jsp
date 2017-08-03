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
<title>监测井基本信息</title>
<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<link href="ui/theme/base/jquery-ui.css"
	rel="stylesheet">
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

	});

</script>

</head>

<body>

	<div id="accordion1" class="accordion">
	    <h3 style="font-size: 1.1em; font-weight: bold;">一、监测设置</h3>
	    <div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td width="25%">机井sim卡号</td>
					<td width="25%"><font><s:property
								value="#session.autoWellBDetail.sim" /> </font>
					</td>
					<td width="25%">机井终端地址</td>
					<td width="25%"><font><s:property
								value="#session.autoWellBDetail.wellAddress" /> </font>
					</td>
				</tr>
				<tr>
					<td width="25%">设站年月</td>
					<td width="25%"><font><s:property
								value="#session.autoWellBDetail.estYm" /> </font>
					</td>
					<td width="25%">运行状况</td>
					<td width="25%"><font><s:property
								value="#session.autoWellBDetail.runCoun" /> </font>
					</td>
				</tr>
				<tr>
					<td width="25%">管理单位</td>
					<td colspan="3"><font><s:property
								value="#session.autoWellBDetail.engMan" /> </font>
					</td>
					
				</tr>
			</table>
		</div>
		<h3 style="font-size: 1.1em; font-weight: bold;">二、基本情况</h3>
		<div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td colspan="4">1.名称、编码、详细位置及地理坐标</td>
				</tr>
				<tr>
					<td width="25%">名称</td>
					<td width="25%"><font><s:property
								value="#session.autoWellBDetail.jlExchWellB.wellNm" /> </font>
					</td>
					<td width="25%">编码</td>
					<td width="25%"><font><s:property
								value="#session.autoWellBDetail.jlExchWellB.wellCd" /> </font>
					</td>
				</tr>
				<tr>
					<td>详细位置</td>
					<td colspan="3">山西省&nbsp;&nbsp;<s:property
							value="#session.autoWellBDetail.jlExchWellB.jlTownB.jlCountyB.jlCityB.cityNm" />&nbsp;&nbsp;<s:property
							value="#session.autoWellBDetail.jlExchWellB.jlTownB.jlCountyB.countyNm" />&nbsp;&nbsp;<s:property
							value="#session.autoWellBDetail.jlExchWellB.jlTownB.xiangNm" />&nbsp;&nbsp;<s:property value="#session.autoWellBDetail.jlExchWellB.jlVillageB.villagenm"/>&nbsp;&nbsp;
							<s:property value="#session.autoWellBDetail.jlExchWellB.loc"/>
					</td>
				</tr>
				<tr>
					<td>地理坐标</td>
					<td colspan="3">东经&nbsp;<s:property value="#session.autoWellBDetail.jlExchWellB.edegrees" />度<s:property
							value="#session.autoWellBDetail.jlExchWellB.eminutes" />分<s:property
							value="#session.autoWellBDetail.jlExchWellB.eseconds" />秒 &nbsp;&nbsp;北纬&nbsp;<s:property
							value="#session.autoWellBDetail.jlExchWellB.ndegrees" />度<s:property
							value="#session.autoWellBDetail.jlExchWellB.nminutes" />分<s:property
							value="#session.autoWellBDetail.jlExchWellB.nseconds" />秒</td>
				</tr>
				<tr>
					<td colspan="4">2.成井时间、井深及地下水埋深</td>
				</tr>
				<tr>
					<td>成井时间</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801003" />年
					</td>
					<td>井深(米)</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801004Str()" />
					</td>
				</tr>
				<tr>
					<td>地下水埋深(米)</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801005Str()"/>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>3.是否为单位自备井</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801006" />
					</td>
					<td>4.井口井管内径(毫米)</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801020" />
					</td>
				</tr>
				<tr>
					<td>5.井壁管材料</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801052" />
					</td>
					<td>6.应用状况</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801007"/></td>
				</tr>
				<tr>
					<td>7.是否已配套机电设备</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801008" />
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>水泵型号</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801009" />
					</td>
					<td>水泵额定扬程(米)</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801010Str()"/></td>
				</tr>
				<tr>
					<td>水泵额定流量(立方米/小时)</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801011Str()" />
					</td>
					<td>水泵额定功率(千瓦)</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801012Str()" />
					</td>
				</tr>
				<tr>
					<td>8.是否已安装水量计量设施</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801013" />
					</td>
					<td>水量计量设施类型</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801014" />
					</td>
				</tr>
				<tr>
					<td>9.是否为规模以上 地下水水源地的机电井</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801015" />
					</td>
					<td>所在水源地名称及编码</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801017" />
					</td>
				</tr>
				<tr>
					<td>10.所在地貌类型区</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801018" />
					</td>
					<td>11.所取用地下水的类型</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801019" />
					</td>
				</tr>
				<tr>
					<td>12.所在水资源三级区名称及编码</td>
					<td colspan="3"><s:property value="#session.autoWellBDetail.jlExchWellB.p801021" />
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div id="accordion2" class="accordion">
		<h3 style="font-size: 1.1em; font-weight: bold;">三、取水情况</h3>
		<div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td>13.水源类型</td>
					<td><s:property value="#session.wellDetail.p801027" />
					</td>
					<td>14.主要取水用途</td>
					<td><s:property value="#session.wellDetail.p801022" />
					</td>
				</tr>
				<s:if test='#session.wellDetail.p801022 == "乡村生活"'>
				<tr>
					<td>乡村实际供水人口(人)</td>
					<td><s:property value="#session.wellDetail.p801023"/></td>
				</tr>
				</s:if>
				<s:if test='#session.wellDetail.p801022 == "农业灌溉"'>
				<tr>
					<td>所在灌区类型</td>
					<td><s:property value="#session.wellDetail.p801024"/></td>
					<td>控制灌溉面积(亩)</td>
					<td><s:property value="#session.wellDetail.p801025"/></td>
					<td>实际灌溉面积(亩)</td>
					<td><s:property value="#session.wellDetail.p801026"/></td>
				</tr>
				</s:if>
			</table>
		</div>
	</div>

	<div id="accordion3" class="accordion">
		<h3 style="font-size: 1.1em; font-weight: bold;">四、管理情况</h3>
		<div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td>19.是否已办理取水许可证</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801029" />
					</td>
					<td></td>
					<td></td>
				</tr>
				<s:if test='#session.autoWellBDetail.jlExchWellB.p801029 == "是"'>
					<tr>
						<td>取水许可证编号</td>
						<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801030"/></td>
						<td>年许可取水量(万立方米)</td>
						<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801031Str()"/></td>
					</tr>
				</s:if>
				<s:if test='#session.autoWellBDetail.jlExchWellB.p801027 != "1"'>
					<tr>
						<td>20.是否已办理采矿许可证</td>
						<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801054Str()" />
						</td>
						<td></td>
						<td></td>
					</tr>
					<s:if test='#session.autoWellBDetail.jlExchWellB.p801054 == "1"'>
						<tr>
							<td>采矿许可证证号</td>
							<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801056"/></td>
							<td>矿区面积(平方千米)</td>
							<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801057Str()"/></td>
						</tr>
						<tr>
							<td>生产规模(万立方米/a)</td>
							<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801058Str()" />
							</td>
							<td></td>
							<td></td>
						</tr>
					</s:if>
				</s:if>
				<tr>
					<td colspan="4">21.管理单位名称及隶属关系</td>
				</tr>
				<tr>
					<td>名称</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801032" />
					</td>
					<td>隶属关系</td>
					<td><s:property value="#session.autoWellBDetail.jlExchWellB.p801033" />
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>

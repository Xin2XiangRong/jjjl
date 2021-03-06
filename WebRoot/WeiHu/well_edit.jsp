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
<title>修改机电井信息</title>

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
	
	
	
</script>

</head>

<body>
	
	<%-- <s:push value="#session.wellEdit"> --%>
	<form id="form" name="form" action="wh/update.action" method="post" >
	<div id="accordion1" class="accordion">
		<h3 style="font-size: 1.1em; font-weight: bold;">一、基本情况</h3>
		<div class="tb_blue2">
			<!-- 不作更改直接传递的参数 -->
			<input type="hidden" name="wellB.jlTownB.xiangCd" value="${ session.wellEdit.jlTownB.xiangCd}"/>
			<input type="hidden" name="wellB.jlTownB.xiangNm" value="${ session.wellEdit.jlTownB.xiangNm}"/>
			<input type="hidden" name="wellB.jlTownB.jlCountyB.countyCd" value="${ session.wellEdit.jlTownB.jlCountyB.countyCd}"/>
			<input type="hidden" name="wellB.jlVillageB.villageid" value="${ session.wellEdit.jlVillageB.villageid}"/>
			<input type="hidden" name="wellB.edegrees" value="${ session.wellEdit.edegrees}"/>
			<input type="hidden" name="wellB.eminutes" value="${ session.wellEdit.eminutes}"/>
			<input type="hidden" name="wellB.eseconds" value="${ session.wellEdit.eseconds}"/>
			<input type="hidden" name="wellB.ndegrees" value="${ session.wellEdit.ndegrees}"/>
			<input type="hidden" name="wellB.nminutes" value="${ session.wellEdit.nminutes}"/>
			<input type="hidden" name="wellB.nseconds" value="${ session.wellEdit.nseconds}"/>
			<input type="hidden" name="wellB.p801003" value="${ session.wellEdit.p801003}"/>
			<input type="hidden" name="wellB.p801052" value="${ session.wellEdit.p801052}"/>
			<input type="hidden" name="wellB.p801015" value="${ session.wellEdit.p801015}"/>
			<input type="hidden" name="wellB.p801017" value="${ session.wellEdit.p801017}"/>
			<input type="hidden" name="wellB.p801018" value="${ session.wellEdit.p801018}"/>
			<input type="hidden" name="wellB.p801019" value="${ session.wellEdit.p801019}"/>
			<input type="hidden" name="wellB.p801021" value="${ session.wellEdit.p801021}"/>
			<input type="hidden" name="wellB.p801027" value="${ session.wellEdit.p801027}"/>
			<input type="hidden" name="wellB.p801024" value="${ session.wellEdit.p801024}"/>
			<input type="hidden" name="wellB.p801030" value="${ session.wellEdit.p801030}"/>
			<input type="hidden" name="wellB.p801054" value="${ session.wellEdit.p801054}"/>
			
			<%-- <s:hidden name="wellB.jlVillageB" value="%{#session.wellEdit.jlVillageB}"></s:hidden>
			<s:hidden name="wellB.wellCd" value="%{#session.wellEdit.wellCd}"></s:hidden> --%>
			<input type="hidden" name="wellB.wellCd" value="${ session.wellEdit.wellCd}"/>
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<tr>
					<td colspan="4">1.名称、编码、详细位置及地理坐标</td>
				</tr>
				<tr>
					<td width="25%">名称</td>
					<td width="25%"><input name="wellB.wellNm" type="text" value="${ session.wellEdit.wellNm}" ></input>
					</td>
					<td width="25%">编码</td>
					<td width="25%"><s:property  value="wellCd"></s:property></td>
				</tr>
				<tr>
					<td>详细位置</td>
					<td colspan="3">山西省&nbsp;&nbsp;<s:property
							value="#session.wellEdit.jlTownB.jlCountyB.jlCityB.cityNm" />&nbsp;&nbsp;<s:property
							value="#session.wellEdit.jlTownB.jlCountyB.countyNm" />&nbsp;&nbsp;<s:property
							value="#session.wellEdit.jlTownB.xiangNm" />&nbsp;&nbsp;<s:property value="#session.wellEdit.jlVillageB.villagenm"/>&nbsp;&nbsp;
							<s:property value="#session.wellEdit.loc"/>
					</td>
				</tr>
				<tr>
					<td>地理坐标</td>
					<td colspan="3">东经&nbsp;<s:property value="#session.wellEdit.edegrees" />度<s:property
							value="#session.wellEdit.eminutes" />分<s:property
							value="#session.wellEdit.eseconds" />秒 &nbsp;&nbsp;北纬&nbsp;<s:property
							value="#session.wellEdit.ndegrees" />度<s:property
							value="#session.wellEdit.nminutes" />分<s:property
							value="#session.wellEdit.nseconds" />秒</td>
				</tr>
				<tr>
					<td colspan="4">2.成井时间、井深及地下水埋深</td>
				</tr>
				<tr>
					<td>成井时间</td>
					<td><s:property value="#session.wellEdit.p801003" />年
					</td>
					<td>井深(米)</td>
					<td><input name="wellB.p801004" type="text" value="${ session.wellEdit.p801004}" />
					</td>
				</tr>
				<tr>
					<td>地下水埋深(米)</td>
					<td><input name="wellB.p801005" type="text" value="${ session.wellEdit.p801005}" />
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>3.是否为单位自备井</td>
					<td><input name="wellB.p801006" type="text" value="${ session.wellEdit.p801006}" />
					</td>
					<td>4.井口井管内径(毫米)</td>
					<td><input name="wellB.p801020" type="text" value="${ session.wellEdit.p801020}" />
					</td>
				</tr>
				<tr>
					<td>5.井壁管材料</td>
					<td><s:property value="#session.wellEdit.p801052" /></td>
					<td>6.应用状况</td>
					<td><input name="wellB.p801007" type="text" value="${ session.wellEdit.p801007}" /></td>
				</tr>
				<tr>
					<td>7.是否已配套机电设备</td>
					<td><input name="wellB.p801008" type="text" value="${ session.wellEdit.p801008}" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>水泵型号</td>
					<td><input name="wellB.p801009" type="text" value="${ session.wellEdit.p801009}" /></td>
					<td>水泵额定扬程(米)</td>
					<td><input name="wellB.p801010" type="text" value="${ session.wellEdit.p801010}" /></td>
				</tr>
				<tr>
					<td>水泵额定流量(立方米/小时)</td>
					<td><input name="wellB.p801011" type="text" value="${ session.wellEdit.p801011}" /></td>
					<td>水泵额定功率(千瓦)</td>
					<td><input name="wellB.p801012" type="text" value="${ session.wellEdit.p801012}" /></td>
				</tr>
				<tr>
					<td>8.是否已安装水量计量设施</td>
					<td><input name="wellB.p801013" type="text" value="${ session.wellEdit.p801013}" /></td>
					<td>水量计量设施类型</td>
					<td><input name="wellB.p801014" type="text" value="${ session.wellEdit.p801014}" /></td>
				</tr>
				<tr>
					<td>9.是否为规模以上 地下水水源地的机电井</td>
					<td><s:property value="#session.wellEdit.p801015" />
					</td>
					<td>所在水源地名称及编码</td>
					<td><s:property value="#session.wellEdit.p801017" />
					</td>
				</tr>
				<tr>
					<td>10.所在地貌类型区</td>
					<td><s:property value="#session.wellEdit.p801018" />
					</td>
					<td>11.所取用地下水的类型</td>
					<td><s:property value="#session.wellEdit.p801019" />
					</td>
				</tr>
				<tr>
					<td>12.所在水资源三级区名称及编码</td>
					<td colspan="3"><s:property value="#session.wellEdit.p801021" />
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
					<td><s:property value="#session.wellEdit.p801027" />
					</td>
					<td>14.主要取水用途</td>
					<td><input name="wellB.p801022" type="text" value="${ session.wellEdit.p801022}" /></td>
				</tr>
				<s:if test='#session.wellEdit.p801022 == "乡村生活"'>
				<tr>
					<td>乡村实际供水人口(人)</td>
					<td><input name="wellB.p801023" type="text" value="${ session.wellEdit.p801023}" /></td>
				</tr>
				</s:if>
				<s:if test='#session.wellEdit.p801022 == "农业灌溉"'>
				<tr>
					<td>所在灌区类型</td>
					<td><s:property value="#session.wellEdit.p801024"/></td>
					<td>控制灌溉面积(亩)</td>
					<td><input name="wellB.p801025" type="text" value="${ session.wellEdit.p801025}" /></td>
					<td>实际灌溉面积(亩)</td>
					<td><input name="wellB.p801026" type="text" value="${ session.wellEdit.p801026}" /></td>
				</tr>
				</s:if>
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
					<td><input name="wellB.p801029" type="text" value="${ session.wellEdit.p801029}" /></td>
					<td></td>
					<td></td>
				</tr>
				<s:if test='#session.wellEdit.p801029 == "是"'>
					<tr>
						<td>取水许可证编号</td>
						<td><s:property value="#session.wellEdit.p801030"/></td>
						<td>年许可取水量(万立方米)</td>
						<td><input name="wellB.p801031" type="text" value="${ session.wellEdit.p801031}" /></td>
					</tr>
				</s:if>
				<s:if test='#session.wellEdit.p801027 != "1"'>
					<tr>
						<td>20.是否已办理采矿许可证</td>
						<td><s:property value="#session.wellEdit.p801054" />
						</td>
						<td></td>
						<td></td>
					</tr>
					<s:if test='#session.wellEdit.p801054 == "1"'>
						<tr>
							<td>采矿许可证证号</td>
							<td><s:property value="#session.wellEdit.p801056"/></td>
							<td>矿区面积(平方千米)</td>
							<td><s:property value="#session.wellEdit.p801057"/></td>
						</tr>
						<tr>
							<td>生产规模(万立方米/a)</td>
							<td><s:property value="#session.wellEdit.p801058" />
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
					<td><input name="wellB.p801032" type="text" value="${ session.wellEdit.p801032}" /></td>
					<td>隶属关系</td>
					<td><input name="wellB.p801033" type="text" value="${ session.wellEdit.p801033}" /></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="submit" class="but_blue" style="margin:0 50%">提交修改</div>
	</form>
	<%-- </s:push> --%>
</body>
</html>

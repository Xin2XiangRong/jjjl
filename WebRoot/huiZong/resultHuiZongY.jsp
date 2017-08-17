<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="net.sf.json.JSONArray" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					
Object jsonListWBY=request.getSession().getAttribute("jsonListWBY");	
Object jsonListXKY=request.getSession().getAttribute("jsonListXKY");	

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>行政区用水汇总结果</title>
    <link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
    <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="ui/jquery-ui.js"></script>
	<script type="text/javascript" src="js-jqChart/jquery.jqChart.min.js"></script>
	<script type="text/javascript" src="js-jqChart/jquery.jqRangeSlider.min.js"></script>
	<script type="text/javascript" src="js-jqChart/jquery.mousewheel.js"></script>
    <script type="text/javascript">
    	$(document).ready(function() {
		// 设置文本样式
		$("td").each(function() {
			$(this).css("text-align", "left").css("text-indent", "1em");
		});
		$("font").each(function() {
			$(this).attr("font-size", "1.2em");
		});
		
		
		var modelXKY=<%=jsonListXKY%>;
		var modelWBY=<%=jsonListWBY%>
		
		$('#jqChartY').jqChart({
                animation: { duration: 1 },
                shadows: {
                    enabled: true
                },
                series: [
                    {
                        type: 'column',
                        title: '许可用水量',
                        fillStyle: '#FCB441',
                        data: modelXKY
                    },
                    {
                        type: 'column',
                        title: '实际用水量',
                        fillStyle: '#418CF0',
                        data: modelWBY
                    }
                ]

            });
		
	});
    	
    </script>
  </head>  
  <body class="gray-bg" style="margin: 0px 0px 0px 0px; overflow-y:auto;">
  	<div class="table_content">
  	<div id="jqChartY" style="margin:-15px auto;width: 800px; height: 300px;"></div>
    
    <div class="white-bg"
		style="margin: 0px 15px 0px 15px; padding-top:10px;">
		<div class="tb_blue2" style="margin:15px 15px 15px 15px;">
			<table id="pageTable" width="100%" border="0" cellspacing="0" cellpadding="0" class="border0">
				<thead>
					<tr onMouseOver="this.className='tr_over'" onMouseOut="this.className= 'tr_out'">
						<td>城市名称</td>
						<s:iterator value="#session.cityXuKeY" var="cityXuKeY">
						<td><s:property value="#cityXuKeY.jlCityB.cityNm"/></td>
						</s:iterator>
					</tr>
				</thead>
				<tbody>
					<tr onMouseOver="this.className='tr_over'" onMouseOut="this.className= 'tr_out'">
						<td>许可用水量(m<sup>3</sup>)</td>
						<s:iterator value="#session.cityXuKeY" var="cityXuKeY">
						<td><s:property value="#cityXuKeY.xukeW"/></td>
						</s:iterator>
					</tr>
					<tr onMouseOver="this.className='tr_over'" onMouseOut="this.className= 'tr_out'">
						<td>实际用水量(m<sup>3</sup>)</td>
						<s:iterator value="#session.cityWBY" var="cityWBY">
						<td><s:property value="#cityWBY.PW"/></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
		</div>
	
	</div>
	</div>
  </body>
</html>

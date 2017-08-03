<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.jjjl.data.WellBDayWV" %>
<%@ page language="java" import="com.jjjl.data.WellBMonthWV" %>
<%@ page language="java" import="net.sf.json.JSONArray" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";	
	Object listD=request.getSession().getAttribute("wellBDayWV");
	Object listM=request.getSession().getAttribute("wellBMonthWV");
	JSONArray jsonArrayDayW=JSONArray.fromObject(listD);
	JSONArray jsonArrayMonW=JSONArray.fromObject(listM);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>监测井用水信息</title>
<link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
<link href="ui/theme/base/jquery-ui.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/jquery.jqChart.css">
<link rel="stylesheet" type="text/css" href="css/jquery.jqRangeSlider.css">
<style type="text/css">

</style>

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
		
		var modelM=<%=jsonArrayMonW %>;
		$('#jqChartM').jqChart({
                
                animation: { duration: 1 },
                shadows: {
                    enabled: true
                },
                dataSource: modelM,
                
                series: [
                    {
                        type: 'column',
                        title: '逐月用水量',
                        xValuesField: {
                            name: 'yearmonth',
                            type: 'string', // string, numeric, dateTime
                        },
                        yValuesField: 'monthW'
                    }
                ]/* ,
                 axes: [
                    {
                        type: 'category',
                        location: 'bottom',
                        labels: {
                        	interval: 2
                        }
                    }
                ] */
            });
        
      var modelD=<%=jsonArrayDayW %>;
		$('#jqChartD').jqChart({
                
                animation: { duration: 1 },
                shadows: {
                    enabled: true
                },
                dataSource: modelD,
         		
                series: [
                    {
                        type: 'line',
                        title: '逐日用水量',
                        xValuesField: {
                            name: 'day',
                            type: 'string' // string, numeric, dateTime
                        },
                        yValuesField: 'dayW'
                    }
                ],
                axes: [
                    {
                        type: 'category',
                        location: 'bottom',
                        labels: {
                        	interval: 3
                        }
                    }
                ]
            });
		
	});

</script>

</head>

<body>
	
	<div id="jqChartM" style="width: 800px; height: 300px;">
    </div>
	<div id="jqChartD" style="width: 1000px; height: 300px;">
    </div>
	
	    <h3 style="font-size: 1.1em; font-weight: bold;">逐月用水信息</h3>
	    <div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<thead>
					<tr>
						<s:iterator value="#session.wellBMonthWV" var="wellBMonthWV" >
							<td><s:property value="#wellBMonthWV.yearmonth"/></td>
						</s:iterator>
					</tr>
				</thead>
				<tbody>
					<tr>
						<s:iterator value="#session.wellBMonthWV" var="wellBMonthWV">
							<td><s:property value="#wellBMonthWV.monthW"/></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
		</div>
		<h3 style="font-size: 1.1em; font-weight: bold;">逐日用水信息</h3>
	    <div class="tb_blue2">
			<table height="30" width="100%" border="0" cellspacing="0"
				cellpadding="0" class="border0">
				<thead>
					<tr>
						<s:iterator value="#session.wellBDayWV" var="wellBDayWV" >
							<td><s:property value="#wellBDayWV.day"/></td>
						</s:iterator>
					</tr>
				</thead>
				<tbody>
					<tr>
						<s:iterator value="#session.wellBDayWV" var="wellBDayWV">
							<td><s:property value="#wellBDayWV.dayW"/></td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>

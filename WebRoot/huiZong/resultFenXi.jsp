<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="net.sf.json.JSONArray" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					
Object jsonListWAT=request.getSession().getAttribute("jsonListWAT");	
Object jsonListWAF=request.getSession().getAttribute("jsonListWAF");	
Object jsonListWAI=request.getSession().getAttribute("jsonListWAI");	
Object jsonListWAL=request.getSession().getAttribute("jsonListWAL");

Object jsonListWAFP=request.getSession().getAttribute("jsonListWAFP");	
Object jsonListWAIP=request.getSession().getAttribute("jsonListWAIP");	
Object jsonListWALP=request.getSession().getAttribute("jsonListWALP");

Object jsonListHm=request.getSession().getAttribute("jsonListHm");	
Object jsonListH=request.getSession().getAttribute("jsonListH");
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
		
	
		var modelWAT=<%=jsonListWAT%>;
		var modelWAF=<%=jsonListWAF%>;
		var modelWAI=<%=jsonListWAI%>;
		var modelWAL=<%=jsonListWAL%>;
		
		$('#jqChartS').jqChart({
                animation: { duration: 1 },
                shadows: {
                    enabled: true
                },
                series: [
                    {
                        type: 'line',
                        title: '总用水量',
                        valueType: 'percentage',
                        stringFormat: '%.1f%%',
                        
                        data: modelWAT
                    },
                    {
                        type: 'line',
                        title: '农业用水量',
                        data: modelWAF
                    },
                    {
                        type: 'line',
                        title: '工业用水量',
                        data: modelWAI
                    },
                    {
                        type: 'line',
                        title: '生活用水量',
                        data: modelWAL
                    }
                ]

            });
            
            var modelWAFP=<%=jsonListWAFP%>;
			var modelWAIP=<%=jsonListWAIP%>;
			var modelWALP=<%=jsonListWALP%>;
            
            $('#jqChartP').jqChart({
                animation: { duration: 1 },
                shadows: {
                    enabled: true
                },
                series: [
                    {
                        type: 'line',
                        title: '农业用水占比',
                        data: modelWAFP
                    },
                    {
                        type: 'line',
                        title: '工业用水占比',
                        data: modelWAIP
                    },
                    {
                        type: 'line',
                        title: '生活用水占比',
                        data: modelWALP
                    }
                ]

            });
            
            var modelHm=<%=jsonListHm%>;
			var modelH=<%=jsonListH%>;
            
            $('#jqChartH').jqChart({
                animation: { duration: 1 },
                shadows: {
                    enabled: true
                },
                series: [
                    {
                        type: 'line',
                        title: 'Hmax',
                        data: modelHm
                    },
                    {
                        type: 'line',
                        title: 'H',
                        data: modelH
                    }
                ]

            });
            
           
        });
        
       function queryFenxiW() {
      	var mycheck=document.getElementById("fenxiW");
      	var objW=document.getElementById("jqChartS");
      	if(mycheck.checked) {
      		objW.style.display="block";
      		}
      	else {
      		objW.style.display="none";
      	}
      }
       
       function queryFenxiR() {
      	var mycheck=document.getElementById("fenxiR");
      	var objR=document.getElementById("jqChartP");
      	if(mycheck.checked) {
      		objR.style.display="block";
      		}
      	else {
      		objR.style.display="none";
      	}
      }
      
      function queryFenxiH() {
      	var mycheck=document.getElementById("fenxiH");
      	var objH=document.getElementById("jqChartH");
      	if(mycheck.checked) {
      		objH.style.display="block";
      		}
      	else {
      		objH.style.display="none";
      	}
      }     	
    </script>
  </head>  
  <body class="gray-bg" style="margin: 0px 0px 0px 0px; overflow-y:auto;">
  	<div class="table_content">
  	<div style="margin: -15px 10px 20px">
  	<input type="checkbox" id="fenxiW" name="fenxi" value="water" checked="checked" onclick="queryFenxiW() ">显示用水量
	<input type="checkbox" id="fenxiR" name="fenxi" value="ratio" onchange="queryFenxiR() ">显示用水占比
	<input type="checkbox" id="fenxiH" name="fenxi" value="entropy" onchange="queryFenxiH() ">显示用水结构信息熵
	</div>
  	<div id="jqChartS" style="margin:0 auto; width: 800px; height: 300px;">
    </div>
	<div id="jqChartP" style="display:none; margin:0 auto; width: 800px; height: 300px;">
    </div>
	<div id="jqChartH" style="display:none; margin:0 auto; width: 800px; height: 300px;">
    </div>
   	</div>
  </body>
</html>

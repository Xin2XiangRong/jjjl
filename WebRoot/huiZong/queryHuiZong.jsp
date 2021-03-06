<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.jjjl.data.SysUserB" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>行政区用水汇总</title>
    <link rel="stylesheet" type="text/css" href="css/new_blue_style.css">
    <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {

        	setTimeout(querySum()
        	,1000);
        });
      
      function querySum() {
      	var obj=$('input:radio:checked').val();
      	var objY=document.getElementById("formYear");
      	var objC=document.getElementById("formCity");
      	var ifrY=document.getElementById("resultY");
      	var ifrC=document.getElementById("resultC");
      	
      	if(obj=="city") {
      		objY.style.display="none";
      		objC.style.display="block";
      		formCity_submit();
      		ifrY.style.display="none";
      		ifrC.style.display="block";
      	} else  if(obj=="year"){
      		objC.style.display="none";
      		objY.style.display="block";
      		formYear_submit();
      		ifrY.style.display="block";
      		ifrC.style.display="none";
      	}
      }
      
      function formYear_submit() {
      	$("#formYear").submit();
      }
      function formCity_submit() {
      	$("#formCity").submit();
      }
    </script>
  </head>  
  <body class="gray-bg">
    <div class="table_content" style="margin-bottom: -5px;">
		<span>行政区用水汇总</span>
		<hr	style="height:1px;border:none;border-top:1px solid #165fd5; margin: 0px 0px 10px 0px;" />
		<div style="margin-bottom: 5px;">
			<input id="sum" name="sum" type="radio" value="city" checked="checked"  onclick="querySum()"/>按城市查询
			<input id="sum" name="sum" type="radio" value="year" onclick="querySum()"/>按年份查询
		</div>
	    <form id="formYear" name="formYear" action="hz/queryYear.action" method="post" target="resultY">
			<select id="year" name="year" style="width:120px" class="select_gray" onchange="formYear_submit()">
					<option value="2014">2014</option>
					<option value="2013">2013</option>
					<option value="2012">2012</option>
					<option value="2011">2011</option>
					<option value="2010">2010</option>
					<option value="2009">2009</option>
					<option value="2008">2008</option>
					<option value="2007">2007</option>
					<option value="2006">2006</option>
					<option value="2005">2005</option>
			</select>
			<span style="height: 30px; line-height:30px; font-size: 14px;">年山西省各市用水汇总</span>
		</form>
		
		<form id="formCity" name="formCity" action="hz/queryCity.action"
	    	method="post" target="resultC">
			<span style="height: 30px; line-height:30px; font-size: 14px;">山西省</span>
			<select id="cityCd" name="cityCd" style="width:120px" class="select_gray" onchange="formCity_submit()">
					<option value="1401">太原市</option>
					<option value="1402">大同市</option>
					<option value="1403">阳泉市</option>
					<option value="1404">长治市</option>
					<option value="1405">晋城市</option>
					<option value="1406">朔州市</option>
					<option value="1407">晋中市</option>
					<option value="1408">运城市</option>
					<option value="1409">忻州市</option>
					<option value="1410">临汾市</option>
					<option value="1411">吕梁市</option>
			</select>
			<span style="height: 30px; line-height:30px; font-size: 14px;">近十年用水汇总</span>
		</form>
	</div>
	<iframe id="resultY" name="resultY" src="waiting.jsp" width="100%" height="80%"
		frameborder="0"></iframe>
		<iframe id="resultC" name="resultC" src="waiting.jsp" width="100%" height="80%"
		frameborder="0"></iframe>
  </body>
</html>

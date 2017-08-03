<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>文件上传成功</title></head>
<body>
	<s:iterator var="fileName" value="multiFileFileName" status="st">
		文件名：<s:property value="fileName"/>&nbsp;&nbsp;
		<img alt="协议扫描件" src="../Upload/${fileName }"height="90%" width="30%">
	</s:iterator>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>�ļ��ϴ��ɹ�</title></head>
<body>
	<s:iterator var="fileName" value="multiFileFileName" status="st">
		�ļ�����<s:property value="fileName"/>&nbsp;&nbsp;
		<img alt="Э��ɨ���" src="../Upload/${fileName }"height="90%" width="30%">
	</s:iterator>
</body>
</html>

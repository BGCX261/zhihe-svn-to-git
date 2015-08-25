<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.jbpm.api.ProcessInstance"%>
<%@page import="com.suncm.util.JbpmUtil"%>
<%@page import="java.util.Set"%>
<%@page import="org.jbpm.api.model.ActivityCoordinates"%>
<%@page import="java.io.InputStream"%><html>
<head>
<%@ include file="../suncm_global.jsp"%>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">


<h1>������Ŀ</h1>
<p class="field-keys"><br>
��������Ŀ��Ϣ�������Ŀ���д��������Խ��еĲ����Ѿ��԰�ť����ʽ�ṩ��<br>
</p>

<fieldset>
<legend>��Ŀ������Ϣ</legend>
<table>
<tr><td class="stitle">��Ŀ����:</td><td>${projectData.projectName }</td></tr>
<tr><td class="stitle">������:</td><td>${projectData.createUser }</td></tr>
<tr><td class="stitle">������:</td><td>${projectData.createDep }</td></tr>
<tr><td class="stitle">����ʱ��:</td><td>${projectData.createdate }</td></tr>
</table>
</fieldset>
<c:if test="${!empty(pageData)}">
<fieldset>
<legend>��Ŀ��չ��Ϣ</legend>
<table>

</table>
</fieldset>
</c:if>

<%

InputStream taskFormStream = (InputStream)session.getAttribute("taskFormStream");
if(taskFormStream != null){
	int readSize = taskFormStream.available();
	while(readSize != -1){
		byte[] buffer = new byte[readSize];
		readSize = taskFormStream.read(buffer);
		out.write(new String(buffer));
	}
}
taskFormStream.close();

%>

</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span>
</div>

</div>


<%@ include file="../suncm_foot.jsp"%>
</div>
</body>
</html>
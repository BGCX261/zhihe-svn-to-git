<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.jbpm.api.ProcessInstance"%>
<%@page import="com.suncm.util.JbpmUtil"%>
<%@page import="java.util.Set"%>
<%@page import="org.jbpm.api.model.ActivityCoordinates"%><html>
<head>
<%@ include file="../suncm_global.jsp"%>
</head>
<body>
<%
	ProcessInstance processInstance = JbpmUtil.getExecutionService()
			.findProcessInstanceById(
					request.getParameter("executionId"));
	Set<String> activityNames = processInstance
			.findActiveActivityNames();

	ActivityCoordinates ac = JbpmUtil.getRepositoryService()
			.getActivityCoordinates(
					processInstance.getProcessDefinitionId(),
					activityNames.iterator().next());
%>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">


<h1>项目流程跟踪图</h1>
<p class="field-keys"><br>
下面是项目当前的处理情况，标有红框的节点表示项目目前处于待此任务完成的状态。<br>
</p>

<h4>项目当前工作流图</h4>
<div style="position: relative;"><img
	src="${basePath }${picFileName}"
	style="position: absolute; left: 0px; top: 0px;">
<div
	style="position:absolute;border:1px solid red;left:<%=ac.getX()%>px;top:<%=ac.getY()%>px;width:<%=ac.getWidth()%>px;height:<%=ac.getHeight()%>px;">
	</div>
</div>


</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span>
</div>

</div>


<%@ include file="../suncm_foot.jsp"%>
</div>
</body>
</html>
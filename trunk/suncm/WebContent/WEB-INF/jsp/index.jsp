<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.suncm.um.SuncmUser"%>
<%@page import="com.suncm.util.JbpmUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.jbpm.api.task.Task"%><html>
<head>
<%@ include file="suncm_global.jsp" %>
</head>
<body>
<div class="container">
	
	<div class="main">

<%@ include file="suncm_head.jsp" %>
		
		<div class="content">
	
			<div class="item">

				<h1>��ӭʹ��</h1>

				

				<cite>�𾴵�  ${suncm_user.userName}</cite>
				<cite>��ӭʹ��Suncm�������ϵͳ</cite>
				<cite>
				<%
				SuncmUser su = (SuncmUser)session.getAttribute("suncm_user");
				List<Task> taskListGroup = JbpmUtil.getTaskService().findGroupTasks(su.getUserId());
				List<Task> taskListPersonal = JbpmUtil.getTaskService().findPersonalTasks(su.getUserId());
				int total = taskListGroup.size()+taskListPersonal.size();
				%>
				<a href="${basePath}ifw.do?ifw_flowname=QueryMyProjectListFlow&pageActType=0">����<%=total %>������������</a></cite>
				
				

			</div>
	
			
		</div>

		<%@ include file="suncm_left.jsp" %>
	
		<div class="clearer"><span></span></div>

	</div>

		<%@ include file="suncm_foot.jsp" %>
</div>
</body>
</html>
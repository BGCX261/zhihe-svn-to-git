<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../suncm_global.jsp"%>

<link rel="stylesheet" type="text/css" href="${basePath}css/tables.css"
	media="screen" />
<script language="javascript" src="${basePath}js/tables.js"></script>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">


<h1>��Ŀ�����б�</h1>
<p class="field-keys"><br>��������Ҫ���������Ŀ�б������������Ӷ���Ŀ���д���<br></p>
<c:choose>
<c:when test="${empty(pageData)}">
<div class="nonehint">Ŀǰ���޴������������</div>
</c:when>
<c:otherwise>
<table class="sortable paginated" align="center">
			<thead>
				<tr>
					<th>��Ŀ����</th>
			<th>��Ŀ����</th>
			<th>����</th>
			<th>��������</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${pageData}">
					<tr>
						<td>${item.spc.projectCateName}</td>
			<td>${item.spi.projectName}</td>
			<td><div class="tawrapper">
			<a href="${basePath}ifw.do?ifw_flowname=PCateGetWflPicFlow&pCateId=${item.spc.projectCateId }&executionId=${item.spi.executionId}&pageActType=0">�鿴��ǰ����ͼ</a>
			
			<a href="${basePath}ifw.do?ifw_flowname=ProjectQueryDetailFlow&taskId=${item.taskId}&projectId=${item.spi.projectId}"/>${item.actionName }</a>
			</div>
			</td>
			
			<td>${item.comeDate }</td></tr>
				</c:forEach>
			</tbody>
		</table>
</c:otherwise>
</c:choose>

</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
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


<h1>项目种类列表</h1>
<p class="field-keys"><br>如下是需要您处理的项目列表，请点击操作链接对项目进行处理。<br></p>
<c:choose>
<c:when test="${empty(pageData)}">
<div class="nonehint">目前暂无待您处理的任务</div>
</c:when>
<c:otherwise>
<table class="sortable paginated" align="center">
			<thead>
				<tr>
					<th>项目分类</th>
			<th>项目名称</th>
			<th>操作</th>
			<th>到达日期</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${pageData}">
					<tr>
						<td>${item.spc.projectCateName}</td>
			<td>${item.spi.projectName}</td>
			<td><div class="tawrapper">
			<a href="${basePath}ifw.do?ifw_flowname=PCateGetWflPicFlow&pCateId=${item.spc.projectCateId }&executionId=${item.spi.executionId}&pageActType=0">查看当前流程图</a>
			
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
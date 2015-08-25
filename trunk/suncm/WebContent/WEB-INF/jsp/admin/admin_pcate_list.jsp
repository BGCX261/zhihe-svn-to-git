<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../suncm_global.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}css/tables.css" media="screen"/>
<script language="javascript" src="${basePath}js/tables.js"></script>

</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">

<h1>项目种类列表</h1>
<c:choose>
<c:when test="${pageTotalNum==0}">
<div class="nonehint">目前暂无项目种类</div>
</c:when>
<c:otherwise>
<p class="field-keys"><br>
系统中所有的项目种类如下，您可以点击系统提供的多种操作链接对选定的种类进行查看或修改。<br>
其中状态为冻结的项目种类不能生成新的项目。
<br></p>
<table class="sortable paginated" align="center">
          <thead>
            <tr>
        	
              <th class="sort-alpha">项目种类名称</th>
              <th class="sort-alpha">项目种类状态</th>
              <th class="sort-date">工作流名称</th>
              <th class="sort-date">操作</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="item" items="${pageData}" begin="${beginNum}" end="${endNum}">
            <tr>
              <td>${item.projectCateName}</td>
			<td><fmt:message bundle="${suncm_admin}"
				key="suncm.admin.projcatestatus_${item.projectCateStat}" /></td>
			<td>${item.wflname}</td>
			<td>
			<div class="tawrapper"><a href="${basePath}ifw.do?ifw_flowname=PCateTplManagerFlow&pCateId=${item.projectCateId}&flag=2">项目模板</a></div>
			<div class="tawrapper"><a href="${basePath}ifw.do?ifw_flowname=PCateGetWflPicFlow&pCateId=${item.projectCateId}&pageActType=1">查看项目工作流图</a></div>
			<c:choose>
<c:when test="${item.projectCateStat==0}">
<div class="tawrapper">冻结</div>
</c:when>
<c:otherwise>
<div class="tawrapper">解冻</div>
</c:otherwise>
</c:choose>
			
			<div class="tawrapper"> 删除</div>
			</td>
            </tr>
            </c:forEach>
</tbody>
</table>
<%@ include file="../include/page_buttons.jsp"%>
</c:otherwise>
</c:choose>
<p class="field-keys"><br>
如果上述模板不能满足需要，您还可以<a href="${basePath}ifw.do?ifw_flowname=DisplayPageFlow&IFW_Reply=admin/admin_add_pcate">添加新的项目种类</a>。
</p>



</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
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

<h1>��Ŀ�����б�</h1>
<c:choose>
<c:when test="${pageTotalNum==0}">
<div class="nonehint">Ŀǰ������Ŀ����</div>
</c:when>
<c:otherwise>
<p class="field-keys"><br>
ϵͳ�����е���Ŀ�������£������Ե��ϵͳ�ṩ�Ķ��ֲ������Ӷ�ѡ����������в鿴���޸ġ�<br>
����״̬Ϊ�������Ŀ���಻�������µ���Ŀ��
<br></p>
<table class="sortable paginated" align="center">
          <thead>
            <tr>
        	
              <th class="sort-alpha">��Ŀ��������</th>
              <th class="sort-alpha">��Ŀ����״̬</th>
              <th class="sort-date">����������</th>
              <th class="sort-date">����</th>
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
			<div class="tawrapper"><a href="${basePath}ifw.do?ifw_flowname=PCateTplManagerFlow&pCateId=${item.projectCateId}&flag=2">��Ŀģ��</a></div>
			<div class="tawrapper"><a href="${basePath}ifw.do?ifw_flowname=PCateGetWflPicFlow&pCateId=${item.projectCateId}&pageActType=1">�鿴��Ŀ������ͼ</a></div>
			<c:choose>
<c:when test="${item.projectCateStat==0}">
<div class="tawrapper">����</div>
</c:when>
<c:otherwise>
<div class="tawrapper">�ⶳ</div>
</c:otherwise>
</c:choose>
			
			<div class="tawrapper"> ɾ��</div>
			</td>
            </tr>
            </c:forEach>
</tbody>
</table>
<%@ include file="../include/page_buttons.jsp"%>
</c:otherwise>
</c:choose>
<p class="field-keys"><br>
�������ģ�岻��������Ҫ����������<a href="${basePath}ifw.do?ifw_flowname=DisplayPageFlow&IFW_Reply=admin/admin_add_pcate">����µ���Ŀ����</a>��
</p>



</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
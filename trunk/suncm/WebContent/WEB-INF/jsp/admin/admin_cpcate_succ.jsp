<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../suncm_global.jsp"%>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">

<h1>创建项目种类</h1>
<p class="succhint">
项目种类<span class="emphasis">${pCateName }</span>已经创建成功,可点击<a href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=0">这里</a>返回项目种类列表，列表中提供了进一步维护项目种类的相关操作。
</p>


</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
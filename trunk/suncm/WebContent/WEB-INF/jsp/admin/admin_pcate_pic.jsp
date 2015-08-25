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

<fieldset>
<legend>项目种类信息</legend>
<table>
<tr><td class="stitle">项目分类名称:</td><td>${pCate.projectCateName }</td></tr>
<tr><td class="stitle">工作流名称:</td><td>${pCate.wflname }</td></tr>
</table>
</fieldset>
<fieldset>
<legend>项目种类工作流图</legend>

<img alt="此工作流暂无对应的工作流图" src="${basePath }${picFileName}" >

</fieldset>

</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
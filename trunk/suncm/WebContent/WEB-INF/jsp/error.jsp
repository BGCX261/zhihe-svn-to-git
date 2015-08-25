<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.suncm.util.SystemConfig"%><html>
<head>
<%@ include file="suncm_global.jsp"%>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="suncm_head.jsp"%>

<div class="content">

<div class="item">

<h1>³ö´íÀ²</h1>

<cite>´íÎó´úÂë:${tranErrorCode }</cite>
<cite>´íÎóÃèÊö:${tranErrorDispMsg }</cite>

</div>


</div>

<%@ include file="suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="suncm_foot.jsp"%></div>
</body>
</html>
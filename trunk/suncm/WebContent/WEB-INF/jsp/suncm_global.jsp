<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
    <%@ taglib uri="/WEB-INF/suncm.tld" prefix="sc"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta name="description" content="description"/>
<meta name="keywords" content="keywords"/> 
<meta name="author" content="author"/> 
<%
String basePath = request.getContextPath();
if(!basePath.endsWith("/")){
	basePath = basePath+"/";
}
pageContext.setAttribute("basePath",basePath);
%>
<<script type="text/javascript">
<!--
var basePath='${basePath}';
//-->
</script>
<link rel="stylesheet" type="text/css" href="${basePath}css/site.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="${basePath}css/forms.css" media="screen"/>
<script language="javascript" src="${basePath}js/jquery.js"></script>
<script language="javascript" src="${basePath}js/common.js"></script>
<script language="javascript" src="${basePath}js/forms.js"></script>
<title>SunCM 会议表决系统</title>

<fmt:setBundle basename="com.suncm.bundle.suncm_admin" var="suncm_admin"/>
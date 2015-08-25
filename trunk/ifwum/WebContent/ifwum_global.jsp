<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%
String basePath = request.getContextPath();
if(!basePath.endsWith("/")){
	basePath = basePath+"/";
}
pageContext.setAttribute("basePath",basePath);
%>
  <link rel="stylesheet" href="<%=basePath%>css/site.css"   media="all"    type="text/css" />
  <link rel="stylesheet" href="<%=basePath%>css/ie6.css"    media="all"    type="text/css" />
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<title>IFW 用户管理系统</title>
<script language="javascript" type="text/javascript" src="<%=basePath%>js/yahoo.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/event.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/chdp.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/cssQuery-p.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/page.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/button.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/common.js" ></script>
 <script language="javascript" type="text/javascript" src="<%=basePath%>js/text-utils.js" ></script>
 

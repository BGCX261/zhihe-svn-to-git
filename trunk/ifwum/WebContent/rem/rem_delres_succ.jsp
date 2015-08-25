<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.css.security.org.Organization"%>
<%@page import="com.css.security.SecurityManagerFactory"%>
<%@page import="com.css.security.SecurityConfiguration"%>
<%@page import="com.css.security.org.Department"%>
<%@page import="com.css.security.db.org.DefaultDepartment"%><html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<style type="text/css">

</style>

</head>
<body onload="javascript:parent.restree.submit();">
<div id="page">

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <div id="main-b">
    <p><br>资源删除成功，如页面没有自动刷新，请点击 <a href="javascript:parent.restree.submit();">这里</a>  刷新机构树<br></p>

    
     </div>
       

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
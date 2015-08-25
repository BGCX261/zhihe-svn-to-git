<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
 <%@ taglib uri="/cp/tree" prefix="tree" %>
    
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
<body>
<div id="page">

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <p class="error-info">出错啦：
    ${errorMsg}</p> 
       

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
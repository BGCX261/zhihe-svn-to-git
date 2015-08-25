<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="ifwum_global.jsp" %>
<style type="text/css">
p#welcome-name{
font-size:1.3em;
margin-top:1em;
margin-bottom:1em;
}
p.ifwintro{
margin-left:2em;
margin-right:2em;
text-indent:2em;
}
div.introimg{
	margin-top:2em;
margin-bottom:2em;
}
</style>
</head>
<body>
<div id="page">
<!-- 头部和一级菜单区 -->
<%@ include file="ifwum_head.jsp" %>

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    没有权限
    </div>
    <div id="main-body">
    
    <p align="center" class="errorp">您没有权限访问此页面，可以使用有权限的用户名重新<a href="<%=basePath%>logon.jsp">登录</a></p>
    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="ifwum_global.jsp" %>
</head>
<body>
<div id="page">
<!-- 头部和一级菜单区 -->
<%@ include file="ifwum_head.jsp" %>

  


  <div id="body">
<!-- 左侧菜单 -->
<%@ include file="ifwum_left.jsp" %>
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    
    </div>
    <div id="main-body">
    <p align="center" class="errorp">出错啦：${errorMsg}
   </p>
    
	
    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
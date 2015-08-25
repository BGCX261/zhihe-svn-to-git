<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>

</head>
<body>
<div id="page">
<!-- 头部和一级菜单区 -->
<%@ include file="../ifwum_head.jsp" %>

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    用户管理-机构树维护   
    </div>
    <div id="main-body">
    
    <iframe id="treeframe" class="treeiframe" width="40%"  height="300" src="<%=basePath%>dm/dm_dpt_tree.jsp" frameborder="0"/>
<iframe id="opframe" class="treeiframe" height="300" width="60%" src="<%=basePath%>dm/dm_dpt_intro.jsp" frameborder="0"/>
    </div>
        

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
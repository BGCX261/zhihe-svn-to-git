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
    岗位管理-创建岗位   
    </div>
    <div id="main-body">
    <p class="succ-dis"><br>岗位已成功创建，可在 <a class="anavigation" href="javascript:posm.submit();">岗位查询/维护</a> 栏目查询和维护此岗位信息。<br>
    <a class="anavigation" href="<%=basePath%>pm/pm_create_pos.jsp">返回</a> 创建岗位首页
    </p>


    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>

</head>
<body>
<div id="page">
<!-- ͷ����һ���˵��� -->
<%@ include file="../ifwum_head.jsp" %>

  


  <div id="body">
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- �������� -->
    <div id="main">
    <div id="main-title">
    �û�����-������ά��   
    </div>
    <div id="main-body">
    
    <iframe id="treeframe" class="treeiframe" width="40%"  height="300" src="<%=basePath%>dm/dm_dpt_tree.jsp" frameborder="0"/>
<iframe id="opframe" class="treeiframe" height="300" width="60%" src="<%=basePath%>dm/dm_dpt_intro.jsp" frameborder="0"/>
    </div>
        

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="ifwum_global.jsp" %>
</head>
<body>
<div id="page">
<!-- ͷ����һ���˵��� -->
<%@ include file="ifwum_head.jsp" %>

  


  <div id="body">
<!-- ���˵� -->
<%@ include file="ifwum_left.jsp" %>
    <!-- �������� -->
    <div id="main">
    <div id="main-title">
    
    </div>
    <div id="main-body">
    <p align="center" class="errorp">��������${errorMsg}
   </p>
    
	
    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
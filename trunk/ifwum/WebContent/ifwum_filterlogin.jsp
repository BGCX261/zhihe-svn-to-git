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
<!-- ͷ����һ���˵��� -->
<%@ include file="ifwum_head.jsp" %>

  


  <div id="body">
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- �������� -->
    <div id="main">
    <div id="main-title">
    û��Ȩ��
    </div>
    <div id="main-body">
    
    <p align="center" class="errorp">��û��Ȩ�޷��ʴ�ҳ�棬����ʹ����Ȩ�޵��û�������<a href="<%=basePath%>logon.jsp">��¼</a></p>
    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
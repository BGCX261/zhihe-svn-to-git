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
    ��ɫ����-������ɫ   
    </div>
    <div id="main-body">
    <p class="succ-dis"><br>��ɫ�ѳɹ����������� <a class="anavigation" href="javascript:rolem.submit();">��ɫ��ѯ/ά��</a> ��Ŀ��ѯ��ά���˽�ɫ��Ϣ��<br>
    <a class="anavigation" href="<%=basePath%>rm/rm_create_role.jsp">����</a> ������ɫ��ҳ
    </p>


    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
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
    �û�����-�û���ѯ/ά��   
    </div>
    <div id="main-body">
    <p class="succ-dis"><br>������Ŀǰϵͳ����ע���û����б��ɵ���������Ӷ��û��������ά����<br></p>
<input type="hidden" name="ifw_flowname" value="CreateUserFlow">
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>�û���</td><td>��ʵ����</td>
    <td>�����ʼ�</td><td>�û�����</td><td>��������</td><td>����</td></tr></thead>
   <c:forEach var="item" items="${users}">
<tr><td>${item.userName}</td><td>${item.realName}</td>
    <td>${item.email}</td><td>${item.userType}</td><td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd"/></td>
    <td>�޸� 
    <form name="d${item.userName}" action="<%=basePath%>ifw.do" method="post">
             	<input type="hidden" name="username" value="${item.userName}">
         	<input type="hidden" name="ifw_flowname" value="DeleteUserFlow">
         	</form>
    <a href="javascript:d${item.userName}.submit();">ɾ��</a>
    <a href="">��������</a>
    </td></tr>

</c:forEach>
	    
    </table>
    
    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function deleteUser(formname){
		form = eval('d' + formname);
		if(confirm("�Ƿ�ȷ��ɾ���û�" + formname+"��")){
			form.submit();
		}
		
	}
</script>
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
    <p><br>������Ŀǰϵͳ����ע���û����б��ɵ���������Ӷ��û��������ά����<br></p>
<input type="hidden" name="ifw_flowname" value="CreateUserFlow">
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>��Ŀ��������</td><td>��Ŀ����״̬</td>
    <td>����������</td><td>����</td></tr></thead>
   <c:forEach var="item" items="${users}">
<tr><td>${item.userName}</td><td>${item.realName}</td>
    <td>${item.email}</td>
    <td>
    <form name="d${item.userName}" action="<%=basePath%>ifw.do" method="post">
             	<input type="hidden" name="username" value="${item.userName}">
         	<input type="hidden" name="ifw_flowname" value="DeleteUserFlow">
         	</form>
    <a href="javascript:deleteUser('${item.userName}');">ɾ��</a>
    
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
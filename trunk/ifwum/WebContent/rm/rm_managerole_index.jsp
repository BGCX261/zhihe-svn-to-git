<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function deleteRole(id,name){
		form = eval('d' + id);
		if(confirm("�Ƿ�ȷ��ɾ����ɫ��" + name+"��")){
			form.submit();
		}
		
	}
	function modifyRole(id){
		mRole.roleId.value=id;
		mRole.submit();
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
    ��ɫ����-��ɫ��ѯ/ά��   
    </div>
    <div id="main-body">
    <p><br>������Ŀǰϵͳ���п��ý�ɫ���б����� ${rolecount} �����ɵ���������ӶԽ�ɫ�������ά����<br></p>
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>��ɫ����</td><td>��ɫ����</td><td>����</td></tr></thead>
   <c:forEach var="item" items="${roles}">
<tr><td>${item.name}</td><td>${item.desc}</td>
    
    <td>
    	<!-- a href="<%=basePath%>ifw.do?ifw_flowname=RmModifyRoleFlow&roleId=${item.roleId}&flag=0">�޸�</a-->
    	<form name="d${item.roleId}" action="<%=basePath%>ifw.do" method="post">
    	
             	<input type="hidden" name="roleId" value="${item.roleId}">
         	<input type="hidden" name="ifw_flowname" value="RmDeleteRoleFlow"> 
    <a href="javascript:deleteRole('${item.roleId}','${item.name}');">ɾ��</a>
    <a href="javascript:modifyRole('${item.roleId}');">��ϸ��Ϣά��</a>
    </form>
    </td></tr>

</c:forEach>
	    
    </table>
    <form name=mRole action="<%=basePath%>ifw.do" method="post">
    	<input type="hidden" name="ifw_flowname" value="RmPrepareRoleInfoFlow">
    	<input type="hidden" name="roleId">
    </form>
    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
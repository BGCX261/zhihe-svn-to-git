<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function deletePos(id,name){
		form = eval('d' + id);
		if(confirm("�Ƿ�ȷ��ɾ���û�" + name+"��")){
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
    ��λ����-��λ��ѯ/ά��   
    </div>
    <div id="main-body">
    <p><br>������Ŀǰϵͳ���п��ø�λ���б����� ${poscount} �����ɵ���������ӶԸ�λ�������ά����<br></p>
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>��λ����</td><td>��λ����</td><td>����</td></tr></thead>
   <c:forEach var="item" items="${pos}">
<tr><td>${item.name}</td><td>${item.desc}</td>
    
    <td>
    	<a href="<%=basePath%>ifw.do?ifw_flowname=PmModifyPosFlow&posId=${item.positionId}&flag=0">�޸�</a>
    	<form name="d${item.positionId}" action="<%=basePath%>ifw.do" method="post">
    	
             	<input type="hidden" name="posId" value="${item.positionId}">
         	<input type="hidden" name="ifw_flowname" value="PmDeletePosFlow"> 
    <a href="javascript:deletePos('${item.positionId}','${item.name}');">ɾ��</a>
    </form>
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
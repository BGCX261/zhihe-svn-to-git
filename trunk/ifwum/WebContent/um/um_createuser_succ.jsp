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
    �û�����-�����û�   
    </div>
    <div id="main-body">
    <p class="succ-dis"><br>�û��ѳɹ���������Ϣ���£�����<a href="javascript:mu.submit();">�û�����</a>��Ŀ��ѯ��ά�����û���Ϣ��<br></p>
<table align="center" class="submit-input">
    <tr><td class="ne-title">�û�����*</td><td class="ne-input">
    ${param.username}</td>
 </td></tr>
    <tr><td class="ne-title">��ʵ������*</td><td class="ne-input">${param.realname}</td>
   </td></tr>
    <tr><td class="ne-title">�����ʼ���ַ��*</td><td class="ne-input">${param.email}</td>
    </td></tr>
    <tr><td class="ne-title">�û����ͣ�*</td><td class="ne-input">
    ${param.usertype}
	</td>
	<tr><td class="ne-title">��ϵ�绰��</td><td class="ne-input">${param.mobile}</td>
    </td></tr>
	    
	    
    </table>    

    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.css.security.org.Organization"%>
<%@page import="com.css.security.SecurityManagerFactory"%>
<%@page import="com.css.security.SecurityConfiguration"%>
<%@page import="com.css.security.org.Department"%>
<%@page import="com.css.security.db.org.DefaultDepartment"%><html>
<head>

<%@ include file="../ifwum_global.jsp" %>
<script language="javascript" type="text/javascript" src="<%=basePath%>js/dm/dptdetail.js" ></script>
<style type="text/css">
*.dptdetail-title{
font-style:italic;
font-weight:bold;
}
*.dptdetail-list{
font-family:"����";

}
a.opbutton{
font-weight:bold;
}
div.dptdetail-info{
margin-bottom:1em;
font-family:"����";
}
div.dptdetail-op{
margin-top:1em;
}
select.mselect{
width:100%;
}
div.invis{
display:none;
font-style:italic;
}
div.vissucc{
color:white;
display:block;
font-style:italic;
background-color:green;
}
div.visfail{
color:white;
display:block;
font-style:italic;
background-color:red;
}
</style>
</head>
<body>
<div id="page">
  


  <div id="body">
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <div id="main-b">
    <h2 class="dptdetail-title">���������Ϣ</h2>
    <ul class="dptdetail-list">
    <li>���Ż�����Ϣ</li>
    <div class="dptdetail-info">
    �������ƣ�${newDpt.deptName }
    ���Ŵ��룺${newDpt.deptCode }
  
        <div class="dptdetail-op">
	<a class="opbutton" href="<%=basePath%>dm/dm_dptdetail_addcld.jsp?parentId=${newDpt.deptId }">����¼�����</a>
	<a class="opbutton" href="<%=basePath%>ifw.do?deptid=${newDpt.deptId }&ifw_flowname=DmDelDptFlow">ɾ���˲���</a>
    </div>
      </div>
    <li>����-��λ��Ϣ</li>
    <div class="dptdetail-info">
    <table width="100%">
    <tr>
    <td width="40%">
    �������и�λ
    </td>
        <td width="20%">
        
    </td>
        <td width="40%">
        ����Ӹ�λ
    </td>
    </tr>
    <tr>
    <td>
	<select id="postodel" size="4" MULTIPLE class="mselect">
	
	  <c:forEach var="item" items="${nowDptPos}">
	  <option value="${item.positionId }">${item.name }
	  </c:forEach>
                  </select></td>
                  <td>
                  <div>
                  <a id="delPos" class="opbutton" href="javascript:delPos('<%=basePath%>Web20Servlet','${newDpt.deptId }');">��ȥ--></a>
                  </div>
                  <div>
                  <a id="addPos" class="opbutton" href="javascript:addPos('<%=basePath%>Web20Servlet','${newDpt.deptId }');"><--���</a>
                  </div>
                  </td>
                  <td>
                  <select id="postoadd" size="4"
	MULTIPLE class="mselect">
                    	  <c:forEach var="item" items="${allPos}">
	  <option value="${item.positionId }">${item.name }
	  </c:forEach>
                  </select>
                  </td>
</tr>
</table>
<div id=addPosHint class="invis">��ѡ��λ�Ѿ��ɹ������������</div>
    </div>
 
    <li>����-�û���Ϣ</li>
       <div class="dptdetail-info">
    <table width="100%">
    <tr>
    <td width="40%">
    ���������û�
    </td>
        <td width="20%">
        
    </td>
        <td width="40%">
        ������û�
    </td>
    </tr>
    <tr>
    <td>
	<select id="usertodel" size="10" MULTIPLE class="mselect">
	
	  <c:forEach var="item" items="${nowDptUser}">
	  <option value="${item.userId }">${item.userName }
	  </c:forEach>
                  </select></td>
                  <td>
                  <div>
                  <a id="delUser" class="opbutton" href="javascript:delUser('<%=basePath%>Web20Servlet','${newDpt.deptId }');">��ȥ--></a>
                  </div>
                  <div>
                  <a id="addUser" class="opbutton" href="javascript:addUser('<%=basePath%>Web20Servlet','${newDpt.deptId }');"><--���</a>
                  </div>
                  </td>
                  <td>
                  <select id="usertoadd" size="10"
	MULTIPLE class="mselect">
                    	  <c:forEach var="item" items="${allUsers}">
	  <option value="${item.userId }">${item.userName }
	  </c:forEach>
                  </select>
                  </td>
</tr>
</table>
<div id=addUserHint class="invis">��ѡ�û��Ѿ��ɹ������������</div>
    </div>
    <li>����Ȩ����Ϣ</li>
    ��ʵ�֡�����
    </ul>
    
     </div>
       

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
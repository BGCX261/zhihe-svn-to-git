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
<script language="javascript" type="text/javascript" src="<%=basePath%>js/rm/roledetail.js" ></script>
<style type="text/css">
*.dptdetail-title{
font-style:italic;
font-weight:bold;
}
*.dptdetail-list{
font-family:"黑体";

}
a.opbutton{
font-weight:bold;
}
div.dptdetail-info{
margin-bottom:1em;
font-family:"宋体";
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
  
<%@ include file="../ifwum_head.jsp" %>

  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <div id="main">
    <div id="main-title">
    角色管理-角色详细信息维护  
    </div>
        <div id="main-body">
    <ul class="dptdetail-list">
    <li>角色基本信息</li>
    <div class="dptdetail-info">
    角色名称：${nowRole.name }<br/>
    角色描述：${nowRole.desc }
  
      </div>
    <li>角色-用户信息</li>
    <div class="dptdetail-info">
    <table width="100%">
    <tr>
    <td width="40%">
    角色已有用户
    </td>
        <td width="20%">
        
    </td>
        <td width="40%">
        待添加用户
    </td>
    </tr>
    <tr>
    <td>
	<select id="usertodel" size="4" MULTIPLE class="mselect">
	
	  <c:forEach var="item" items="${nowRoleUsers}">
	  <option value="${item.userId }">${item.userName }
	  </c:forEach>
                  </select></td>
                  <td>
                  <div align="center">
                  <a id="delPos" class="opbutton" href="javascript:delUser('<%=basePath%>Web20Servlet','${nowRole.roleId }');">除去--></a>
                  </div>
                  <div align="center">
                  <a id="addPos" class="opbutton" href="javascript:addUser('<%=basePath%>Web20Servlet','${nowRole.roleId }');"><--添加</a>
                  </div>
                  </td>
                  <td>
                  <select id="usertoadd" size="4"
	MULTIPLE class="mselect">
                    	  <c:forEach var="item" items="${allUsers}">
	  <option value="${item.userId }">${item.userName }
	  </c:forEach>
                  </select>
                  </td>
</tr>
</table>
<div id=addUserHint class="invis">所选用户已经成功添加至本角色</div>
    </div>
 
    <li>角色-资源信息</li>
       <div class="dptdetail-info">
    <table width="100%">
    <tr>
    <td width="40%">
    角色已有资源
    </td>
        <td width="20%">
        
    </td>
        <td width="40%">
        待添加资源
    </td>
    </tr>
    <tr>
    <td>
	<select id="restodel" size="10" MULTIPLE class="mselect">
	
	  <c:forEach var="item" items="${nowRoleRes}">
	  <option value="${item.resourceId }">${item.name }
	  </c:forEach>
                  </select></td>
                  <td>
                  <div align="center">
                  <a id="delRes" class="opbutton" href="javascript:delRes('<%=basePath%>Web20Servlet','${nowRole.roleId }');">除去--></a>
                  </div>
                  <div align="center">
                  <a id="addRes" class="opbutton" href="javascript:addRes('<%=basePath%>Web20Servlet','${nowRole.roleId }');"><--添加</a>
                  </div>
                  </td>
                  <td>
                  <select id="restoadd" size="10"
	MULTIPLE class="mselect">
                    	  <c:forEach var="item" items="${allRes}">
	  <option value="${item.resourceId }">${item.name }
	  </c:forEach>
                  </select>
                  </td>
</tr>
</table>
<div id=addResHint class="invis">所选资源已经成功添加至本角色</div>
    </div>
    </ul>
    </div>
     </div>
       

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->
<%@ include file="../ifwum_foot.jsp" %>
  
  

</div>


</body>
</html>
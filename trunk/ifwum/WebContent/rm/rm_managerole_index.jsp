<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function deleteRole(id,name){
		form = eval('d' + id);
		if(confirm("是否确定删除角色：" + name+"？")){
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
<!-- 头部和一级菜单区 -->
<%@ include file="../ifwum_head.jsp" %>

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    角色管理-角色查询/维护   
    </div>
    <div id="main-body">
    <p><br>下面是目前系统所有可用角色的列表，共有 ${rolecount} 个，可点击操作链接对角色进行相关维护：<br></p>
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>角色名称</td><td>角色描述</td><td>操作</td></tr></thead>
   <c:forEach var="item" items="${roles}">
<tr><td>${item.name}</td><td>${item.desc}</td>
    
    <td>
    	<!-- a href="<%=basePath%>ifw.do?ifw_flowname=RmModifyRoleFlow&roleId=${item.roleId}&flag=0">修改</a-->
    	<form name="d${item.roleId}" action="<%=basePath%>ifw.do" method="post">
    	
             	<input type="hidden" name="roleId" value="${item.roleId}">
         	<input type="hidden" name="ifw_flowname" value="RmDeleteRoleFlow"> 
    <a href="javascript:deleteRole('${item.roleId}','${item.name}');">删除</a>
    <a href="javascript:modifyRole('${item.roleId}');">详细信息维护</a>
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

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function deleteUser(formname){
		form = eval('d' + formname);
		if(confirm("是否确定删除用户" + formname+"？")){
			form.submit();
		}
		
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
    用户管理-用户查询/维护   
    </div>
    <div id="main-body">
    <p><br>下面是目前系统所有注册用户的列表，可点击操作链接对用户进行相关维护：<br></p>
<input type="hidden" name="ifw_flowname" value="CreateUserFlow">
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>项目分类名称</td><td>项目分类状态</td>
    <td>工作流名称</td><td>操作</td></tr></thead>
   <c:forEach var="item" items="${users}">
<tr><td>${item.userName}</td><td>${item.realName}</td>
    <td>${item.email}</td>
    <td>
    <form name="d${item.userName}" action="<%=basePath%>ifw.do" method="post">
             	<input type="hidden" name="username" value="${item.userName}">
         	<input type="hidden" name="ifw_flowname" value="DeleteUserFlow">
         	</form>
    <a href="javascript:deleteUser('${item.userName}');">删除</a>
    
    </td></tr>

</c:forEach>
	    
    </table>
    
    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
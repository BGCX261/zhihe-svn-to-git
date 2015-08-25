<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function deletePos(id,name){
		form = eval('d' + id);
		if(confirm("是否确定删除用户" + name+"？")){
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
    岗位管理-岗位查询/维护   
    </div>
    <div id="main-body">
    <p><br>下面是目前系统所有可用岗位的列表，共有 ${poscount} 个，可点击操作链接对岗位进行相关维护：<br></p>
    <table class="list" align="center" border="1" bordercolor="maroon" cellspacing="0" cellpadding="3">
   <thead> <tr><td>岗位名称</td><td>岗位描述</td><td>操作</td></tr></thead>
   <c:forEach var="item" items="${pos}">
<tr><td>${item.name}</td><td>${item.desc}</td>
    
    <td>
    	<a href="<%=basePath%>ifw.do?ifw_flowname=PmModifyPosFlow&posId=${item.positionId}&flag=0">修改</a>
    	<form name="d${item.positionId}" action="<%=basePath%>ifw.do" method="post">
    	
             	<input type="hidden" name="posId" value="${item.positionId}">
         	<input type="hidden" name="ifw_flowname" value="PmDeletePosFlow"> 
    <a href="javascript:deletePos('${item.positionId}','${item.name}');">删除</a>
    </form>
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
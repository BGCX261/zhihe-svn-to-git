<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>

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
    用户管理-创建用户   
    </div>
    <div id="main-body">
    <p class="succ-dis"><br>用户已成功创建，信息如下，可在<a href="javascript:mu.submit();">用户管理</a>栏目查询和维护此用户信息。<br></p>
<table align="center" class="submit-input">
    <tr><td class="ne-title">用户名：*</td><td class="ne-input">
    ${param.username}</td>
 </td></tr>
    <tr><td class="ne-title">真实姓名：*</td><td class="ne-input">${param.realname}</td>
   </td></tr>
    <tr><td class="ne-title">电子邮件地址：*</td><td class="ne-input">${param.email}</td>
    </td></tr>
    <tr><td class="ne-title">用户类型：*</td><td class="ne-input">
    ${param.usertype}
	</td>
	<tr><td class="ne-title">联系电话：</td><td class="ne-input">${param.mobile}</td>
    </td></tr>
	    
	    
    </table>    

    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
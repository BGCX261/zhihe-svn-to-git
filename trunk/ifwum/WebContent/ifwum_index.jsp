<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="ifwum_global.jsp" %>
<style type="text/css">
p#welcome-name{
font-size:1.3em;
margin-top:1em;
margin-bottom:1em;
}
p.ifwintro{
margin-left:2em;
margin-right:2em;
text-indent:2em;
}
div.introimg{
	margin-top:2em;
margin-bottom:2em;
}
</style>
</head>
<body>
<div id="page">
<!-- 头部和一级菜单区 -->
<%@ include file="ifwum_head.jsp" %>

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    ifw用户管理-首页
    </div>
    <div id="main-body">
    
    <p id="welcome-name" align="center" valign="middle">欢迎使用ifw用户管理系统!</p>
    <p class="ifwintro">ifw用户管理系统是一个用来管理用户，角色，岗位，部门，组织，资源的权限管理系统，它的主要目标是将系统中的这些
分散的对象集中管理起来，提供统一的权限设置视图和安全管理入口，    目前ifw主要包含了组织管理，岗位管理，用户管理，角色管理，资源管理五大模块。
通过这些模块的协作实现了如下图的一个机构树和资源树，以及两棵树之间的权限关系。</p>
    
    <div align="center" class="introimg">
    <img   src="<%=basePath %>/image/ifwum.jpg">
    </div>
    
    <p class="ifwintro">
    ifw用户管理系统涉及的名词解释：
    <ul>
    <li>组织机构</li>
    组织机构对象实际上是由部门和用户作为节点构成的一个树结构，其中树的叶子节点为用户。
   <li>
   用户
   </li>
   用户对象表示的是一个系统中真实的用户，这些用户是应用系统的最终使用者，能够进行系统授权的各种操作。用户对象拥有几个重要基本属性：姓名、注册名、Email、密码、类型。 
      <li>
   角色
   </li>
   能够完成某项功能的人员的总称，角色是一种身份标识，代表往往具有某个身份的一类用户。角色应当是用户的属性，一个用户可以具有多个角色。反过来，具有某个角色属性的用户也可以有多个。因此，角色可以是一个用户集合；另外，用户属性中也可以包括一个角色集合，用于存放用户所属角色。拥有了角色这种身份标识以后，就可以对“权限”进行管理。
    <li>
   岗位
   </li>
   岗位描述的是一个部门当中所拥有的职务信息。岗位在人力资源管理和OA办公自动化中有大量的应用。
       <li>
   资源
   </li>
   系统中所有的对象都可以视为资源，例如：页面、数据、操作等等。资源是工作系统中可管理的对象，资源是有限的，因此有时需要对其进行权限控制。
       <li>
   权限
   </li>
   权限是指某个用户对于某个资源的可访问性。
    </ul>
    

    </p>
	
    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
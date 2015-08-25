<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.suncm.util.JbpmUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.jbpm.api.identity.User"%>
<%@page import="org.jbpm.pvm.internal.identity.impl.UserImpl"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>suncm 会议管理系统</title>
<%
String basePath = request.getContextPath();
if(!basePath.endsWith("/")){
	basePath = basePath+"/";
}

%>
<style type="text/css">
div{
background-color:silver;
font-family:"黑体";
font-style:oblique;
}
div#main{
border-bottom-color:tomato;
border-bottom-width:1;
margin-left:30%;
margin-right:30%;
margin-top:20px;
padding-left:20;
padding-bottom:20;
padding-right:20;
padding-top:20;
width:inherit;
}
div#title{
background-color:#FFFF00;
border-bottom-color:#000000;
font-weight:bold;
font-size:1.0em;
}
div.userlist{
border-bottom-color:tomato;
border-bottom-width:1;
margin-left:30%;
margin-right:30%;
padding-left:20;
padding-bottom:20;
padding-right:20;
padding-top:20;
width:inherit;
}
</style>
</head>
<body>
<div class="userlist">
系统功能完成情况如下：
<table>
<tr>
<td>功能名</td><td>开发完成</td><td>测试完成</td>
</tr>
<tr>
<td>项目种类设置</td><td>是</td><td>否</td>
</tr>
<tr>
<td>新建项目</td><td>是</td><td>否</td>
</tr>
<tr>
<td>项目查询</td><td>否</td><td>否</td>
</tr>
<tr>
<td>待处理项目</td><td>否</td><td>否</td>
</tr>
<tr>
<td>历史处理查询</td><td>否</td><td>否</td>
</tr>
<tr>
<td>预备会议</td><td>否</td><td>否</td>
</tr>
<tr>
<td>当前会议</td><td>否</td><td>否</td>
</tr>
<tr>
<td>完成会议</td><td>否</td><td>否</td>
</tr>
<tr>
<td>菜单权限控制模块</td><td>否</td><td>否</td>
</tr>
</table>
</div>
<div id="main">
<div id="title"><br>suncm 会议管理系统登录<br>For memory of sun,a great corp.</div>
<form name="logon" method="post" action="<%=basePath %>ifwlogon.do">
<div>用户名：<input type="text" name="username"></div>
<div>密码：<input type="password" name="password"></div>
<div align="center"><input type="submit" name="sub" value="登录"></div>
<input type="hidden" name="ifw_flowname" value="LogonFlow">
</form>
</div>
<div class="userlist">
系统中现有用户如下：
<table>
<tr>
<td>用户名</td><td>密码</td><td>角色</td>
</tr>
<%
List<User> users = JbpmUtil.getIdentityService().findUsers();
for(User user:users){
%>
<tr>
<td><%=user.getId() %></td><td><%=((UserImpl)user).getPassword() %></td>
<td><%List<String> groups = JbpmUtil.getIdentityService().findGroupIdsByUser(user.getId()); 
for(String group : groups){
%>
<%=group %>,
<%} %>
</td>
</tr>
<%} %>
</table>
</div>
</body>
</html>
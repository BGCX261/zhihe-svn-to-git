<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.suncm.util.JbpmUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.jbpm.api.identity.User"%>
<%@page import="org.jbpm.pvm.internal.identity.impl.UserImpl"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>suncm �������ϵͳ</title>
<%
String basePath = request.getContextPath();
if(!basePath.endsWith("/")){
	basePath = basePath+"/";
}

%>
<style type="text/css">
div{
background-color:silver;
font-family:"����";
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
ϵͳ�������������£�
<table>
<tr>
<td>������</td><td>�������</td><td>�������</td>
</tr>
<tr>
<td>��Ŀ��������</td><td>��</td><td>��</td>
</tr>
<tr>
<td>�½���Ŀ</td><td>��</td><td>��</td>
</tr>
<tr>
<td>��Ŀ��ѯ</td><td>��</td><td>��</td>
</tr>
<tr>
<td>��������Ŀ</td><td>��</td><td>��</td>
</tr>
<tr>
<td>��ʷ�����ѯ</td><td>��</td><td>��</td>
</tr>
<tr>
<td>Ԥ������</td><td>��</td><td>��</td>
</tr>
<tr>
<td>��ǰ����</td><td>��</td><td>��</td>
</tr>
<tr>
<td>��ɻ���</td><td>��</td><td>��</td>
</tr>
<tr>
<td>�˵�Ȩ�޿���ģ��</td><td>��</td><td>��</td>
</tr>
</table>
</div>
<div id="main">
<div id="title"><br>suncm �������ϵͳ��¼<br>For memory of sun,a great corp.</div>
<form name="logon" method="post" action="<%=basePath %>ifwlogon.do">
<div>�û�����<input type="text" name="username"></div>
<div>���룺<input type="password" name="password"></div>
<div align="center"><input type="submit" name="sub" value="��¼"></div>
<input type="hidden" name="ifw_flowname" value="LogonFlow">
</form>
</div>
<div class="userlist">
ϵͳ�������û����£�
<table>
<tr>
<td>�û���</td><td>����</td><td>��ɫ</td>
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
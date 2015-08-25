<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>ifw 用户管理系统</title>
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
margin-top:20%;
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
</style>
</head>
<body>

<div id="main">
<div id="title"><br>ifw用户管理系统登录<br></div>
<form name="logon" method="post" action="<%=basePath %>ifwlogon.do">
<div>用户名：<input type="text" name="username"></div>
<div>密码：<input type="password" name="password"></div>
<div align="center"><input type="submit" name="sub" value="登录"></div>
<input type="hidden" name="ifw_flowname" value="LogonFlow">
</form>
</div>

</body>
</html>
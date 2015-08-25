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
<script language="javascript" type="text/javascript" src="<%=basePath%>js/rem/resdetail.js" ></script>
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
div#urlsele{
width:80%;
}
input#addurl{
font-size:14px;
}
span.title{
background-color:orange;
color:white;
font-weight:bold;
}
</style>
</head>
<body>
<div id="page">
  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <div id="main-b">
    <h2 class="dptdetail-title">资源相关信息</h2>
    <ul class="dptdetail-list">
    <li>资源基本信息</li>
    <div class="dptdetail-info">
    <div><span class="title">资源名称：</span>${newRes.name }</div>
    <div><span class="title">资源标题：</span>${newRes.title }</div>
    <div><span class="title">资源内容：</span>${newRes.content }</div>
    <div><span class="title">资源描述：</span>${newRes.desc }</div>
  
        <div class="dptdetail-op">
	<a class="opbutton" href="<%=basePath%>rem/rem_create_res.jsp?parentId=${newRes.resourceId}">添加下级资源</a>
	<a class="opbutton" href="<%=basePath%>ifw.do?resId=${newRes.resourceId }&ifw_flowname=RemDelResFlow">删除此资源</a>
    </div>
      </div>
    <li>资源键信息</li>
   <div class="dptdetail-info">
    
    已有资源键列表，可选中一项或多项后点击"删除"按钮除去一个资源键：
    <div id=urlsele>
                  <select id="restodel" size="4"
	MULTIPLE class="mselect" >
                    	  <c:forEach var="item" items="${nowResUrls}">
	  <option value="${item }">${item }
	  </c:forEach>
                  </select>
                  
                  </div>
                  <div><input id="delurl" type="button" value="删除" class="button" onclick="javascript:delUrl('<%=basePath%>Web20Servlet','${newRes.resourceId}');"></div>
<div id=delUrlHint class="invis">资源键已经成功删除</div>                  
                  <div style="margin-top: 1em">请输入一个资源键后点击"添加"按钮将其添加至资源键列表中：</div>
                  <div>
                  <form name="addurlform">
<TEXTAREA id="rurl" cols="40">
</TEXTAREA>
<input id="addurl" type="button" value="添加" class="button" onclick="javascript:addUrl('<%=basePath%>Web20Servlet','${newRes.resourceId}');">
</form>
</div>
                  
<div id=addUrlHint class="invis">资源键已经成功添加至本资源</div>
    </div>
 </ul>
    
     </div>
       

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
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
font-family:"����";

}
a.opbutton{
font-weight:bold;
}
div.dptdetail-info{
font-family:"����";
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
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <div id="main-b">
    <h2 class="dptdetail-title">��Դ�����Ϣ</h2>
    <ul class="dptdetail-list">
    <li>��Դ������Ϣ</li>
    <div class="dptdetail-info">
    <div><span class="title">��Դ���ƣ�</span>${newRes.name }</div>
    <div><span class="title">��Դ���⣺</span>${newRes.title }</div>
    <div><span class="title">��Դ���ݣ�</span>${newRes.content }</div>
    <div><span class="title">��Դ������</span>${newRes.desc }</div>
  
        <div class="dptdetail-op">
	<a class="opbutton" href="<%=basePath%>rem/rem_create_res.jsp?parentId=${newRes.resourceId}">����¼���Դ</a>
	<a class="opbutton" href="<%=basePath%>ifw.do?resId=${newRes.resourceId }&ifw_flowname=RemDelResFlow">ɾ������Դ</a>
    </div>
      </div>
    <li>��Դ����Ϣ</li>
   <div class="dptdetail-info">
    
    ������Դ���б���ѡ��һ���������"ɾ��"��ť��ȥһ����Դ����
    <div id=urlsele>
                  <select id="restodel" size="4"
	MULTIPLE class="mselect" >
                    	  <c:forEach var="item" items="${nowResUrls}">
	  <option value="${item }">${item }
	  </c:forEach>
                  </select>
                  
                  </div>
                  <div><input id="delurl" type="button" value="ɾ��" class="button" onclick="javascript:delUrl('<%=basePath%>Web20Servlet','${newRes.resourceId}');"></div>
<div id=delUrlHint class="invis">��Դ���Ѿ��ɹ�ɾ��</div>                  
                  <div style="margin-top: 1em">������һ����Դ������"���"��ť�����������Դ���б��У�</div>
                  <div>
                  <form name="addurlform">
<TEXTAREA id="rurl" cols="40">
</TEXTAREA>
<input id="addurl" type="button" value="���" class="button" onclick="javascript:addUrl('<%=basePath%>Web20Servlet','${newRes.resourceId}');">
</form>
</div>
                  
<div id=addUrlHint class="invis">��Դ���Ѿ��ɹ����������Դ</div>
    </div>
 </ul>
    
     </div>
       

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
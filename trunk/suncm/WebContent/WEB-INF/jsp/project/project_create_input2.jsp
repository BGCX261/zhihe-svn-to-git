<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../suncm_global.jsp"%>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">
<h1>创建项目</h1>
<p class="field-keys"><br>请确认项目基本信息并输入项目详细信息，带*号的为必输项<br></p>
<form >
<fieldset class="clear-after">  
            <legend>请确认项目基本信息</legend>
            <div>项目名称:
    ${dynamicData.projectName }</div>
    <div>项目分类:
   ${dynamicData.pCateName }</div>
   </fieldset>
</form>
<form name="cpcate" method="post" action="<%=basePath%>ifwfileup.do" enctype="multipart/form-data">
<input type="hidden" name="ifw_flowname" value="CreateProjectFlow">
<input type="hidden" name="pageActType" value="2">
<c:if test="${!empty(pageData)}">
<fieldset class="clear-after">  
            <legend>请填写项目详细信息</legend>
<ol>
	<c:forEach var="item" items="${pageData}">
    <sc:widget/>
    </c:forEach>
    
    </ol>
   </fieldset>
   </c:if>
   <input type="button" value="上一步" id="back" class="sbutton" onClick="javascript:history.go(-1);"/>
   <input type="submit" value="完成" id="send" class="sbutton"/>
	</form>
	
</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
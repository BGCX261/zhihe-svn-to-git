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
<h1>������Ŀ</h1>
<p class="field-keys"><br>��ȷ����Ŀ������Ϣ��������Ŀ��ϸ��Ϣ����*�ŵ�Ϊ������<br></p>
<form >
<fieldset class="clear-after">  
            <legend>��ȷ����Ŀ������Ϣ</legend>
            <div>��Ŀ����:
    ${dynamicData.projectName }</div>
    <div>��Ŀ����:
   ${dynamicData.pCateName }</div>
   </fieldset>
</form>
<form name="cpcate" method="post" action="<%=basePath%>ifwfileup.do" enctype="multipart/form-data">
<input type="hidden" name="ifw_flowname" value="CreateProjectFlow">
<input type="hidden" name="pageActType" value="2">
<c:if test="${!empty(pageData)}">
<fieldset class="clear-after">  
            <legend>����д��Ŀ��ϸ��Ϣ</legend>
<ol>
	<c:forEach var="item" items="${pageData}">
    <sc:widget/>
    </c:forEach>
    
    </ol>
   </fieldset>
   </c:if>
   <input type="button" value="��һ��" id="back" class="sbutton" onClick="javascript:history.go(-1);"/>
   <input type="submit" value="���" id="send" class="sbutton"/>
	</form>
	
</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
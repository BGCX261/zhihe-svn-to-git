<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../suncm_global.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	
	$('form').submit(function(){
		$('#pCateName').attr('value',cpcate.pCateId.options[cpcate.pCateId.selectedIndex].text);
		return true;
	});
});
</script>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">

<h1>������Ŀ</h1>
<p class="field-keys"><br>��������Ŀ������Ϣ����*�ŵ�Ϊ������<br></p>
<form name="cpcate" method="post" action="<%=basePath%>ifw.do">

<fieldset class="clear-after">  
            <legend>����д��Ŀ������Ϣ</legend>
<input type="hidden" name="ifw_flowname" value="CreateProjectFlow">
<input type="hidden" name="pCateName" id="pCateName">
<input type="hidden" name="pageActType" value="1">
<ol>
    <li><label for="projectName">��Ŀ����*</label>
    <input class="required limitlen" maxlength="56" type="text" name="projectName" id="projectName"/> 
    <span>���56��Ӣ���ַ���28������</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="wflName">��Ŀ����*</label>
    <select name="pCateId" id="pCateId">
    	<c:forEach var="item" items="${pageData}" >
    <option value="${item.projectCateId }">${item.projectCateName }</option>
    </c:forEach>
    </select> 
    <span>��ѡ����Ŀ��������</span><img src='${basePath}img/check_right.gif'/></li>
    
    </ol>
   </fieldset>
   <input type="submit" value="��һ��" id="send" class="sbutton"/>
	</form>


</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
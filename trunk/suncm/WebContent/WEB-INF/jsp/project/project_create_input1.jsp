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

<h1>创建项目</h1>
<p class="field-keys"><br>请输入项目基本信息，带*号的为必输项<br></p>
<form name="cpcate" method="post" action="<%=basePath%>ifw.do">

<fieldset class="clear-after">  
            <legend>请填写项目基本信息</legend>
<input type="hidden" name="ifw_flowname" value="CreateProjectFlow">
<input type="hidden" name="pCateName" id="pCateName">
<input type="hidden" name="pageActType" value="1">
<ol>
    <li><label for="projectName">项目名称*</label>
    <input class="required limitlen" maxlength="56" type="text" name="projectName" id="projectName"/> 
    <span>最多56个英文字符或28个汉字</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="wflName">项目分类*</label>
    <select name="pCateId" id="pCateId">
    	<c:forEach var="item" items="${pageData}" >
    <option value="${item.projectCateId }">${item.projectCateName }</option>
    </c:forEach>
    </select> 
    <span>请选择项目所属分类</span><img src='${basePath}img/check_right.gif'/></li>
    
    </ol>
   </fieldset>
   <input type="submit" value="下一步" id="send" class="sbutton"/>
	</form>


</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
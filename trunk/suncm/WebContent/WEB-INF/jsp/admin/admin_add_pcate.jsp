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
<h1>创建项目种类</h1>
<p class="field-keys"><br>请在下面表格中填写项目种类信息后，点击“创建”按钮来创建一个项目种类，带*号的为必输项<br></p>
<form name="cpcate" method="post" action="<%=basePath%>ifwfileup.do" enctype="multipart/form-data">

<fieldset class="clear-after">  
            <legend>请填写项目种类信息</legend>
<input type="hidden" name="ifw_flowname" value="CreatePCateFlow">
<ol>
    <li><label for="pCateName">项目种类名称*</label>
    <input class="required limitlen" maxlength="56" type="text" name="pCateName" id="pCateName" /> 
    <span>最多56个英文字符或28个汉字</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="wflName">工作流名称*</label>
    <input class="required limitlen" maxlength="56" type="text" name="wflName" id="wflName" /> 
    <span>最多56个英文字符或28个汉字</span><img src='${basePath}img/check_right.gif'/></li>
    <li><label for="wflFile">工作流文件*</label>
    <input class="required" type="file" name="wflFile" id="wflFile" /> 
    <span>工作流逻辑文件或部署包</span><img src='${basePath}img/check_right.gif'/></li>
    </ol>
   </fieldset>
   <input type="submit" value="创建" id="send" />
	</form>
</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
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
<h1>������Ŀ����</h1>
<p class="field-keys"><br>��������������д��Ŀ������Ϣ�󣬵������������ť������һ����Ŀ���࣬��*�ŵ�Ϊ������<br></p>
<form name="cpcate" method="post" action="<%=basePath%>ifwfileup.do" enctype="multipart/form-data">

<fieldset class="clear-after">  
            <legend>����д��Ŀ������Ϣ</legend>
<input type="hidden" name="ifw_flowname" value="CreatePCateFlow">
<ol>
    <li><label for="pCateName">��Ŀ��������*</label>
    <input class="required limitlen" maxlength="56" type="text" name="pCateName" id="pCateName" /> 
    <span>���56��Ӣ���ַ���28������</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="wflName">����������*</label>
    <input class="required limitlen" maxlength="56" type="text" name="wflName" id="wflName" /> 
    <span>���56��Ӣ���ַ���28������</span><img src='${basePath}img/check_right.gif'/></li>
    <li><label for="wflFile">�������ļ�*</label>
    <input class="required" type="file" name="wflFile" id="wflFile" /> 
    <span>�������߼��ļ������</span><img src='${basePath}img/check_right.gif'/></li>
    </ol>
   </fieldset>
   <input type="submit" value="����" id="send" />
	</form>
</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%></div>
</body>
</html>
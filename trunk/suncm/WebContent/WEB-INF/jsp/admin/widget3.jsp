<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
	<%--�ļ��ϴ��� --%>
		<form name="addwidget3" id="addwidget3" method="post" action="${basePath}ifw.do">
<fieldset class="clear-after">
<input type="hidden" name="pCateId" value="${pCateId}">
<input type="hidden" name="ifw_flowname" value="PCateTplManagerFlow">
<input type="hidden" name="flag" value="0">
<input type="hidden" name="pagetype">

            <legend>�붨���ֶ�����</legend>
	<ol id="widget3"> 
<li><label for="propertyName">�ֶ�����*</label>
    <input class="required limitlen" maxlength="56" type="text" name="propertyName" id="propertyName" /> 
    <span>���56��Ӣ���ַ���28������</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="itemdesc">�ֶ�����</label>
    <input class="limitlen" maxlength="100" type="text" name="itemdesc" id="itemdesc" /> 
    <span>���100��Ӣ���ַ���50������</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="isforced">�Ƿ����*</label>
    <select name="isforced">
    <option value="1">��</option>
    <option value="0">��</option>
    </select>
    <span>���ѡ��������½���Ŀʱ��ǿ��Ҫ������</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    

           
    </ol>
        </fieldset>
    <div ><input type="submit" value="���" id="add3"
	class="sbutton" /></div>
    </form>
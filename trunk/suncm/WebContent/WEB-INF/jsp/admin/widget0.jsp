<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
	<%--��ͨ�ı������ --%>
	
	<form name="addwidget0" id="addwidget0" method="post" action="${basePath}ifw.do">
<fieldset class="clear-after">
<input type="hidden" name="pCateId" value="${pCateId}">
<input type="hidden" name="ifw_flowname" value="PCateTplManagerFlow">
<input type="hidden" name="flag" value="0">
<input type="hidden" name="pagetype">

            <legend>�붨���ֶ�����</legend>
	<ol id="widget0"> 
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
    <li><label for="minlength">��������*</label>
    <input class="limitlen" maxlength="3" type="text" name="minlength" id="minlength" value='0'/> 
    <span>������С��1000������,������1,�򳤶���СΪ1,Ĭ����0</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>               
    <li><label for="maxlength">��������</label>
    <input class="limitlen" maxlength="3" type="text" name="maxlength" id="maxlength" value="1000"/> 
    <span>������С��1000������.������9,�򳤶����Ϊ9,Ĭ��1000</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
        <li><label for="options">Ĭ��ֵ</label>
    <input class="limitlen" maxlength="100" type="text" name="options" id="options"/> 
    <span>����������Ĭ��ֵ,���100��Ӣ���ַ���50������</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="ismodify">�Ƿ���޸�*</label>
    <select name="ismodify">
    <option value="0">��</option>
    <option value="1">��</option>
    
    </select>
    <span>��Ŀһ���������ֶ��Ƿ����ٽ����޸�</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="isqcon">�Ƿ��ǲ�ѯ����*</label>
    <select name="isqcon">
    <option value="0">��</option>
    <option value="1">��</option>
    
    </select>
    <span>����Ŀ��ѯʱ�Ƿ������Ϊ��ѯ����</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="isinlist">�Ƿ��ѯ�б���ʾ*</label>
    <select name="isinlist">
    <option value="0">��</option>
    <option value="1">��</option>
    
    </select>
    <span>��Ŀ��ѯ�Ľ���б��Ƿ�չʾ���ֶ�</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>        
    </ol>
    </fieldset>
    <div ><input type="submit" value="���" id="add0"
	class="sbutton" /></div>
    </form>
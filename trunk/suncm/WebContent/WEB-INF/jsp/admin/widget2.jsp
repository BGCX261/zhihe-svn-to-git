<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
	<%--日期选择框 --%>
		<form name="addwidget2" id="addwidget2" method="post" action="${basePath}ifw.do">
<fieldset class="clear-after">
<input type="hidden" name="pCateId" value="${pCateId}">
<input type="hidden" name="ifw_flowname" value="PCateTplManagerFlow">
<input type="hidden" name="flag" value="0">
<input type="hidden" name="pagetype">

            <legend>请定制字段属性</legend>
	<ol id="widget2"> 
<li><label for="propertyName">字段名称*</label>
    <input class="required limitlen" maxlength="56" type="text" name="propertyName" id="propertyName" /> 
    <span>最多56个英文字符或28个汉字</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="itemdesc">字段描述</label>
    <input class="limitlen" maxlength="100" type="text" name="itemdesc" id="itemdesc" /> 
    <span>最多100个英文字符或50个汉字</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="isforced">是否必输*</label>
    <select name="isforced">
    <option value="1">是</option>
    <option value="0">否</option>
    </select>
    <span>如果选择必输则新建项目时会强制要求输入</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    
    <li><label for="ismodify">是否可修改*</label>
    <select name="ismodify">
    <option value="0">否</option>
    <option value="1">是</option>
    
    </select>
    <span>项目一旦建立此字段是否还能再进行修改</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="isqcon">是否是查询条件*</label>
    <select name="isqcon">
    <option value="0">否</option>
    <option value="1">是</option>
    
    </select>
    <span>在项目查询时是否可以作为查询条件</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>
    <li><label for="isinlist">是否查询列表显示*</label>
    <select name="isinlist">
    <option value="0">否</option>
    <option value="1">是</option>
    
    </select>
    <span>项目查询的结果列表是否展示此字段</span>
    <img src='${basePath}img/check_right.gif'/>
    </li>        
    </ol>
        </fieldset>
    <div ><input type="submit" value="添加" id="add2"
	class="sbutton" /></div>
    </form>
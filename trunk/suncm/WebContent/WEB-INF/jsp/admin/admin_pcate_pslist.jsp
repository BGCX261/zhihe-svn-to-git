<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../suncm_global.jsp"%>
<script language="javascript" src="${basePath}js/widgets.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}css/tables.css"
	media="screen" />
<script language="javascript" src="${basePath}js/tables.js"></script>
<script type="text/javascript">
history.go(1);
$(document).ready(function() {
	$('form').unbind();
	$('form').submit(function(){
		var ptname = eval('document.'+$(this).attr('name')+'.pagetype');
		ptname.value=addwidget.widgetType.value;
		return true;
	});
	 $('form').submit(function() {
		    $('#submit-message').remove();
		    $(this).find('input.required').trigger('blur');
		    var numWarnings = $('.warning', this).length;
		      if (numWarnings) {
		        var fieldList = [];
		        $(this).find('.warning label').each(function() {
		          fieldList.push($(this).text().replace('\*',''));
		        });
		        $('<div></div>')
		        .attr({
		          'id': 'submit-message', 
		          'class': 'warning'
		        })
		        .append('请先修正下述输入项的错误，共' + 
		                                      numWarnings + '个:<br />')
		        .append('&bull; ' + fieldList.join('<br />&bull; '))
		        .insertBefore('#add'+addwidget.widgetType.value);
		      return false;
		    }});
});
</script>
</head>
<body>
<div class="container">

<div class="main"><%@ include file="../suncm_head.jsp"%>

<div class="content">

<div class="item">

<h1>项目模板设置</h1>
<p class="field-keys"><br>
每个项目除固定字段外都可根据需要维护若干定制字段，系统提供了多种类型的可定制字段，并可定制字段的常用属性，如是否必输，长度限制等。<br />
请先选择定制的字段类型，然后选择字段相关的若干属性，点击"添加按钮"即可将字段添加至项目。<br />
其中标有"*"号的是必输项 <br>
</p>

<form name="addwidget" method="post">
<fieldset class="clear-after"><legend>请选择字段种类</legend>
<ol>
	<li><label for="widgetType">项目种类名称*</label> <select
		name="widgetType" id="widgetType">
		<option value="0">普通文本框</option>
		<option value="1">普通下拉框</option>
		<option value="2">日期选择框</option>
		<option value="3">文件上传框</option>
	</select></li>
</ol>
</fieldset>
</form>

    
<%@ include file="widget0.jsp"%> <%@ include
	file="widget1.jsp"%> <%@ include
	file="widget2.jsp"%> <%@ include
	file="widget3.jsp"%>


<p class="field-keys"><br>
下表是此项目分类已有的字段列表以及属性 <br>
</p>
<c:choose>
	<c:when test="${pageTotalNum==0}">
		<div class="nonehint">目前暂无模板字段</div>
	</c:when>
	<c:otherwise>
		<table class="sortable paginated" align="center">
			<thead>
				<tr>
					<th>字段名称</th>
					<th>类型</th>
					<th>字段描述</th>
					<th>是否必输</th>
					<th>是否只读</th>
					<th>长度下限</th>
					<th>长度上限</th>
					<th>下拉选项值</th>
					<th>是否作为查询条件</th>
					<th>是否在查询列表中展示</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${pageData}" begin="${beginNum}"
					end="${endNum}">
					<tr>
						<td>${item.propertyName }</td>
						<td><fmt:message bundle="${suncm_admin}"
							key="suncm.admin.pagesettype_${item.pagetype}" /></td>
						<td>${item.itemdesc}</td>
						<td><fmt:message bundle="${suncm_admin}"
							key="suncm.admin.switch_${item.isforced}" /></td>
						<td><fmt:message bundle="${suncm_admin}"
							key="suncm.admin.switch_${item.readonly}" /></td>
						<td>${item.minlength}</td>
						<td>${item.maxlength}</td>
						<td>${item.options}&nbsp;</td>
						<td><fmt:message bundle="${suncm_admin}"
							key="suncm.admin.switch_${item.isqcon}" /></td>
						<td><fmt:message bundle="${suncm_admin}"
							key="suncm.admin.switch_${item.isinlist}" /></td>
						<td><a
							href="${basePath}ifw.do?ifw_flowname=PCateTplManagerFlow&pCateId=${pCateId}&flag=1&id=${item.id.pageNo}">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:otherwise>
</c:choose></div>


</div>

<%@ include file="../suncm_left.jsp"%>

<div class="clearer"><span></span></div>

</div>

<%@ include file="../suncm_foot.jsp"%>
</div>
</body>
</html>
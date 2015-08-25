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
		        .append('������������������Ĵ��󣬹�' + 
		                                      numWarnings + '��:<br />')
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

<h1>��Ŀģ������</h1>
<p class="field-keys"><br>
ÿ����Ŀ���̶��ֶ��ⶼ�ɸ�����Ҫά�����ɶ����ֶΣ�ϵͳ�ṩ�˶������͵Ŀɶ����ֶΣ����ɶ����ֶεĳ������ԣ����Ƿ���䣬�������Ƶȡ�<br />
����ѡ���Ƶ��ֶ����ͣ�Ȼ��ѡ���ֶ���ص��������ԣ����"��Ӱ�ť"���ɽ��ֶ��������Ŀ��<br />
���б���"*"�ŵ��Ǳ����� <br>
</p>

<form name="addwidget" method="post">
<fieldset class="clear-after"><legend>��ѡ���ֶ�����</legend>
<ol>
	<li><label for="widgetType">��Ŀ��������*</label> <select
		name="widgetType" id="widgetType">
		<option value="0">��ͨ�ı���</option>
		<option value="1">��ͨ������</option>
		<option value="2">����ѡ���</option>
		<option value="3">�ļ��ϴ���</option>
	</select></li>
</ol>
</fieldset>
</form>

    
<%@ include file="widget0.jsp"%> <%@ include
	file="widget1.jsp"%> <%@ include
	file="widget2.jsp"%> <%@ include
	file="widget3.jsp"%>


<p class="field-keys"><br>
�±��Ǵ���Ŀ�������е��ֶ��б��Լ����� <br>
</p>
<c:choose>
	<c:when test="${pageTotalNum==0}">
		<div class="nonehint">Ŀǰ����ģ���ֶ�</div>
	</c:when>
	<c:otherwise>
		<table class="sortable paginated" align="center">
			<thead>
				<tr>
					<th>�ֶ�����</th>
					<th>����</th>
					<th>�ֶ�����</th>
					<th>�Ƿ����</th>
					<th>�Ƿ�ֻ��</th>
					<th>��������</th>
					<th>��������</th>
					<th>����ѡ��ֵ</th>
					<th>�Ƿ���Ϊ��ѯ����</th>
					<th>�Ƿ��ڲ�ѯ�б���չʾ</th>
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
							href="${basePath}ifw.do?ifw_flowname=PCateTplManagerFlow&pCateId=${pCateId}&flag=1&id=${item.id.pageNo}">ɾ��</a></td>
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
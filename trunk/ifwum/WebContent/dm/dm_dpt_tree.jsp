<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    
 <%@ taglib uri="/ium" prefix="ium" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript" type="text/javascript" src="<%=basePath%>js/tree.js" ></script>
<script type="text/javascript" language="javascript">
function clickLink(){
	var nodeId = this.name.substring(3);
	
	if(nodeId == 0)
		parent.opframe.location.href='<%=basePath%>dm/dm_dptdetail_addcld.jsp?parentId=0';
	else
		parent.opframe.location.href='<%=basePath%>ifw.do?ifw_flowname=DmPrepareDptInfoFlow&dptId=' + this.name.substring(3);
}
</script>
</head>


<body >
  


  <div id="body">
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- �������� -->
    
    <p><br>���������£����ڴ˻�����ά��������Ϣ���������ź󻹿��Ե�� <a href="javascript:parent.dpttree.submit();">����</a> ˢ�»�������<br></p>
<!-- tree:explorer provider="com.css.security.db.org.OrgTreeModelProvider" rootText="��������Ϣ">
  <tree:node id="node" type="com.css.framework.model.TreeNode" imgPath="/ifwum/plugins/tree/skins/default/images/">
    <tree:line show="" parentHref="dm_dpt_detail.jsp" leafHref= "./dm_dpt_detail.jsp" target="opframe"/>
  </tree:node>
</tree:explorer-->
<ium:tree provider="com.css.security.db.org.DeptTreeNodeProvider" linkUrl="#" rootText="��֯������"/>

<script type="text/javascript" language="javascript">
var linkB = document.getElementById('body');
var links = document.getElementsByTagName('a');
for(var i=0;i<links.length;i++){
	links[i].onclick = clickLink;
}
</script>

       

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

</div>

</body>
</html>
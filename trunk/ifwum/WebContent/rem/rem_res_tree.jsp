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
		parent.opframe.location.href='<%=basePath%>rem/rem_create_res.jsp?parentId=0';
	else
		parent.opframe.location.href='<%=basePath%>ifw.do?ifw_flowname=RemPrepareResInfoFlow&resId=' + this.name.substring(3);
}
</script>
</head>


<body >
  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- 主交易区 -->
    
    <p><br>资源树如下，可在此基础上维护资源信息，创建资源后还可以点击 <a href="javascript:parent.restree.submit();">这里</a> 刷新资源树。<br></p>
<!-- tree:explorer provider="com.css.security.db.org.OrgTreeModelProvider" rootText="机构树信息">
  <tree:node id="node" type="com.css.framework.model.TreeNode" imgPath="/ifwum/plugins/tree/skins/default/images/">
    <tree:line show="" parentHref="dm_dpt_detail.jsp" leafHref= "./dm_dpt_detail.jsp" target="opframe"/>
  </tree:node>
</tree:explorer-->
<ium:tree provider="com.css.security.db.permission.ResTreeModelProvider" linkUrl="#" rootText="资源树"/>

<script type="text/javascript" language="javascript">
var linkB = document.getElementById('body');
var links = document.getElementsByTagName('a');
for(var i=0;i<links.length;i++){
	links[i].onclick = clickLink;
}
</script>

       

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

</div>

</body>
</html>
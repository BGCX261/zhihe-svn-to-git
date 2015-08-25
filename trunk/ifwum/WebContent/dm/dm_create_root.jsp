<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkcroot(){
		if(!checks('croot','deptcode',20,'机构代码')){
			return false;
		}
		if(!checks('croot','deptname',30,'机构名称')){
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div id="page">
<!-- 头部和一级菜单区 -->
<%@ include file="../ifwum_head.jsp" %>

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    机构管理-创建根机构
    </div>
    <div id="main-body">
    <p><br>请输入下述信息创建根机构<br></p>
<form name="croot" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="DmCreateDptFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">机构代码：*</td><td class="ne-input">
    <input type="text" length="20" maxlength="20" name="deptcode" onblur="javascript:createHint('croot','deptcode',20,'机构代码');"></td>
    <td id="deptcode-hint" class="hint">部门简称，最多10个汉字或20个英文字母</td></tr>
    <tr>
    <td class="ne-title">机构名称：*</td><td class="ne-input">
    <input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'机构名称');"></td>
    <td id="deptname-hint" class="hint">部门全称，最多15个汉字或30个英文字母</td></tr>
    <input type="hidden" name="typecode" value="1">
    <input type="hidden" name="parentId" value="0">
    <input type="hidden" name="infocode" value="1">
	    <tr><td colspan="3" align="center"><input class="button" type="submit"  value="创建">
	    </td></tr>
	    
    </table>
    
	</form>
    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
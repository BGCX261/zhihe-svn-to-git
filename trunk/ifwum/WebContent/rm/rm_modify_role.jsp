<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkmrole(){
		if(!checks('mrole','rolename',50,'角色名称')){
			return false;
		}
		if(!checks('mrole','roledesc',200,'角色描述')){
			return false;
		}
		if(!createHintSpec()){
			alert("角色名称和角色描述均无改变，不能提交。");
			return false;
		}
		return true;
	}
	function createHintSpec(){
		if(mrole.rolename.value=='${roleObject.name}' && mrole.roledesc.value=='${roleObject.desc}'){
			document.all["rolename-hint"].className="errorhint";
			document.all["roledesc-hint"].className="errorhint";
			document.all["rolename-hint"].innerHTML='角色名称和角色描述均无改变，不能提交。';
			document.all["roledesc-hint"].innerHTML='角色名称和角色描述均无改变，不能提交。';
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
    机构管理-角色信息修改
    </div>
    <div id="main-body">
    <p><br>请修改角色信息<br></p>
<form name="mrole" method="rolet" action="<%=basePath%>ifw.do" onSubmit="return(checkmrole());">
<input type="hidden" name="ifw_flowname" value="PmModifyroleFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">角色名称：*</td><td class="ne-input">
    <input type="text" value="${roleObject.name }" length="50" maxlength="50" name="rolename" 
    onblur="javascript:createHint('mrole','rolename',50,'角色名称');"></td>
    <td id="rolename-hint" class="hint">角色简要的中文名，最多25个汉字或50个英文字母</td></tr>
    <tr>
    <td class="ne-title">角色描述：*</td><td class="ne-input">
    <TEXTAREA name="roledesc" cols="30" onblur="javascript:createHint('mrole','roledesc',200,'角色描述');createHintSpec();">${roleObject.desc }</TEXTAREA>
    
    <!-- input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'机构名称');"-->
    </td>
    <td id="roledesc-hint" class="hint">可对角色的职能，责任做出详细说明，最多100个汉字或200个英文字母</td></tr>
    <input type="hidden" name="flag" value="1">
    <input type="hidden" name="roleId" value="${roleObject.roleId}">
	    <tr><td colspan="3" align="center"><input class="button" type="submit"  value="修改">
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
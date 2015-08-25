<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkmpos(){
		if(!checks('mpos','posname',50,'岗位名称')){
			return false;
		}
		if(!checks('mpos','posdesc',200,'岗位描述')){
			return false;
		}
		if(!createHintSpec()){
			alert("岗位名称和岗位描述均无改变，不能提交。");
			return false;
		}
		return true;
	}
	function createHintSpec(){
		if(mpos.posname.value=='${posObject.name}' && mpos.posdesc.value=='${posObject.desc}'){
			document.all["posname-hint"].className="errorhint";
			document.all["posdesc-hint"].className="errorhint";
			document.all["posname-hint"].innerHTML='岗位名称和岗位描述均无改变，不能提交。';
			document.all["posdesc-hint"].innerHTML='岗位名称和岗位描述均无改变，不能提交。';
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
    机构管理-岗位信息修改
    </div>
    <div id="main-body">
    <p><br>请修改岗位信息<br></p>
<form name="mpos" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkmpos());">
<input type="hidden" name="ifw_flowname" value="PmModifyPosFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">岗位名称：*</td><td class="ne-input">
    <input type="text" value="${posObject.name }" length="50" maxlength="50" name="posname" 
    onblur="javascript:createHint('mpos','posname',50,'岗位名称');"></td>
    <td id="posname-hint" class="hint">岗位简要的中文名，最多25个汉字或50个英文字母</td></tr>
    <tr>
    <td class="ne-title">岗位描述：*</td><td class="ne-input">
    <TEXTAREA name="posdesc" cols="30" onblur="javascript:createHint('mpos','posdesc',200,'岗位描述');createHintSpec();">${posObject.desc }</TEXTAREA>
    
    <!-- input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'机构名称');"-->
    </td>
    <td id="posdesc-hint" class="hint">可对岗位的职能，责任做出详细说明，最多100个汉字或200个英文字母</td></tr>
    <input type="hidden" name="flag" value="1">
    <input type="hidden" name="posId" value="${posObject.positionId}">
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
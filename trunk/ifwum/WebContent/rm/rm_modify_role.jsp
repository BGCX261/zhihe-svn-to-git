<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkmrole(){
		if(!checks('mrole','rolename',50,'��ɫ����')){
			return false;
		}
		if(!checks('mrole','roledesc',200,'��ɫ����')){
			return false;
		}
		if(!createHintSpec()){
			alert("��ɫ���ƺͽ�ɫ�������޸ı䣬�����ύ��");
			return false;
		}
		return true;
	}
	function createHintSpec(){
		if(mrole.rolename.value=='${roleObject.name}' && mrole.roledesc.value=='${roleObject.desc}'){
			document.all["rolename-hint"].className="errorhint";
			document.all["roledesc-hint"].className="errorhint";
			document.all["rolename-hint"].innerHTML='��ɫ���ƺͽ�ɫ�������޸ı䣬�����ύ��';
			document.all["roledesc-hint"].innerHTML='��ɫ���ƺͽ�ɫ�������޸ı䣬�����ύ��';
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div id="page">
<!-- ͷ����һ���˵��� -->
<%@ include file="../ifwum_head.jsp" %>

  


  <div id="body">
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->
    <!-- �������� -->
    <div id="main">
    <div id="main-title">
    ��������-��ɫ��Ϣ�޸�
    </div>
    <div id="main-body">
    <p><br>���޸Ľ�ɫ��Ϣ<br></p>
<form name="mrole" method="rolet" action="<%=basePath%>ifw.do" onSubmit="return(checkmrole());">
<input type="hidden" name="ifw_flowname" value="PmModifyroleFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">��ɫ���ƣ�*</td><td class="ne-input">
    <input type="text" value="${roleObject.name }" length="50" maxlength="50" name="rolename" 
    onblur="javascript:createHint('mrole','rolename',50,'��ɫ����');"></td>
    <td id="rolename-hint" class="hint">��ɫ��Ҫ�������������25�����ֻ�50��Ӣ����ĸ</td></tr>
    <tr>
    <td class="ne-title">��ɫ������*</td><td class="ne-input">
    <TEXTAREA name="roledesc" cols="30" onblur="javascript:createHint('mrole','roledesc',200,'��ɫ����');createHintSpec();">${roleObject.desc }</TEXTAREA>
    
    <!-- input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'��������');"-->
    </td>
    <td id="roledesc-hint" class="hint">�ɶԽ�ɫ��ְ�ܣ�����������ϸ˵�������100�����ֻ�200��Ӣ����ĸ</td></tr>
    <input type="hidden" name="flag" value="1">
    <input type="hidden" name="roleId" value="${roleObject.roleId}">
	    <tr><td colspan="3" align="center"><input class="button" type="submit"  value="�޸�">
	    </td></tr>
	    
    </table>
    
	</form>
    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="../ifwum_foot.jsp" %>

</div>


</body>
</html>
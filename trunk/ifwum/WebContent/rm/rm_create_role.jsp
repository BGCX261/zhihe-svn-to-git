<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkcroot(){
		if(!checks('crole','rolename',50,'��ɫ����')){
			return false;
		}
		if(!checks('crole','roledesc',256,'��ɫ����')){
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
    ��������-������ɫ
    </div>
    <div id="main-body">
    <p><br>������������Ϣ����һ����ɫ<br></p>
<form name="crole" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="RmCreateRoleFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">��ɫ���ƣ�*</td><td class="ne-input">
    <input type="text" length="50" maxlength="50" name="rolename" onblur="javascript:createHint('crole','rolename',50,'��ɫ����');"></td>
    <td id="rolename-hint" class="hint">��ɫ��Ҫ�������������25�����ֻ�50��Ӣ����ĸ</td></tr>
    <tr>
    <td class="ne-title">��ɫ������*</td><td class="ne-input">
    <TEXTAREA name="roledesc" cols="30" onblur="javascript:createHint('crole','roledesc',200,'��ɫ����');">
</TEXTAREA>
    
    <!-- input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'��������');"-->
    </td>
    <td id="roledesc-hint" class="hint">�ɶԽ�ɫ�Ķ�λ������ϸ˵�������128�����ֻ�256��Ӣ����ĸ</td></tr>
    <input type="hidden" name="typecode" value="1">
    <input type="hidden" name="infocode" value="1">
	    <tr><td colspan="3" align="center"><input class="button" type="submit"  value="����">
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
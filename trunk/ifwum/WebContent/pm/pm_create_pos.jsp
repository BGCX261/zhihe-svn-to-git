<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkcroot(){
		if(!checks('cpos','posname',50,'��λ����')){
			return false;
		}
		if(!checks('cpos','posdesc',200,'��λ����')){
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
    ��������-������λ
    </div>
    <div id="main-body">
    <p><br>������������Ϣ����һ����λ<br></p>
<form name="cpos" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="PmCreatePosFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">��λ���ƣ�*</td><td class="ne-input">
    <input type="text" length="50" maxlength="50" name="posname" onblur="javascript:createHint('cpos','posname',50,'��λ����');"></td>
    <td id="posname-hint" class="hint">��λ��Ҫ�������������25�����ֻ�50��Ӣ����ĸ</td></tr>
    <tr>
    <td class="ne-title">��λ������*</td><td class="ne-input">
    <TEXTAREA name="posdesc" cols="30" onblur="javascript:createHint('cpos','posdesc',200,'��λ����');">
</TEXTAREA>
    
    <!-- input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'��������');"-->
    </td>
    <td id="posdesc-hint" class="hint">�ɶԸ�λ��ְ�ܣ�����������ϸ˵�������100�����ֻ�200��Ӣ����ĸ</td></tr>
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
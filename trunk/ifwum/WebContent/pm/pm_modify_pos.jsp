<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkmpos(){
		if(!checks('mpos','posname',50,'��λ����')){
			return false;
		}
		if(!checks('mpos','posdesc',200,'��λ����')){
			return false;
		}
		if(!createHintSpec()){
			alert("��λ���ƺ͸�λ�������޸ı䣬�����ύ��");
			return false;
		}
		return true;
	}
	function createHintSpec(){
		if(mpos.posname.value=='${posObject.name}' && mpos.posdesc.value=='${posObject.desc}'){
			document.all["posname-hint"].className="errorhint";
			document.all["posdesc-hint"].className="errorhint";
			document.all["posname-hint"].innerHTML='��λ���ƺ͸�λ�������޸ı䣬�����ύ��';
			document.all["posdesc-hint"].innerHTML='��λ���ƺ͸�λ�������޸ı䣬�����ύ��';
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
    ��������-��λ��Ϣ�޸�
    </div>
    <div id="main-body">
    <p><br>���޸ĸ�λ��Ϣ<br></p>
<form name="mpos" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkmpos());">
<input type="hidden" name="ifw_flowname" value="PmModifyPosFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">��λ���ƣ�*</td><td class="ne-input">
    <input type="text" value="${posObject.name }" length="50" maxlength="50" name="posname" 
    onblur="javascript:createHint('mpos','posname',50,'��λ����');"></td>
    <td id="posname-hint" class="hint">��λ��Ҫ�������������25�����ֻ�50��Ӣ����ĸ</td></tr>
    <tr>
    <td class="ne-title">��λ������*</td><td class="ne-input">
    <TEXTAREA name="posdesc" cols="30" onblur="javascript:createHint('mpos','posdesc',200,'��λ����');createHintSpec();">${posObject.desc }</TEXTAREA>
    
    <!-- input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'��������');"-->
    </td>
    <td id="posdesc-hint" class="hint">�ɶԸ�λ��ְ�ܣ�����������ϸ˵�������100�����ֻ�200��Ӣ����ĸ</td></tr>
    <input type="hidden" name="flag" value="1">
    <input type="hidden" name="posId" value="${posObject.positionId}">
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
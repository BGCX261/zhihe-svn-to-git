<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
	function checkcroot(){
		if(!checks('croot','deptcode',20,'��������')){
			return false;
		}
		if(!checks('croot','deptname',30,'��������')){
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
    ��������-����������
    </div>
    <div id="main-body">
    <p><br>������������Ϣ����������<br></p>
<form name="croot" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="DmCreateDptFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">�������룺*</td><td class="ne-input">
    <input type="text" length="20" maxlength="20" name="deptcode" onblur="javascript:createHint('croot','deptcode',20,'��������');"></td>
    <td id="deptcode-hint" class="hint">���ż�ƣ����10�����ֻ�20��Ӣ����ĸ</td></tr>
    <tr>
    <td class="ne-title">�������ƣ�*</td><td class="ne-input">
    <input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'��������');"></td>
    <td id="deptname-hint" class="hint">����ȫ�ƣ����15�����ֻ�30��Ӣ����ĸ</td></tr>
    <input type="hidden" name="typecode" value="1">
    <input type="hidden" name="parentId" value="0">
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
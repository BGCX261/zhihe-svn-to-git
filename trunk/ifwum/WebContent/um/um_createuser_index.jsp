<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<script language="javascript">
function createHintPassword(formname,itemname,limit,nameCN){
	var itemvalue = eval(formname+"."+itemname+".value");
	var itemvalue1 = eval(formname+".password.value");
	if(itemvalue == itemvalue1){
		document.all[itemname + "-hint"].className="okhint";
		replaceText(document.all[itemname + "-hint"],okmessage);
	}else{
		errormessage = "������������벻һ�£����޸ġ�";
		document.all[itemname + "-hint"].className="errorhint";
		replaceText(document.all[itemname + "-hint"],errormessage);
	}
}
function checksPassword(formname,itemname,limit,nameCN){
	var itemvalue = eval(formname+"."+itemname+".value");
	var itemvalue1 = eval(formname+".password.value");
	var item = eval(formname+"."+itemname);
		
		if(itemvalue1 == itemvalue){
			return true;
		}else{
			alert(errormessage);
			item.focus();
			return false;
		}
}
	function checkcroot(){
		if(!checks('cuser','username',50,'�û���')){
			return false;
		}
		if(!checks('cuser','password',32,'����')){
			return false;
		}
		if(!checks('cuser','password1',32,'')){
			return false;
		}
		if(!checks('cuser','realname',100,'��ʵ����')){
			return false;
		}
		if(!checks('cuser','email',50,'�����ʼ���ַ')){
			return false;
		}
		if(!checks('cuser','mobile',20,'��ϵ�绰')){
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
    �û�����-�����û�   
    </div>
    <div id="main-body">
    <p><br>��������������д�û���Ϣ�� �������������ť������һ���û�����*�ŵ�Ϊ������<br></p>
<form name="cuser" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="CreateUserFlow">
    <table align="center" class="submit-input">
    <tr><td class="ne-title">�û�����*</td><td class="ne-input">
    <input type="text"  maxlength="50" name="username" onblur="javascript:createHint('cuser','username',50,'�û���');"></td>
    <td id="username-hint" class=hint>���50��Ӣ���ַ�������¼ϵͳȫ��ʹ���û���</td></tr>
    
    <tr><td class="ne-title">���룺*</td><td class="ne-input">
    <input type="password"  maxlength="32" name="password" onblur="javascript:createHint('cuser','password',32,'����');"></td>
    <td id="password-hint" class=hint>ϵͳʹ���û����������¼�����μ�����</td></tr>
    
    <tr><td class="ne-title">�ٴ��������룺*</td><td class="ne-input">
    <input type="password"  maxlength="32" name="password1" onblur="javascript:createHintPassword('cuser','password1',32,'����');"></td>
    <td id="password1-hint" class=hint>������һ�����룬���������������һ��</td></tr>
    
    <tr><td class="ne-title">��ʵ������*</td><td class="ne-input">
    <input type="text" name="realname" maxlength="100" onblur="javascript:createHint('cuser','realname',100,'��ʵ����');"></td>
    <td id="realname-hint" class=hint>�����û�����ʵ�����������ڲ����û�����Ӧ����</td></tr>
    
    <tr><td class="ne-title">�����ʼ���ַ��*</td><td class="ne-input">
    <input type="text" name="email" onblur="javascript:createHint('cuser','email',50,'�����ʼ���ַ');" maxlength="50"></td>
    <td id="email-hint" class=hint>��Ҫ����aaa@bbb.com���ָ�ʽ</td></tr>
    
    <tr><td class="ne-title">�û����ͣ�*</td><td class="ne-input">
<select name="usertype" style="font-size:12px">
					  <option value="1" >�ڲ��û�</option>
					  <option value="2" selected>�ⲿ�û�</option>
					</select>
	</td>
	<td class="hint">����λ�û�����Ϊ�ڲ��û����Ǳ���λ�û�����Ϊ�ⲿ�û����ڲ��û��ɷ��ʵ�ϵͳһ����ⲿ�û���</td>
	</tr>
	
	<tr><td class="ne-title">��ϵ�绰��</td><td class="ne-input">
	<input type="text" name="mobile" maxlength="20" onblur="javascript:createHintLength('cuser','mobile',50,'�����ʼ���ַ');"></td>
    <td id="mobile-hint" class=hint>�ֻ�����������</td></tr>
    
	    <tr><td colspan="3" align="center">
	    <input class="button" type="submit" value="����">
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
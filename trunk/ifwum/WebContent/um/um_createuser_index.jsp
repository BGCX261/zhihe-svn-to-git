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
		errormessage = "两次输入的密码不一致，请修改。";
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
		if(!checks('cuser','username',50,'用户名')){
			return false;
		}
		if(!checks('cuser','password',32,'密码')){
			return false;
		}
		if(!checks('cuser','password1',32,'')){
			return false;
		}
		if(!checks('cuser','realname',100,'真实姓名')){
			return false;
		}
		if(!checks('cuser','email',50,'电子邮件地址')){
			return false;
		}
		if(!checks('cuser','mobile',20,'联系电话')){
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
    用户管理-创建用户   
    </div>
    <div id="main-body">
    <p><br>请在下面表格中填写用户信息后 点击“创建”按钮来创建一个用户，带*号的为必输项<br></p>
<form name="cuser" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="CreateUserFlow">
    <table align="center" class="submit-input">
    <tr><td class="ne-title">用户名：*</td><td class="ne-input">
    <input type="text"  maxlength="50" name="username" onblur="javascript:createHint('cuser','username',50,'用户名');"></td>
    <td id="username-hint" class=hint>最多50个英文字符，今后登录系统全部使用用户名</td></tr>
    
    <tr><td class="ne-title">密码：*</td><td class="ne-input">
    <input type="password"  maxlength="32" name="password" onblur="javascript:createHint('cuser','password',32,'密码');"></td>
    <td id="password-hint" class=hint>系统使用用户名和密码登录，请牢记密码</td></tr>
    
    <tr><td class="ne-title">再次输入密码：*</td><td class="ne-input">
    <input type="password"  maxlength="32" name="password1" onblur="javascript:createHintPassword('cuser','password1',32,'密码');"></td>
    <td id="password1-hint" class=hint>再输入一次密码，两次密码输入务必一致</td></tr>
    
    <tr><td class="ne-title">真实姓名：*</td><td class="ne-input">
    <input type="text" name="realname" maxlength="100" onblur="javascript:createHint('cuser','realname',100,'真实姓名');"></td>
    <td id="realname-hint" class=hint>输入用户的真实姓名，可用于查找用户名对应的人</td></tr>
    
    <tr><td class="ne-title">电子邮件地址：*</td><td class="ne-input">
    <input type="text" name="email" onblur="javascript:createHint('cuser','email',50,'电子邮件地址');" maxlength="50"></td>
    <td id="email-hint" class=hint>需要符合aaa@bbb.com这种格式</td></tr>
    
    <tr><td class="ne-title">用户类型：*</td><td class="ne-input">
<select name="usertype" style="font-size:12px">
					  <option value="1" >内部用户</option>
					  <option value="2" selected>外部用户</option>
					</select>
	</td>
	<td class="hint">本单位用户定义为内部用户，非本单位用户定义为外部用户，内部用户可访问的系统一般比外部用户多</td>
	</tr>
	
	<tr><td class="ne-title">联系电话：</td><td class="ne-input">
	<input type="text" name="mobile" maxlength="20" onblur="javascript:createHintLength('cuser','mobile',50,'电子邮件地址');"></td>
    <td id="mobile-hint" class=hint>手机，座机均可</td></tr>
    
	    <tr><td colspan="3" align="center">
	    <input class="button" type="submit" value="创建">
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
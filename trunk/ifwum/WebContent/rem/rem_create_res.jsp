<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.css.security.org.Organization"%>
<%@page import="com.css.security.SecurityManagerFactory"%>
<%@page import="com.css.security.SecurityConfiguration"%>
<%@page import="com.css.security.org.Department"%>
<%@page import="com.css.security.db.org.DefaultDepartment"%><html>
<head>
<%@ include file="../ifwum_global.jsp" %>
<style type="text/css">

</style>
<script language="javascript">
	function checkcres(){

		if(!checks('cres','resname',50,'资源名称')){
			return false;
		}
		if(!checks('cres','restitle',50,'资源标题')){
			return false;
		}
		if(!checks('cres','rescontent',256,'资源内容')){
			return false;
		}
		if(!checksLength('cres','resdesc',256,'资源描述')){
			return false;
		}
		return true;
	}
	/*
	function conServer(url){
		//alert("test");
		creatRequest();
		//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
		request.open("POST",url,true);
		request.onreadystatechange = updateHint;
		request.setRequestHeader("Content-Type",
	    "application/x-www-form-urlencoded");
		request.send('deptcode=' + escape(cres.deptcode.value) + '&ifw_flowname=Web20CheckFlow&flag=0');
	}
	function updateHint(){
		var result=false;
		if (request.readyState == 4) {
		    if (request.status == 200) {
			    result = request.responseText
			    alert(request.responseText);
		    }else{//当发生服务器错时，
		    	result = true
		    }
		    if(result){
				errormessage="校验成功";
				document.all["deptcode-hint"].className="okhint";
				replaceText(document.all["deptcode-hint"],okmessage);
			}else{
				errormessage="机构代码已被注册，请修改"
				document.all["deptcode-hint"].className="errorhint";
				replaceText(document.all["deptcode-hint"],errormessage);
				alert(1);
			}	
		}

		
		return result;
	}
	*/
</script>
</head>
<body>
<div id="page">

  


  <div id="body">
<!-- 左侧菜单 暂时不要-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <div id="main-b">
    <p><br>请输入下述信息创建一个资源<br></p>
<form name="cres" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcres());">
<input type="hidden" name="ifw_flowname" value="RemCreateResFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">资源名称：*</td><td class="ne-input">
    <input type="text" length="50" maxlength="50" name="resname" 
    onblur="javascript:createHint('cres','resname',50,'资源名称');"></td>
    <td id="resname-hint" class="hint">资源的简短名称，最多25个汉字或50个英文字母</td></tr>
    
    <tr>
    <td class="ne-title">资源标题：*</td><td class="ne-input">
    <input type="text" length="50" maxlength="50" name="restitle" onblur="javascript:createHint('cres','restitle',50,'资源标题');"></td>
    <td id="restitle-hint" class="hint">资源的简短标题，最多25个汉字或50个英文字母</td></tr>
    
     <tr>  <td class="ne-title">资源内容：*</td><td class="ne-input">
    <TEXTAREA name="rescontent" cols="20" onblur="javascript:createHint('cres','rescontent',256,'资源内容');">
</TEXTAREA>
    </td>
    <td id="rescontent-hint" class="hint">可对资源包含哪些内容进行详细说明，便于权限管理员将资源分配给适当的用户或角色，最多128个汉字或256个英文字母</td></tr>
    
        <tr>   <td class="ne-title">资源描述：</td><td class="ne-input">
    <TEXTAREA name="resdesc" cols="20" onblur="javascript:createHintLength('cres','resdesc',256,'资源描述');">
</TEXTAREA>
    </td>
    <td id="resdesc-hint" class="hint">有关资源的其他描述，选输，最多128个汉字或256个英文字母</td></tr>
    <input type="hidden" name="parentId" value="${param.parentId}">
    <input type="hidden" name="typecode" value="1">
    <input type="hidden" name="infocode" value="1">
	    <tr><td colspan="3" align="center"><input class="button" type="submit"  value="创建">
	    </td></tr>
	    
    </table>
    
	</form>
    
     </div>
       

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
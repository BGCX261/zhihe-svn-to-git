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
	function checkcroot(){
		if(errormessage=="机构代码已被注册，请修改"){
			alert(errormessage);
			croot.deptcode.focus();
			return false;
		}
		if(!checks('croot','deptcode',20,'机构代码')){
			return false;
		}
		if(!checks('croot','deptname',30,'机构名称')){
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
		request.send('deptcode=' + escape(croot.deptcode.value) + '&ifw_flowname=Web20CheckFlow&flag=0');
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
    <p><br>请输入下述信息创建子机构<br></p>
<form name="croot" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcroot());">
<input type="hidden" name="ifw_flowname" value="DmCreateDptFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">机构代码：*</td><td class="ne-input">
    <input type="text" length="20" maxlength="20" name="deptcode" 
    onblur="javascript:createHint('croot','deptcode',20,'机构代码');"></td>
    <td id="deptcode-hint" class="hint">最多10个汉字或20个英文字母</td></tr>
    <tr>
    <td class="ne-title">机构名称：*</td><td class="ne-input">
    <input type="text" length="30" maxlength="30" name="deptname" onblur="javascript:createHint('croot','deptname',30,'机构名称');"></td>
    <td id="deptname-hint" class="hint">最多15个汉字或30个英文字母</td></tr>
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
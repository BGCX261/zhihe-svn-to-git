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

		if(!checks('cres','resname',50,'��Դ����')){
			return false;
		}
		if(!checks('cres','restitle',50,'��Դ����')){
			return false;
		}
		if(!checks('cres','rescontent',256,'��Դ����')){
			return false;
		}
		if(!checksLength('cres','resdesc',256,'��Դ����')){
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
		    }else{//��������������ʱ��
		    	result = true
		    }
		    if(result){
				errormessage="У��ɹ�";
				document.all["deptcode-hint"].className="okhint";
				replaceText(document.all["deptcode-hint"],okmessage);
			}else{
				errormessage="���������ѱ�ע�ᣬ���޸�"
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
<!-- ���˵� ��ʱ��Ҫ-->
<!-- %@ include file="ifwum_left.jsp" %-->

    <div id="main-b">
    <p><br>������������Ϣ����һ����Դ<br></p>
<form name="cres" method="post" action="<%=basePath%>ifw.do" onSubmit="return(checkcres());">
<input type="hidden" name="ifw_flowname" value="RemCreateResFlow">
    <table align="center" class="submit-input">
    <tr>
    <td class="ne-title">��Դ���ƣ�*</td><td class="ne-input">
    <input type="text" length="50" maxlength="50" name="resname" 
    onblur="javascript:createHint('cres','resname',50,'��Դ����');"></td>
    <td id="resname-hint" class="hint">��Դ�ļ�����ƣ����25�����ֻ�50��Ӣ����ĸ</td></tr>
    
    <tr>
    <td class="ne-title">��Դ���⣺*</td><td class="ne-input">
    <input type="text" length="50" maxlength="50" name="restitle" onblur="javascript:createHint('cres','restitle',50,'��Դ����');"></td>
    <td id="restitle-hint" class="hint">��Դ�ļ�̱��⣬���25�����ֻ�50��Ӣ����ĸ</td></tr>
    
     <tr>  <td class="ne-title">��Դ���ݣ�*</td><td class="ne-input">
    <TEXTAREA name="rescontent" cols="20" onblur="javascript:createHint('cres','rescontent',256,'��Դ����');">
</TEXTAREA>
    </td>
    <td id="rescontent-hint" class="hint">�ɶ���Դ������Щ���ݽ�����ϸ˵��������Ȩ�޹���Ա����Դ������ʵ����û����ɫ�����128�����ֻ�256��Ӣ����ĸ</td></tr>
    
        <tr>   <td class="ne-title">��Դ������</td><td class="ne-input">
    <TEXTAREA name="resdesc" cols="20" onblur="javascript:createHintLength('cres','resdesc',256,'��Դ����');">
</TEXTAREA>
    </td>
    <td id="resdesc-hint" class="hint">�й���Դ������������ѡ�䣬���128�����ֻ�256��Ӣ����ĸ</td></tr>
    <input type="hidden" name="parentId" value="${param.parentId}">
    <input type="hidden" name="typecode" value="1">
    <input type="hidden" name="infocode" value="1">
	    <tr><td colspan="3" align="center"><input class="button" type="submit"  value="����">
	    </td></tr>
	    
    </table>
    
	</form>
    
     </div>
       

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  
  

</div>


</body>
</html>
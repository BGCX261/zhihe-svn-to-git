<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="ifwum_global.jsp" %>
</head>
<body>
<div id="page">




  <div id="header">
  	<div class="oi">

    <div id="title"><h1>IFW�û�����ϵͳ</h1><div class="float-divider"></div>

      
    </div> 
       
    <!--div id="search"><h3>Search:</h3> 
     <form method="post" action="http://www.tipjar.com/cgi-bin/test">
      <input type="text"   id="searchtext" name="searchtext" value="" size="32" />
      <input type="submit" id="find" name="find" class="button" value="Search"  />
     </form>
     <p class="message">Search message</p>
    </div-->
  <div class="float-divider"></div>
  </div></div>

  


 
  


  <div id="body">
    <!-- �������� -->
    <div id="main">
    <div id="main-title">
    ��¼����
    </div>
    <div id="main-body">
    <p align="center" class="errorp">��������${errorMsg}
    ����<a href="<%=basePath%>logon.jsp">��¼</a></p>
    
	
    </div>
    
    </div>

    <!--��ʱ����Ҫ�Ҳ� %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
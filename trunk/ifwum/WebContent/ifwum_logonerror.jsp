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

    <div id="title"><h1>IFW用户管理系统</h1><div class="float-divider"></div>

      
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
    <!-- 主交易区 -->
    <div id="main">
    <div id="main-title">
    登录错误
    </div>
    <div id="main-body">
    <p align="center" class="errorp">出错啦：${errorMsg}
    重新<a href="<%=basePath%>logon.jsp">登录</a></p>
    
	
    </div>
    
    </div>

    <!--暂时不需要右侧 %@ include file="ifwum_right.jsp" %-->

  </div>
  
  
    <%@ include file="ifwum_foot.jsp" %>

</div>


</body>
</html>
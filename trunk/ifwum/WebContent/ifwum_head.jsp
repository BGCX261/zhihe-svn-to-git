<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<SCRIPT language="javascript">
function favorate(){
	window.external.addFavorite(location.href,document.title);
	return false;
}
</SCRIPT>


  <div id="preheader">
    <p class="part1"><a href="javascript:document.location.href='<%=basePath %>ifw.do?ifw_flowname=LogoffFlow'">�˳���¼</a></p>
    <!-- p class="part2"><a href="#" onClick="javascript:favorate();">�����ղ�</a></p-->
  </div>

  <div id="header">
  	<div class="oi">

    <div id="title"><h1>IFW�û�����ϵͳ</h1><div class="float-divider"></div>
          <div class="menu">
        <h3 class="menu-head" >��������</h3> 
        <ul class="dropdown hidden">
         <li class="menu-item"><a href="#"><a href="<%=basePath %>dm/dm_dpttree_index.jsp">������ά��</a></a></li>
         <form name="dpttree" method="post" action="<%=basePath %>dm/dm_dpttree_index.jsp">
         </form>
        </ul>      
      </div>
      <div class="menu">
        <h3 class="menu-head" >��λ����</h3> 
        <ul class="dropdown hidden">
        <li class="menu-item"><a href="#"><a href="<%=basePath%>pm/pm_create_pos.jsp">������λ</a></a></li>
         <li class="menu-item"><a href="#"><a href="javascript:posm.submit();">��λ��ѯ/ά��</a></a></li>
         <form name="posm" method="post" action="<%=basePath%>ifw.do">
         	<input type="hidden" name="ifw_flowname" value="PmQueryPosListFlow">
         </form>
        </ul>      
      </div>
      <div class="menu">
        <h3 class="menu-head" >�û�����</h3> 
        <ul class="dropdown hidden">
         <li class="menu-item"><a href="<%=basePath%>um/um_createuser_index.jsp">�����û�</a></li>
         <li class="menu-item"><a href="javascript:mu.submit();">�û���ѯ/ά��</a></li>
         <form name="mu" method="post" action="<%=basePath%>ifw.do">
         	<input type="hidden" name="ifw_flowname" value="QueryUserListFlow">
         </form>
         <!-- li class="menu-item"><a href="#">menu item</a></li-->
         <!-- li class="menu-item"><a href="#">menu item</a></li-->
        </ul>      
      </div>
      <div class="menu">
        <h3 class="menu-head" >��ɫ����</h3> 
        <ul class="dropdown hidden">
         <li class="menu-item"><a href="<%=basePath%>rm/rm_create_role.jsp">�½���ɫ</a></li>
         <li class="menu-item"><a href="javascript:rolem.submit();">��ɫ��ѯ/ά��</a></li>
         <form name="rolem" method="post" action="<%=basePath%>ifw.do">
         	<input type="hidden" name="ifw_flowname" value="RmQueryRoleListFlow">
         </form>
        </ul>      
      </div>
            <div class="menu">
        <h3 class="menu-head" >��Դ����</h3> 
        <ul class="dropdown hidden">
         <li class="menu-item"><a href="<%=basePath %>rem/rem_restree_index.jsp">��Դ��ά��</a></li>
                  <form name="restree" method="post" action="<%=basePath %>rem/rem_restree_index.jsp">
         </form>
        </ul>      
      </div>
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

  


 
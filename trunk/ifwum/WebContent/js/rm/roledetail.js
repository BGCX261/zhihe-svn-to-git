function addRes(url,roleId){
		//alert("test");
		creatRequest();
		//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
		var resIds = '';
		var sel = false
		fromList = document.getElementById("restoadd");
		for (i=0;i<fromList.options.length;i++)
		  {
		    var current = fromList.options[i];
		    if (current.selected)
		    {
		    	sel = true;
		      if (current.value == 'temp')
		      {
		        alert ('您不能选择这个资源!');
		        return;
		      }
		      resIds = resIds + "," + current.value;
		    }
		  }
		if(sel){
			resIds = resIds.substring(1);
		}else{
			alert("还未选择要添加的资源");
			return;
		}
		request.open("POST",url,true);
		request.onreadystatechange = updateAddRes;
		request.setRequestHeader("Content-Type",
	    "application/x-www-form-urlencoded");
		request.send('roleId=' + escape(roleId) + '&ifw_flowname=RmManageRoleResFlow&flag=0&resIds=' + resIds);
	}
function updateAddRes(){
	var result=false;
	if (request.readyState == 4) {
	    if (request.status == 200) {
		    result = request.responseText
		    if(result){//if add successful,the result will be true;
		    	addPosHintDiv = document.getElementById("addResHint");
		    	addPosHintDiv.className = 'vissucc';
		    	replaceText(addPosHintDiv,'已经成功添加角色对所选择资源的操作权限');
		    	copyToList('restoadd','restodel')

		    }else{
			    addPosHintDiv = document.getElementById("addResHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//当发生服务器错时，
	    	alert("服务器处理发生错误！请重新查询后再进行操作。");
	    	addPosHintDiv = document.getElementById("addResHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"服务器处理发生错误！请重新查询后再进行操作。");
		    document.getElementById("addRes").disabled=true
		    document.getElementById("delRes").disabled=true
	    }

	}
}

function delRes(url,roleId){
	//alert("test");
	creatRequest();
	//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
	var resIds = '';
	var sel = false
	fromList = document.getElementById("restodel");
	for (i=0;i<fromList.options.length;i++)
	  {
	    var current = fromList.options[i];
	    if (current.selected)
	    {
	    	sel = true;
	      if (current.value == 'temp')
	      {
	        alert ('您不能选择这个资源!');
	        return;
	      }
	      resIds = resIds + "," + current.value;
	    }
	  }
	if(sel){
		resIds = resIds.substring(1);
	}else{
		alert("还未选择要除去的资源");
		return;
	}
	request.open("POST",url,true);
	request.onreadystatechange = updateDelRes;
	request.setRequestHeader("Content-Type",
    "application/x-www-form-urlencoded");
	request.send('roleId=' + escape(roleId) + '&ifw_flowname=RmManageRoleResFlow&flag=1&resIds=' + resIds);
}
function updateDelRes(){
	var result=false;
	if (request.readyState == 4) {
	    if (request.status == 200) {
		    result = request.responseText
		    if(result){//if add successful,the result will be true;
		    	addPosHintDiv = document.getElementById("addResHint");
		    	addPosHintDiv.className = 'vissucc';
		    	replaceText(addPosHintDiv,'所选资源已经成功除去');
		    	copyToList('restodel','restoadd')
		    }else{
			    addPosHintDiv = document.getElementById("addResHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//当发生服务器错时，
	    	alert("服务器处理发生错误！请重新查询后再进行操作。");
	    	addPosHintDiv = document.getElementById("addResHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"服务器处理发生错误！请重新查询后再进行操作。");
		    document.getElementById("addRes").disabled=true
		    document.getElementById("delRes").disabled=true
	    }

	}
}
function addUser(url,roleId){
	//alert("test");
	creatRequest();
	//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
	var userIds = '';
	var sel = false
	fromList = document.getElementById("usertoadd");
	for (i=0;i<fromList.options.length;i++)
	  {
	    var current = fromList.options[i];
	    if (current.selected)
	    {
	    	sel = true;
	      if (current.value == 'temp')
	      {
	        alert ('您不能选择这个用户!');
	        return;
	      }
	      userIds = userIds + "," + current.value;
	    }
	  }
	if(sel){
		userIds = userIds.substring(1);
	}else{
		alert("还未选择要添加的用户");
		return;
	}
	request.open("POST",url,true);
	request.onreadystatechange = updateAddUser;
	request.setRequestHeader("Content-Type",
    "application/x-www-form-urlencoded");
	request.send('roleId=' + escape(roleId) + '&ifw_flowname=RmManageRoleUserFlow&flag=0&userIds=' + userIds);
}
function updateAddUser(){
var result=false;
if (request.readyState == 4) {
    if (request.status == 200) {
	    result = request.responseText
	    if(result){//if add successful,the result will be true;
	    	addPosHintDiv = document.getElementById("addUserHint");
	    	addPosHintDiv.className = 'vissucc';
	    	replaceText(addPosHintDiv,'所选用户已经成功添加至本角色');
	    	copyToList('usertoadd','usertodel')

	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//当发生服务器错时，
    	alert("服务器处理发生错误！请重新查询后再进行操作。");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"服务器处理发生错误！请重新查询后再进行操作。");
	    document.getElementById("addUser").disabled=true
	    document.getElementById("delUser").disabled=true
    }

}
}

function delUser(url,roleId){
//alert("test");
creatRequest();
//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
var userIds = '';
var sel = false
fromList = document.getElementById("usertodel");
for (i=0;i<fromList.options.length;i++)
  {
    var current = fromList.options[i];
    if (current.selected)
    {
    	sel = true;
      if (current.value == 'temp')
      {
        alert ('您不能选择这个用户!');
        return;
      }
      userIds = userIds + "," + current.value;
    }
  }
if(sel){
	userIds = userIds.substring(1);
}else{
	alert("还未选择要除去的用户");
	return;
}
request.open("POST",url,true);
request.onreadystatechange = updateDelUser;
request.setRequestHeader("Content-Type",
"application/x-www-form-urlencoded");
request.send('roleId=' + escape(roleId) + '&ifw_flowname=RmManageRoleUserFlow&flag=1&userIds=' + userIds);
}
function updateDelUser(){
var result=false;
if (request.readyState == 4) {
    if (request.status == 200) {
	    result = request.responseText
	    if(result){//if add successful,the result will be true;
	    	addPosHintDiv = document.getElementById("addUserHint");
	    	addPosHintDiv.className = 'vissucc';
	    	replaceText(addPosHintDiv,'所选用户已经成功除去');
	    	copyToList('usertodel','usertoadd')
	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//当发生服务器错时，
    	alert("服务器处理发生错误！请重新查询后再进行操作。");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"服务器处理发生错误！请重新查询后再进行操作。");
	    document.getElementById("addUser").disabled=true
	    document.getElementById("delUser").disabled=true
    }

}
}

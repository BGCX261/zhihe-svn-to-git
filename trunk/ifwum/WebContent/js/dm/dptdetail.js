function addPos(url,deptCode){
		//alert("test");
		creatRequest();
		//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
		var posIds = '';
		var sel = false
		fromList = document.getElementById("postoadd");
		for (i=0;i<fromList.options.length;i++)
		  {
		    var current = fromList.options[i];
		    if (current.selected)
		    {
		    	sel = true;
		      if (current.value == 'temp')
		      {
		        alert ('您不能选择这个岗位!');
		        return;
		      }
		      posIds = posIds + "," + current.value;
		    }
		  }
		if(sel){
			posIds = posIds.substring(1);
		}else{
			alert("还未选择要添加的岗位");
			return;
		}
		request.open("POST",url,true);
		request.onreadystatechange = updateAddPos;
		request.setRequestHeader("Content-Type",
	    "application/x-www-form-urlencoded");
		request.send('deptid=' + escape(deptCode) + '&ifw_flowname=Web20CheckFlow&flag=1&posIds=' + posIds);
	}
function updateAddPos(){
	var result=false;
	if (request.readyState == 4) {
	    if (request.status == 200) {
		    result = request.responseText
		    if(result){//if add successful,the result will be true;
		    	addPosHintDiv = document.getElementById("addPosHint");
		    	addPosHintDiv.className = 'vissucc';
		    	replaceText(addPosHintDiv,'所选岗位已经成功添加至本部门');
		    	copyToList('postoadd','postodel')

		    }else{
			    addPosHintDiv = document.getElementById("addPosHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//当发生服务器错时，
	    	alert("服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
	    	addPosHintDiv = document.getElementById("addPosHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
		    document.getElementById("addPos").disabled=true
		    document.getElementById("delPos").disabled=true
	    }

	}
}

function delPos(url,deptCode){
	//alert("test");
	creatRequest();
	//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;
	var posIds = '';
	var sel = false
	fromList = document.getElementById("postodel");
	for (i=0;i<fromList.options.length;i++)
	  {
	    var current = fromList.options[i];
	    if (current.selected)
	    {
	    	sel = true;
	      if (current.value == 'temp')
	      {
	        alert ('您不能选择这个岗位!');
	        return;
	      }
	      posIds = posIds + "," + current.value;
	    }
	  }
	if(sel){
		posIds = posIds.substring(1);
	}else{
		alert("还未选择要除去的岗位");
		return;
	}
	request.open("POST",url,true);
	request.onreadystatechange = updateDelPos;
	request.setRequestHeader("Content-Type",
    "application/x-www-form-urlencoded");
	request.send('deptid=' + escape(deptCode) + '&ifw_flowname=Web20CheckFlow&flag=2&posIds=' + posIds);
}
function updateDelPos(){
	var result=false;
	if (request.readyState == 4) {
	    if (request.status == 200) {
		    result = request.responseText
		    if(result){//if add successful,the result will be true;
		    	addPosHintDiv = document.getElementById("addPosHint");
		    	addPosHintDiv.className = 'vissucc';
		    	replaceText(addPosHintDiv,'所选岗位已经成功除去');
		    	copyToList('postodel','postoadd')
		    }else{
			    addPosHintDiv = document.getElementById("addPosHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//当发生服务器错时，
	    	alert("服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
	    	addPosHintDiv = document.getElementById("addPosHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
		    document.getElementById("addPos").disabled=true
		    document.getElementById("delPos").disabled=true
	    }

	}
}
function addUser(url,deptCode){
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
	request.send('deptid=' + escape(deptCode) + '&ifw_flowname=DmManageDptUserFlow&flag=0&userIds=' + userIds);
}
function updateAddUser(){
var result=false;
if (request.readyState == 4) {
    if (request.status == 200) {
	    result = request.responseText
	    if(result){//if add successful,the result will be true;
	    	addPosHintDiv = document.getElementById("addUserHint");
	    	addPosHintDiv.className = 'vissucc';
	    	replaceText(addPosHintDiv,'所选用户已经成功添加至本部门');
	    	copyToList('usertoadd','usertodel')

	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//当发生服务器错时，
    	alert("服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
	    document.getElementById("addUser").disabled=true
	    document.getElementById("delUser").disabled=true
    }

}
}

function delUser(url,deptCode){
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
request.send('deptid=' + escape(deptCode) + '&ifw_flowname=DmManageDptUserFlow&flag=1&userIds=' + userIds);
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
    	alert("服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
	    document.getElementById("addUser").disabled=true
	    document.getElementById("delUser").disabled=true
    }

}
}

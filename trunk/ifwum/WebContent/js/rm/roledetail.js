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
		        alert ('������ѡ�������Դ!');
		        return;
		      }
		      resIds = resIds + "," + current.value;
		    }
		  }
		if(sel){
			resIds = resIds.substring(1);
		}else{
			alert("��δѡ��Ҫ��ӵ���Դ");
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
		    	replaceText(addPosHintDiv,'�Ѿ��ɹ���ӽ�ɫ����ѡ����Դ�Ĳ���Ȩ��');
		    	copyToList('restoadd','restodel')

		    }else{
			    addPosHintDiv = document.getElementById("addResHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//��������������ʱ��
	    	alert("���������������������²�ѯ���ٽ��в�����");
	    	addPosHintDiv = document.getElementById("addResHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"���������������������²�ѯ���ٽ��в�����");
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
	        alert ('������ѡ�������Դ!');
	        return;
	      }
	      resIds = resIds + "," + current.value;
	    }
	  }
	if(sel){
		resIds = resIds.substring(1);
	}else{
		alert("��δѡ��Ҫ��ȥ����Դ");
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
		    	replaceText(addPosHintDiv,'��ѡ��Դ�Ѿ��ɹ���ȥ');
		    	copyToList('restodel','restoadd')
		    }else{
			    addPosHintDiv = document.getElementById("addResHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//��������������ʱ��
	    	alert("���������������������²�ѯ���ٽ��в�����");
	    	addPosHintDiv = document.getElementById("addResHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"���������������������²�ѯ���ٽ��в�����");
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
	        alert ('������ѡ������û�!');
	        return;
	      }
	      userIds = userIds + "," + current.value;
	    }
	  }
	if(sel){
		userIds = userIds.substring(1);
	}else{
		alert("��δѡ��Ҫ��ӵ��û�");
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
	    	replaceText(addPosHintDiv,'��ѡ�û��Ѿ��ɹ����������ɫ');
	    	copyToList('usertoadd','usertodel')

	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//��������������ʱ��
    	alert("���������������������²�ѯ���ٽ��в�����");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"���������������������²�ѯ���ٽ��в�����");
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
        alert ('������ѡ������û�!');
        return;
      }
      userIds = userIds + "," + current.value;
    }
  }
if(sel){
	userIds = userIds.substring(1);
}else{
	alert("��δѡ��Ҫ��ȥ���û�");
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
	    	replaceText(addPosHintDiv,'��ѡ�û��Ѿ��ɹ���ȥ');
	    	copyToList('usertodel','usertoadd')
	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//��������������ʱ��
    	alert("���������������������²�ѯ���ٽ��в�����");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"���������������������²�ѯ���ٽ��в�����");
	    document.getElementById("addUser").disabled=true
	    document.getElementById("delUser").disabled=true
    }

}
}

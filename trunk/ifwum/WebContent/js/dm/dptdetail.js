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
		        alert ('������ѡ�������λ!');
		        return;
		      }
		      posIds = posIds + "," + current.value;
		    }
		  }
		if(sel){
			posIds = posIds.substring(1);
		}else{
			alert("��δѡ��Ҫ��ӵĸ�λ");
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
		    	replaceText(addPosHintDiv,'��ѡ��λ�Ѿ��ɹ������������');
		    	copyToList('postoadd','postodel')

		    }else{
			    addPosHintDiv = document.getElementById("addPosHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//��������������ʱ��
	    	alert("�����������������������������еĲ������Ӻ����²�����");
	    	addPosHintDiv = document.getElementById("addPosHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"�����������������������������еĲ������Ӻ����²�����");
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
	        alert ('������ѡ�������λ!');
	        return;
	      }
	      posIds = posIds + "," + current.value;
	    }
	  }
	if(sel){
		posIds = posIds.substring(1);
	}else{
		alert("��δѡ��Ҫ��ȥ�ĸ�λ");
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
		    	replaceText(addPosHintDiv,'��ѡ��λ�Ѿ��ɹ���ȥ');
		    	copyToList('postodel','postoadd')
		    }else{
			    addPosHintDiv = document.getElementById("addPosHint");
			    addPosHintDiv.className = 'visfail';
			    replaceText(addPosHintDiv,result);
			    
		    }
	    }else{//��������������ʱ��
	    	alert("�����������������������������еĲ������Ӻ����²�����");
	    	addPosHintDiv = document.getElementById("addPosHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,"�����������������������������еĲ������Ӻ����²�����");
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
	    	replaceText(addPosHintDiv,'��ѡ�û��Ѿ��ɹ������������');
	    	copyToList('usertoadd','usertodel')

	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//��������������ʱ��
    	alert("�����������������������������еĲ������Ӻ����²�����");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"�����������������������������еĲ������Ӻ����²�����");
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
	    	replaceText(addPosHintDiv,'��ѡ�û��Ѿ��ɹ���ȥ');
	    	copyToList('usertodel','usertoadd')
	    }else{
		    addPosHintDiv = document.getElementById("addUserHint");
		    addPosHintDiv.className = 'visfail';
		    replaceText(addPosHintDiv,result);
		    
	    }
    }else{//��������������ʱ��
    	alert("�����������������������������еĲ������Ӻ����²�����");
    	addPosHintDiv = document.getElementById("addUserHint");
	    addPosHintDiv.className = 'visfail';
	    replaceText(addPosHintDiv,"�����������������������������еĲ������Ӻ����²�����");
	    document.getElementById("addUser").disabled=true
	    document.getElementById("delUser").disabled=true
    }

}
}

function addUrl(url,resId){
		//alert("test");
	urlList = document.getElementById('restodel');
	rurl = addurlform.rurl.value;
	if(!(isEmpty(rurl,'��Դ��')&&checkMixtureLength(rurl,256,'��Դ��'))){
		alert(errormessage);
		document.getElementById('rurl').focus();
		return false;
	}
	if(rurl.indexOf(',') != -1){
		alert("��Դ�����ܰ����ַ�','���޸ġ�");
		document.getElementById('rurl').focus();
		return false;
	}
	for (i=0;i<urlList.options.length;i++)
	  {
	    var current = urlList.options[i];
	    if(current.value == rurl){
	    	alert("��Դ���Ѿ������ڴ���Դ����Դ���б��У����޸ĺ������ύ��");
	    	document.getElementById('rurl').focus();
	    	return false;
	    }
	  }
	
		creatRequest();
		//var url = "/ifw/Web20Servlet?ori=" + document.all["ori"].value;

		request.open("POST",url,true);
		request.onreadystatechange = updateAddUrl;
		request.setRequestHeader("Content-Type",
	    "application/x-www-form-urlencoded");
		request.send('resId=' + escape(resId) + '&ifw_flowname=RemManageUrlFlow&flag=0&rurl=' + escape(rurl));
	}
function updateAddUrl(){
	var result="true";
	if (request.readyState == 4) {
	    if (request.status == 200) {
		    result = request.responseText
		    if(result == "true"){//if add successful,the result will be true;
		    	addUrlHintDiv = document.getElementById("addUrlHint");
		    	addUrlHintDiv.className = 'vissucc';
		    	replaceText(addUrlHintDiv,'������Դ���Ѿ��ɹ����������Դ');
		    	
		    	urlList = document.getElementById('restodel');
		    	urlList.options[urlList.length] = new Option(addurlform.rurl.value,addurlform.rurl.value);

		    }else{
			    addUrlHintDiv = document.getElementById("addUrlHint");
			    addUrlHintDiv.className = 'visfail';
			    replaceText(addUrlHintDiv,result);
			    
		    }
	    }else{//��������������ʱ��
	    	alert("�������������������������Դ���еĲ������Ӻ����²�����");
	    	addUrlHintDiv = document.getElementById("addUrlHint");
		    addUrlHintDiv.className = 'visfail';
		    replaceText(addUrlHintDiv,"�������������������������Դ���еĲ������Ӻ����²�����");
		    document.getElementById("addPos").disabled=true
		    document.getElementById("delPos").disabled=true
	    }

	}
}

function delUrl(url,resId){
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
	        alert ('������ѡ�������Դ��!');
	        return;
	      }
	      resIds = resIds + "," + current.value;
	    }
	  }
	if(sel){
		resIds = resIds.substring(1);
	}else{
		alert("��δѡ��Ҫ��ȥ����Դ��");
		return;
	}
	request.open("POST",url,true);
	request.onreadystatechange = updateDelUrl;
	request.setRequestHeader("Content-Type",
    "application/x-www-form-urlencoded");
	request.send('resId=' + escape(resId) + '&ifw_flowname=RemManageUrlFlow&flag=1&urls=' + resIds);
}
function updateDelUrl(){
	var result="true";
	if (request.readyState == 4) {
	    if (request.status == 200) {
		    result = request.responseText
		    //alert(result)
		    if(result=="true"){//if add successful,the result will be true;
		    	delUrlHintDiv = document.getElementById("delUrlHint");
		    	delUrlHintDiv.className = 'vissucc';
		    	replaceText(delUrlHintDiv,'��ѡ��Դ���Ѿ��ɹ���ȥ');
		    	urlList = document.getElementById('restodel');
		    	for (i=0;i<urlList.options.length;i++){
		  	    var current = urlList.options[i];
		  	    if (current.selected)
		  	    {
		  	    	urlList.options[i] = null;
		  	    }
		  	  }
		    }else{
			    delUrlHintDiv = document.getElementById("delUrlHint");
			    delUrlHintDiv.className = 'visfail';
			    replaceText(delUrlHintDiv,result);
			    
		    }
	    }else{//��������������ʱ��
	    	alert("�����������������������������еĲ������Ӻ����²�����");
	    	delUrlHintDiv = document.getElementById("delUrlHint");
		    delUrlHintDiv.className = 'visfail';
		    replaceText(delUrlHintDiv,"�����������������������������еĲ������Ӻ����²�����");
	    }

	}
}

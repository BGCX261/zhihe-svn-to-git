function addUrl(url,resId){
		//alert("test");
	urlList = document.getElementById('restodel');
	rurl = addurlform.rurl.value;
	if(!(isEmpty(rurl,'资源键')&&checkMixtureLength(rurl,256,'资源键'))){
		alert(errormessage);
		document.getElementById('rurl').focus();
		return false;
	}
	if(rurl.indexOf(',') != -1){
		alert("资源键不能包含字符','请修改。");
		document.getElementById('rurl').focus();
		return false;
	}
	for (i=0;i<urlList.options.length;i++)
	  {
	    var current = urlList.options[i];
	    if(current.value == rurl){
	    	alert("资源键已经包含在此资源的资源键列表中，请修改后重新提交。");
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
		    	replaceText(addUrlHintDiv,'所填资源键已经成功添加至本资源');
		    	
		    	urlList = document.getElementById('restodel');
		    	urlList.options[urlList.length] = new Option(addurlform.rurl.value,addurlform.rurl.value);

		    }else{
			    addUrlHintDiv = document.getElementById("addUrlHint");
			    addUrlHintDiv.className = 'visfail';
			    replaceText(addUrlHintDiv,result);
			    
		    }
	    }else{//当发生服务器错时，
	    	alert("服务器处理发生错误！请点击左侧资源树中的部门链接后重新操作。");
	    	addUrlHintDiv = document.getElementById("addUrlHint");
		    addUrlHintDiv.className = 'visfail';
		    replaceText(addUrlHintDiv,"服务器处理发生错误！请点击左侧资源树中的部门链接后重新操作。");
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
	        alert ('您不能选择这个资源键!');
	        return;
	      }
	      resIds = resIds + "," + current.value;
	    }
	  }
	if(sel){
		resIds = resIds.substring(1);
	}else{
		alert("还未选择要除去的资源键");
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
		    	replaceText(delUrlHintDiv,'所选资源键已经成功除去');
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
	    }else{//当发生服务器错时，
	    	alert("服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
	    	delUrlHintDiv = document.getElementById("delUrlHint");
		    delUrlHintDiv.className = 'visfail';
		    replaceText(delUrlHintDiv,"服务器处理发生错误！请点击左侧机构树中的部门链接后重新操作。");
	    }

	}
}

/*
 *some common function,such as common check ,common compute.... 
 * 
 */
//这两个字段存放页面检查最后一个输入项的结果
var okmessage="校验通过";
var errormessage="校验失败";
/*
 * 检查长度和非空
 */
function checks(formname,itemname,limit,nameCN){
var itemvalue = eval(formname+"."+itemname+".value");
var item = eval(formname+"."+itemname);
	
	if(isEmpty(itemvalue,nameCN)&&checkMixtureLength(itemvalue,limit,nameCN)){
		return true;
	}else{
		alert(errormessage);
		item.focus();
		return false;
	}
}
/*
 * 只检查长度
 */
function checksLength(formname,itemname,limit,nameCN){
	var itemvalue = eval(formname+"."+itemname+".value");
	var item = eval(formname+"."+itemname);
		
		if(checkMixtureLength(itemvalue,limit,nameCN)){
			return true;
		}else{
			alert(errormessage);
			item.focus();
			return false;
		}
	}
function createHint(formname,itemname,limit,nameCN){
	var itemvalue = eval(formname+"."+itemname+".value");
	
	if(isEmpty(itemvalue,nameCN)&&checkMixtureLength(itemvalue,limit,nameCN)){
		document.all[itemname + "-hint"].className="okhint";
		replaceText(document.all[itemname + "-hint"],okmessage);
	}else{
		document.all[itemname + "-hint"].className="errorhint";
		replaceText(document.all[itemname + "-hint"],errormessage);
	}
}
function createHintLength(formname,itemname,limit,nameCN){
	var itemvalue = eval(formname+"."+itemname+".value");
	
	if(checkMixtureLength(itemvalue,limit,nameCN)){
		document.all[itemname + "-hint"].className="okhint";
		replaceText(document.all[itemname + "-hint"],okmessage);
	}else{
		document.all[itemname + "-hint"].className="errorhint";
		replaceText(document.all[itemname + "-hint"],errormessage);
	}
}
/*
	功能：检查串的字节长度；
	输入：字符串
	输出：正确true；不正确false；
*/
function checkMixtureLength(inStr,lgLimit,nameCN)
{
    var lg=getMixtureLength(inStr); 
	var lgLimitC =  lgLimit/2;
	if (lg > lgLimit) {
		errormessage = nameCN + "不能超过"+ lgLimit +"个字符或" + lgLimitC + "个汉字！";
		/*if (language == "ZH_CN") 
			alert(alertNameC +"不能超过"+ lgLimit +"个字符或" + lgLimitC + "个汉字！");
		else if (language == "EN_US")
			alert("You have input " + alertNameE + "over " + lgLimit + " English words or " + lgLimitC + " Chinese words! ");
		*/
		return false;
	}
	return true;
}
/*
 * 获得一个输入项的字节长度
 */
function getMixtureLength(inStr)
{
   var escapeValue=escape(inStr);
   var iLength=0;
   var iFinded=0;


   //计算汉字 
   do{
      iFinded=escapeValue.indexOf("%u");
      if(iFinded != -1){
        escapeValue = escapeValue.substring(0,iFinded)+escapeValue.substr(iFinded+6);
        iLength +=2;
      }
   }while(iFinded != -1);

   //计算特殊字符
   do{
      iFinded=escapeValue.indexOf("%");
      if(iFinded != -1){
        escapeValue = escapeValue.substring(0,iFinded)+escapeValue.substr(iFinded+3);
        //alert(escapeValue);
        iLength++;
      }
   }while(iFinded != -1);

   iLength = iLength+escapeValue.length;
   return iLength;
}

/*
功能：去掉字符串开始和结尾的空格；
输入：String对象；
输出：开始和结尾不含空格的字符串；
*/
function trim(inStr){

 return inStr.replace(/(^\s*)|(\s*$)/g, "");
}

/*  
功能：检查字符串是否为NULL或空或去掉空格后为空,为空给出错误信息

*/

function isEmpty(inStr,nameCN){
if(inStr == null || inStr == "" || trim(inStr)==""){
	errormessage=nameCN + "不能为空";
	return false;
}
else{
	return true;
}
}
/*
 * ajax与服务器通讯相关类
 */
var request = null;
function creatRequest(){
	try{
		request = new XMLHttpRequest();
	}catch(trymicrosoft){
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(othermicrosoft){
			try{
			request = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(failed){
				request = null;
			}
		}
	}
	if(request == null)
		alert("error creating xml request!");
}
function copyToList(from,to) //from表示:包含可选择项目的select对象名字 to表示:列出可选择项目的select对象名字 //你可以根据你的具体情况修改
{
  fromList = document.getElementById(from);
  toList = document.getElementById(to);
  if (toList.options.length > 0 && toList.options[0].value == 'temp')
  {
    toList.options.length = 0;
  }
  var sel = false;
  for (i=0;i<fromList.options.length;i++)
  {
    var current = fromList.options[i];
    if (current.selected)
    {
      sel = true;
      if (current.value == 'temp')
      {
        alert ('你不能选择这个项目!');
        return;
      }
      txt = current.text;
      val = current.value;
      toList.options[toList.length] = new Option(txt,val);
      fromList.options[i] = null;
      i--;
    }
  }
  if (!sel) alert ('你还没有选择任何项目');
}
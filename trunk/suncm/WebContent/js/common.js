var errormessage;
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

function isEmpty(inStr){
if(inStr == null || inStr == "" || trim(inStr)==""){
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
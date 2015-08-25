<!--建议：该Script方法应该使用变量或者set方法设置各个图像文件的相对位置--> 
<!--注：该代码段未使用boolean作为判断量，0为假非0为真-->
function Folder(parentnode,num,folderDescription, hreference,itemLevel)
{//构建文件夹的对象，参数folderDescription为超链接的标题，hreference为链接地址
  this.level = itemLevel
  this.type = 0
  this.num = num//栏目编码
  this.parentnode = parentnode
  this.desc = folderDescription
  this.hreference = hreference 
  this.id = -1   
  this.navObj = 0  
  this.iconImg = 0  
  this.nodeImg = 0  
  this.isLastNode = 0 
 
  this.isOpen = true 
  this.iconSrc = basePath+"image/menu/dot1.gif"   
  this.focusimg = basePath+"image/menu/arrow.gif"
  this.children = new Array 
  this.nChildren = 0 
 
  this.initialize = initializeFolder 
  this.setState = setStateFolder 
  this.addChild = addChild 
  this.createIndex = createEntryIndex 
  this.hide = hideFolder 
  this.display = display 
  this.renderOb = drawFolder 
  this.totalHeight = totalHeight 
  this.subEntries = folderSubEntries 
  this.outputLink = outputFolderLink 
} 
 
function setStateFolder(isOpen) 
{//控制文件夹的打开或者关闭状态isOpen=true为打开的，反之为关闭
  var subEntries 
  var totalHeight 
  var fIt = 0 
  var i=0 
 
  if (isOpen == this.isOpen)//若现在的文件夹状态和想要变成的状态一致，不做任何操作 
    return 
 
  if (browserVersion == 2)  
  {//若浏览器为网景浏览器
    totalHeight = 0
    for (i=0; i < this.nChildren; i++) 
      totalHeight = totalHeight + this.children[i].navObj.clip.height 
      subEntries = this.subEntries() 
    if (this.isOpen) 
      totalHeight = 0 - totalHeight 
    for (fIt = this.id + subEntries + 1; fIt < nEntries; fIt++) 
      indexOfEntries[fIt].navObj.moveBy(0, totalHeight) 
  }  
  this.isOpen = isOpen 
  propagateChangesInState(this) 
} 
 
function propagateChangesInState(folder) 
{//文件夹属性改变后，此操作执行刷新、改变文件夹的新特性
  var i=0 
 
  if (folder.isOpen) 
  {//若文件夹是打开的 
    if (folder.nodeImg)
      if (folder.isLastNode)//该选项是最后一个选项 
        folder.nodeImg.src = basePath+"image/menu/ftv2mlastnode.gif" 
      else//该选项不是最后一个选项
	  folder.nodeImg.src = basePath+"image/menu/ftv2mnode.gif" 
    folder.iconImg.src = basePath+"image/menu/dot1.gif" 
    for (i=0; i<folder.nChildren; i++) 
      folder.children[i].display() 
  } 
  else 
  {//若文件夹是关闭的
    if (folder.nodeImg) 
      if (folder.isLastNode) 
        folder.nodeImg.src = basePath+"image/menu/ftv2plastnode.gif" 
      else 
	  folder.nodeImg.src = basePath+"image/menu/ftv2pnode.gif" 
    folder.iconImg.src = basePath+"image/menu/dot1.gif" 
    for (i=0; i<folder.nChildren; i++) 
      folder.children[i].hide() 
  }  
} 
 
function hideFolder() 
{//关闭文件夹 
  if (browserVersion == 1) {//若浏览器为IE 
    if (this.navObj.style.display == "none") 
      return 
    this.navObj.style.display = "none" 
  } else {//若浏览器不是IE
    if (this.navObj.visibility == "hiden") 
      return 
    this.navObj.visibility = "hiden" 
  } 
   
  this.setState(0) 
} 
function initializeFolder(level, lastNode, leftSide, displayflag) 
{//初始化文件夹，level为文件夹所处等级，lastNode是否为最后节点文件夹，leftSide 
var j=0 
var i=0 
var numberOfFolders 
var numberOfDocs 
var nc 
      
  nc = this.nChildren 
   
  this.createIndex() 
 
  var auxEv = "" 
 
  if (browserVersion > 0) 
    auxEv = "<a href='javascript:clickOnNode("+this.id+")'>" 
  else 
    auxEv = "<a>" 
 
  if (level>0) 
    if (lastNode)
    {//若该文件夹为文件夹树的最后一个 
      this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='"+basePath+"image/menu/ftv2mlastnode.gif' width=16 height=22 border=0>") 
      leftSide = leftSide + "<img src='"+basePath+"image/menu/ftv2blank.gif' width=16 height=22>"  
      this.isLastNode = 1 
    } 
    else 
    {//若不是最后一个
      this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='"+basePath+"image/menu/ftv2mnode.gif' width=16 height=22 border=0>") 
      leftSide = leftSide + "<img src='"+basePath+"image/menu/ftv2vertline.gif' width=16 height=22>" 
      this.isLastNode = 0 
    } 
  else 
    this.renderOb("") 
  if(displayflag){
  
  if (nc > 0) 
  { 
    level = level + 1//节点所处的等级加1
    for (i=0 ; i < this.nChildren; i++)  
    { 
      if (i == this.nChildren-1)//子节点的最后一个 
        this.children[i].initialize(level, 1, leftSide, '1') 
      else 
        this.children[i].initialize(level, 0, leftSide, '1') 
    } 
   } 
  }
} 
 
function drawFolder(leftSide) 
{//构建格式化网页
  if (browserVersion == 2) { 
    if (!document.yPos) 
      document.yPos=8 
    document.write("<layer id='folder" + this.id + "' top=" + document.yPos + " visibility=hiden>") 
  } 
  document.write("<div id='folder" + this.id + "' style='position:block;'>")
  document.write(leftSide)
  document.write("<img name='folderIcon" + this.id + "' ") 
  document.write("src='" + this.iconSrc+"' border=0>")
    
    this.outputLink() 
    document.write(this.desc + "</a>") 
  
	document.write("<img style='display:none' id='focusIcon"+this.id+"' ") 
  document.write("src='"+this.focusimg+"'  border=0></div>") 
      
  /*document.write("<table ") 
  if (browserVersion == 1) 
    document.write(" id='folder" + this.id + "' style='position:block;' ") 
  document.write(" border=1 cellspacing=0 cellpadding=0>") 
  document.write("<tr><td>") 
  document.write(leftSide)
  //if(this.hreference.substring(0,1) != '#')
  //this.outputLink() 
  document.write("<img name='folderIcon" + this.id + "' ") 
  document.write("src='" + this.iconSrc+"' border=1></a>") 
  document.write("</td><td valign=middle nowrap>") 
  if (this.hreference.substring(0,1) != '#') 
  { 
    this.outputLink() 
    document.write(this.desc + "</a>") 
  } 
  else 
    document.write(this.desc) 
  document.write("</td>")  
   document.write("<td>")
  document.write("<img style='display:none' id='focusIcon"+this.id+"' ") 
  document.write("src='"+this.focusimg+"'  border=0>") 
  document.write("</td>")
  document.write("</table>") 
   */
  if (browserVersion == 2) { 
    document.write("</layer>") 
  }  
  if (browserVersion == 1) { 
    this.navObj = document.all["folder"+this.id] 
    this.iconImg = document.all["folderIcon"+this.id] 
     this.focusImg = document.all["focusIcon"+this.id] 
    this.nodeImg = document.all["nodeIcon"+this.id] 
  } else if (browserVersion == 2) { 
    this.navObj = document.layers["folder"+this.id] 
    this.iconImg = this.navObj.document.images["folderIcon"+this.id] 
    this.nodeImg = this.navObj.document.images["nodeIcon"+this.id] 
    document.yPos=document.yPos+this.navObj.clip.height 
  } 
} 
 
function outputFolderLink() 
{//实现对文档元素的超链接，形如:
 //<a href='url' TARGET="xbody" onClick='javascript:clickOnFolder(this.id)'>
  if (this.hreference) 
  { 
    document.write("<a name='lnm"+this.num+"' id='link" + this.id + "' href='"+this.hreference + "'") 
    //if (browserVersion > 0) 
      //    document.write(" onClick='javascript:clickOnLink("+this.id+")'") 
    document.write(">") 
  } 
  else 
    document.write("<a>") 
} 
 
function addChild(childNode) 
{//给文件夹树添加一个子节点元素；childNode可以是文件夹也可以是文件 
  this.children[this.nChildren] = childNode 
  this.nChildren++ 
  return childNode 
} 
 
function folderSubEntries() 
{//统计整个树中有多少个节点
  var i = 0 
  var se = this.nChildren 
 
  for (i=0; i < this.nChildren; i++){ 
    if (this.children[i].children) //if is a folder 
      se = se + this.children[i].subEntries() 
  } 
 
  return se 
} 
 
 
 
function Item(parentnode,num,itemDescription, itemLink,itemLevel)
{//初始化元素项目
  this.level = itemLevel
  this.type = 1; 
  this.num = num//栏目编码
  this.parentnode = parentnode
  this.desc = itemDescription 
  this.link = itemLink 
  this.id = -1
  this.navObj = 0
  this.iconImg = 0
  this.focusImg = 0
  this.iconSrc = basePath+"image/menu/dot1.gif" 
  this.focusimg = basePath+"image/menu/arrow.gif"
 
  this.initialize = initializeItem 
  this.createIndex = createEntryIndex 
  this.hide = hideItem 
  this.display = display 
  this.renderOb = drawItem 
  this.totalHeight = totalHeight 
} 
 
function hideItem() 
{//关闭文件夹中的项目 
  if (browserVersion == 1) { 
    if (this.navObj.style.display == "none") 
      return 
    this.navObj.style.display = "none" 
  } else { 
    if (this.navObj.visibility == "hiden") 
      return 
    this.navObj.visibility = "hiden" 
  }     
} 
 
function initializeItem(level, lastNode, leftSide) 
{//初始化元素项目  
  this.createIndex() 
 
  if (level>0) 
    if (lastNode)
    { 
      this.renderOb(leftSide + "<img src='"+basePath+"image/menu/ftv2lastnode.gif' width=16 height=22>") 
      leftSide = leftSide + "<img src='"+basePath+"image/menu/ftv2blank.gif' width=16 height=22>"  
    } 
    else 
    { 
      this.renderOb(leftSide + "<img src='"+basePath+"image/menu/ftv2node.gif' width=16 height=22>") 
      leftSide = leftSide + "<img src='"+basePath+"image/menu/ftv2vertline.gif' width=16 height=22>" 
    } 
  else 
    this.renderOb("")   
} 
function findMenuItemchain(menuitem){
	var menuchain = "";
	while(menuitem.num != 0){
		menuchain = menuchain + "|" + menuitem.num 
		menuitem = menuitem.parentnode;
	}
	return menuchain;
}
function drawItem(leftSide) 
{//动态化构建网页元素存在的表格空间。 
  if (browserVersion == 2) 
    document.write("<layer id='item" + this.id + "' top=" + document.yPos + " visibility=hiden>")
    
      document.write("<div id='item" + this.id + "'>")
      //alert(leftSide)
  document.write(leftSide)
  document.write("<img name='itemIcon" + this.id + "' ") 
  document.write("src='" + this.iconSrc+"' border=0>")
  if (USETEXTLINKS){
	  	
	  	
	    document.write("<a name='lnm" + this.num +"' id='link" + this.id + "' href=" +this.link)
	    document.write(">" + this.desc + "</a>") 
	     
	    }
	  else 
	    document.write(this.desc) 
	document.write("<img style='display:none' id='focusIcon"+this.id+"' ") 
  document.write("src='"+this.focusimg+"'  border=0></div>")  
    
    
    
  /*document.write("<table ") 
  if (browserVersion == 1) 
    document.write(" id='item" + this.id + "' style='position:block;' ") 
  document.write(" border=0 cellspacing=0 cellpadding=0>") 
  document.write("<tr><td>") 
  document.write(leftSide) 
  //document.write("<a href=" + this.link + ">") 
  document.write("<img id='itemIcon"+this.id+"' ") 
  document.write("src='"+this.iconSrc+"' border=0>") 
  //document.write("</a>") 
  document.write("</td><td valign=middle nowrap>") 
  if (USETEXTLINKS){
  	var menuitemchain = findMenuItemchain(this);
  	if(this.link.substring(0,1) != '!')
    document.write("<a id='link'" + this.id + " href=" + basePath + this.link + "?" + sessstr + "&menuitemchain=" + menuitemchain + " target=mainFrame")
    else
    document.write("<a id='link'" + this.id + " href=" + basePath + "newcorporbank/MenuFormForward.jsp?" + "menuitemchain=" + menuitemchain + "&formID=" + this.link.substring(1) + "&" + sessstr + " target=mainFrame")
    document.write(" onClick='javascript:clickOnLink("+this.id+")'") 
    document.write(">" + this.desc + "</a>") 
    }
  else 
    document.write(this.desc) 
  document.write("</td>")
  document.write("<td>")
  document.write("<img style='display:none' id='focusIcon"+this.id+"' ") 
  document.write("src='"+this.focusimg+"'  border=0>") 
  document.write("</td>")
  document.write("</table>") 
   
  if (browserVersion == 2) 
    document.write("</layer>") 
 */
  if (browserVersion == 1) { 
    this.navObj = document.all["item"+this.id] 
    this.iconImg = document.all["itemIcon"+this.id] 
    this.focusImg = document.all["focusIcon"+this.id] 
    this.linkObj = document.all["link"+this.id] 
  } else if (browserVersion == 2) { 
    this.navObj = document.layers["item"+this.id] 
    this.iconImg = this.navObj.document.images["itemIcon"+this.id] 
    document.yPos=document.yPos+this.navObj.clip.height 
  } 
} 
 
 
function display() 
{//与关闭文件夹项目对应，显示文件夹项目
  if (browserVersion == 1) 
    this.navObj.style.display = "block" 
  else 
    this.navObj.visibility = "show" 
} 
 
function createEntryIndex() 
{ 
  this.id = nEntries 
  indexOfEntries[nEntries] = this 
  nEntries++ 
} 
 
function totalHeight()
{//统计总体高度
  var h = this.navObj.clip.height 
  var i = 0 
   
  if (this.isOpen)
    for (i=0 ; i < this.nChildren; i++)  
      h = h + this.children[i].totalHeight() 
 
  return h 
} 
 
 
function clickOnFolder(folderId) 
{ 
  var clicked = indexOfEntries[folderId] 
 
  if (!clicked.isOpen) {
    clickOnNode(folderId) 
    return 
  } 
  if (clicked.isSelected) 
    return
  return
} 
 
function clickOnNode(folderId) 
{ //点击文件夹前面的小加号
  var clickedFolder = 0 
  var state = 0 
 
  clickedFolder = indexOfEntries[folderId] 
/*
  if(clickedFolder_old.id)
  if(clickedFolder_old.id != clickedFolder.id){
  if (clickedFolder_old.isOpen)
  clickOnNode(clickedFolder_old.id) 
  }*/
  /*该段代码主要实现，
  当一个文件夹打开的时候，
  打开另一个文件夹，
  原来那个打开的自动关闭。
  由于该功能会导致使用多重文件夹的时候出现图像bug
  故废除掉，有用的时候可以再度启用*/
  
  clickedFolder_old = clickedFolder
  
  state = clickedFolder.isOpen 
 
  clickedFolder.setState(!state)
} 
function clickOnNodeON(folderId) 
{ //点击文件夹前面的小加号
  var clickedFolder = 0 
  var state = 0 
  var index
 	for(var i = 0;i<indexOfEntries.length;i++){
		if(indexOfEntries[i].num == folderId){
		index = i
		break}
	}
  clickedFolder = indexOfEntries[index] 
/*
  if(clickedFolder_old.id)
  if(clickedFolder_old.id != clickedFolder.id){
  if (clickedFolder_old.isOpen)
  clickOnNode(clickedFolder_old.id) 
  }*/
  /*该段代码主要实现，
  当一个文件夹打开的时候，
  打开另一个文件夹，
  原来那个打开的自动关闭。
  由于该功能会导致使用多重文件夹的时候出现图像bug
  故废除掉，有用的时候可以再度启用*/
  
  clickedFolder_old = clickedFolder
  
  state = clickedFolder.isOpen 
 
  clickedFolder.setState(!state)
} 
function clickOnLink(folderId) 
{
	//alert("asdfasdf");
	focus.focusImg.style.display = "none"
	focus =  indexOfEntries[folderId]
	focus.focusImg.style.display = "block"
}


function clickOnLinkON(folderId) 
{
	var index
	for(var i = 0;i<indexOfEntries.length;i++){
		if(indexOfEntries[i].num == folderId){
		index = i
		break}
	}
	//alert("asdfasdf");
	focus.focusImg.style.display = "none"
	focus =  indexOfEntries[index]
	focus.focusImg.style.display = "block"
}
function initializeDocument(rootid,displayflag) 
{ 
nEntries = 0;
indexOfEntries.length = 0
	var index;
	var root1;
  if (document.all) 
    browserVersion = 1 //IE4
  else 
    if (document.layers) 
      browserVersion = 2 //NS4 
    else 
      browserVersion = 0 //other 
      
  fT.initialize(0, 1, "",displayflag); 
  if(displayflag){
	  fT.display()
	  }
  for(var i = 0;i < indexOfEntries.length;i++){
  	if(!indexOfEntries[i].isOpen){
  		indexOfEntries[i].isOpen = !indexOfEntries[i].isOpen;
  	}
  }
  if (browserVersion > 0 && displayflag) 
  { 
    document.write("<layer top="+indexOfEntries[nEntries-1].navObj.top+">&nbsp;</layer>") 
	
  } 
}
function submitFindFocus(rootsub,chain){
	var rootsub1 = rootsub;
	var index
	while(chain.length != 0){
		var focusitem = chain.substring(chain.lastIndexOf("|")+1)
		if(!rootsub1.type){
	 	for(var i = 0; i < rootsub1.children.length;i++){
  		if(rootsub1.children[i].num == new String(focusitem)){
  			clickOnNode(rootsub1.id);
  			index = i;
		 	}
  		}
 		}
 		rootsub1 = rootsub1.children[index];
 		chain = chain.substring(0,chain.lastIndexOf("|"))
	}
	return rootsub1;
} 
function findFocus(root){
	if(!root.type){
    	for(var i = 0;i < root.nChildren;i++){
    		if(root.children[i].num == root.hreference.substring(1)){
    			clickOnNode(root.id);
    			focus = root.children[i];
    			findFocus(focus);
    		}
    	}
    }
}
function findItemFocus(root,focus){
	var serchroot = root
	if(!root.type){
    	for(var i = 0;i < root.nChildren;i++){
    		if(root.children[i].num == focus){
    			Itemfocus = root.children[i];
    			break;}
    			serchroot = root.children[i];
    			findItemFocus(serchroot,focus);
    		
    	}
    }
}
 
function gFld(parentnode,num,description, hreference,itemLevel) 
{//生成一个文件夹
  folder = new Folder(parentnode,num,description, hreference,itemLevel) 
  return folder 
} 
 
function gLnk(parentnode,num, description, linkData,itemLevel) 
{//生成一个链接，也是节点
 
  linkItem = new Item(parentnode,num,description, linkData,itemLevel) 
    
  
  return linkItem 
} 
 
function insFld(parentFolder, childFolder) 
{//插入一个文件夹
	
  return parentFolder.addChild(childFolder) 
} 
 
function insDoc(parentFolder, document) 
{//插入一个节点 
  parentFolder.addChild(document) 
} 

function outMenu(module,url) 
{ 
  insDoc(aux1, gLnk(0,module,url))
} 
USEFOLDLINKS = 0 ; 
USETEXTLINKS = 1 ;
indexOfEntries = new Array; 
clickedFolder_old = 0;
nEntries = 0 ;
//document = document; 
browserVersion = 0; 
selectedFolder=0;
root = 0;
var focus
var Itemfocus = 0;
var MiniFlag = 0;
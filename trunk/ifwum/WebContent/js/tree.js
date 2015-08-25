<!--���飺��Script����Ӧ��ʹ�ñ�������set�������ø���ͼ���ļ������λ��--> 
<!--ע���ô����δʹ��boolean��Ϊ�ж�����0Ϊ�ٷ�0Ϊ��-->
function Folder(parentnode,num,folderDescription, hreference,itemLevel)
{//�����ļ��еĶ��󣬲���folderDescriptionΪ�����ӵı��⣬hreferenceΪ���ӵ�ַ
  this.level = itemLevel
  this.type = 0
  this.num = num//��Ŀ����
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
{//�����ļ��еĴ򿪻��߹ر�״̬isOpen=trueΪ�򿪵ģ���֮Ϊ�ر�
  var subEntries 
  var totalHeight 
  var fIt = 0 
  var i=0 
 
  if (isOpen == this.isOpen)//�����ڵ��ļ���״̬����Ҫ��ɵ�״̬һ�£������κβ��� 
    return 
 
  if (browserVersion == 2)  
  {//�������Ϊ���������
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
{//�ļ������Ըı�󣬴˲���ִ��ˢ�¡��ı��ļ��е�������
  var i=0 
 
  if (folder.isOpen) 
  {//���ļ����Ǵ򿪵� 
    if (folder.nodeImg)
      if (folder.isLastNode)//��ѡ�������һ��ѡ�� 
        folder.nodeImg.src = basePath+"image/menu/ftv2mlastnode.gif" 
      else//��ѡ������һ��ѡ��
	  folder.nodeImg.src = basePath+"image/menu/ftv2mnode.gif" 
    folder.iconImg.src = basePath+"image/menu/dot1.gif" 
    for (i=0; i<folder.nChildren; i++) 
      folder.children[i].display() 
  } 
  else 
  {//���ļ����ǹرյ�
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
{//�ر��ļ��� 
  if (browserVersion == 1) {//�������ΪIE 
    if (this.navObj.style.display == "none") 
      return 
    this.navObj.style.display = "none" 
  } else {//�����������IE
    if (this.navObj.visibility == "hiden") 
      return 
    this.navObj.visibility = "hiden" 
  } 
   
  this.setState(0) 
} 
function initializeFolder(level, lastNode, leftSide, displayflag) 
{//��ʼ���ļ��У�levelΪ�ļ��������ȼ���lastNode�Ƿ�Ϊ���ڵ��ļ��У�leftSide 
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
    {//�����ļ���Ϊ�ļ����������һ�� 
      this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='"+basePath+"image/menu/ftv2mlastnode.gif' width=16 height=22 border=0>") 
      leftSide = leftSide + "<img src='"+basePath+"image/menu/ftv2blank.gif' width=16 height=22>"  
      this.isLastNode = 1 
    } 
    else 
    {//���������һ��
      this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='"+basePath+"image/menu/ftv2mnode.gif' width=16 height=22 border=0>") 
      leftSide = leftSide + "<img src='"+basePath+"image/menu/ftv2vertline.gif' width=16 height=22>" 
      this.isLastNode = 0 
    } 
  else 
    this.renderOb("") 
  if(displayflag){
  
  if (nc > 0) 
  { 
    level = level + 1//�ڵ������ĵȼ���1
    for (i=0 ; i < this.nChildren; i++)  
    { 
      if (i == this.nChildren-1)//�ӽڵ�����һ�� 
        this.children[i].initialize(level, 1, leftSide, '1') 
      else 
        this.children[i].initialize(level, 0, leftSide, '1') 
    } 
   } 
  }
} 
 
function drawFolder(leftSide) 
{//������ʽ����ҳ
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
{//ʵ�ֶ��ĵ�Ԫ�صĳ����ӣ�����:
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
{//���ļ��������һ���ӽڵ�Ԫ�أ�childNode�������ļ���Ҳ�������ļ� 
  this.children[this.nChildren] = childNode 
  this.nChildren++ 
  return childNode 
} 
 
function folderSubEntries() 
{//ͳ�����������ж��ٸ��ڵ�
  var i = 0 
  var se = this.nChildren 
 
  for (i=0; i < this.nChildren; i++){ 
    if (this.children[i].children) //if is a folder 
      se = se + this.children[i].subEntries() 
  } 
 
  return se 
} 
 
 
 
function Item(parentnode,num,itemDescription, itemLink,itemLevel)
{//��ʼ��Ԫ����Ŀ
  this.level = itemLevel
  this.type = 1; 
  this.num = num//��Ŀ����
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
{//�ر��ļ����е���Ŀ 
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
{//��ʼ��Ԫ����Ŀ  
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
{//��̬��������ҳԪ�ش��ڵı��ռ䡣 
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
{//��ر��ļ�����Ŀ��Ӧ����ʾ�ļ�����Ŀ
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
{//ͳ������߶�
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
{ //����ļ���ǰ���С�Ӻ�
  var clickedFolder = 0 
  var state = 0 
 
  clickedFolder = indexOfEntries[folderId] 
/*
  if(clickedFolder_old.id)
  if(clickedFolder_old.id != clickedFolder.id){
  if (clickedFolder_old.isOpen)
  clickOnNode(clickedFolder_old.id) 
  }*/
  /*�öδ�����Ҫʵ�֣�
  ��һ���ļ��д򿪵�ʱ��
  ����һ���ļ��У�
  ԭ���Ǹ��򿪵��Զ��رա�
  ���ڸù��ܻᵼ��ʹ�ö����ļ��е�ʱ�����ͼ��bug
  �ʷϳ��������õ�ʱ������ٶ�����*/
  
  clickedFolder_old = clickedFolder
  
  state = clickedFolder.isOpen 
 
  clickedFolder.setState(!state)
} 
function clickOnNodeON(folderId) 
{ //����ļ���ǰ���С�Ӻ�
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
  /*�öδ�����Ҫʵ�֣�
  ��һ���ļ��д򿪵�ʱ��
  ����һ���ļ��У�
  ԭ���Ǹ��򿪵��Զ��رա�
  ���ڸù��ܻᵼ��ʹ�ö����ļ��е�ʱ�����ͼ��bug
  �ʷϳ��������õ�ʱ������ٶ�����*/
  
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
{//����һ���ļ���
  folder = new Folder(parentnode,num,description, hreference,itemLevel) 
  return folder 
} 
 
function gLnk(parentnode,num, description, linkData,itemLevel) 
{//����һ�����ӣ�Ҳ�ǽڵ�
 
  linkItem = new Item(parentnode,num,description, linkData,itemLevel) 
    
  
  return linkItem 
} 
 
function insFld(parentFolder, childFolder) 
{//����һ���ļ���
	
  return parentFolder.addChild(childFolder) 
} 
 
function insDoc(parentFolder, document) 
{//����һ���ڵ� 
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
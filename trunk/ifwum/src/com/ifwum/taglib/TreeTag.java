package com.ifwum.taglib;

import java.io.IOException;
import java.util.Hashtable;
import java.net.URLEncoder;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.css.framework.model.TreeModel;
import com.css.framework.model.TreeNode;
import com.css.framework.model.TreeXProvider;

/**
 * @author 解志超
 * 
 * 在这个tag内部生成树js对象
 */
public class TreeTag extends TagSupport {
	/**
	 * 由于变量名不能以数字开头，在每个节点的id前面固定增加一个常量串
	 */
	private static final String NODENAME = "nd";
	/**
	 * tag生成的所有节点id以此字段排序作为区分
	 */
	private int id = 1;
	/**
	 * 获得树根节点的类
	 */
	protected String provider = "";
	/**
	 * 每个链接的目的地址
	 */
	protected String linkUrl = "";
	/**
	 * 根节点需要显示的文字，不配置就使用默认值
	 */
	protected String rootText = "树形结构";
	
	public String getRootText() {
		return rootText;
	}

	public void setRootText(String rootText) {
		this.rootText = rootText;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	JspWriter out = null;
	
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * default constructor
	 */
	public TreeTag() {
		super();
	}

	public int doStartTag() {
		out = pageContext.getOut();
		
		try {

	      TreeXProvider _provider = null;
	      Class providerClass = null;
	                try{
	                    providerClass = Class.forName((String) provider);
	                    _provider = (TreeXProvider) providerClass.newInstance();
	                } catch(Exception cnfe){
	                    throw new RuntimeException("tree 数据源错误");
	                }
	      Hashtable key = new Hashtable();
	      
	      Object obj = _provider.fetchTreeSource(key) ;
	      TreeNode root = null;
	      if(obj instanceof TreeModel){
	    	  root = (TreeNode)((TreeModel)obj).getRoot();
	      }else if(obj instanceof TreeNode){
	    	  root = (TreeNode)obj ;
	      }
			if(root == null){
			    return EVAL_PAGE;
			}
			out.print("\n<script language=\"javascript\">");
			out.print("\nvar basePath ='"); 
			out.print(pageContext.getAttribute("basePath"));
			out.print("'\nvar fT = gFld('0','0','" + rootText + "','"+ linkUrl +"');");
			out.print("\n</script>");
			out.print("\n<script language=\"javascript\">\n");				
				for(int i = 0;i < root.getChildCount();i++){
					
				    VisitSubTree(root.getChildAt(i),"fT");			    
				    			    
				}	
				out.print("\ninitializeDocument('0', '1');");		
			    out.print("\n</script>");					
		

			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				out.print("<p>代码生成错误:" + e.getMessage() + "</p>");
			} catch (IOException ex) {

			}
			return EVAL_PAGE;
		}
	}
	/**
	 * 在这个函数中生成submitForm()函数
	 */
	public int doEndTag() {
		try {
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	private void VisitSubTree(TreeNode treeRoot,String parentnodename) throws Exception{
	    int children = treeRoot.getChildCount();
	    String nodeId = treeRoot.getChildId().toString();
	    String mynode = null;
	    TreeNode temp = null;
	    String nodeName = (String)treeRoot.getChildName();
	    if (nodeName == null) {
	    	nodeName = "";
	    }
	    if (children != 0) {
	        String tempLink = ""; 
			out.print("var ");
			out.print(NODENAME);
			out.print(id);
			out.print("= insFld(");
			out.print(parentnodename);
			out.print(",");
			out.print("gFld(");
			out.print(parentnodename);
			out.print(",'");
			out.print(nodeId);
			out.print("','");
			out.print(nodeName);	
			out.print("','");
			out.print(linkUrl);
			out.print("','0'));\n");
			mynode = NODENAME + id;
			id++;

		    for(int i = 0;i < children;i++){
			    temp = treeRoot.getChildAt(i);
			    VisitSubTree(temp,mynode);
	        
	    }
	    }else {
			out.print("insDoc(");
			out.print(parentnodename);
			out.print(",");
			out.print("gLnk(");
			out.print(parentnodename);
			out.print(",'");
			out.print(nodeId);
			out.print("','");
			out.print(nodeName);	
			out.print("','");
			out.print(linkUrl);
			out.print("','0'));\n");
		}
	    
	}
	
}
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
 * @author ��־��
 * 
 * �����tag�ڲ�������js����
 */
public class TreeTag extends TagSupport {
	/**
	 * ���ڱ��������������ֿ�ͷ����ÿ���ڵ��idǰ��̶�����һ��������
	 */
	private static final String NODENAME = "nd";
	/**
	 * tag���ɵ����нڵ�id�Դ��ֶ�������Ϊ����
	 */
	private int id = 1;
	/**
	 * ��������ڵ����
	 */
	protected String provider = "";
	/**
	 * ÿ�����ӵ�Ŀ�ĵ�ַ
	 */
	protected String linkUrl = "";
	/**
	 * ���ڵ���Ҫ��ʾ�����֣������þ�ʹ��Ĭ��ֵ
	 */
	protected String rootText = "���νṹ";
	
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
	                    throw new RuntimeException("tree ����Դ����");
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
				out.print("<p>�������ɴ���:" + e.getMessage() + "</p>");
			} catch (IOException ex) {

			}
			return EVAL_PAGE;
		}
	}
	/**
	 * ���������������submitForm()����
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
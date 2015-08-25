package com.ifw.base;


public class IFWConstants {
	
	/**
	 * ifw step别名，别名作为step的唯一标志，跳转时使用
	 */
	public final static String STEPALIAS = "alias";
	
	/**交易代码*/
	public final static String TRANCODE = "ifw_TranCode";
	
	public final static String REPLY = "IFW_Reply";
	
	/**交易文件保存路径*/
	public final static String OPERATIONFILEPATH = "OperationFilePath";
	
	/**IFW配置文件保存路径*/
	public final static String IFWCFGFILEPATH = "IFWConfFilePath";
	
	/**classes路径*/
	public final static String CLASSPATH = IFWConstants.class.getResource("/").getPath();
		
	/**classpath下op文件路径*/
	public final static String CONFOPPATH = "/configfiles/operations/";
	
	/**配置文件*/
	public final static String CONFPATH = "/configfiles/";
	
	/**OpStep 开始Tag*/
	public final static String OPSTEPTAG = "Step";
	
	public final static String FLOW = "Flow";
	
	public final static String OPSTEPS = "OpSteps";
	
	public final static String ID = "ID";
	
	public final static String ISCACHECLASS = "IsCacheClass";
	
	public final static String SETTINGS = "Settings";
	
	public final static String ISCACHEOP = "isCacheOp";
	
	public final static String IJUMP = "IJump";
	
	//public final static String DO = "Do";
	
	public final static String END = "end";
	
	public final static String SMII = "SessionMaxInactiveInterval";
	
	public final static String IFWLOG = "ifwlog";
	
	public final static String SYSERROR = "000001";
	
	public final static String SESSIONERROR = "000002";
	
	public final static String LOGOUTPAGE = "000003";
	
	public final static String SERVICE = "Service";
	
	public final static String REFERID = "ReferID";
	
	public final static String PARAMS = "params";
	
	public final static String APPINFOCODE = "AppInfoCode";
	
	public final static String APPINFOMSG = "AppInfoMsg";
	
	
}

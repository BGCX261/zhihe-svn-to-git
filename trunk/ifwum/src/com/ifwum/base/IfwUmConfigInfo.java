package com.ifwum.base;
/**
 * 
 * @author kfzx-xiezc
 *
 *	ifwum系统配置封装类，单例，对外采用javabean的方式访问，设置方式可后续实现，目前先使用默认值
 *
 */
public class IfwUmConfigInfo {
	int numPerPage = 20;
	private static IfwUmConfigInfo singleConfig = new IfwUmConfigInfo();
	
	private IfwUmConfigInfo(){
		super();
	}

	public static  IfwUmConfigInfo getInstance(){
		return singleConfig;
	}
	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
}

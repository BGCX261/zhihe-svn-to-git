package com.ifwum.base;
/**
 * 
 * @author kfzx-xiezc
 *
 *	ifwumϵͳ���÷�װ�࣬�������������javabean�ķ�ʽ���ʣ����÷�ʽ�ɺ���ʵ�֣�Ŀǰ��ʹ��Ĭ��ֵ
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

package com.ifwum.step;

import java.util.Iterator;
import java.util.Vector;

import com.css.security.SecurityConfiguration;
import com.css.security.permission.Permission;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ��������Դid��ѯ��Դ��Ӧ����Դ������Դ���ɶ�Ӧ��ʵ��ϵͳ�е�һ����Դ����URL���ֶΣ���ȡ�
 * 
 * @author xiezc
 *
 */
public class RemQueryResKeyInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
			Resource rs = tree.getResource(Long.parseLong(resId));
			Vector v = rs.getUrls();
			
		    setObjectParam("nowResUrls", v);
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

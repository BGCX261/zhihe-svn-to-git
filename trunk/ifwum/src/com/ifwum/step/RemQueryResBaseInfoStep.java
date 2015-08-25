package com.ifwum.step;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ��������Դid��ѯ��Դ������Ϣ
 * 
 * @author xiezc
 *
 */
public class RemQueryResBaseInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
			Resource rs = tree.getResource(Long.parseLong(resId));
			if(rs == null){
				setStringParam("errorMsg", "���ִ��󣬴�����Ϣ����Դ���������޷��ҵ���Ӧ��Դ��Ϣ��");
				return "1";
			}
		    setObjectParam("newRes", rs);
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

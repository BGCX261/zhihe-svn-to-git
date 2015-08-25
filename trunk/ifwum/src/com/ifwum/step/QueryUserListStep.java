package com.ifwum.step;

import java.util.Iterator;

import com.css.security.SecurityConfiguration;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ���������������½�һ���û�
 * 
 * @author xiezc
 *
 */
public class QueryUserListStep extends AbstractStep {

	public String execute() throws EXTException {
		
		try{
			UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
			Iterator it = um.getUsers();
			setObjectParam("users", it);
			return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

package com.ifwum.step;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import com.css.framework.model.ListData;
import com.css.security.SecurityConfiguration;
import com.css.security.permission.RoleManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
import com.ifwum.base.IfwUmConfigInfo;
/**
 * ����Ȩ�޹���ϵͳ����ѯ��ɫ�б�
 * 
 * @author xiezc
 *
 */
public class RmQueryRoleListStep extends AbstractStep {

	public String execute() throws EXTException {
		
		try{
			 
			
			RoleManager rm = SecurityConfiguration.getSecurityFactory().getRoleManager();
			Iterator roles = rm.getAllRoles() ;
			HttpSession session = (HttpSession)getObjectParam("ifw_session");
			//��������
			session.setAttribute("roles", roles);
			session.setAttribute("rolecount", String.valueOf(rm.getAllRolesCount()));
			return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

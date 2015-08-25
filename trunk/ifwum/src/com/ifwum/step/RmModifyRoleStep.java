package com.ifwum.step;

import com.css.security.SecurityConfiguration;
import com.css.security.permission.Role;
import com.css.security.permission.RoleManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ���������������޸�һ����λ
 * 
 * @author xiezc
 *
 */
public class RmModifyRoleStep extends AbstractStep {

	public String execute() throws EXTException {
		String rolename=getStringParam("rolename");
		String roledesc=getStringParam("roledesc");
		String roleId=getStringParam("roleId");
		
		try{
			RoleManager rm = SecurityConfiguration.getSecurityFactory().getRoleManager();
			Role role = rm.getRole(Long.parseLong(roleId));
			//Result r = role.setName(rolename);
			//Result r1 = role.setDesc(roledesc);
			
			/*if (r.equals(Result.SUCCESS) && r1.equals(Result.SUCCESS)){//�޸ĳɹ�
				//User user = um.getUser(username);
				//setObjectParam("createdUser", user);
				return "0";
			}else{
				
				setStringParam("errorMsg",
						r.equals(Result.SUCCESS)?r1.getFullMessage():r.getFullMessage());
				return "1";
			}*/
			return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

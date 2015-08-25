package com.ifwum.step;

import java.util.StringTokenizer;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Role;
import com.css.security.permission.RoleManager;
import com.css.security.result.Result;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ���ӽ�ɫɾ���û�
 * 
 * @author xiezc
 *
 */
public class RmDelUserFromRoleStep extends AbstractStep {

	public String execute() throws EXTException {
		String roleId=getStringParam("roleId");
		String userIds=getStringParam("userIds");
		
		try{
			RoleManager rm = SecurityConfiguration.getSecurityFactory().getRoleManager();
			UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
			Role nowRole = rm.getRole(Long.parseLong(roleId));
			StringTokenizer st = new StringTokenizer(userIds,",");
			while(st.hasMoreTokens()){
				Result r = nowRole.removeUser(um.getUser((Long.parseLong(st.nextToken()))));
				if (r.equals(Result.SUCCESS)){//�����ɹ�����������
					//User user = um.getUser(username);
					//setObjectParam("createdUser", user);
					setStringParam("result", "true");
				}else{//����ʧ�ܣ���ʾ������Ϣ
					setStringParam("result", r.getFullMessage());
					break;
				}
			}
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		setStringParam("result", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "0";
	}

}
}

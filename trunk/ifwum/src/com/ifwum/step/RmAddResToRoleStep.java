package com.ifwum.step;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Permission;
import com.css.security.permission.Role;
import com.css.security.permission.RoleManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ����ĳ����ɫ���һ��������Դ
 * 
 * @author xiezc
 *
 */
public class RmAddResToRoleStep extends AbstractStep {

	public String execute() throws EXTException {
		long roleId=Long.parseLong(getStringParam("roleId"));
		String resIds=getStringParam("resIds");
		
		try{
			RoleManager rm = SecurityConfiguration.getSecurityFactory().getRoleManager();
			Permission permission = SecurityConfiguration.getSecurityFactory().getPermission();
			
			HttpSession session = (HttpSession)getObjectParam("ifw_session");
			User user = (User)session.getAttribute("ifw_user");
		
			StringTokenizer st = new StringTokenizer(resIds,",");
			while(st.hasMoreTokens()){
				Result r = permission.createRolePermission(roleId, Long.parseLong(st.nextToken()), 1, user.getUserId());
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

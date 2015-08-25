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
 * 访问权限管理系统，向某个角色添加一个或多个资源
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
				if (r.equals(Result.SUCCESS)){//创建成功，继续处理
					//User user = um.getUser(username);
					//setObjectParam("createdUser", user);
					setStringParam("result", "true");
				}else{//创建失败，提示错误信息
					setStringParam("result", r.getFullMessage());
					break;
				}
			}
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		setStringParam("result", "出现错误，错误信息："+e.getMessage());
		return "0";
	}

}
}

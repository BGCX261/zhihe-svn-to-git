package com.ifwum.step;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
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
 * 访问权限管理系统，根据角色id查询角色基本信息
 * 
 * @author xiezc
 *
 */
public class RmQueryRoleBaseInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String roleId=getStringParam("roleId");
		ArrayList allUserList = new ArrayList(); 
		ArrayList nowRoleUserList = new ArrayList();
		try{
			RoleManager rm = SecurityConfiguration.getSecurityFactory().getRoleManager();
			Role r = rm.getRole(Long.parseLong(roleId));
			if(r == null){
				setStringParam("errorMsg", "出现错误，错误信息：找不到角色id对应的角色");
				return "1";
			}
		    setObjectParam("nowRole", r);
		    Iterator users = r.getUsers(0);
		    while(users.hasNext()){
		    	nowRoleUserList.add(users.next());
		    }
		    setObjectParam("nowRoleUsers", nowRoleUserList);
		    
		    UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
		    Iterator allUsers = um.getUsers();
		    boolean isHave = false;
			while(allUsers.hasNext()){
				User ua = (User)allUsers.next();
		    	for(int i = 0;i < nowRoleUserList.size();i++){
		    		User pRoll = (User)nowRoleUserList.get(i);
		    		if(pRoll.getUserId() == ua.getUserId()){
		    			isHave = true;
		    			break;
		    		}
		    	}
		    	if(!isHave){
		    		allUserList.add(ua);
		    	}
		    	isHave = false;
			}
			setObjectParam("allUsers", allUserList);
		    
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

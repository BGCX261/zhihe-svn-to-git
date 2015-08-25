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
import com.css.security.org.Position;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据部门id查询部门用户信息
 * 
 * @author xiezc
 *
 */
public class DmQueryDptUserInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("dptId");
		ArrayList nowDptUserList = new ArrayList();
		ArrayList allUserList = new ArrayList();
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getOrganization(Long.parseLong(dptId));
			Department nowDpt = (Department)org.getDepartment(Long.parseLong(dptId));
			Iterator iter = nowDpt.getUsers();
			while(iter.hasNext()){
				nowDptUserList.add(iter.next());
			}
		    setObjectParam("nowDptUser", nowDptUserList);
		    
		    UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
		    Iterator allUsers = um.getUsers();
		    boolean isHave = false;
			while(allUsers.hasNext()){
				User ua = (User)allUsers.next();
		    	for(int i = 0;i < nowDptUserList.size();i++){
		    		User pDpt = (User)nowDptUserList.get(i);
		    		if(pDpt.getUserId() == ua.getUserId()){
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

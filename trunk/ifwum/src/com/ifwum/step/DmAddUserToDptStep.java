package com.ifwum.step;

import java.util.StringTokenizer;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.result.Result;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，向某个部门添加一个或多个用户
 * 
 * @author xiezc
 *
 */
public class DmAddUserToDptStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("deptid");
		String userIds=getStringParam("userIds");
		
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getDefaultOrganization();
			UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
			Department nowDpt = (Department)org.getDepartment(Long.parseLong(dptId));
			StringTokenizer st = new StringTokenizer(userIds,",");
			while(st.hasMoreTokens()){
				Result r = nowDpt.addUser(um.getUser(Long.parseLong(st.nextToken())));
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

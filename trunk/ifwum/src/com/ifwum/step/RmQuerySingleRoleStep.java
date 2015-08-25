package com.ifwum.step;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Position;
import com.css.security.org.PositionManager;
import com.css.security.permission.Role;
import com.css.security.permission.RoleManager;
import com.css.security.result.Result;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据岗位id查询一个岗位的信息
 * 
 * @author xiezc
 *
 */
public class RmQuerySingleRoleStep extends AbstractStep {

	public String execute() throws EXTException {
		String posId=getStringParam("roleId");
		
		try{
			RoleManager rm = SecurityConfiguration.getSecurityFactory().getRoleManager();

			Role pos = rm.getRole(Long.parseLong(posId));
			
			setObjectParam("roleObject", pos);
			
			return "0";
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

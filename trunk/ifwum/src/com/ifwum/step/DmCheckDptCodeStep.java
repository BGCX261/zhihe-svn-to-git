package com.ifwum.step;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，检查上送的dptCode是否已经注册过
 * 
 * @author xiezc
 *
 */
public class DmCheckDptCodeStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptCode=getStringParam("deptcode");
		
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getDefaultOrganization();
			
			Department nowDpt = (Department)org.getDepartmentByCode(dptCode);
			if(nowDpt == null){
				setObjectParam("result", "true");
			}else{
				setObjectParam("result", "false");
			}
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

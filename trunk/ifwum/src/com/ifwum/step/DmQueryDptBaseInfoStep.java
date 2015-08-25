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
 * 访问权限管理系统，根据部门id查询部门基本信息
 * 
 * @author xiezc
 *
 */
public class DmQueryDptBaseInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("dptId");
		
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getOrganization(Long.parseLong(dptId));
			if(org == null){
				setStringParam("errorMsg", "出现错误，错误信息：机构代码有误，无法找到对应机构信息。");
				return "1";
			}
			Department nowDpt = (Department)org.getDepartment(Long.parseLong(dptId)) ;
		    setObjectParam("newDpt", nowDpt);
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

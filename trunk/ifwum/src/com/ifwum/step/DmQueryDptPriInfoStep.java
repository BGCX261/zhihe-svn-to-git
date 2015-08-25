package com.ifwum.step;

import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Permission;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据部门id查询部门资源信息
 * 
 * @author xiezc
 *
 */
public class DmQueryDptPriInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("dptId");
		
		try{
			Permission per = SecurityConfiguration.getSecurityFactory().getPermission();
			Iterator iter = per.getDeptPermissions(Long.parseLong(dptId));
		    setObjectParam("newDptPri", iter);
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

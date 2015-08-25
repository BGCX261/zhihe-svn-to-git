package com.ifwum.step;

import java.util.StringTokenizer;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，删除某个部门
 * 
 * @author xiezc
 *
 */
public class DmDelDptStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("deptid");
		
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getDefaultOrganization();
			
			Department d = org.getDepartment(Long.parseLong(dptId));
			Department parent = org.getDepartment(d.getParentId());
			Result r = parent.removeChild(d);
			
			if (r.equals(Result.SUCCESS)){//删除成功，返回结果页面
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

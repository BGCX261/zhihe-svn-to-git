package com.ifwum.step;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.css.security.result.Result;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，删除某个部门
 * 
 * @author xiezc
 *
 */
public class RemDelResStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
			
			Resource rs = tree.getResource(Long.parseLong(resId));
			Resource parent = tree.getResource(rs.getParentId());
			Result r = parent.deleteChild(rs);
			
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

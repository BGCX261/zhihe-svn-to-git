package com.ifwum.step;

import java.util.Iterator;
import java.util.Vector;

import com.css.security.SecurityConfiguration;
import com.css.security.permission.Permission;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据资源id查询资源对应的资源键，资源键可对应到实际系统中的一类资源，如URL，字段，表等。
 * 
 * @author xiezc
 *
 */
public class RemQueryResKeyInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
			Resource rs = tree.getResource(Long.parseLong(resId));
			Vector v = rs.getUrls();
			
		    setObjectParam("nowResUrls", v);
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

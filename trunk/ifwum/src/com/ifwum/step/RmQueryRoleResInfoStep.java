package com.ifwum.step;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.framework.model.ListData;
import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Permission;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.css.security.permission.Role;
import com.css.security.permission.RoleManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据角色id查询角色对应的资源信息
 * 
 * @author xiezc
 *
 */
public class RmQueryRoleResInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String roleId=getStringParam("roleId");
		ArrayList allResListOri = new ArrayList();
		ArrayList allResList = new ArrayList();
		ArrayList nowRoleResList = new ArrayList();
		
		try{
			Permission p = SecurityConfiguration.getSecurityFactory().getPermission();
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
		    Iterator perms = p.getRolePermissions(-1, Long.parseLong(roleId));
		    while(perms.hasNext()){
		    	nowRoleResList.add(tree.getResource(((Permission)perms.next()).getResourceId()));
		    }
		    
		    setObjectParam("nowRoleRes", nowRoleResList);
		     
		    
		    Resource rs = tree.getResource(0);
		    VisitRsTree(rs,allResListOri);
		
		    boolean isHave = false;
			for(int i = 0;i < allResListOri.size();i++){
				Resource ra = (Resource)allResListOri.get(i);
		    	for(int j = 0;j < nowRoleResList.size();j++){
		    		Resource r = (Resource)nowRoleResList.get(j);
		    		if(r.getResourceId() == ra.getResourceId()){
		    			isHave = true;
		    			break;
		    		}
		    	}
		    	if(!isHave){
		    		allResList.add(ra);
		    	}
		    	isHave = false;
			}
			setObjectParam("allRes", allResList);
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
	private void VisitRsTree(Resource rs,ArrayList container){
		Iterator r = rs.getChildren();
		Resource next = null;
		while(r.hasNext()){
			next = (Resource)r.next();
			container.add(next);
			VisitRsTree(next,container);
		}
	}
}

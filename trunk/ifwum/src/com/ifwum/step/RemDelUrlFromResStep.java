package com.ifwum.step;

import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.PositionManager;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.css.security.permission.RoleManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，将一些资源键从资源删除
 * 
 * @author xiezc
 *
 */
public class RemDelUrlFromResStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		String urls=getStringParam("urls");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();

			Resource res = tree.getResource(Long.parseLong(resId));
			StringTokenizer st = new StringTokenizer(urls,",");
			
			while(st.hasMoreTokens()){
				Result r = res.removeUrl(st.nextToken());
				if (r.equals(Result.SUCCESS)){//创建成功，返回结果页面
					//User user = um.getUser(username);
					//setObjectParam("createdUser", user);
					setStringParam("result", "true");
					
				}else{
					setStringParam("result", r.getFullMessage());
					break;
				}
			}
			
			
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("result", "出现错误，错误信息："+e.getMessage());
		
	}
		return "0";

}
}

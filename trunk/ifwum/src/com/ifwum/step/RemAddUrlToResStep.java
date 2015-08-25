package com.ifwum.step;

import java.util.Hashtable;

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
 * ����Ȩ�޹���ϵͳ����һ����Դ���󶨵�һ����Դ��
 * 
 * @author xiezc
 *
 */
public class RemAddUrlToResStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		String rurl=getStringParam("rurl");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();

			Resource res = tree.getResource(Long.parseLong(resId));
			Result r = res.createUrl(rurl);
			
			if (r.equals(Result.SUCCESS)){//�����ɹ������ؽ��ҳ��
				//User user = um.getUser(username);
				//setObjectParam("createdUser", user);
				setStringParam("result", "true");
				
			}else{
				setStringParam("result", r.getFullMessage());
			}
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("result", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		
	}
		return "0";

}
}

package com.ifwum.step;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ���������������½�һ���û�
 * 
 * @author xiezc
 *
 */
public class DeleteUserStep extends AbstractStep {

	public String execute() throws EXTException {
		String username=getStringParam("username");
		
		try{
			UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
			User user = um.getUser(username);
			Result r = um.deleteUser(user);
			if (r.equals(Result.SUCCESS)){//ɾ���ɹ������ؽ��ҳ��
				setObjectParam("deletedUser", user);
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

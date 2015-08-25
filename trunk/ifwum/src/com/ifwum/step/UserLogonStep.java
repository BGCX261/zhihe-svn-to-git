package com.ifwum.step;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ����֤�û��Ƿ���Ч
 * ��Ч�򷵻�-1����Ч������һ��session�������û��������session��ifw_user��ֵ��
 * 
 * @author xiezc
 *
 */
public class UserLogonStep extends AbstractStep {

	public String execute() throws EXTException {
		String username=getStringParam("username");
		String password=getStringParam("password");
		try{
		UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
		Result rt = um.login(username, password);
		if (rt.equals(Result.SUCCESS)){//��¼�ɹ�������session
			HttpServletRequest req = (HttpServletRequest)getObjectParam("ifw_session");
			HttpSession hs = req.getSession(true);
			User user = um.getUser(username) ;
			hs.setAttribute("ifw_user", user);
			return "0";
		}else{
			setStringParam("errorMsg", rt.getFullMessage());
			return "1";
		}
	}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}

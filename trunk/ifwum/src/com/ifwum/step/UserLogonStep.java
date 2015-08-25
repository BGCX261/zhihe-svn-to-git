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
 * 访问权限管理系统，验证用户是否有效
 * 无效则返回-1，有效则生成一个session，并将用户对象存入session的ifw_user键值中
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
		if (rt.equals(Result.SUCCESS)){//登录成功，创建session
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
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}

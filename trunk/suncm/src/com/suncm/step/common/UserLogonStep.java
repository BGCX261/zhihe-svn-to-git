package com.suncm.step.common;

import javax.servlet.http.HttpSession;

import com.ifw.exception.EXTException;
import com.suncm.um.ISuncmUmFacade;
import com.suncm.um.SuncmUser;
import com.suncm.util.OperFailException;
import com.suncm.util.SpringUtil;
import com.suncm.util.SystemConfig;

/**
 * 用户登录过程
 * 
 * 无效则返回-1，有效则生成一个session，并将用户对象存入session的ifw_user键值中
 * 
 * @author xiezc
 * 
 */
public class UserLogonStep extends WebCommonStep {

	public String execute() throws EXTException {
		String username = getStringParam("username");
		String password = getStringParam("password");
		try {
			ISuncmUmFacade suf = (ISuncmUmFacade)SpringUtil.getApplicationContext().getBean("UserFacade");
			
			SuncmUser su = suf.getUser(username, password);
			
			HttpSession hs = (HttpSession) getObjectParam("ifw_session");
			hs.setAttribute("suncm_user", su);

			return "0";
		}catch(OperFailException ofe){
			this.setSessionParam("tranErrorCode", ofe.getTranErrorCode());
			this.setSessionParam("tranErrorDispMsg", ofe.getTranErrorDispMsg());
			this.setSessionParam("tranErrorMsg", ofe.getTranErrorMsg());
			this.setSessionParam("tranErrorLocation", ofe.getTranErrorLocation());
		}
		catch (Exception e) {

			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", e.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			e.printStackTrace();
		}
		return "1";
	}
}

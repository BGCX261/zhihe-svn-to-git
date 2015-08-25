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
 * «Â¿Ìsession
 * 
 * @author xiezc
 *
 */
public class UserLogoffStep extends AbstractStep {

	public String execute() throws EXTException {

			HttpSession session = (HttpSession)getObjectParam("ifw_session");
			session.invalidate();
			return "0";

}
}

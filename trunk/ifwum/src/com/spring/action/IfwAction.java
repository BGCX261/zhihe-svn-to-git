package com.spring.action;         

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ifw.base.IFWConstants;
import com.ifw.spring.ext.SpringFlow;
/**
 * 这个action不会新建session
 * 
 * @author xiezc
 *
 */
public class IfwAction implements Controller {


	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		
		Map model = new HashMap();
		//将提交参数放在另一个集合中
		Enumeration e = req.getParameterNames();
		String name = null;
		while(e.hasMoreElements()){
			name = (String)e.nextElement();
			model.put(name, req.getParameter(name));
		}
		//将session带入flow中,由于之前已经做过登录,此处不再新建session，如果session为空表示没有登录或登录超时
		HttpSession session = req.getSession(false);
		//session超时返回超时页面
		if(session == null){
			return new ModelAndView("ifwum_sessionerror",model);
		}else{
			//如果session中没有用户对象也返回超时页面，提示重新登录
			Object ifw_user = session.getAttribute("ifw_user");
			if(ifw_user == null){
				return new ModelAndView("ifwum_sessionerror",model);
			}
		}
		
		model.put("ifw_session", session);
		
		SpringFlow sf = new SpringFlow(model,req.getParameter("ifw_flowname")); 
		
		sf.execute();
		return new ModelAndView((String)model.get(IFWConstants.REPLY),model);
		//System.out.println("xiexie" + getHelloWorld());
		
	}
	
}

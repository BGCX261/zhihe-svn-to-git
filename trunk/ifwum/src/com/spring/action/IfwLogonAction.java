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
 * 由于登录时需要创建session，所以使用与非登录交易不同的action
 * 
 * @author xiezc
 *
 */
public class IfwLogonAction implements Controller {


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
		//将request带入flow中,由于是登录，flow中需要在验证用户有效的的时候新建一个session
		HttpSession session = req.getSession(true);
		model.put("ifw_session", req);
		
		SpringFlow sf = new SpringFlow(model,req.getParameter("ifw_flowname")); 
		
		sf.execute();
	
		//System.out.println("xiexie" + getHelloWorld());
		return new ModelAndView((String)model.get(IFWConstants.REPLY),model);
	}
	
}

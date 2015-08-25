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
 * ���ڵ�¼ʱ��Ҫ����session������ʹ����ǵ�¼���ײ�ͬ��action
 * 
 * @author xiezc
 *
 */
public class IfwLogonAction implements Controller {


	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		Map model = new HashMap();
		//���ύ����������һ��������
		Enumeration e = req.getParameterNames();
		String name = null;
		while(e.hasMoreElements()){
			name = (String)e.nextElement();
			model.put(name, req.getParameter(name));
		}
		//��request����flow��,�����ǵ�¼��flow����Ҫ����֤�û���Ч�ĵ�ʱ���½�һ��session
		HttpSession session = req.getSession(true);
		model.put("ifw_session", req);
		
		SpringFlow sf = new SpringFlow(model,req.getParameter("ifw_flowname")); 
		
		sf.execute();
	
		//System.out.println("xiexie" + getHelloWorld());
		return new ModelAndView((String)model.get(IFWConstants.REPLY),model);
	}
	
}

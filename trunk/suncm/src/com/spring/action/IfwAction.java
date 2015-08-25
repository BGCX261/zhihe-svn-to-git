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
 * ���action�����½�session
 * 
 * @author xiezc
 *
 */
public class IfwAction implements Controller {


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
		//��session����flow��,����֮ǰ�Ѿ�������¼,�˴������½�session�����sessionΪ�ձ�ʾû�е�¼���¼��ʱ
		HttpSession session = req.getSession(false);
		//session��ʱ���س�ʱҳ��
		if(session == null){
			return new ModelAndView("suncm_sessionerror",model);
		}else{
			//���session��û���û�����Ҳ���س�ʱҳ�棬��ʾ���µ�¼
			Object suncm_user = session.getAttribute("suncm_user");
			if(suncm_user == null){
				return new ModelAndView("suncm_sessionerror",model);
			}
		}
		
		model.put("ifw_session", session);
		session.setAttribute("tranErrorCode", "0");
		session.setAttribute("actDesc", "");
		session.setAttribute("tranErrorMsg", "");
		session.setAttribute("tranErrorDispMsg", "");
		session.setAttribute("tranErrorLocation", "");
		
		SpringFlow sf = new SpringFlow(model,req.getParameter("ifw_flowname")); 
		
		sf.execute();
		return new ModelAndView((String)model.get(IFWConstants.REPLY),model);
		//System.out.println("xiexie" + getHelloWorld());
		
	}
	
}

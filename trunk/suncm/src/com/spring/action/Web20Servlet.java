package com.spring.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.ifw.exception.EXTException;
import com.ifw.spring.ext.SpringFlow;

/**
 * ����spring��web���ֻ�ܷ���һ��ҳ�棨Ҳ���������߲�֪����������ʽ��������ʹ�õ�����servlet��Ӧajax��ʽ����������
 * 
 * xiezc
 */
public class Web20Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Web20Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream out = response.getOutputStream();
		Map model = new HashMap();
		//���ύ����������һ��������
		Enumeration e = request.getParameterNames();
		String name = null;
		while(e.hasMoreElements()){
			name = (String)e.nextElement();
			model.put(name, request.getParameter(name));
		}
		//��session����flow��,����֮ǰ�Ѿ�������¼,�˴������½�session�����sessionΪ�ձ�ʾû�е�¼���¼��ʱ
		HttpSession session = request.getSession(false);
		// session��ʱ���س�ʱҳ��
		if (session == null) {
			out.write("session��ʱ�������µ�¼".getBytes());
			return;
		} else {
			// ���session��û���û�����Ҳ���س�ʱҳ�棬��ʾ���µ�¼
			Object suncm_user = session.getAttribute("suncm_user");
			if (suncm_user == null) {
				out.write("session��ʱ�������µ�¼".getBytes());
				return;
			}
		}
		
		model.put("ifw_session", session);
		session.setAttribute("tranErrorCode", "0");
		session.setAttribute("actDesc", "");
		session.setAttribute("tranErrorDispMsg", "");
		session.setAttribute("tranErrorMsg", "");
		session.setAttribute("tranErrorLocation", "");
		try{
		SpringFlow sf = new SpringFlow(model,request.getParameter("ifw_flowname")); 
		
		sf.execute();
		}catch (EXTException ext) {
			ext.printStackTrace();
			out.write("".getBytes());
		}
		response.setCharacterEncoding("GBK");
		//����web2.0������flowӦ�������������result�ֶ��У�����̶�д�����ֶ�
		out.write(((String)model.get("result")).getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request,response);
	}

}

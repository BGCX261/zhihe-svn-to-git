package com.suncm.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbpm.api.IdentityService;

/**
 * Servlet implementation class InitJbpmUserServlet
 */
public class InitJbpmUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitJbpmUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IdentityService identifyService = JbpmUtil.getIdentityService();
		 /*String baosId = identifyService.createGroup("��Ŀ������Ա");
		 identifyService.createUser("����", "��", "��");
		 identifyService.createUser("����", "��", "��");
		 identifyService.createMembership("����", baosId,"submitter");
		 identifyService.createMembership("����", baosId,"submitter");*/
		 

		 String msId = identifyService.createGroup("����");
		 identifyService.createUser("����", "��", "��");
		 identifyService.createMembership("����", msId,"submitter");
		 

		 String zcId = identifyService.createGroup("�ܲ�");
		 identifyService.createUser("��Ƥ", "Ƥ", "��");
		 identifyService.createMembership("��Ƥ", zcId,"submitter");
		 
		 response.setCharacterEncoding("GBK");
		 response.getWriter().println("JBPM�Դ��û��Ѿ��������");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

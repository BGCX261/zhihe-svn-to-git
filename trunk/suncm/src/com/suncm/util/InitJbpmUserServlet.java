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
		 /*String baosId = identifyService.createGroup("项目报送人员");
		 identifyService.createUser("刘宝", "宝", "刘");
		 identifyService.createUser("刘松", "松", "刘");
		 identifyService.createMembership("刘宝", baosId,"submitter");
		 identifyService.createMembership("刘松", baosId,"submitter");*/
		 

		 String msId = identifyService.createGroup("秘书");
		 identifyService.createUser("米书", "书", "米");
		 identifyService.createMembership("米书", msId,"submitter");
		 

		 String zcId = identifyService.createGroup("总裁");
		 identifyService.createUser("张皮", "皮", "张");
		 identifyService.createMembership("张皮", zcId,"submitter");
		 
		 response.setCharacterEncoding("GBK");
		 response.getWriter().println("JBPM自带用户已经创建完成");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

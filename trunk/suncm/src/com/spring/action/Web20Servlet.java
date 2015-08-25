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
 * 由于spring的web框架只能返回一个页面（也可能有作者不知道的其他方式），这里使用单独的servlet响应ajax方式上来的请求
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
		//将提交参数放在另一个集合中
		Enumeration e = request.getParameterNames();
		String name = null;
		while(e.hasMoreElements()){
			name = (String)e.nextElement();
			model.put(name, request.getParameter(name));
		}
		//将session带入flow中,由于之前已经做过登录,此处不再新建session，如果session为空表示没有登录或登录超时
		HttpSession session = request.getSession(false);
		// session超时返回超时页面
		if (session == null) {
			out.write("session超时，请重新登录".getBytes());
			return;
		} else {
			// 如果session中没有用户对象也返回超时页面，提示重新登录
			Object suncm_user = session.getAttribute("suncm_user");
			if (suncm_user == null) {
				out.write("session超时，请重新登录".getBytes());
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
		//对于web2.0的请求，flow应当将结果放置在result字段中，这里固定写出此字段
		out.write(((String)model.get("result")).getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request,response);
	}

}

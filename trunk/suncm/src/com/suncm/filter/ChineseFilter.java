package com.suncm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChineseFilter extends HttpServlet implements Filter {
		 private FilterConfig filterConfig;
		     //Handle the passed-in FilterConfig
		 public void init(FilterConfig aFilterConfig) throws ServletException {
		     this.filterConfig = aFilterConfig;
		 }
		     //Process the request/response pair
		     public void doFilter(ServletRequest request, ServletResponse response,FilterChain filterChain) {
		         try {
		          String encoding=filterConfig.getInitParameter("encoding");//��WEB.xml�����ļ���ȡ���������������ǿ���ͨ�������޸ı����ʽ��                  
		             request.setCharacterEncoding(encoding);//��������ı����ʽ
		             filterChain.doFilter(request, response);
		         } catch (ServletException sx) {
		             filterConfig.getServletContext().log(sx.getMessage());
		         } catch (IOException iox) {
		             filterConfig.getServletContext().log(iox.getMessage());
		         }
		     }

		     //Clean up resources
		     public void destroy() {
		     }

		  protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		   // TODO Auto-generated method stub
		   super.doGet(arg0, arg1);  
		  }

		  protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		   // TODO Auto-generated method stub
		   super.doPost(arg0, arg1);   
		  } 

}

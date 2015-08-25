package filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;

/**
 * <p>
 * Encoding Filter
 * </p>
 * <p>
 * 创建日期： 2009-4-22 下午4:33
 * </p>
 * 
 * @author kfzx-zoucl
 */
public class SetCharacterEncodingFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	protected boolean ignore = false;

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encoding1 = null;
		if (ignore || (request.getCharacterEncoding() == null)) {
			String encoding = selectEncoding(request);
			encoding1 = request.getCharacterEncoding();
			if (encoding != null){
				if(encoding1!=null){
					request.setCharacterEncoding(encoding1);
				}else{
					request.setCharacterEncoding(encoding);
				}
			}
		}
		/*Enumeration e = request.getParameterNames();
		String temp = request.getParameter((String)e.nextElement());
		System.out.println(temp.getBytes());*/
		
		/*if(encoding1!=null){
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String parameter = (String)e.nextElement();
				String temp = request.getParameter(parameter);
				String opTemp = new String(temp.getBytes(encoding),encoding1);
				request.setAttribute(parameter, opTemp);
				System.out.println(opTemp);
			}
		}*/

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null)
			this.ignore = true;
		else if (value.equalsIgnoreCase("true"))
			this.ignore = true;
		else if (value.equalsIgnoreCase("yes"))
			this.ignore = true;
		else
			this.ignore = false;

	}

	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}
}

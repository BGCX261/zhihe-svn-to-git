/*
 * Created on 2005-6-28
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
package com.suncm.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.css.log.Logger;
import com.css.security.ConfigManager;
import com.css.security.SecurityConfiguration;
import com.css.security.permission.Permission;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.css.security.user.User;

/**
 * @author Administrator
 * 
 * 检查过滤用户访问url权限问题的过滤器，过滤原则如下：
 * 1.首先获取url，判断是否是不需要判断的特殊页面，比如登录页面
 * 2.再者再判断是否是登录用户，即session中是否有用户ID
 * 3.然后再判断session中用户是否有权限访问该url
 * 
 */
public class PermissionFilter implements Filter
{

    static Logger logger = Logger.getLogger(PermissionFilter.class.toString());

    private static ConfigManager config = ConfigManager.getInstance();

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javaoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    /**
     * 登录页面
     * 这些
     */
    public static final String LOGIN_PAGE = config.getLoginPage();

    /**
     * 消息提示页面
     */
    public static final String MESSAGE_PAGE = config.getMessagePage();

    /**
     * 不需要过滤的页面
     */
    public static final String[] needNotCheckPageList = config.getPageList();

    /**
     * 判断是否需要过滤的页面
     * 
     * @param url
     * @return
     */
    private boolean needCheckRight(String url)
    {
        if (url == null)
            return false;
        for (int i = 0; i < needNotCheckPageList.length; i++)
        {
            if (url.startsWith(needNotCheckPageList[i]))
            {
                //if (logger.debug())
                {
                    // logger.debug("Start with: " + needNotCheckPageList[i] + " so need not check.");
                }
                return false;
            }
        }

        PatternRule rule = new PatternRule(config);

        // log.debug("rule.doFilter(url)="+rule.doFilter(url));

        return rule.doFilter(url);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException
    {
    	String basePath = "/ifwum/";
    	
        // TODO Auto-generated method stub

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        /*String query = "";
        if (req.getQueryString() != null)
            query = "?" + req.getQueryString();

        String url = uri + query;*/
        //不使用从前的方式进行权限过滤，如果是*.do的请求都根据Flow名判断，否则根据jsp名判断
        String resourceKey = null;
        if(uri.endsWith(".do")){
        	resourceKey = req.getParameter("ifw_flowname");
        }else{
        	if(uri.indexOf("?") == -1)
        	resourceKey = uri.substring(uri.lastIndexOf("/")+1);
        	else
        		resourceKey = uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("?"));
        }

        //if (logger.debug())
        {
            // logger.debug("userId=" + luserId + "\nurl: " + url + "\nneed check: " + needCheckRight(url));
        }

        if (!needCheckRight(resourceKey))
        {
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = req.getSession();

        SuncmUser user = (SuncmUser) session.getAttribute("ifw_user");
        
        
        long userId = 0;
        if (user != null)
            userId = user.getUserId();
        else
        {
            res.sendRedirect(basePath+LOGIN_PAGE);
            return;
        }

        /**
         * 如果用户可以访问该链接，则将该链接发送给过滤链的(FilterChain)下一个过滤器过滤。
         * 在过滤链的最后就是用户请求的Servlet，因此，如果希望用户访问不到Servlet，只需要 阻断该过滤链的访问即可。
         */
        if (canAccess(resourceKey, userId))
            chain.doFilter(req, res);
        else
            res.sendRedirect(basePath+MESSAGE_PAGE + "?url=stay&ifw_filtermessage=" + URLEncoder.encode("您没有权限访问该页面。", "GBK"));
    }

    /**
     * 判断是否某个用户是否满足一个页面的访问条件。
     * 
     * @param url
     * @param userId
     * @return
     */
    private boolean canAccess(String url, long userId)
    {
        // long t1 = System.currentTimeMillis() ;
        ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
        Resource resource = (Resource) tree.getRoot();
        
        //对于一个xx.jsp?id=1这样的页面，需要取问号前面部分
        if(url.indexOf("?")!=-1)
        	url = url.substring(0,url.indexOf("?")) ;
       

        Resource bean = resource.getResourceByUrl(url);
        long resourceId = 0;

        // 如果该URL资源没被注册,则不限制访问
        if (bean != null)
            resourceId = bean.getResourceId();
        else
            return true;

        Permission permission = SecurityConfiguration.getSecurityFactory().getPermission();
        boolean flag = permission.checkUserOperatePermission(userId, resourceId);
        // long t2 = System.currentTimeMillis() ;
        // System.out.println("canAccess cost:"+(t2-t1)+"ms.");
        return flag;
    }

    public static void main(String[] args)
    {
    }
}

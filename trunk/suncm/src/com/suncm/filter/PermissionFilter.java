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
 * �������û�����urlȨ������Ĺ�����������ԭ�����£�
 * 1.���Ȼ�ȡurl���ж��Ƿ��ǲ���Ҫ�жϵ�����ҳ�棬�����¼ҳ��
 * 2.�������ж��Ƿ��ǵ�¼�û�����session���Ƿ����û�ID
 * 3.Ȼ�����ж�session���û��Ƿ���Ȩ�޷��ʸ�url
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
     * ��¼ҳ��
     * ��Щ
     */
    public static final String LOGIN_PAGE = config.getLoginPage();

    /**
     * ��Ϣ��ʾҳ��
     */
    public static final String MESSAGE_PAGE = config.getMessagePage();

    /**
     * ����Ҫ���˵�ҳ��
     */
    public static final String[] needNotCheckPageList = config.getPageList();

    /**
     * �ж��Ƿ���Ҫ���˵�ҳ��
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
        //��ʹ�ô�ǰ�ķ�ʽ����Ȩ�޹��ˣ������*.do�����󶼸���Flow���жϣ��������jsp���ж�
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
         * ����û����Է��ʸ����ӣ��򽫸����ӷ��͸���������(FilterChain)��һ�����������ˡ�
         * �ڹ��������������û������Servlet����ˣ����ϣ���û����ʲ���Servlet��ֻ��Ҫ ��ϸù������ķ��ʼ��ɡ�
         */
        if (canAccess(resourceKey, userId))
            chain.doFilter(req, res);
        else
            res.sendRedirect(basePath+MESSAGE_PAGE + "?url=stay&ifw_filtermessage=" + URLEncoder.encode("��û��Ȩ�޷��ʸ�ҳ�档", "GBK"));
    }

    /**
     * �ж��Ƿ�ĳ���û��Ƿ�����һ��ҳ��ķ���������
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
        
        //����һ��xx.jsp?id=1������ҳ�棬��Ҫȡ�ʺ�ǰ�沿��
        if(url.indexOf("?")!=-1)
        	url = url.substring(0,url.indexOf("?")) ;
       

        Resource bean = resource.getResourceByUrl(url);
        long resourceId = 0;

        // �����URL��Դû��ע��,�����Ʒ���
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

package com.suncm.step.common;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import com.ifw.exception.EXTException;
import com.suncm.util.HibernateUtil;
import com.suncm.util.SystemConfig;
/**
 * 执行外部配置的一个hql查询，结果放入session的pageData字段中
 * hql语句中支持变量，使用${varname}表示变量，目前变量来源默认为客户端提交字段
 * 
 * @author xiezc
 *
 */
public class QueryListStep extends WebCommonStep {

	public String execute() throws EXTException {
			HttpSession session = (HttpSession)getObjectParam("ifw_session");
		try{
			String hql = getSetting("hql");
			
			hql = dealHql(hql);
			
			Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();

			hsession.beginTransaction();   
			
			List results = hsession.createQuery(hql).list();
			
			hsession.getTransaction().commit();
			
			session.setAttribute("pageData", results);
			session.setAttribute("dataId", this.getFlow().getFlowName());
			session.setAttribute("pageTotalNum", results.size());

			int totalNum = results.size();
			int numPerPage = Integer.parseInt(SystemConfig.getConfig("numPerPage"));
			int totalpageNum = 0;
			if(totalNum%numPerPage == 0){
				totalpageNum = totalNum/numPerPage; 
			}else{
				totalpageNum = totalNum/numPerPage + 1;
			}
			session.setAttribute("totalPageNum", totalpageNum);
			
			return "0";
			
		}catch(Throwable t){
			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			t.printStackTrace();
			
			return "-1";
		}
		
	}
/**
 * 处理hql中的变量
 * 
 * @param hql
 * @return
 */
	private String dealHql(String hql){
		int index = hql.indexOf("${");
		while(index != -1){
			int indexEnd = hql.indexOf("}");
			String name = hql.substring(index+2,indexEnd);
			String value = getStringParam(name);
			//需要对$进行转义
			hql = hql.replaceAll("\\$\\{"+hql.substring(index+2,indexEnd)+"\\}", "'" + value + "'");
			index = hql.indexOf("${");
		}
		
		index = hql.indexOf("@{");
		while(index != -1){
			int indexEnd = hql.indexOf("}");
			String name = hql.substring(index+2,indexEnd);
			String value = getStringParam(name);
			//需要对$进行转义
			hql = hql.replaceAll("\\@\\{"+hql.substring(index+2,indexEnd)+"\\}",  value );
			index = hql.indexOf("@{");
		}
		return hql;
	}
}

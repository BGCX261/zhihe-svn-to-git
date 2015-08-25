package com.suncm.step.admin;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmProcatePageset;
import com.suncm.pojo.SuncmProcatePagesetId;
import com.suncm.step.common.WebCommonStep;
import com.suncm.util.HibernateUtil;
import com.suncm.util.SystemConfig;

/**
 * 给项目分类增加一个字段
 * 
 * @author xiezc
 * 
 */
public class PCateAddWidgetToTplStep extends WebCommonStep {

	public String execute() throws EXTException {

		try {
			//1.获得当前最大的pageNo
			Session hsession1 = HibernateUtil.getSessionFactory()
			.getCurrentSession();
			Transaction tx1 = hsession1.beginTransaction();
			Integer pageNo = (Integer)hsession1.createQuery("select max(a.id.pageNo) from SuncmProcatePageset a").uniqueResult();
			tx1.commit();
			if(pageNo == null){
				pageNo = new Integer(0);
			}
			//保存字段对象
			SuncmProcatePagesetId sppi = new SuncmProcatePagesetId();
			sppi.setProjectCateId(getStringParam("pCateId"));
			sppi.setPageNo(pageNo.intValue()+1);
			SuncmProcatePageset spp = new SuncmProcatePageset();
			spp.setId(sppi);
			spp.setPropertyName(getStringParam("propertyName"));
			spp.setItemdesc(getStringParam("itemdesc"));
			String isforced = getStringParam("isforced");
			if(isforced == null || isforced.trim().length()==0){
				isforced="0";
			}
			spp.setIsforced(Integer.parseInt(isforced));
			String minlength = getStringParam("minlength");
			if(minlength == null || minlength.trim().length()==0){
				minlength="0";
			}
			spp.setMinlength(Integer.parseInt(minlength));
			String maxlength = getStringParam("maxlength");
			if(maxlength == null || maxlength.trim().length()==0){
				maxlength="1000";
			}
			spp.setMaxlength(Integer.parseInt(maxlength));
			spp.setOptions(getStringParam("options"));
			String ismodify = getStringParam("ismodify");
			if(ismodify == null || ismodify.trim().length()==0){
				ismodify="0";
			}
			spp.setIsmodify(Integer.parseInt(ismodify));
			String isqcon = getStringParam("isqcon");
			if(isqcon == null || isqcon.trim().length()==0){
				isqcon="0";
			}
			spp.setIsqcon(Integer.parseInt(isqcon));
			String isinlist = getStringParam("isinlist");
			if(isinlist == null || isinlist.trim().length()==0){
				isinlist="0";
			}
			spp.setIsinlist(Integer.parseInt(isinlist));
			spp.setPagetype(Integer.parseInt(getStringParam("pagetype")));
			
			
			Session hsession = HibernateUtil.getSessionFactory()
			.getCurrentSession();
			Transaction tx = hsession.beginTransaction();
			hsession.save(spp);
			tx.commit();
			
			
			return "0";
		} catch (Throwable t) {

			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			t.printStackTrace();

			return "-1";
		}

	}
}

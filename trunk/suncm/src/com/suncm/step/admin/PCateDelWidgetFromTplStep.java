package com.suncm.step.admin;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ifw.exception.EXTException;
import com.suncm.step.common.WebCommonStep;
import com.suncm.util.HibernateUtil;
import com.suncm.util.SystemConfig;

/**
 * 先部署工作流，部署成功后保存项目分类信息
 * 
 * @author xiezc
 * 
 */
public class PCateDelWidgetFromTplStep extends WebCommonStep {

	public String execute() throws EXTException {

		try {
			String pCateId = getStringParam("pCateId");
			String widgetId = getStringParam("id");

			Session hsession = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			Transaction tx = hsession.beginTransaction();
			int deletedEntities = hsession
					.createQuery(
							"delete SuncmProcatePageset spp where spp.id.projectCateId=:oldid and spp.id.pageNo=:oldNo")
					.setString("oldid", pCateId).setInteger("oldNo",
							Integer.parseInt(widgetId)).executeUpdate();
			tx.commit();
			if (deletedEntities != 1) {
				this.setSessionParam("tranErrorCode", "C000002");
				this.setSessionParam("tranErrorDispMsg", SystemConfig
						.getErrorDisp("C000002"));
				this.setSessionParam("tranErrorMsg", pCateId+widgetId);
				this.setSessionParam("tranErrorLocation", this.getStepID());
				return "-1";
				}
			return "0";

		} catch (Throwable t) {

			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			setStringParam("result", SystemConfig
					.getErrorDisp("C000002"));
			t.printStackTrace();

			return "-1";
		}

	}
}

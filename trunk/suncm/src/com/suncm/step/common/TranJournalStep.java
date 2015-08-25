package com.suncm.step.common;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmErrorJournal;
import com.suncm.pojo.SuncmJournal;
import com.suncm.um.SuncmUser;
import com.suncm.util.HibernateUtil;
import com.suncm.util.SystemConfig;

public class TranJournalStep extends WebCommonStep {

	public String execute() throws EXTException {

		try {
			String tranErrorCode = this.getSessionStrParam("tranErrorCode");
			if (tranErrorCode.equals("0")) {// 程序未出错，记录正确日志
				String dbOn = SystemConfig.getConfig("okdblog");
				if (dbOn.equals("1")) {

					Session hsession = HibernateUtil.getSessionFactory()
							.getCurrentSession();

					Transaction tx = hsession.beginTransaction();

					SuncmJournal sj = new SuncmJournal();
					SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddhhmmss");
					sj.setActime(sd.format(new java.util.Date()));
					sj.setActionname(this.getFlow().getFlowName());
					//获得用户对象
					SuncmUser su = (SuncmUser)getSessionObjParam("suncm_user");
					if(su != null){
						sj.setActor(su.getUserId());
					}
					sj.setActdesc(getSessionStrParam("actDesc"));

					hsession.save(sj);
					tx.commit();

				}
				return "0";
			} else {
				String dbOn = SystemConfig.getConfig("errordblog");
				if (dbOn.equals("1")) {

					Session hsession = HibernateUtil.getSessionFactory()
							.getCurrentSession();

					Transaction tx = hsession.beginTransaction();

					SuncmErrorJournal sj = new SuncmErrorJournal();
					SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddhhmmss");
					sj.setActime(sd.format(new java.util.Date()));
					sj.setActionname(this.getFlow().getFlowName());
					//获得用户对象
					SuncmUser su = (SuncmUser)getSessionObjParam("suncm_user");
					if(su != null){
						sj.setActor(su.getUserId());
					}
					sj.setActdesc(getSessionStrParam("actDesc"));
					sj.setErrorcode(getSessionStrParam("tranErrorCode"));
					sj.setErrordesc(getSessionStrParam("tranErrorMsg"));
					sj.setErrorlocation(getSessionStrParam("tranErrorLocation"));

					hsession.save(sj);
					tx.commit();

				}
				return "1";
			}
			
		} catch (Throwable t) {// 记日志出错不影响流程
			this.setSessionParam("tranErrorCode", "C000003");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000003"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			t.printStackTrace();

			return "1";
		}

	}

}
